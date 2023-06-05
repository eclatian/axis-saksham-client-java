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
import com.eclatian.oss.axis.saksham.client.base.Response;
import java.util.List;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * The {@code BeneficiaryRegistrationResponse} class represents a response for beneficiary registration.
 * It extends the {@link Response} class and encapsulates the response data related to beneficiary registration.
 * The class provides getters and setters for accessing and modifying the response data.
 *
 *
 * <p>The annotation {@code @JsonTags} is used with the following parameters:</p>
 * <ul>
 *   <li>{@code encrypted}:
 *     <ul>
 *       <li>Description: Specifies the JSON tag for the encrypted part of the response body.</li>
 *       <li>Value: "BeneficiaryRegistrationResponseBodyEncrypted"</li>
 *     </ul>
 *   </li>
 *   <li>{@code root}:
 *     <ul>
 *       <li>Description: Specifies the JSON tag for the root element of the response.</li>
 *       <li>Value: "BeneficiaryRegistrationResponse"</li>
 *     </ul>
 *   </li>
 *   <li>{@code body}:
 *     <ul>
 *       <li>Description: Specifies the JSON tag for the response body.</li>
 *       <li>Value: "data"</li>
 *     </ul>
 *   </li>
 * </ul>
 *
 * <p>Individual attributes of this class are as follows:</p>
 * <ul>
 *   <li>{@link #beneDetails}:
 *     <ul>
 *       <li>Description: A list of {@link BeneDetail} objects containing details of the registered beneficiaries.</li>
 *     </ul>
 *   </li>
 * </ul>
 *
 * @see Response
 * @see lombok.Getter
 * @see lombok.Setter
 * @see lombok.ToString
 * @see JsonTags
 * @see BeneDetail
 *
 * @since 1.0
 * @author Abhideep Chakravarty
 */
@Getter
@Setter
@ToString
@JsonTags(encrypted = "BeneficiaryRegistrationResponseBodyEncrypted",
    root = "BeneficiaryRegistrationResponse",
    body = "data")
public class BeneficiaryRegistrationResponse extends Response {
    
    /**
     * The list of beneficiary details representing the registered beneficiaries.
     */
    private List<BeneDetail> beneDetails;
}

