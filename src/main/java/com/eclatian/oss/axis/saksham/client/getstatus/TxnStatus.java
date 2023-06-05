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
package com.eclatian.oss.axis.saksham.client.getstatus;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * Represents the transaction status information.
 * This class provides getters and setters for accessing the transaction status attributes.
 */
@Getter
@Setter
@ToString
public class TxnStatus {
    /**
     * The corporate code associated with the transaction.
     */
    public String corpCode;
    
    /**
     * The description of the transaction status.
     */
    public String statusDescription;
    
    /**
     * The batch number of the transaction.
     */
    public String batchNo;
    
    /**
     * The unique transaction reference number (UTR).
     * This can be of various types, such as String or Integer, hence it is represented as an Object.
     */
    public Object utrNo;
    
    /**
     * The date when the transaction was processed.
     */
    public String processingDate;
    
    /**
     * The response code of the transaction.
     */
    public String responseCode;
    
    /**
     * The customer reference number (CRN) associated with the transaction.
     */
    public String crn;
    
    /**
     * The current status of the transaction.
     */
    public String transactionStatus;
    
    
}

