/*
 *
 * Axis Saksham Java Client SDK
 * This is the java SDK to consume Axis Sakham APIs. This reduces the boiler plate coding required to make API calls
 * and hence speeds up the developers to integrate with Saksham API in faster and productive way.
 *
 * 2023 Eclatian Technologies Pvt. Ltd.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
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
 * The Jackson parser implementation for converting Axis request and response objects to JSON and vice versa.
 *
 * <p>
 * The {@code JacksonParser} class is responsible for serializing Axis request and response objects to JSON using the
 * Jackson library. It also provides methods for parsing JSON strings to objects and extracting specific values from
 * JSON.
 * </p>
 *
 * <p>
 * The parser uses an instance of {@link ObjectMapper} from Jackson to perform the serialization and deserialization. It
 * also configures the coercion of empty strings to empty values for certain data types using the
 * {@link ObjectMapper#coercionConfigFor} method.
 * </p>
 *
 * <p>
 * The {@code getEncryptedRequestJson} method converts a request object to a JSON string for an encrypted request. It
 * builds a JSON template with placeholders for the root tag, SubHeader, encrypted tag, and encrypted data. It replaces
 * the placeholders with the actual values from the request object and calls the necessary utility methods to set the
 * checksum and encrypt the body. The final JSON string is returned.
 * </p>
 *
 * <p>
 * The {@code getSubHeaderJson} method retrieves the SubHeader JSON from the request object. If the
 * autoPopulateSubHeader flag is enabled in the {@link SakshamManager} options, it automatically populates the SubHeader
 * fields. Otherwise, it retrieves the SubHeader from the request object. The SubHeader is then converted to JSON using
 * the {@code getJson} method.
 * </p>
 *
 * <p>
 * The {@code autoPopulateSubHeader} method is used to automatically populate the SubHeader fields when the
 * {@code autoPopulateSubHeader} flag is enabled. It creates a new {@link SubHeader} object, sets the required fields
 * like serviceRequestId, serviceRequestVersion, channelId, and requestUUID, and returns the populated SubHeader.
 * </p>
 *
 * <p>
 * The {@code getHybridRequestJson} method converts a request object to a JSON string for a hybrid request. Similar to
 * {@code getEncryptedRequestJson}, it builds a JSON template with placeholders and replaces them with actual values. It
 * also converts the request body to JSON using the {@code getJson} method. The final JSON string is returned.
 * </p>
 *
 * <p>
 * The {@code getJson} method converts an object to JSON using the {@link ObjectMapper#writeValueAsString} method. If
 * any exception occurs during the serialization process, a {@link SakshamClientException} is thrown.
 * </p>
 *
 * <p>
 * The {@code getResponseObject} method parses a JSON string to a response object. It extracts the encrypted JSON data
 * from the response, decrypts it, and retrieves the actual data JSON using the provided root tag and body tag. The
 * decrypted data is then deserialized to the response object using the {@link ObjectMapper#readValue} method.
 * </p>
 *
 * <p>
 * The {@code getDecryptedJsonString} method reads the encrypted JSON data from the response JSON, decrypts it using
 * AES-128 decryption, and returns the decrypted JSON string.
 * </p>
 *
 * <p>
 * The {@code getDataJsonString} method reads the decrypted JSON string, extracts the status field, and checks if it is
 * "F" indicating an error. If an error occurs, a {@link SakshamClientException} is thrown with the error message.
 * Otherwise, it retrieves the data JSON using the provided body tag and returns it.
 * </p>
 *
 * <p>
 * The {@code getMap} method converts an object to a {@link LinkedHashMap} using the {@link ObjectMapper#convertValue}
 * method. This method is used to convert a request object to a map for generating the checksum.
 * </p>
 *
 * <p>
 * The {@code getJsonValue} method retrieves a specific value from a JSON string based on the provided key. It reads the
 * JSON string as a string key-value pair map and returns the value corresponding to the given key.
 * </p>
 *
 * <p>
 * Note: The {@code JacksonParser} class assumes the presence of the {@link Logger} and {@link LoggerFactory} classes
 * for logging purposes.
 * </p>
 *
 * @see ObjectMapper
 * @see SakshamClientException
 * @see Logger
 * @see LoggerFactory
 */
