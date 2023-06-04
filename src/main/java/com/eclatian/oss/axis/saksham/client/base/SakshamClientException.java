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
