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

import java.util.LinkedHashMap;
import lombok.Getter;
import lombok.Setter;

/**
 * The {@code AParser} class is an abstract class that represents a parser for request and response objects. Any
 * parser implementation like Jackson or Gson needs to implement this and provide a relevant method 
 * implementation so that in case of change of parser rest of the code remains unchanged. It provides methods 
 * for generating encrypted and hybrid request JSON, retrieving response objects,
 * converting request objects to a map, and generating JSON from data objects.
 * This class serves as a base class for concrete parser implementations.
 *
 * @param <K> The type of the request object.
 * @param <V> The type of the response object.
 *
 * @see lombok.Getter
 * @see lombok.Setter
 * @see SakshamClientException
 *
 * @since 1.0
 * @author Abhideep Chakravarty
 */
@Getter
@Setter
public abstract class AParser<K extends Request, V extends Response> {

    /**
     * Generates encrypted request JSON from a given request object.
     *
     * @param request The request object to generate encrypted request JSON for.
     * @return The encrypted request JSON.
     * @throws SakshamClientException If an exception occurs during the generation of encrypted request JSON.
     */
    public abstract String getEncryptedRequestJson(K request) throws SakshamClientException;

    /**
     * Generates hybrid request JSON from a given request object.
     *
     * @param request The request object to generate hybrid request JSON for.
     * @return The hybrid request JSON.
     * @throws SakshamClientException If an exception occurs during the generation of hybrid request JSON.
     */
    public abstract String getHybridRequestJson(K request) throws SakshamClientException;

    /**
     * Retrieves a response object of the specified type from the given JSON response string.
     *
     * @param json The JSON response string to extract the response object from.
     * @param type The class representing the type of the response object.
     * @return The response object of the specified type.
     * @throws SakshamClientException If an exception occurs during the retrieval of the response object.
     */
    public abstract V getResponseObject(String json, Class<V> type) throws SakshamClientException;

    /**
     * Converts a request object to a map representation.
     *
     * @param request The request object to convert to a map.
     * @return A linked hash map representing the request object.
     */
    public abstract LinkedHashMap<String, Object> getMap(Object request);

    /**
     * Generates JSON from a given data object.
     *
     * @param dataObject The data object to generate JSON for.
     * @return The generated JSON as a string.
     * @throws SakshamClientException If an exception occurs during the generation of JSON.
     */
    protected abstract String getJson(Object dataObject) throws SakshamClientException;
    
    /**
     * Retrieves value from a JSON by its key.
     *
     * @param json The JSON string from which value is to be fetched.
     * @param key The key for which value is to be fetched.
     * @return The value corresponding to the key in the JSON.
     * @throws SakshamClientException If an exception occurs during the retrieval of the value.
     */
    public abstract String getJsonValue(String json, String key) throws SakshamClientException;
}