public class JacksonParser extends AParser<Request, Response> {

    /**
     * The logger instance for logging messages.
     */
    protected final Logger logger = LoggerFactory.getLogger(this.getClass().getName());

    /**
     * The ObjectMapper instance for serializing and deserializing objects.
     */
    private final ObjectMapper objectMapper = new ObjectMapper();

    /**
     * Constructs a new JacksonParser and configures the coercion of empty strings to empty values for
     * certain data
     * types.
     */
    public JacksonParser() {
        objectMapper.coercionConfigFor(LogicalType.POJO)
            .setCoercion(CoercionInputShape.EmptyString, CoercionAction.AsEmpty);
    }

    /**
     * Converts a request object to an encrypted JSON request string.
     *
     * <p>
     * The method builds a JSON template with placeholders for the root tag, SubHeader, encrypted tag, 
     * and encrypted
     * data. It replaces the placeholders with the actual values from the request object and calls the necessary
     * utility
     * methods to set the checksum and encrypt the body. The final JSON string is returned.
     * </p>
     *
     * @param request The Axis request object.
     * @return The encrypted JSON request string.
     * @throws SakshamClientException If an error occurs during the conversion.
     */
    @Override
    public String getEncryptedRequestJson(Request request) throws SakshamClientException {
        String json = "{"
            + "\"ROOT_TAG\": {"
            + "\"SubHeader\": SUB_HEADER_DATA,"
            + "\"ENC_TAG\": \"ENC_DATA\""
            + "}"
            + "}";
        logger.debug("Json: {}", json);
        try {
            ChecksumUtil.setChecksum(request);
        } catch (Exception ex) {
            java.util.logging.Logger.getLogger(BaseService.class.getName()).log(Level.SEVERE, null, ex);
        }
        String encData = EncryptionUtil.getEncryptedBody(request);
        logger.debug("ENC: {}", encData);
        String subHeaderJson = this.getSubHeaderJson(request);
        JsonTagsData td = TagsUtil.getTags(request.getClass());
        json = json.replace("ROOT_TAG", td.getRootTag())
            .replace("ENC_TAG", td.getEncTag())
            .replace("ENC_DATA", encData)
            .replace("SUB_HEADER_DATA", subHeaderJson);
        logger.debug("Final JSON: {}", json);
        return json;
    }

