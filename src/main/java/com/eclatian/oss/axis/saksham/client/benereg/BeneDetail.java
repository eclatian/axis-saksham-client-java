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

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * The {@code BeneDetail} class represents the details of a beneficiary.
 * It encapsulates various attributes associated with the beneficiary.
 * The class provides getters and setters for accessing and modifying the beneficiary information.
 *
 * 
 * <p>Individual attributes of this class are as follows:</p>
 * <ul>
 *   <li>{@link #beneMobileNo}:
 *     <ul>
 *       <li>Description: The mobile number of the beneficiary.</li>
 *     </ul>
 *   </li>
 *   <li>{@link #statusDesc}:
 *     <ul>
 *       <li>Description: The status description of the beneficiary.</li>
 *     </ul>
 *   </li>
 *   <li>{@link #beneBankName}:
 *     <ul>
 *       <li>Description: The bank name of the beneficiary.</li>
 *     </ul>
 *   </li>
 *   <li>{@link #beneName}:
 *     <ul>
 *       <li>Description: The name of the beneficiary.</li>
 *     </ul>
 *   </li>
 *   <li>{@link #beneIfscCode}:
 *     <ul>
 *       <li>Description: The IFSC code of the beneficiary's bank.</li>
 *     </ul>
 *   </li>
 *   <li>{@link #beneCode}:
 *     <ul>
 *       <li>Description: The code associated with the beneficiary.</li>
 *     </ul>
 *   </li>
 *   <li>{@link #beneEmailAddr1}:
 *     <ul>
 *       <li>Description: The email address of the beneficiary.</li>
 *     </ul>
 *   </li>
 *   <li>{@link #corpCode}:
 *     <ul>
 *       <li>Description: The corporate code associated with the beneficiary.</li>
 *     </ul>
 *   </li>
 *   <li>{@link #status}:
 *     <ul>
 *       <li>Description: The status of the beneficiary.</li>
 *     </ul>
 *   </li>
 *   <li>{@link #beneAccNum}:
 *     <ul>
 *       <li>Description: The account number of the beneficiary.</li>
 *     </ul>
 *   </li>
 *   <li>{@link #benePincode}:
 *     <ul>
 *       <li>Description: The pin code of the beneficiary's address.</li>
 *     </ul>
 *   </li>
 *   <li>{@link #beneAcType}:
 *     <ul>
 *       <li>Description: The type of account of the beneficiary.</li>
 *     </ul>
 *   </li>
 *   <li>{@link #authorizedBy}:
 *     <ul>
 *       <li>Description: The entity authorized by the beneficiary.</li>
 *     </ul>
 *   </li>
 *   <li>{@link #authorizedDate}:
 *     <ul>
 *       <li>Description: The date of authorization for the beneficiary.</li>
 *     </ul>
 *   </li>
 * </ul>
 *
 * @see lombok.Getter
 * @see lombok.Setter
 * @see lombok.ToString
 *
 * @since 1.0
 * 
 * @author Abhideep Chakravarty
 */
@Getter
@Setter
@ToString
public class BeneDetail {
    /** The mobile number of the beneficiary. */
    private String beneMobileNo;

    /** The status description of the beneficiary. */
    private String statusDesc;

    /** The bank name of the beneficiary. */
    private String beneBankName;

    /** The name of the beneficiary. */
    private String beneName;

    /** The IFSC code of the beneficiary's bank. */
    private String beneIfscCode;

    /** The code associated with the beneficiary. */
    private String beneCode;

    /** The email address of the beneficiary. */
    private String beneEmailAddr1;

    /** The corporate code associated with the beneficiary. */
    private String corpCode;

    /** The status of the beneficiary. */
    private String status;

    /** The account number of the beneficiary. */
    private String beneAccNum;

    /** The pin code of the beneficiary's address. */
    private String benePincode;

    /** The type of account of the beneficiary. */
    private String beneAcType;

    /** The entity authorized by the beneficiary. */
    private String authorizedBy;

    /** The date of authorization for the beneficiary. */
    private String authorizedDate;
}
