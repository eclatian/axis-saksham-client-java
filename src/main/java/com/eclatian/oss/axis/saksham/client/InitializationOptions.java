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

import java.io.InputStream;
import lombok.Getter;
import lombok.Setter;

/**
 * The {@code InitializationOptions} class represents the options for initializing the Saksham client.
 * It encapsulates various parameters required for client initialization.
 *
 * <p>Usage example:
 * {@code
 * InitializationOptions options = new InitializationOptions.Builder()
 *                                 .env(SakshamEnv.PROD)
 *                                 .corpCode("ABC123")
 *                                 .channelId("CH001")
 *                                 .clientId("client123")
 *                                 .clientSecret("secret456")
 *                                 .key("29C1EB633ECAB0CA0F52B588AE92EA31")
 *                                 .certPassPhrase("passphrase")
 *                                 .certFileStream(inputStream)
 *                                 .autoPopulateSubHeader(true)
 *                                 .hideRequestRawJson(true)
 *                                 .build();
 * SakshamClient client = new SakshamClient(options);
 * }
 * </p>
 *
 * <p>Note: The {@code InitializationOptions} class is immutable. Use the {@link Builder} class to construct
 * the options.
 *
 * @author Abhideep Chakravarty
 */
@Getter
@Setter
public class InitializationOptions {
    private SakshamEnv env;
    private String corpCode;
    private String channelId;
    private String clientId;
    private String clientSecret;
    private String key;
    private InputStream certFileStream;
    private String certPassPhrase;
    private boolean autoPopulateSubHeader;
    private boolean hideRequestRawJson;

    private InitializationOptions(Builder builder) {
        this.env = builder.env;
        this.corpCode = builder.corpCode;
        this.channelId = builder.channelId;
        this.clientId = builder.clientId;
        this.clientSecret = builder.clientSecret;
        this.key = builder.key;
        this.certFileStream = builder.certFileStream;
        this.autoPopulateSubHeader = builder.autoPopulateSubHeader;
        this.hideRequestRawJson = builder.hideRequestRawJson;
        this.certPassPhrase = builder.certPassPhrase;
    }

    /**
     * The builder class for constructing {@code InitializationOptions}.
     */
    public static class Builder {
        private SakshamEnv env;
        private String corpCode;
        private String channelId;
        private String clientId;
        private String clientSecret;
        private String key;
        private String certPassPhrase;
        private InputStream certFileStream;
        private boolean autoPopulateSubHeader = true;
        private boolean hideRequestRawJson = true;

        /**
         * Sets the Saksham environment.
         *
         * @param env the Saksham environment
         * @return the builder instance
         */
        public Builder env(SakshamEnv env) {
            this.env = env;
            return this;
        }

        /**
         * Sets the corporation code. This will be given by Axis Bank 
         * during on-boarding process.
         *
         * @param corpCode the corporation code
         * @return the builder instance
         */
        public Builder corpCode(String corpCode) {
            this.corpCode = corpCode;
            return this;
        }

        /**
         * Sets the channel ID. This will be given by Axis Bank 
         * during on-boarding process.
         *
         * @param channelId the channel ID
         * @return the builder instance
         */
        public Builder channelId(String channelId) {
            this.channelId = channelId;
            return this;
        }

        /**
         * Sets the client ID. This will be given by Axis Bank 
         * during on-boarding process.
         *
         * @param clientId the client ID
         * @return the builder instance
         */
        public Builder clientId(String clientId) {
            this.clientId = clientId;
            return this;
        }

        /**
         * Sets the client secret. This will be given by Axis Bank 
         * during on-boarding process.
         *
         * @param clientSecret the client secret
         * @return the builder instance
         */
        public Builder clientSecret(String clientSecret) {
            this.clientSecret = clientSecret;
            return this;
        }

        /**
         * Sets the encryption key. This will be given by Axis Bank 
         * during on-boarding process.
         *
         * @param key the encryption key
         * @return the builder instance
         */
        public Builder key(String key) {
            this.key = key;
            return this;
        }

        /**
         * Sets the passphrase for the certificate. You will create this when you follow the instructions
         * given by Axis Bank along with the mTLS certificate.
         *
         * @param passPhrase the passphrase for the certificate
         * @return the builder instance
         */
        public Builder certPassPhrase(String passPhrase) {
            this.certPassPhrase = passPhrase;
            return this;
        }

        /**
         * Sets the input stream for the certificate file.
         *
         * @param certFileStream the input stream for the certificate file
         * @return the builder instance
         */
        public Builder certFileStream(InputStream certFileStream) {
            this.certFileStream = certFileStream;
            return this;
        }

        /**
         * Sets the flag for auto-populating sub-headers. By default it is set to true. If you make it false,
         * you need to populate the {@link SubHeader} in the request object. 
         *
         * @param autoPopulateSubHeader the flag for auto-populating sub-headers
         * @return the builder instance
         */
        public Builder autoPopulateSubHeader(boolean autoPopulateSubHeader) {
            this.autoPopulateSubHeader = autoPopulateSubHeader;
            return this;
        }

        /**
         * Sets the flag for hiding the request raw JSON. By default it is set to false. Make it true only 
         * to debug if your values are going correctly in the JSON before encryption.
         *
         * @param hideRequestRawJson the flag for hiding the request raw JSON
         * @return the builder instance
         */
        public Builder hideRequestRawJson(boolean hideRequestRawJson) {
            this.hideRequestRawJson = hideRequestRawJson;
            return this;
        }

        /**
         * Builds the {@code InitializationOptions} instance.
         *
         * @return the {@code InitializationOptions} instance
         */
        public InitializationOptions build() {
            return new InitializationOptions(this);
        }
    }
}
