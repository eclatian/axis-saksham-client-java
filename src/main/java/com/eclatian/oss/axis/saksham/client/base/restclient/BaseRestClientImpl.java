package com.eclatian.oss.axis.saksham.client.base.restclient;

import com.eclatian.oss.axis.saksham.client.SakshamManager;
import com.eclatian.oss.axis.saksham.client.base.AParser;
import com.eclatian.oss.axis.saksham.client.base.JacksonParser;
import com.eclatian.oss.axis.saksham.client.base.Request;
import com.eclatian.oss.axis.saksham.client.base.SakshamClientException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


/**
 * The abstract base class for implementing REST clients.
 * 
 * <p>
 * This class provides common functionality and methods for making REST API calls and handling responses.
 * It is intended to be extended by specific REST client implementations.
 * </p>
 *
 */
public abstract class BaseRestClientImpl implements IRestClient {

    protected final Logger logger = LoggerFactory.getLogger(this.getClass().getName());
    protected AParser parser = new JacksonParser();

    /**
     * Generates the JSON representation of the request object.
     *
     * <p>
     * The method delegates the creation of the JSON request to the configured {@link AParser} implementation,
     * based on the options specified in the {@link SakshamManager} instance.
     * </p>
     *
     * @param request The request object.
     * @return The JSON representation of the request.
     * @throws SakshamClientException If an error occurs during the JSON generation process.
     */
    @Override
    public String getJsonRequest(Request request) throws SakshamClientException {
        String requestJson;
        logger.debug("Mode: " + SakshamManager.INSTANCE.getOptions().isHideRequestRawJson());
        if (SakshamManager.INSTANCE.getOptions().isHideRequestRawJson()) {
            requestJson = this.parser.getEncryptedRequestJson(request);
        } else {
            requestJson = this.parser.getHybridRequestJson(request);
        }
        return requestJson;
    }
}
