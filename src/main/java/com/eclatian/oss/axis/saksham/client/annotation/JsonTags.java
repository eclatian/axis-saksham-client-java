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
 * The {@code JsonTags} annotation is used to annotate a subclass of {@linkplain com.eclatian.oss.axis.saksham.client.base.Request Request} or {@link com.eclatian.oss.axis.saksham.client.base.Response Response} class
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
 * @author Abhideep Chakravarty
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

