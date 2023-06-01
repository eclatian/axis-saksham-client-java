/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.eclatian.oss.axis.saksham.client.base;

import java.util.LinkedHashMap;
import lombok.Getter;
import lombok.Setter;

/**
 * The {@code AParser} class is an abstract class that represents a parser for request and response objects.
 * It provides methods for generating encrypted and hybrid request JSON, retrieving response objects,
 * converting request objects to a map, and generating JSON from data objects.
 * This class serves as a base class for concrete parser implementations.
 *
 *
 * <p>Type Parameters:</p>
 * <ul>
 *   <li>{@code K}: The type of the request object.</li>
 *   <li>{@code V}: The type of the response object.</li>
 * </ul>
 *
 * <p>The class declares the following abstract methods:</p>
 * <ul>
 *   <li>{@link #getEncryptedRequestJson(K)}:
 *     <ul>
 *       <li>Description: Generates encrypted request JSON from a given request object.</li>
 *       <li>Parameters:
 *         <ul>
 *           <li>{@code request}: The request object to generate encrypted request JSON for.</li>
 *         </ul>
 *       </li>
 *       <li>Returns: The encrypted request JSON.</li>
 *       <li>Throws:
 *         <ul>
 *           <li>{@link SakshamClientException}: If an exception occurs during the generation of encrypted request JSON.</li>
 *         </ul>
 *       </li>
 *     </ul>
 *   </li>
 *   <li>{@link #getHybridRequestJson(K)}:
 *     <ul>
 *       <li>Description: Generates hybrid request JSON from a given request object.</li>
 *       <li>Parameters:
 *         <ul>
 *           <li>{@code request}: The request object to generate hybrid request JSON for.</li>
 *         </ul>
 *       </li>
 *       <li>Returns: The hybrid request JSON.</li>
 *       <li>Throws:
 *         <ul>
 *           <li>{@link SakshamClientException}: If an exception occurs during the generation of hybrid request JSON.</li>
 *         </ul>
 *       </li>
 *     </ul>
 *   </li>
 *   <li>{@link #getResponseObject(String, Class)}:
 *     <ul>
 *       <li>Description: Retrieves a response object of the specified type from the given JSON response string.</li>
 *       <li>Parameters:
 *         <ul>
 *           <li>{@code json}: The JSON response string to extract the response object from.</li>
 *           <li>{@code type}: The class representing the type of the response object.</li>
 *         </ul>
 *       </li>
 *       <li>Returns: The response object of the specified type.</li>
 *       <li>Throws:
 *         <ul>
 *           <li>{@link SakshamClientException}: If an exception occurs during the retrieval of the response object.</li>
 *         </ul>
 *       </li>
 *     </ul>
 *   </li>
 *   <li>{@link #getMap(Object)}:
 *     <ul>
 *       <li>Description: Converts a request object to a map representation.</li>
 *       <li>Parameters:
 *         <ul>
 *           <li>{@code request}: The request object to convert to a map.</li>
 *         </ul>
 *       </li>
 *       <li>Returns: A linked hash map representing the request object.</li>
 *     </ul>
 *   </li>
 *   <li>{@link #getJson(Object)}:
 *     <ul>
 *       <li>Description: Generates JSON from a given data object.</li>
 *       <li>Parameters:
 *         <ul>
 *           <li>{@code dataObject}: The data object to generate JSON for.</li>
 *         </ul>
 *       </li>
 *       <li>Returns: The generated JSON as a string.</li>
 *       <li>Throws:
 *         <ul>
 *           <li>{@link SakshamClientException}: If an exception occurs during the generation of JSON.</li>
 *         </ul>
 *       </li>
 *     </ul>
 *   </li>
 * </ul>
 *
 * <p>Implementations of this class must provide concrete implementations for the abstract methods.</p>
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
    
    protected abstract String getJsonValue(String json, String key) throws SakshamClientException;
}
