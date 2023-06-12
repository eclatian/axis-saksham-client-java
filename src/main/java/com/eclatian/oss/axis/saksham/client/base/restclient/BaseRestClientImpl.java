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
import com.eclatian.oss.axis.saksham.client.base.AParser;
import com.eclatian.oss.axis.saksham.client.base.JacksonParser;
import com.eclatian.oss.axis.saksham.client.base.Request;
import com.eclatian.oss.axis.saksham.client.base.Response;
import com.eclatian.oss.axis.saksham.client.base.SakshamClientException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * The abstract base class for implementing REST clients.
 *
 * <p>
 * This class provides common functionality and methods for making REST API calls and handling responses. It is intended
 * to be extended by specific REST client implementations.
 * </p>
 *
 */
public abstract class BaseRestClientImpl implements IRestClient {

    protected final Logger logger = LoggerFactory.getLogger(this.getClass().getName());
    protected AParser<Request, Response> parser = new JacksonParser();

    /**
     * Generates the JSON representation of the request object.
     *
     * <p>
     * The method delegates the creation of the JSON request to the configured {@link AParser} implementation, based on
     * the options specified in the {@link SakshamManager} instance.
     * </p>
     *
     * @param request The request object.
     * @return The JSON representation of the request.
     * @throws SakshamClientException If an error occurs during the JSON generation process.
     */
    @Override
    public String getJsonRequest(Request request) throws SakshamClientException {
        String requestJson;
        logger.debug("Mode: {}", SakshamManager.INSTANCE.getOptions().isHideRequestRawJson());
        if (SakshamManager.INSTANCE.getOptions().isHideRequestRawJson()) {
            requestJson = this.parser.getEncryptedRequestJson(request);
        } else {
            requestJson = this.parser.getHybridRequestJson(request);
        }
        return requestJson;
    }
}
