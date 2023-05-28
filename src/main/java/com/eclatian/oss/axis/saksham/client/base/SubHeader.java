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
 * <p><strong>Author:</strong> Abhideep Chakravarty</p>
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
