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

import lombok.Getter;
import lombok.Setter;

/**
 * The {@code SubHeader} class represents the sub-header information for a request.
 * It provides getter and setter methods for accessing and modifying the sub-header properties.
 *
 * <p>The sub-header typically contains information such as the request UUID, service request ID,
 * service request version, and channel ID. Some of these properties have default values set.</p>
 *
 * <p>This class uses the Lombok annotations {@code @Getter} and {@code @Setter} to automatically
 * generate the getter and setter methods for the sub-header properties.</p>
 *
 * <p><strong>Example Usage:</strong></p>
 * <pre>{@code
 * SubHeader subHeader = new SubHeader();
 * subHeader.setRequestUUID("12345678");
 * subHeader.setChannelId("web");
 * }</pre>
 *
 * @author Abhideep Chakravarty
 */
@Getter
@Setter
public class SubHeader {
    /**
     * The unique identifier for the request.
     */
    private String requestUUID;

    /**
     * The ID of the service request. Default value is set to "OpenAPI".
     */
    private String serviceRequestId = "OpenAPI";

    /**
     * The version of the service request. Default value is set to "1.0".
     */
    private String serviceRequestVersion = "1.0";

    /**
     * The ID of the channel.
     */
    private String channelId;
}
