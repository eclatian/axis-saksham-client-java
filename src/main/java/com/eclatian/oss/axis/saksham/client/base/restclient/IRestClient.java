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

import com.eclatian.oss.axis.saksham.client.base.Request;
import com.eclatian.oss.axis.saksham.client.base.SakshamClientException;

/**
 * The interface for a REST client used to make API requests and handle responses.
 *
 * 
 */
public interface IRestClient {

    /**
     * Makes an API request and returns the response.
     *
     * @param url The URL on which the request is to be sent.
     * @param requestJson The JSON representation of the request.
     * @return The response json as String.
     * @throws SakshamClientException If an error occurs during the API request or response processing.
     */
    public String makeAPIRequest(String url, String requestJson) throws SakshamClientException;

    /**
     * Retrieves the JSON representation of the request.
     *
     * @param request The request object.
     * @return The JSON representation of the request.
     * @throws SakshamClientException If an error occurs while converting the request to JSON.
     */
    public String getJsonRequest(Request request) throws SakshamClientException;
}
