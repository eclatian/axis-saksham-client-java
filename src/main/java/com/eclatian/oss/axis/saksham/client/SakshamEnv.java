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

package com.eclatian.oss.axis.saksham.client;

import lombok.Getter;

/**
 * The {@code SakshamEnv} enum represents the different environments for Saksham API.
 * It provides the API root URL for each environment.
 *
 * <p>Usage example:
 * {@code
 * SakshamEnv environment = SakshamEnv.UAT;
 * String apiRootURL = environment.getApiRootURL();
 * }
 * </p>
 *
 * <p>Note: The {@code SakshamEnv} enum is immutable.
 *
 * @author Abhideep Chakravarty
 */
@Getter
public enum SakshamEnv {
    UAT("https://sakshamuat.axisbank.co.in/gateway/api/txb/v1"),
    PROD("https://saksham.axisbank.co.in/gateway/api/txb/v1");

    private final String apiRootURL;

    /**
     * Constructs a {@code SakshamEnv} enum constant with the specified API root URL.
     *
     * @param apiRootURL the API root URL for the environment
     */
    SakshamEnv(String apiRootURL) {
        this.apiRootURL = apiRootURL;
    }
}