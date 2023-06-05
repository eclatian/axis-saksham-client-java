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


