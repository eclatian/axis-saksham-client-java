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
package com.eclatian.oss.axis.saksham.client.base;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.Setter;

/**
 * The {@code Response} class represents a generic response object.
 * It serves as a base class for specific response classes and encapsulates common response data.
 * The class provides getters and setters for accessing and modifying the response data.
 *
 * <p>Individual attributes of this class are as follows:</p>
 * <ul>
 *   <li>{@link #checksum}:
 *     <ul>
 *       <li>Description: A string representing the checksum associated with the response data.</li>
 *     </ul>
 *   </li>
 *   <li>{@link #errorMessage}:
 *     <ul>
 *       <li>Description: A string representing the error message associated with the response, if any.</li>
 *     </ul>
 *   </li>
 * </ul>
 *
 * @see lombok.Getter
 * @see lombok.Setter
 * @see JsonInclude
 *
 * @since 1.0
 * @author Abhideep Chakravarty
 */
@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Response {
    
    private String checksum;
    private String errorMessage;
}
