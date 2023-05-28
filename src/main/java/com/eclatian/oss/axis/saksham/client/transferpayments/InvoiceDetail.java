/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.eclatian.oss.axis.saksham.client.transferpayments;

import com.fasterxml.jackson.annotation.JsonInclude;
import java.util.Date;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author Abhideep
 */
@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class InvoiceDetail {
    private String invoiceAmount;
    private String invoiceNumber;
    private Date invoiceDate;
    private String cashDiscount;
    private String tax;
    private String netAmount;
}
