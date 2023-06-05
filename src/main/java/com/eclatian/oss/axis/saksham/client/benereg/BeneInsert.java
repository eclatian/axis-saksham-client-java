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

import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;


/**
 * The {@code BeneInsert} class represents a beneficiary insert request.
 * It encapsulates the details required for inserting a beneficiary.
 * The class provides getters and setters for accessing and modifying the beneficiary information.
 *
 *
 * <p>Individual attributes of this class and their annotations are as follows:</p>
 * <ul>
 *   <li>{@link #apiVersion}:
 *     <ul>
 *       <li>Default Value: "1.0"</li>
 *       <li>Description: Represents the API version used for the beneficiary insert request.</li>
 *     </ul>
 *   </li>
 *   <li>{@link #beneLEI}:
 *     <ul>
 *       <li>Description: Represents the Legal Entity Identifier (LEI) of the beneficiary.</li>
 *     </ul>
 *   </li>
 *   <li>{@link #beneCode}:
 *     <ul>
 *       <li>Annotation: {@link javax.validation.constraints.NotNull}</li>
 *       <li>Description: Represents the code associated with the beneficiary.</li>
 *       <li>Importance: This annotation indicates that the beneficiary code cannot be null, helping to ensure data integrity and prevent potential errors.</li>
 *     </ul>
 *   </li>
 *   <li>{@link #beneName}:
 *     <ul>
 *       <li>Annotation: {@link javax.validation.constraints.NotNull}</li>
 *       <li>Description: Represents the name of the beneficiary.</li>
 *       <li>Importance: This annotation indicates that the beneficiary name cannot be null, helping to ensure data integrity and prevent potential errors.</li>
 *     </ul>
 *   </li>
 *   <li>{@link #beneAccNum}:
 *     <ul>
 *       <li>Annotation: {@link javax.validation.constraints.NotNull}</li>
 *       <li>Description: Represents the account number of the beneficiary.</li>
 *       <li>Importance: This annotation indicates that the beneficiary account number cannot be null, helping to ensure data integrity and prevent potential errors.</li>
 *     </ul>
 *   </li>
 *   <li>{@link #beneIfscCode}:
 *     <ul>
 *       <li>Annotation: {@link javax.validation.constraints.NotNull}</li>
 *       <li>Description: Represents the IFSC code of the beneficiary's bank.</li>
 *       <li>Importance: This annotation indicates that the beneficiary IFSC code cannot be null, helping to ensure data integrity and prevent potential errors.</li>
 *     </ul>
 *   </li>
 *   <li>{@link #beneAcType}:
 *     <ul>
 *       <li>Description: Represents the account type of the beneficiary.</li>
 *     </ul>
 *   </li>
 *   <li>{@link #beneBankName}:
 *     <ul>
 *       <li>Description: Represents the name of the beneficiary's bank.</li>
 *     </ul>
 *   </li>
 *   <li>{@link #beneAddr1}:
 *     <ul>
 *       <li>Description: Represents the address line 1 of the beneficiary.</li>
 *     </ul>
 *   </li>
 *   <li>{@link #beneAddr2}:
 *     <ul>
 *       <li>Description: Represents the address line 2 of the beneficiary.</li>
 *     </ul>
 *   </li>
 *   <li>{@link #beneAddr3}:
 *     <ul>
 *       <li>Description: Represents the address line 3 of the beneficiary.</li>
 *     </ul>
 *   </li>
 *   <li>{@link #beneCity}:
 *     <ul>
 *       <li>Description: Represents the city of the beneficiary's address.</li>
 *     </ul>
 *   </li>
 *   <li>{@link #beneState}:
 *     <ul>
 *       <li>Description: Represents the state of the beneficiary's address.</li>
 *     </ul>
 *   </li>
 *   <li>{@link #benePincode}:
 *     <ul>
 *       <li>Description: Represents the pincode of the beneficiary's address.</li>
 *     </ul>
 *   </li>
 *   <li>{@link #beneEmailAddr1}:
 *     <ul>
 *       <li>Description: Represents the primary email address of the beneficiary.</li>
 *     </ul>
 *   </li>
 *   <li>{@link #beneMobileNo}:
 *     <ul>
 *       <li>Description: Represents the mobile number of the beneficiary.</li>
 *     </ul>
 *   </li>
 * </ul>
 *
 * @see lombok.Getter
 * @see lombok.Setter
 * @see lombok.ToString
 * @see com.fasterxml.jackson.annotation.JsonInclude
 *
 * @since 1.0
 * 
 * @author Abhideep Chakravarty
 */
@Getter
@Setter
@ToString
@JsonInclude(JsonInclude.Include.NON_NULL)
public class BeneInsert {
    private String apiVersion = "1.0";
    private String beneLEI;
    @NotNull
    private String beneCode;
    @NotNull
    private String beneName;
    @NotNull
    private String beneAccNum;
    @NotNull
    private String beneIfscCode;
    private String beneAcType;
    private String beneBankName;
    private String beneAddr1;
    private String beneAddr2;
    private String beneAddr3;
    private String beneCity;
    private String beneState;
    private String benePincode;
    private String beneEmailAddr1;
    private String beneMobileNo;
}
