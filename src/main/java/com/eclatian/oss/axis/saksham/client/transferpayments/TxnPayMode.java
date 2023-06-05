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
package com.eclatian.oss.axis.saksham.client.transferpayments;

import lombok.Getter;

/**
 * Represents the transaction payment mode.
 *
 * <p>
 * <b>Author:</b> Abhideep Chakravarty
 * </p>
 */
@Getter
public enum TxnPayMode {

    RT("RTGS"),
    NE("NEFT"),
    PA("IMPS"),
    FT("Fund Transfer (Axis to Axis)"),
    CC("Corporate Cheques"),
    DD("Demand Draft");

    private String hint;

    /**
     * Constructs a new transaction payment mode with the specified hint.
     *
     * @param pHint the hint for the payment mode
     */
    private TxnPayMode(String pHint) {
        this.hint = pHint;
    }
    
}

