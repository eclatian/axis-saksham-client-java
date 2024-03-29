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
package com.eclatian.oss.axis.saksham.client.base;

import com.eclatian.oss.axis.saksham.client.SakshamManager;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author Abhideep
 */
/**
 * The {@code Request} class represents a generic request object.
 * It serves as a base class for specific request classes and encapsulates common request data.
 * The class provides getters and setters for accessing and modifying the request data.
 *
 *
 * <p>Individual attributes of this class are as follows:</p>
 * <ul>
 *   <li>{@link #channelId}:
 *     <ul>
 *       <li>Description: A string representing the channel ID associated with the request.</li>
 *       <li>Importance of Annotation: The {@link NotNull} annotation is used to indicate that this 
 * attribute cannot have a {@code null} value.</li>
 *       <li>Default Value: The default value is retrieved from the {@code SakshamManager.INSTANCE.getOptions()
 * .getChannelId()} method call.</li>
 *     </ul>
 *   </li>
 *   <li>{@link #corpCode}:
 *     <ul>
 *       <li>Description: A string representing the corporate code associated with the request.</li>
 *       <li>Importance of Annotation: The {@link NotNull} annotation is used to indicate that this 
 * attribute cannot have a {@code null} value.</li>
 *       <li>Default Value: The default value is retrieved from the {@code SakshamManager.INSTANCE.getOptions()
 * .getCorpCode()} method call.</li>
 *     </ul>
 *   </li>
 *   <li>{@link #checksum}:
 *     <ul>
 *       <li>Description: A string representing the checksum associated with the request data.</li>
 *     </ul>
 *   </li>
 *   <li>{@link #subHeader}:
 *     <ul>
 *       <li>Description: An instance of the {@link SubHeader} class representing the subheader associated
 * 
 * 
 * with the request.</li>
 *       <li>Importance of Annotation: The {@link JsonIgnore} annotation is used to indicate that this 
 * attribute should be ignored during JSON serialization and deserialization.</li>
 *     </ul>
 *   </li>
 * </ul>
 *
 * @see lombok.Getter
 * @see lombok.Setter
 * @see JsonInclude
 * @see NotNull
 * @see JsonIgnore
 * @see SubHeader
 *
 * @since 1.0
 * @author Abhideep Chakravarty
 */
@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Request {
    
    @NotNull
    private String channelId = SakshamManager.INSTANCE.getOptions().getChannelId();
    @NotNull
    private String corpCode = SakshamManager.INSTANCE.getOptions().getCorpCode();
    private String checksum;
    @JsonIgnore
    private SubHeader subHeader;
}
