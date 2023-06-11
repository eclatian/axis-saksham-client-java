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
package com.eclatian.oss.axis.saksham.client.base.restclient;

import com.eclatian.oss.axis.saksham.client.SakshamManager;
import com.eclatian.oss.axis.saksham.client.base.AxisRestClient;
import com.eclatian.oss.axis.saksham.client.base.SakshamClientException;
import java.io.IOException;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.ParseException;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.util.EntityUtils;



/**
 * Implementation of the {@link BaseRestClientImpl} class using Apache HttpClient.
 *
 */
public class HttpClientRestImpl extends BaseRestClientImpl {

    /**
     * Makes an API request using Apache HttpClient.
     *
     * @param requestJson The JSON representation of the request.
     * @return The parsed response object.
     * @throws SakshamClientException If an error occurs during the API request or response processing.
     */
    @Override
    public String makeAPIRequest(String url, String requestJson) throws SakshamClientException {
        CloseableHttpClient client = AxisRestClient.INSTANCE.getHttpClient();
        

        // Create and send a request
        HttpPost httpPost = new HttpPost(url);
        httpPost.setHeader("Content-Type", "application/json");
        logger.debug("Client id = {}", SakshamManager.INSTANCE.getOptions().getClientId());
        logger.debug("Client secret = {}", SakshamManager.INSTANCE.getOptions().getClientSecret());
        httpPost.setHeader("X-IBM-Client-Id", SakshamManager.INSTANCE.getOptions().getClientId());
        httpPost.setHeader("X-IBM-Client-Secret", SakshamManager.INSTANCE.getOptions().getClientSecret());
        httpPost.setEntity(new StringEntity(requestJson, ContentType.APPLICATION_JSON));
        logger.debug("Request URL = {}", httpPost.toString());
        HttpResponse response = null;
        try {
            response = client.execute(httpPost);
        } catch (IOException ex) {
            throw new SakshamClientException("Could not make a successful API call. Verify your IP address is whitelisted and you are using mTLS properly.", ex);
        }
        logger.debug("Status code = {}", response.getStatusLine().getStatusCode());
        this.validateResponse(response);
        String responseString = this.convertHttpResponseToString(response);
        logger.debug("Valid response String: {}", responseString);

        return responseString;
    }

    /**
     * Validates the HTTP response and handles specific HTTP status codes.
     *
     * @param httpResponse The HTTP response object.
     * @throws SakshamClientException If the response contains an error status code.
     */
    public void validateResponse(HttpResponse httpResponse) throws SakshamClientException {
        switch (httpResponse.getStatusLine().getStatusCode()) {
            case 200:
                return;
            case 503:
                this.convert503ToException(httpResponse);
                break;
            // Add more cases for other status codes if needed
        }
    }

    /**
     * Converts a 503 HTTP response to a {@link SakshamClientException}.
     *
     * @param httpResponse The HTTP response object.
     * @throws SakshamClientException If the 503 response contains error information.
     */
    private void convert503ToException(HttpResponse httpResponse) throws SakshamClientException {
        String responseString = this.convertHttpResponseToString(httpResponse);
        logger.debug("Error 503 response String: {}", responseString);
        String sb = "httpCode: CODE | httpMessage: MSG | errorCode: ERR | moreInformation: INFO";
        sb = sb.replace("CODE", parser.getJsonValue(responseString, "httpCode"))
                .replace("MSG", parser.getJsonValue(responseString, "httpMessage"))
                .replace("ERR", parser.getJsonValue(responseString, "errorCode"))
                .replace("INFO", parser.getJsonValue(responseString, "moreInformation"));
        throw new SakshamClientException(sb);
    }

    /**
     * Converts the HTTP response to a String representation.
     *
     * @param response The HTTP response object.
     * @return The response as a String.
     * @throws SakshamClientException If an error occurs while converting the response to a String.
     */
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
}
