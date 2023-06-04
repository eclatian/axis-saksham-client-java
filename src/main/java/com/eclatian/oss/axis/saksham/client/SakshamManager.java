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
