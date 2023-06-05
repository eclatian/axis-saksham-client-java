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
package com.eclatian.oss.axis.saksham.client.benereg;

import com.eclatian.oss.axis.saksham.client.annotation.JsonTags;
import com.eclatian.oss.axis.saksham.client.base.Request;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import java.util.ArrayList;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * The {@code BeneficiaryRegistrationRequest} class represents a request for beneficiary registration.
 * It extends the {@link Request} class and encapsulates the necessary information for registering beneficiaries.
 * The class provides getters and setters for accessing and modifying the request data.
 *
 *
 * <p>The annotation {@code @JsonTags} is used with the following parameters:</p>
 * <ul>
 *   <li>{@code encrypted}:
 *     <ul>
 *       <li>Description: Specifies the JSON tag for the encrypted part of the request body.</li>
 *       <li>Value: "BeneficiaryRegistrationRequestBodyEncrypted"</li>
 *     </ul>
 *   </li>
 *   <li>{@code root}:
 *     <ul>
 *       <li>Description: Specifies the JSON tag for the root element of the request.</li>
 *       <li>Value: "BeneficiaryRegistrationRequest"</li>
 *     </ul>
 *   </li>
 *   <li>{@code body}:
 *     <ul>
 *       <li>Description: Specifies the JSON tag for the request body.</li>
 *       <li>Value: "BeneficiaryRegistrationRequestBody"</li>
 *     </ul>
 *   </li>
 * </ul>
 *
 * <p>Individual attributes of this class are as follows:</p>
 * <ul>
 *   <li>{@link #userId}:
 *     <ul>
 *       <li>Description: The ID of the user associated with the registration request.</li>
 *       <li>Annotation: {@link NotNull}</li>
 *     </ul>
 *   </li>
 *   <li>{@link #beneinsert}:
 *     <ul>
 *       <li>Description: An ArrayList of {@link BeneInsert} objects representing the beneficiaries to be registered.</li>
 *       <li>Annotation: {@link NotEmpty}</li>
 *       <li>Additional Annotation: {@link Valid}</li>
 *     </ul>
 *   </li>
 * </ul>
 *
 * @see Request
 * @see lombok.Getter
 * @see lombok.Setter
 * @see lombok.ToString
 * @see JsonTags
 * @see BeneInsert
 *
 * @since 1.0
 * @author Abhideep Chakravarty
 */
@Getter
@Setter
@ToString
@JsonTags(encrypted = "BeneficiaryRegistrationRequestBodyEncrypted",
    root = "BeneficiaryRegistrationRequest",
    body = "BeneficiaryRegistrationRequestBody")
public class BeneficiaryRegistrationRequest extends Request {

    @NotNull
    private String userId = "System";
    @NotEmpty
    private ArrayList<@Valid BeneInsert> beneinsert;

}

