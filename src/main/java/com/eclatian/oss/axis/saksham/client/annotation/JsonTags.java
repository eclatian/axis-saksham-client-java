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
 * The {@code JsonTags} annotation is used to annotate a subclass of {@link Request} or {@link Response} class
 * with JSON tags information.
 * It is a custom annotation that can be applied to classes.
 *
 * <p>The {@code JsonTags} annotation is used at runtime and can be accessed via reflection.
 * It provides three elements: {@code root}, {@code body}, and {@code encrypted},
 * representing the JSON tags associated with the annotated class.</p>
 *
 * <p><strong>Example Usage:</strong></p>
 * <pre>{@code
 * \@JsonTags(root = "data", body = "body", encrypted = "encryptedData")
 * public class MyDataClass {
 *     // Class implementation
 * }
 * }</pre>
 *
 * @author: Abhideep Chakravarty
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
public @interface JsonTags {
    /**
     * The root JSON tag associated with the annotated class.
     *
     * @return the root JSON tag
     */
    public String root();

    /**
     * The body JSON tag associated with the annotated class.
     *
     * @return the body JSON tag
     */
    public String body();

    /**
     * The encrypted JSON tag associated with the annotated class.
     *
     * @return the encrypted JSON tag
     */
    public String encrypted();
}

