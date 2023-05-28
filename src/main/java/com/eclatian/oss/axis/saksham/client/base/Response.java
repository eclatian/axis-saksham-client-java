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
