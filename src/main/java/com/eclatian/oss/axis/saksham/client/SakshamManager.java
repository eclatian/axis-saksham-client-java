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
 * The {@code SakshamManager} enum represents the manager for Saksham API configuration and initialization.
 * It follows the singleton pattern and provides methods to initialize and access the configuration options. You
 * must initialize this in the beginning of using the services of this SDK.
 *
 * <p>Usage example:
 * {@code
 * InitializationOptions options = new InitializationOptions.Builder()
 *                                 .env(SakshamEnv.UAT)
 *                                 .corpCode("your-corp-code")
 *                                 .channelId("your-channel-id")
 *                                 .clientId("your-client-id")
 *                                 .clientSecret("your-client-secret")
 *                                 .key("your-key")
 *                                 .build();
 *
 * SakshamManager.INSTANCE.initialize(options);
 * InitializationOptions managerOptions = SakshamManager.INSTANCE.getOptions();
 * }
 * </p>
 *
 * <p>Note: The {@code SakshamManager} enum follows the singleton pattern and is thread-safe.
 *
 * @author Abhideep Chakravarty
 */
@Getter
public enum SakshamManager {
    INSTANCE;

    private InitializationOptions options;

    /**
     * Initializes the Saksham API configuration with the specified options.
     *
     * @param options the initialization options for Saksham API
     */
    public void initialize(InitializationOptions options) {
        this.options = options;
    }

    /**
     * Retrieves the configuration options for Saksham API.
     *
     * @return the initialization options for Saksham API
     */
    public InitializationOptions getOptions() {
        return options;
    }
}
