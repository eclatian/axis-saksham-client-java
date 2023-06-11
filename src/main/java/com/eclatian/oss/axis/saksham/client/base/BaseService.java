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
package com.eclatian.oss.axis.saksham.client.base;

import com.eclatian.oss.axis.saksham.client.SakshamManager;
import com.eclatian.oss.axis.saksham.client.annotation.AxisAPI;
import com.eclatian.oss.axis.saksham.client.base.restclient.HttpClientRestImpl;
import com.eclatian.oss.axis.saksham.client.base.restclient.IRestClient;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validation;
import jakarta.validation.Validator;
import jakarta.validation.ValidatorFactory;
import java.lang.reflect.ParameterizedType;
import java.util.Set;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * The abstract base class for Axis service implementations.
 *
 * <p>
 * This class provides common functionality for triggering Axis requests and handling the responses. It defines a
 * generic type {@code K} for the request and {@code V} for the response, which are subclasses of {@link Request} and
 * {@link Response} respectively.
 * </p>
 *
 * <p>
 * The {@code BaseService} class is designed to be extended by specific service implementations. It contains a logger
 * for logging purposes and an instance of {@link IRestClient} for making API requests.
 * </p>
 *
 * <p>
 * The {@code trigger} method is the entry point for triggering an Axis request and obtaining the response. It takes a
 * request object of type {@code K}, validates the request using Java Bean Validation API, converts the request to JSON
 * using the {@link IRestClient#getJsonRequest} method, and makes the API request using the
 * {@link IRestClient#makeAPIRequest} method. The resulting response object of type {@code V} is returned.
 * </p>
 *
 * <p>
 * The {@code validateRequest} method performs the validation of the request object using the Java Bean Validation API.
 * It obtains the default validator factory and validator, and validates the request against the defined constraints. If
 * there are any constraint violations, a {@link SakshamClientException} is thrown with the violation details.
 * </p>
 *
 * @param <K> The type of the request object, which must be a subclass of {@link Request}.
 * @param <V> The type of the response object, which must be a subclass of {@link Response}.
 * @see Request
 * @see Response
 * @see IRestClient
 * @see SakshamClientException
 * @see Validation
 * @see Validator
 * @see ConstraintViolation
 * @author Abhideep Chakravarty
 */
public abstract class BaseService<K extends Request, V extends Response> {

    protected final Logger logger = LoggerFactory.getLogger(this.getClass().getName());
    private final IRestClient restClient = new HttpClientRestImpl();
    protected AParser<Request, Response> parser = new JacksonParser();

    /**
     * Triggers the Axis request and returns the response.
     *
     * @param request The Axis request to be triggered.
     * @return The Axis response object.
     * @throws SakshamClientException If an error occurs during the request triggering process.
     */
    public V trigger(K request) throws SakshamClientException {
        V response = null;
        try {
            this.validateRequest(request);
            String requestJson = this.restClient.getJsonRequest(request);
            String url = SakshamManager.INSTANCE.getOptions().getEnv().getApiRootURL() + this.getAPIPath();
            logger.debug("Target URL = {}", url);
            String responseString = this.restClient.makeAPIRequest(url, requestJson);
            response = this.parseObject(responseString);
        } catch (SakshamClientException ex) {
            logger.error("An error occurred: {}", ex.getMessage(), ex);
        }
        return response;
    }

    /**
     * Parses the response JSON and returns the corresponding response object.
     *
     * <p>
     * The method uses the configured {@link AParser} implementation to parse the response JSON and converts it to the
     * appropriate response object type.
     * </p>
     *
     * @param responseJson The response JSON string.
     * @return The parsed response object.
     * @throws SakshamClientException If an error occurs during parsing or if the response contains an error message.
     */
    protected V parseObject(String responseJson) throws SakshamClientException {
        V response;
        try {
            response = (V) parser.getResponseObject(responseJson, getResponseType());
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
    protected Class getResponseType() {
        return (Class<V>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[1];
    }

    /**
     * Retrieves the API path for the REST client.
     *
     * @return The API path as specified by the {@link AxisAPI} annotation.
     */
    protected String getAPIPath() {
        AxisAPI annotation = this.getClass().getAnnotation(AxisAPI.class);
        String apiPath = annotation.path();
        logger.debug("API Path for {0} is {1} ", this.getClass().getTypeName(), apiPath);
        return apiPath;
    }

    /**
     * Validates the given request object using Java Bean Validation API.
     *
     * <p>
     * This method performs validation of the request object against the defined constraints. It uses the default
     * validator factory and validator obtained from the Validation API. If there are any constraint violations, a
     * {@link SakshamClientException} is thrown with the violation details.
     * </p>
     *
     * @param request The request object to be validated.
     * @throws SakshamClientException If the request fails validation due to constraint violations.
     */
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
}
