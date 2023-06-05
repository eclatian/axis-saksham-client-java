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
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.eclatian.oss.axis.saksham.client.annotation;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * The {@code JsonTagsData} class represents the JSON tags data for a specific class which is annotated with
 * {@link JsonTags}.
 * It is a simple data class that encapsulates the JSON tags information.
 *
 * <p>The {@code JsonTagsData} class provides getter and setter methods for the three JSON tags:
 * {@code rootTag}, {@code bodyTag}, and {@code encTag}.</p>
 *
 * <p>The {@code JsonTagsData} class also overrides the {@code toString()} method to provide a string representation
 * of the JSON tags data.</p>
 *
 * <p><strong>Example Usage:</strong></p>
 * <pre>{@code
 * JsonTagsData tagsData = new JsonTagsData();
 * tagsData.setRootTag("data");
 * tagsData.setBodyTag("body");
 * tagsData.setEncTag("encryptedData");
 *
 * System.out.println(tagsData.toString());
 * // Output: JsonTagsData(rootTag=data, bodyTag=body, encTag=encryptedData)
 * }</pre>
 *
 * @author: Abhideep Chakravarty
 */
@Getter
@Setter
@ToString
public class JsonTagsData {
    private String rootTag;
    private String bodyTag;
    private String encTag;
}
