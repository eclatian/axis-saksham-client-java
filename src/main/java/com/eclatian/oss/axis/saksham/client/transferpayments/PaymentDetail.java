/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.eclatian.oss.axis.saksham.client.transferpayments;

import com.eclatian.oss.axis.saksham.client.utils.CommonUtil;
import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.validation.constraints.NotNull;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.ArrayList;
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
public class PaymentDetail {

    public PaymentDetail() {
        ZoneId zone = ZoneId.of("Asia/Kolkata");
        this.valueDate = CommonUtil.INSTANCE.getDateAsString(ZonedDateTime.now(zone));
    } 
    
    @NotNull
    private TxnPayMode txnPaymode;
    @NotNull
    private String custUniqRef;
    private String txnType;
    @NotNull
    private String txnAmount;
    @NotNull
    private String corpAccNum;
    @NotNull
    private String valueDate;
    @NotNull
    private String beneName;
    @NotNull
    private String beneCode;
    @NotNull
    private String beneAccNum;
    private String beneAcType;
    private String beneAddr1;
    private String beneAddr2;
    private String beneAddr3;
    private String beneCity;
    private String beneState;
    private String benePincode;
    private String beneIfscCode;
    private String beneBankName;
    private String baseCode;
    private String chequeNumber;
    private Date chequeDate;
    private String payableLocation;
    private String printLocation;
    private String beneEmailAddr1;
    private String beneMobileNo;
    private String productCode;
    private ArrayList<InvoiceDetail> invoiceDetails;
    private String enrichment1;
    private String enrichment2;
    private String enrichment3;
    private String enrichment4;
    private String enrichment5;
    private String senderToReceiverInfo;
    private String beneLEI;
    
    public void setValueDate(String pValueDate) {
        ZoneId zone = ZoneId.of("Asia/Kolkata");
        this.valueDate = CommonUtil.INSTANCE.getDateAsString(ZonedDateTime.now(zone));
    }

    public String getValueDate() {
        return this.valueDate;
    }
}
