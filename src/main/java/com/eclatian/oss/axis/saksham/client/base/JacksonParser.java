/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.eclatian.oss.axis.saksham.client.base;

import com.eclatian.oss.axis.saksham.client.SakshamManager;
import com.eclatian.oss.axis.saksham.client.annotation.JsonTagsData;
import com.eclatian.oss.axis.saksham.client.utils.ChecksumUtil;
import com.eclatian.oss.axis.saksham.client.utils.EncryptionUtil;
import com.eclatian.oss.axis.saksham.client.utils.TagsUtil;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.cfg.CoercionAction;
import com.fasterxml.jackson.databind.cfg.CoercionInputShape;
import com.fasterxml.jackson.databind.type.LogicalType;
import java.util.LinkedHashMap;
import java.util.UUID;
import java.util.logging.Level;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * The {@code JacksonParser} class is a subclass of {@code AParser} that provides JSON parsing
 * functionality using the Jackson library.
 *
 * <p>The class declares the following fields:</p>
 * <ul>
 *   <li>{@code logger}: The logger instance for logging purposes.</li>
 *   <li>{@code objectMapper}: The ObjectMapper instance for JSON parsing.</li>
 * </ul>
 *
 * <p>The class overrides the following methods:</p>
 * <ul>
 *   <li>{@link #getEncryptedRequestJson(Request)}: Generates the JSON for an encrypted request.</li>
 *   <li>{@link #getHybridRequestJson(Request)}: Generates the JSON for a hybrid request.</li>
 *   <li>{@link #getJson(Object)}: Converts an object to its JSON representation.</li>
 *   <li>{@link #getResponseObject(String, Class)}: Converts the JSON response to the specified response object.</li>
 * </ul>
 *
 * <p>The class also includes private helper methods for generating sub-header JSON, auto-populating sub-header,
 * getting decrypted JSON string, and getting data JSON string.</p>
 *
 * @see AParser
 * @see Request
 * @see Response
 * @see Logger
 * @see ObjectMapper
 *
 * @since 1.0
 * @author Abhideep Chakravarty
 */
public class JacksonParser extends AParser {

    protected final Logger logger = LoggerFactory.getLogger(this.getClass().getName());
    private final ObjectMapper objectMapper = new ObjectMapper();

    public JacksonParser() {
        objectMapper.coercionConfigFor(LogicalType.POJO).setCoercion(CoercionInputShape
            .EmptyString, CoercionAction.AsEmpty);
    }
    
    

    /**
     * Generates the JSON for an encrypted request.
     *
     * @param request The request object.
     * @return The JSON representation of the encrypted request.
     * @throws SakshamClientException if an error occurs while generating the JSON.
     */
    @Override
    public String getEncryptedRequestJson(Request request) throws SakshamClientException {
        String json = "{"
            + "\"ROOT_TAG\": {"
            + "\"SubHeader\": SUB_HEADER_DATA,"
            + "\"ENC_TAG\": \"ENC_DATA\""
            + ""
            + "}"
            + "}";
        logger.debug("Json : " + json);
        try {
            ChecksumUtil.setChecksum(request);
        } catch (Exception ex) {
            java.util.logging.Logger.getLogger(BaseService.class.getName()).log(Level.SEVERE, null, ex);
        }
        String encData = EncryptionUtil.getEncryptedBody(request);
        logger.debug("ENC : " + encData);
        String subHeaderJson = this.getSubHeaderJson(request);
        JsonTagsData td = TagsUtil.getTags(request.getClass());
        json = json.replace("ROOT_TAG", td.getRootTag()).replace("ENC_TAG",
            td.getEncTag()).replace("ENC_DATA", encData)
            .replace("SUB_HEADER_DATA", subHeaderJson);
        logger.debug("FInal json : " + json);
        return json;
    }

    private String getSubHeaderJson(Request request) {
        String json = null;
        SubHeader subHeader;
        if (SakshamManager.INSTANCE.getOptions().isAutoPopulateSubHeader()) {
            subHeader = this.autoPopulateSubHeader();
        } else {
            subHeader = request.getSubHeader();
        }
        try {
            json = this.getJson(subHeader);
        } catch (SakshamClientException ex) {
            logger.error(ex.getMessage());
        }
        return json;
    }

    private SubHeader autoPopulateSubHeader() {
        SubHeader sub = new SubHeader();
        sub.setServiceRequestId("OpenAPI");
        sub.setServiceRequestVersion("1.0");
        sub.setChannelId(SakshamManager.INSTANCE.getOptions().getChannelId());
        UUID uuid = UUID.randomUUID();
        String uuidString = uuid.toString().replace("-", "");
        sub.setRequestUUID(uuidString);
        return sub;
    }

    /**
     * Generates the JSON for a hybrid request.
     *
     * @param request The request object.
     * @return The JSON representation of the hybrid request.
     * @throws SakshamClientException if an error occurs while generating the JSON.
     */
    
    @Override
    public String getHybridRequestJson(Request request) throws SakshamClientException {
        String json = "{"
            + "\"ROOT_TAG\": {"
            + "\"SubHeader\": SUB_HEADER_DATA,"
            + "\"BODY_TAG\": BODY_DATA,"
            + "\"ENC_TAG\": \"ENC_DATA\""
            + ""
            + "}"
            + "}";
        logger.debug("Json : " + json);
        try {
            ChecksumUtil.setChecksum(request);
        } catch (Exception ex) {
            java.util.logging.Logger.getLogger(BaseService.class.getName()).log(Level.SEVERE, null, ex);
        }
        String reqBodyJson = null;
        try {
            reqBodyJson = this.getJson(request);
        } catch (SakshamClientException ex) {
            throw new SakshamClientException("Could not parse the object to JSON for unencrypted"
                + " request body.", ex);
        }
        String subHeaderJson = this.getSubHeaderJson(request);
        JsonTagsData td = TagsUtil.getTags(request.getClass());
        String encData = EncryptionUtil.getEncryptedBody(request);
        json = json.replace("ROOT_TAG", td.getRootTag()).replace("BODY_TAG",
            td.getBodyTag()).replace("BODY_DATA", reqBodyJson)
            .replace("SUB_HEADER_DATA", subHeaderJson).replace("ENC_TAG",
            td.getEncTag()).replace("ENC_DATA", encData);
        logger.debug("FInal json : " + json);
        return json;
    }

    /**
     * Converts an object to its JSON representation.
     *
     * @param dataObject The object to be converted.
     * @return The JSON representation of the object.
     * @throws SakshamClientException if an error occurs while converting the object to JSON.
     */
    @Override
    protected String getJson(Object dataObject) throws SakshamClientException {
        try {
            return objectMapper.writeValueAsString(dataObject);
        } catch (JsonProcessingException ex) {
            throw new SakshamClientException("Could not convert " + dataObject.getClass() + " object to json.",
                ex);
        }

    }

    /**
     * Converts the JSON response to the specified response object.
     *
     * @param json The JSON response.
     * @param type The response type class.
     * @return The response object.
     * @throws SakshamClientException if an error occurs while converting the JSON to the response object.
     */
    @Override
    public Response getResponseObject(String json, Class type) throws SakshamClientException {
        
        JsonTagsData td = TagsUtil.getTags(type);
        String decryptedJson = getDecryptedJsonString(json, type, td);
        String dataJson = getDataJsonString(decryptedJson, type, td);
        Response res = null;
        try {
            res = (Response) objectMapper.readValue(dataJson, type);
        } catch (JsonProcessingException ex) {
            throw new SakshamClientException("Could not convert the decrypted json to " + type.getName() 
                + " object.", ex);
        }
        logger.debug("Response object = " + res.toString());
        return res;
    }

    private String getDecryptedJsonString(String json, Class type, JsonTagsData td) 
        throws SakshamClientException {
        JsonNode jsonNode;
        try {
            jsonNode = objectMapper.readTree(json);
        } catch (JsonProcessingException ex) {
            throw new SakshamClientException("Could not read response josn of type  " + type ,ex);
        }            
        String encResponseData = jsonNode.get(td.getRootTag()).get(td.getEncTag()).asText();
        String decryptedJson;
        try {
            decryptedJson = EncryptionUtil.aes128Decrypt(encResponseData);
        } catch (Exception ex) {
            throw new SakshamClientException("Could not decrypt the json data for  " + td.getEncTag() ,ex);
        }
        logger.debug("Decrypted json = " + decryptedJson);
        return decryptedJson;
    }
    
    
    private String getDataJsonString(String json, Class type, JsonTagsData td) 
        throws SakshamClientException {
        JsonNode jsonNode = readJsonKey(json, type);   
        String status = jsonNode.get("status").asText();
        if ("F".equals(status)) {
            String error = jsonNode.get("message").asText();
            throw new SakshamClientException(error);
        }
        String dataJson = jsonNode.get(td.getBodyTag()).toString();
        
        logger.debug("Data json = " + dataJson);
        return dataJson;
    }

    private JsonNode readJsonKey(String json, Class type) throws SakshamClientException {
        JsonNode jsonNode;
        try {
            jsonNode = objectMapper.readTree(json);
        } catch (JsonProcessingException ex) {
            throw new SakshamClientException("Could not read data josn for type  " + type ,ex);
        }
        return jsonNode;
    }
    
    @Override
    public LinkedHashMap<String, Object> getMap(Object request) {
        return objectMapper.convertValue(request,
            new TypeReference<LinkedHashMap<String, Object>>() {
        });

    }

    @Override
    protected String getJsonValue(String json, String key) throws SakshamClientException {
        JsonNode jsonNode = readJsonKey(json, String.class);   
        String value = jsonNode.get(key).asText();
        logger.debug("Key = {} Value = {}", key, value);
        return value;
    }
}
