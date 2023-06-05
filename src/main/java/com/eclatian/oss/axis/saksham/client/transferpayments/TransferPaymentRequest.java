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

import com.eclatian.oss.axis.saksham.client.annotation.JsonTags;
import com.eclatian.oss.axis.saksham.client.base.Request;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotEmpty;
import java.util.ArrayList;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * Represents a transfer payment request.
 * This class extends the base Request class.
 * It contains a list of payment details for the transfer.
 *
 * <p>
 * @author Abhideep Chakravarty
 * </p>
 */
@Getter
@Setter
@ToString
@JsonTags(encrypted = "TransferPaymentRequestBodyEncrypted",
    root = "TransferPaymentRequest",
    body = "TransferPaymentRequestBody")
public class TransferPaymentRequest extends Request {

    /**
     * The list of payment details for the transfer.
     * The field is mandatory and cannot be empty.
     */
    @NotEmpty(message = "paymentDetails is mandatory")
    private ArrayList<@Valid PaymentDetail> paymentDetails;
    
}

