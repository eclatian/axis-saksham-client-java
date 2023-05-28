/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.eclatian.oss.axis.saksham.client.utils;

import com.eclatian.oss.axis.saksham.client.annotation.JsonTags;
import com.eclatian.oss.axis.saksham.client.annotation.JsonTagsData;


/**
 * The {@code TagsUtil} class provides utility methods for retrieving tags from a given class using annotations.
 * It supports retrieving tags using the {@code JsonTags} annotation.
 *
 * <p><strong>Example Usage:</strong></p>
 * <pre>{@code
 * // Define a class with JsonTags annotation
 * \@JsonTags(root = "data", body = "content", encrypted = true)
 * public class MyRequest {
 *     // Class implementation
 * }
 *
 * // Get the tags from the class
 * JsonTagsData tagsData = TagsUtil.getTags(MyRequest.class);
 * System.out.println("Root Tag: " + tagsData.getRootTag());
 * System.out.println("Body Tag: " + tagsData.getBodyTag());
 * System.out.println("Encrypted Tag: " + tagsData.getEncTag());
 * }</pre>
 *
 * <p>This class uses reflection to retrieve the {@code JsonTags} annotation from a given class and returns
 * the corresponding tags using the {@code JsonTagsData} object.</p>
 *
 * @since 1.0
 * @see JsonTags
 * @see JsonTagsData
 * @see Class#getAnnotation(Class)
 * @see Class
 * @author Abhideep Chakravarty
 */
public class TagsUtil {
    
    /**
     * Retrieves the tags from the given class using the {@code JsonTags} annotation.
     *
     * @param request the class from which to retrieve the tags
     * @return the {@code JsonTagsData} object containing the retrieved tags
     */
    public static JsonTagsData getTags(Class request) {
        JsonTags tagsAnnotation = (JsonTags) request.getAnnotation(JsonTags.class);
        JsonTagsData td = new JsonTagsData();
        td.setBodyTag(tagsAnnotation.body());
        td.setEncTag(tagsAnnotation.encrypted());
        td.setRootTag(tagsAnnotation.root());
        return td;
    }
}
