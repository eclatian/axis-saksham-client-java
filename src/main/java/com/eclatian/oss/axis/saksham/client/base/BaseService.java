package com.eclatian.oss.axis.saksham.client.base;

import com.eclatian.oss.axis.saksham.client.SakshamManager;
import com.eclatian.oss.axis.saksham.client.annotation.AxisAPI;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validation;
import jakarta.validation.Validator;
import jakarta.validation.ValidatorFactory;
import java.io.IOException;
import java.lang.reflect.ParameterizedType;
import java.util.Set;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.ParseException;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.util.EntityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * The {@code BaseService} class is an abstract class that provides common functionality for service classes handling
 * Axis requests.
 *
 * <p>
 * The class declares the following fields:</p>
 * <ul>
 * <li>{@code logger}: The logger instance for logging purposes.</li>
 * <li>{@code parser}: The AParser instance for JSON parsing.</li>
 * </ul>
 *
 * <p>
 * The class provides the following methods:</p>
 * <ul>
 * <li>{@link #trigger(Request)}: Triggers the Axis request and returns the response.
 * <ul>
 * <li>Description: Validates the request, converts it to JSON format based on the options, and makes the API request.
 * It returns the parsed response or logs an error if an exception occurs.</li>
 * <li>Parameters:
 * <ul>
 * <li>{@code request}: The Axis request to be triggered.</li>
 * </ul>
 * </li>
 * <li>Returns: The Axis response object.</li>
 * </ul>
 * </li>
 * </ul>
 *
 * <p>
 * The class also includes private helper methods for request validation, making the API request, retrieving the API
 * path, and parsing the response object.</p>
 *
 * <p>
 * Note: This is an abstract class, and concrete service classes should extend it and implement the necessary abstract
 * methods.</p>
 *
 * @param <K> The type parameter representing the Axis request.
 * @param <V> The type parameter representing the Axis response.
 *
 * @see Request
 * @see Response
 * @see AParser
 * @see Logger
 *
 * @since 1.0
 * @author Abhideep Chakravarty
 */
public abstract class BaseService<K extends Request, V extends Response> {

    protected final Logger logger = LoggerFactory.getLogger(this.getClass().getName());
    private final AParser parser = new JacksonParser();

    /**
     * Triggers the Axis request and returns the response.
     *
     * @param request The Axis request to be triggered.
     * @return The Axis response object.
     */
    public V trigger(K request) {
        V response = null;
        try {
            this.validateRequest(request);
            String requestJson;
            logger.debug("Mode : " + SakshamManager.INSTANCE.getOptions().isHideRequestRawJson());
            if (SakshamManager.INSTANCE.getOptions().isHideRequestRawJson()) {
                requestJson = this.parser.getEncryptedRequestJson(request);
            } else {
                requestJson = this.parser.getHybridRequestJson(request);
            }
            response = this.makeAPIRequest(requestJson);
        } catch (SakshamClientException ex) {
            logger.error("An error occurred: {}", ex.getMessage(), ex);
        }
        return response;
    }

    private void validateRequest(K request) throws SakshamClientException {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        Validator validator = factory.getValidator();

        Set<ConstraintViolation<K>> violations = validator.validate(request);

        if (!violations.isEmpty()) {
            StringBuilder message = new StringBuilder();
            for (ConstraintViolation<K> violation : violations) {
                message.append(violation.getPropertyPath()).append(": ").append(violation
                    .getMessage()).append(",");
            }
            throw new SakshamClientException(message.toString());
        }
        logger.debug("Validation check done.");
    }

    private V makeAPIRequest(String requestJson) throws SakshamClientException {
        CloseableHttpClient client = AxisRestClient.INSTANCE.getHttpClient();
        String url = SakshamManager.INSTANCE.getOptions().getEnv().getApiRootURL() + this.getAPIPath();
        logger.debug("Target URL = " + url);

        // Create and send a request
        HttpPost httpPost = new HttpPost(url);
        httpPost.setHeader("Content-Type", "application/json");
        logger.debug("Client id = " + SakshamManager.INSTANCE.getOptions().getClientId());
        logger.debug("Client secret = " + SakshamManager.INSTANCE.getOptions().getClientSecret());
        httpPost.setHeader("X-IBM-Client-Id", SakshamManager.INSTANCE.getOptions().getClientId());
        httpPost.setHeader("X-IBM-Client-Secret", SakshamManager.INSTANCE.getOptions()
            .getClientSecret());
        httpPost.setEntity(new StringEntity(requestJson, ContentType.APPLICATION_JSON));
        logger.debug("Request URL = " + httpPost.toString());
        HttpResponse response = null;
        try {
            response = client.execute(httpPost);
        } catch (IOException ex) {
            throw new SakshamClientException("Could not make a successful API call. Verify your IP"
                + " address is whitelisted and you are using mTLS properly.", ex);
        }
        logger.debug("Status code = " + response.getStatusLine().getStatusCode());
        this.validateResponse(response);
        String responseString = this.convertHttpResponseToString(response);
        logger.debug("Valid reponse String : " + responseString);

        return parseObject(responseString);
    }

    private String convertHttpResponseToString(HttpResponse response) throws SakshamClientException {
        HttpEntity entity2 = response.getEntity();
        String responseString;
        try {
            responseString = EntityUtils.toString(entity2, "UTF-8");
        } catch (IOException | ParseException ex) {
            throw new SakshamClientException("Could not convert the API response to String.", ex);
        }
        return responseString;
    }

    private String getAPIPath() {
        AxisAPI annotation = this.getClass().getAnnotation(AxisAPI.class);
        String apiPath = annotation.path();
        logger.debug("API Path for " + this.getClass().getTypeName() + " is " + apiPath);
        return apiPath;
    }

    private V parseObject(String responseJson) throws SakshamClientException {
        V response = null;
        try {
            response = (V) parser.getResponseObject(responseJson, getReponseType());
        } catch (SakshamClientException ex) {
            throw new SakshamClientException("Could not parse the response JSON.", ex);
        }
        if (response.getErrorMessage() != null) {
            throw new SakshamClientException(response.getErrorMessage());
        }
        return response;
    }

    /**
     * Retrieves the response type of the service.
     *
     * @return The response type class.
     */
    private Class<V> getReponseType() {
        return (Class<V>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[1];
    }

    private void validateResponse(HttpResponse httpResponse) throws SakshamClientException {
        switch (httpResponse.getStatusLine().getStatusCode()) {
            case 200:
                return;
            case 503:
                this.convert503ToException(httpResponse);
                break;

        }
    }

    private void convert503ToException(HttpResponse httpResponse) throws SakshamClientException {
        String responseString = this.convertHttpResponseToString(httpResponse);
        logger.debug("Error 503 reponse String : " + responseString);
        String sb = "httpCode: CODE | httpMessage: MSG | errorCode: ERR "
            + "| moreInformation: INFO";
        sb = sb.replace("CODE", parser.getJsonValue(responseString, "httpCode"))
            .replace("MSG", parser.getJsonValue(responseString, "httpMessage"))
            .replace("ERR", parser.getJsonValue(responseString, "errorCode"))
            .replace("INFO", parser.getJsonValue(responseString, "moreInformation"));
        throw new SakshamClientException(sb);
    }
}
