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
package com.eclatian.oss.axis.saksham.client.utils;

import com.eclatian.oss.axis.saksham.client.base.AParser;
import com.eclatian.oss.axis.saksham.client.base.JacksonParser;
import com.eclatian.oss.axis.saksham.client.base.Request;
import com.eclatian.oss.axis.saksham.client.base.SakshamClientException;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


/**
 * The {@code ChecksumUtil} class provides utility methods for generating and validating checksums.
 * It includes methods for generating a checksum based on a given request map and encoding the checksum with SHA256.
 * The class also provides a method for setting the checksum on a {@link Request} object.
 *
 * <p>Checksums are used for data integrity verification and are commonly used in data transmission and storage.</p>
 *
 * <p><strong>Example Usage:</strong></p>
 * <pre>{@code
 * LinkedHashMap<String, Object> requestMap = new LinkedHashMap<>();
 * // Populate the requestMap with data
 *
 * String checksum = ChecksumUtil.generateCheckSum(requestMap);
 * System.out.println("Checksum: " + checksum);
 *
 * // Set the checksum on a request object
 * Request request = new Request();
 * ChecksumUtil.setChecksum(request);
 * }</pre>
 *
 * <p>This class uses the {@code AParser} and {@code JacksonParser} classes for parsing the request map.</p>
 *
 * @since 1.0
 * @author Abhideep Chakravarty
 */
public class ChecksumUtil {

    protected static final Logger logger = LoggerFactory.getLogger(ChecksumUtil.class.getName());
    private static final AParser PARSER = new JacksonParser();

    /**
     * Generates a checksum based on the provided request map.
     *
     * @param requestMap the request map to generate the checksum from
     * @return the generated checksum
     * @throws Exception if an error occurs during checksum generation
     */
    private static String generateCheckSum(LinkedHashMap<String, Object> requestMap) throws Exception {
        StringBuilder finalChkSum = new StringBuilder();
        StringBuilder keys = new StringBuilder();
        try {
            if (null == requestMap) {
                return null;
            }
            for (Map.Entry<String, Object> entry : requestMap.entrySet()) {
                if (!entry.getKey().equals("checksum")) {
                    if (entry.getValue() instanceof List) {
                        List<Object> tempLst = ((List) entry.getValue());
                        if (!CollectionUtils.isEmpty(tempLst) && (tempLst.get(0) instanceof Map)) {
                            List<? extends Map<String, Object>> innerObjectMap
                                = (List<? extends Map<String, Object>>) entry.getValue();

                            for (Map<String, Object> innerMap : innerObjectMap) {

                                for (Entry<? extends String, ? extends Object> entryInn
                                    : innerMap.entrySet()) {

                                    keys.append(entryInn.getKey());

                                    finalChkSum.append(
                                        getInnerLevel2Map(
                                            entryInn.getValue()));

                                }
                            }
                        } else if (!CollectionUtils.isEmpty(tempLst)) {
                            for (Object strValues : tempLst) {
                                finalChkSum.append(
                                    validateInfo(
                                        String.valueOf(strValues)));
                            }
                        }
                    } else if (entry.getValue() instanceof Map) {
                        Map<? extends String, ? extends Object> innerObjectMap2
                            = (Map<? extends String, ? extends Object>) entry.getValue();
                        for (Entry<? extends String, ? extends Object> entryInn
                            : innerObjectMap2.entrySet()) {
                            keys.append(entryInn.getKey());
                            finalChkSum.append(
                                validateInfo(
                                    String.valueOf(entryInn.getValue())));

                        }
                    } else {
                        finalChkSum.append(
                            validateInfo(
                                String.valueOf(entry.getValue())));
                    }
                }
            }
        } catch (Exception e) {
           throw new SakshamClientException("Could not generate checksum value for the given object.",
               e);
        }
        logger.debug("Checksum = {}", finalChkSum.toString().trim());
        return String.valueOf(
            encodeCheckSumWithSHA256(
                finalChkSum.toString().trim()));

    }

    /**
     * Recursively processes inner level 2 maps to generate the checksum.
     *
     * @param entryInnLvl2 the inner level 2 map to process
     * @return the checksum generated from the inner level 2 map
     */
    private static String getInnerLevel2Map(Object entryInnLvl2) {

        StringBuilder finalChkSum = new StringBuilder();

        StringBuilder keys = new StringBuilder();
        if (entryInnLvl2 instanceof List) {
            List<Object> tempLst = ((List) entryInnLvl2);
            if (!CollectionUtils.isEmpty(tempLst) && (tempLst.get(0) instanceof Map)) {
                List<? extends Map<String, Object>> innerObjectMap
                    = (List<? extends Map<String, Object>>) entryInnLvl2;
                for (Map<String, Object> innerMap : innerObjectMap) {
                    for (Entry<? extends String, ? extends Object> entryInn : innerMap.entrySet()) {

                        keys.append(entryInn.getKey());
                        finalChkSum.append(
                            validateInfo(String.valueOf(entryInn.getValue())));
                    }
                }
            } else if (!CollectionUtils.isEmpty(tempLst)) {
                for (Object strValues : tempLst) {
                    finalChkSum.append(
                        validateInfo(
                            String.valueOf(strValues)));
                }
            }
        } else if (entryInnLvl2 instanceof Map) {
            Map<? extends String, ? extends Object> innerObjectMap2
                = (Map<? extends String, ? extends Object>) entryInnLvl2;
            for (Entry<? extends String, ? extends Object> entryInn : innerObjectMap2.entrySet()) {

                keys.append(entryInn.getKey());

                finalChkSum.append(
                    validateInfo(
                        String.valueOf(entryInn.getValue())
                    ));
            }
        } else {
            finalChkSum.append(
                validateInfo(
                    String.valueOf(entryInnLvl2)));
        }

        return finalChkSum.toString();

    }

    /**
     * Validates the given value and returns it if not empty or "null", otherwise returns an empty string.
     *
     * @param value the value to validate
     * @return the validated value or an empty string
     */
    private static Object validateInfo(String value) {
        return (StringUtils.isNotEmpty(value) && !"null".equals(value))
            ? value : StringUtils.EMPTY;

    }

    /**
     * Encodes the given data with SHA256 and returns the encoded checksum.
     *
     * @param data the data to encode
     * @return the encoded checksum
     * @throws NoSuchAlgorithmException if the SHA256 algorithm is not available
     */
    public static String encodeCheckSumWithSHA256(String data) throws NoSuchAlgorithmException {
        MessageDigest md;
        StringBuilder sb = new StringBuilder();
        logger.debug("Checksum for encoding: {}", data);

        md = MessageDigest.getInstance("MD5");
        md.update(data.getBytes(StandardCharsets.UTF_8));
        // Get the hashbytes 
        byte[] hashBytes = md.digest();
        // Convert hash bytes to hex format 
        for (byte b : hashBytes) {
            sb.append(String.format("%02x", b));
        }
        
        return sb.toString();

    }

    /**
     * Sets the checksum on the provided request object.
     *
     * @param request the request object to set the checksum on
     * @throws Exception if an error occurs during checksum generation or setting the checksum on the
     * request object
     */
    public static void setChecksum(Request request) throws Exception {
        request.setChecksum(null);

        LinkedHashMap<String, Object> dataMap = PARSER.getMap(request);
        request.setChecksum(ChecksumUtil.generateCheckSum(dataMap));

    }

}
