package com.eclatian.oss.axis.saksham.client.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;


/**
 * The {@code AxisAPI} annotation is used to mark a service class as an Axis API with a specific path.
 * It is a custom annotation that can be applied to classes.
 *
 * <p>The {@code AxisAPI} annotation is used at runtime and can be accessed via reflection.
 * It provides a single element, {@code path}, which represents the path associated with the API.</p>
 *
 * <p><strong>Example Usage:</strong></p>
 * <pre>{@code
 * \@AxisAPI(path = "/api/endpoint")
 * public class MyApiClass {
 *     // Class implementation
 * }
 * }</pre>
 *
 * @author: Abhideep Chakravarty
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
public @interface AxisAPI {
    /**
     * The path associated with the Axis API.
     * 
     * @return the path of the API
     */
    public String path();
}


