
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