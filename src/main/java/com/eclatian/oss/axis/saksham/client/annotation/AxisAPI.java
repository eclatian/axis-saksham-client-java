/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.eclatian.oss.axis.saksham.client.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;


/**
 * The {@code AxisAPI} annotation is used to mark a class as an Axis API with a specific path.
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
 * <p><strong>Author:</strong> Abhideep Chakravarty</p>
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


