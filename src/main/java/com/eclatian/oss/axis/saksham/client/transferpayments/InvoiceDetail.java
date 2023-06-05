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

import com.fasterxml.jackson.annotation.JsonInclude;
import java.util.Date;
import lombok.Getter;
import lombok.Setter;

/**
 * Represents the InvoiceDetail class, which is a data transfer object (DTO) for invoice details.
 * The class is annotated with Lombok's @Getter and @Setter annotations to generate getter and setter methods.
 * The @JsonInclude annotation is used to exclude properties with null values during JSON serialization.
 * 
 * <p>Attributes:
 * - invoiceAmount: The amount of the invoice.
 * - invoiceNumber: The number of the invoice.
 * - invoiceDate: The date of the invoice.
 * - cashDiscount: The cash discount applied to the invoice.
 * - tax: The tax amount applied to the invoice.
 * - netAmount: The net amount payable for the invoice.
 * 
 * Example usage:
 * InvoiceDetail invoice = new InvoiceDetail();
 * invoice.setInvoiceAmount("1000");
 * invoice.setInvoiceNumber("INV-001");
 * invoice.setInvoiceDate(new Date());
 * invoice.setCashDiscount("50");
 * invoice.setTax("100");
 * invoice.setNetAmount("950");
 *
 * // Serialize the invoice object to JSON
 * ObjectMapper objectMapper = new ObjectMapper();
 * String json = objectMapper.writeValueAsString(invoice);
 *
 * // Deserialize the JSON back to an InvoiceDetail object
 * InvoiceDetail deserializedInvoice = objectMapper.readValue(json, InvoiceDetail.class);
 *
 * @see lombok.Getter
 * @see lombok.Setter
 * @see com.fasterxml.jackson.annotation.JsonInclude
 */
@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class InvoiceDetail {
    /**
     * The amount of the invoice.
     */
    private String invoiceAmount;
    
    /**
     * The number of the invoice.
     */
    private String invoiceNumber;
    
    /**
     * The date of the invoice.
     */
    private Date invoiceDate;
    
    /**
     * The cash discount applied to the invoice.
     */
    private String cashDiscount;
    
    /**
     * The tax amount applied to the invoice.
     */
    private String tax;
    
    /**
     * The net amount payable for the invoice.
     */
    private String netAmount;
}
