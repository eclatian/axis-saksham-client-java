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

package com.eclatian.oss.axis.saksham.client.beneenquiry;

/**
 * The {@code BeneStatus} enum represents the status of a beneficiary.
 * It defines three possible values: "Inactive", "Active", and "All".
 *
 * <p>The {@code BeneStatus} enum provides a set of constants that represent the possible beneficiary statuses.</p>
 *
 * <p><strong>Example Usage:</strong></p>
 * <pre>{@code
 * BeneStatus status = BeneStatus.Active;
 *
 * if (status == BeneStatus.Active) {
 *     System.out.println("Beneficiary is active");
 * } else if (status == BeneStatus.Inactive) {
 *     System.out.println("Beneficiary is inactive");
 * } else if (status == BeneStatus.All) {
 *     System.out.println("All beneficiaries");
 * }
 * }</pre>
 *
 * @author: Abhideep Chakravarty
 */
public enum BeneStatus {
    /**
     * Represents an inactive beneficiary.
     */
    Inactive,

    /**
     * Represents an active beneficiary.
     */
    Active,

    /**
     * Represents all beneficiaries.
     */
    All;
}

