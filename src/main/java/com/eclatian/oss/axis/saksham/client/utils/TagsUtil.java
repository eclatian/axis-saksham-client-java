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
