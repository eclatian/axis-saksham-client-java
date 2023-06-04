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
