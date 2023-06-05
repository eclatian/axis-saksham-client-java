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

/**
 * The {@code SakshamClientException} class is a custom exception class that represents an exception specific to
 * the Saksham client.
 *
 * <p>The class extends the {@code Exception} class and provides three constructors for creating exceptions:</p>
 * <ul>
 *   <li>{@link #SakshamClientException()}: Creates a new instance of the exception with no message or cause.</li>
 *   <li>{@link #SakshamClientException(String)}: Creates a new instance of the exception with the 
 * specified message.</li>
 *   <li>{@link #SakshamClientException(String, Throwable)}: Creates a new instance of the exception with 
 * the specified
 *     message and cause.</li>
 * </ul>
 *
 * <p>Instances of this exception are thrown when an error occurs in the Saksham client.</p>
 *
 * @see Exception
 *
 * @since 1.0
 * @author [Your Name]
 */
public class SakshamClientException extends Exception {

    /**
     * Constructs a new SakshamClientException with no detail message or cause.
     */
    public SakshamClientException() {
        super();
    }

    /**
     * Constructs a new SakshamClientException with the specified detail message.
     *
     * @param message The detail message.
     */
    public SakshamClientException(String message) {
        super(message);
    }

    /**
     * Constructs a new SakshamClientException with the specified detail message and cause.
     *
     * @param message The detail message.
     * @param cause The cause of the exception.
     */
    public SakshamClientException(String message, Throwable cause) {
        super(message, cause);
    }
}