    /**
     * Retrieves the SubHeader JSON from the request object.
     *
     * <p>
     * If the autoPopulateSubHeader flag is enabled in the {@link SakshamManager} options, it automatically populates
     * the SubHeader fields. Otherwise, it retrieves the SubHeader from the request object. The SubHeader is then
     * converted to JSON using the {@code getJson} method.
     * </p>
     *
     * @param request The Axis request object.
     * @return The SubHeader JSON string.
     * @throws SakshamClientException If an error occurs during the conversion.
     */
    private String getSubHeaderJson(Request request) throws SakshamClientException {
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
            throw new SakshamClientException("Could not created SubHeader json.",ex);
        }
        return json;
    }

    /**
     * Automatically populates the SubHeader fields.
     *
     * <p>
     * When the autoPopulateSubHeader flag is enabled, this method creates a new {@link SubHeader} object and sets the
     * required fields such as serviceRequestId, serviceRequestVersion, channelId, and requestUUID. It returns the
     * populated SubHeader.
     * </p>
     *
     * @return The populated SubHeader object.
     */
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
     * Converts a request object to a hybrid JSON request string.
     *
     * <p>
     * The method builds a JSON template with placeholders for the root tag, SubHeader, body tag, and encrypted tag. It
     * replaces the placeholders with the actual values from the request object and calls the necessary utility methods
     * to set the checksum, convert the body to JSON, and encrypt the body. The final JSON string is returned.
     * </p>
     *
     * @param request The Axis request object.
     * @return The hybrid JSON request string.
     * @throws SakshamClientException If an error occurs during the conversion.
     */
    @Override
    public String getHybridRequestJson(Request request) throws SakshamClientException {
        String json = "{"
            + "\"ROOT_TAG\": {"
            + "\"SubHeader\": SUB_HEADER_DATA,"
            + "\"BODY_TAG\": BODY_DATA,"
            + "\"ENC_TAG\": \"ENC_DATA\""
            + "}"
            + "}";
        logger.debug("Json: {}", json);
        try {
            ChecksumUtil.setChecksum(request);
        } catch (Exception ex) {
            throw new SakshamClientException("Could not set proper checksum.", ex);
        }
        String reqBodyJson = null;
        try {
            reqBodyJson = this.getJson(request);
        } catch (SakshamClientException ex) {
            throw new SakshamClientException("Could not parse the object to JSON for unencrypted "
                + "request body.", ex);
        }
        String subHeaderJson = this.getSubHeaderJson(request);
        JsonTagsData td = TagsUtil.getTags(request.getClass());
        String encData = EncryptionUtil.getEncryptedBody(request);
        json = json.replace("ROOT_TAG", td.getRootTag())
            .replace("BODY_TAG", td.getBodyTag())
            .replace("BODY_DATA", reqBodyJson)
            .replace("SUB_HEADER_DATA", subHeaderJson)
            .replace("ENC_TAG", td.getEncTag())
            .replace("ENC_DATA", encData);
        logger.debug("Final JSON: {}", json);
        return json;
    }

    /**
     * Converts an object to a JSON string using the Jackson ObjectMapper.
     *
     * <p>
     * The method uses the {@link ObjectMapper#writeValueAsString} method to serialize the object to JSON. If any
     * exception occurs during the serialization process, a {@link SakshamClientException} is thrown.
     * </p>
     *
     * @param dataObject The object to be converted to JSON.
     * @return The JSON string representation of the object.
     * @throws SakshamClientException If an error occurs during the serialization process.
     */
    @Override
    protected String getJson(Object dataObject) throws SakshamClientException {
        try {
            return objectMapper.writeValueAsString(dataObject);
        } catch (JsonProcessingException ex) {
            throw new SakshamClientException("Could not convert " + dataObject.getClass() + " object to JSON.",
                ex);
        }
    }

    /**
     * Parses a JSON string to a response object.
     *
     * <p>
     * The method takes a JSON string, extracts the encrypted JSON data from it, decrypts the data, retrieves the actual
     * data JSON using the provided root tag and body tag, and deserializes the data to the response object using the
     * {@link ObjectMapper#readValue} method.
     * </p>
     *
     * @param json The JSON string to be parsed.
     * @param type The class of the response object.
     * @return The parsed response object.
     * @throws SakshamClientException If an error occurs during the parsing process.
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
            throw new SakshamClientException("Could not convert the decrypted JSON to " + type.getName() 
                + " object.", ex);
        }
        logger.debug("Response object: {}", res.toString());
        return res;
    }

    /**
     * Reads the encrypted JSON data from the response JSON and decrypts it.
     *
     * <p>
     * The method reads the encrypted JSON data from the response JSON, decrypts it using AES-128 decryption, and
     * returns the decrypted JSON string.
     * </p>
     *
     * @param json The response JSON string.
     * @param type The class of the response object.
     * @param td The JSON tags data containing the root tag and encrypted tag.
     * @return The decrypted JSON string.
     * @throws SakshamClientException If an error occurs during the decryption process.
     */
    private String getDecryptedJsonString(String json, Class<?> type, JsonTagsData td)
        throws SakshamClientException {
        JsonNode jsonNode;
        try {
            jsonNode = objectMapper.readTree(json);
        } catch (JsonProcessingException ex) {
            throw new SakshamClientException("Could not read response JSON of type " + type, ex);
        }
        String encResponseData = jsonNode.get(td.getRootTag()).get(td.getEncTag()).asText();
        String decryptedJson;
        try {
            decryptedJson = EncryptionUtil.aes128Decrypt(encResponseData);
        } catch (Exception ex) {
            throw new SakshamClientException("Could not decrypt the JSON data for " + td.getEncTag(), ex);
        }
        logger.debug("Decrypted JSON: {}", decryptedJson);
        return decryptedJson;
    }

    /**
     * Retrieves the data JSON from the decrypted JSON string.
     *
     * <p>
     * The method reads the decrypted JSON string, extracts the status field, and checks if it is "F", 
     * indicating an
     * error. If an error occurs, a {@link SakshamClientException} is thrown with the error message.
     * Otherwise, it
     * retrieves the data JSON using the provided body tag and returns it.
     * </p>
     *
     * @param json The decrypted JSON string.
     * @param type The class of the response object.
     * @param td The JSON tags data containing the root tag and body tag.
     * @return The data JSON string.
     * @throws SakshamClientException If an error occurs during the retrieval process.
     */
    private String getDataJsonString(String json, Class<?> type, JsonTagsData td)
        throws SakshamClientException {
        JsonNode jsonNode = readJsonKey(json, type);
        String status = jsonNode.get("status").asText();
        if ("F".equals(status)) {
            String error = jsonNode.get("message").asText();
            throw new SakshamClientException(error);
        }
        String dataJson = jsonNode.get(td.getBodyTag()).toString();

        logger.debug("Data JSON: {}", dataJson);
        return dataJson;
    }

    /**
     * Reads a JSON key from the JSON string.
     *
     * <p>
     * The method reads the JSON string as a string key-value pair map using the 
     * {@link ObjectMapper#readTree} method
     * and returns the corresponding JSON node based on the provided key.
     * </p>
     *
     * @param json The JSON string.
     * @param type The class of the response object.
     * @return The JSON node corresponding to the provided key.
     * @throws SakshamClientException If an error occurs during the JSON reading process.
     */
    private JsonNode readJsonKey(String json, Class<?> type) throws SakshamClientException {
        JsonNode jsonNode;
        try {
            jsonNode = objectMapper.readTree(json);
        } catch (JsonProcessingException ex) {
            throw new SakshamClientException("Could not read data JSON for type " + type, ex);
        }
        return jsonNode;
    }

    /**
     * Converts an object to a {@link LinkedHashMap} representation.
     *
     * <p>
     * The method uses the {@link ObjectMapper#convertValue} method to convert the object to a
     * {@link LinkedHashMap}
     * representation.
     * </p>
     *
     * @param request The object to be converted.
     * @return The {@link LinkedHashMap} representation of the object.
     */
    @Override
    public LinkedHashMap<String, Object> getMap(Object request) {
        return objectMapper.convertValue(request, new TypeReference<LinkedHashMap<String, Object>>() {
        });
    }

    /**
     * Retrieves the value of a specific key from a JSON string.
     *
     * <p>
     * The method reads the JSON string as a string key-value pair map using the {@link ObjectMapper#readTree} method
     * and returns the value corresponding to the provided key.
     * </p>
     *
     * @param json The JSON string.
     * @param key The key to retrieve the value for.
     * @return The value corresponding to the provided key.
     * @throws SakshamClientException If an error occurs during the JSON reading process.
     */
    @Override
    public String getJsonValue(String json, String key) throws SakshamClientException {
        JsonNode jsonNode = readJsonKey(json, String.class);
        String value = jsonNode.get(key).asText();
        logger.debug("Key = {} Value = {}", key, value);
        return value;
    }
}
