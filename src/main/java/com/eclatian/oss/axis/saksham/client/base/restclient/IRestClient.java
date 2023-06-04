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
