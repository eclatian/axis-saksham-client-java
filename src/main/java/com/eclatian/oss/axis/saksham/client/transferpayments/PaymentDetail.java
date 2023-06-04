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
 * Represents the PaymentDetail class, which is a data transfer object (DTO) for payment details.
 * The class is annotated with Lombok's @Getter and @Setter annotations to generate getter and setter methods.
 * The @JsonInclude annotation is used to exclude properties with null values during JSON serialization.
 * 
 * <p>Attributes:
 * - txnPaymode: The payment mode for the transaction.
 * - custUniqRef: The unique reference for the customer.
 * - txnType: The type of transaction.
 * - txnAmount: The amount of the transaction.
 * - corpAccNum: The corporate account number.
 * - valueDate: The value date of the transaction.
 * - beneName: The beneficiary name.
 * - beneCode: The beneficiary code.
 * - beneAccNum: The beneficiary account number.
 * - beneAcType: The beneficiary account type.
 * - beneAddr1: The first line of the beneficiary address.
 * - beneAddr2: The second line of the beneficiary address.
 * - beneAddr3: The third line of the beneficiary address.
 * - beneCity: The city of the beneficiary.
 * - beneState: The state of the beneficiary.
 * - benePincode: The pincode of the beneficiary.
 * - beneIfscCode: The IFSC code of the beneficiary bank.
 * - beneBankName: The name of the beneficiary bank.
 * - baseCode: The base code.
 * - chequeNumber: The number of the cheque.
 * - chequeDate: The date of the cheque.
 * - payableLocation: The payable location.
 * - printLocation: The print location.
 * - beneEmailAddr1: The primary email address of the beneficiary.
 * - beneMobileNo: The mobile number of the beneficiary.
 * - productCode: The product code.
 * - invoiceDetails: The list of invoice details.
 * - enrichment1: The first enrichment.
 * - enrichment2: The second enrichment.
 * - enrichment3: The third enrichment.
 * - enrichment4: The fourth enrichment.
 * - enrichment5: The fifth enrichment.
 * - senderToReceiverInfo: The sender-to-receiver information.
 * - beneLEI: The Legal Entity Identifier (LEI) of the beneficiary.
 * 
 * Example usage:
 * PaymentDetail payment = new PaymentDetail();
 * payment.setTxnPaymode(TxnPayMode.CASH);
 * payment.setCustUniqRef("123456789");
 * payment.setTxnAmount("1000");
 * payment.setCorpAccNum("CORP-001");
 * payment.setBeneName("John Doe");
 * payment.setBeneAccNum("BENE-001");
 * payment.setValueDate("2022-01-01");
 *
 * // Serialize the payment object to JSON
 * ObjectMapper objectMapper = new ObjectMapper();
 * String json = objectMapper.writeValueAsString(payment);
 *
 * // Deserialize the JSON back to a PaymentDetail object
 * PaymentDetail deserializedPayment = objectMapper.readValue(json, PaymentDetail.class);
 *
 * @see lombok.Getter
 * @see lombok.Setter
 * @see com.fasterxml.jackson.annotation.JsonInclude
 */
@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class PaymentDetail {
    /**
     * The payment mode for the transaction.
     */
    @NotNull
    private TxnPayMode txnPaymode;
    
    /**
     * The unique reference for the customer.
     */
    @NotNull
    private String custUniqRef;
    
    /**
     * The type of transaction.
     */
    private String txnType;
    
    /**
     * The amount of the transaction.
     */
    @NotNull
    private String txnAmount;
    
    /**
     * The corporate account number.
     */
    @NotNull
    private String corpAccNum;
    
    /**
     * The value date of the transaction.
     */
    @NotNull
    private String valueDate;
    
    /**
     * The beneficiary name.
     */
    @NotNull
    private String beneName;
    
    /**
     * The beneficiary code.
     */
    @NotNull
    private String beneCode;
    
    /**
     * The beneficiary account number.
     */
    @NotNull
    private String beneAccNum;
    
    /**
     * The beneficiary account type.
     */
    private String beneAcType;
    
    /**
     * The first line of the beneficiary address.
     */
    private String beneAddr1;
    
    /**
     * The second line of the beneficiary address.
     */
    private String beneAddr2;
    
    /**
     * The third line of the beneficiary address.
     */
    private String beneAddr3;
    
    /**
     * The city of the beneficiary.
     */
    private String beneCity;
    
    /**
     * The state of the beneficiary.
     */
    private String beneState;
    
    /**
     * The pincode of the beneficiary.
     */
    private String benePincode;
    
    /**
     * The IFSC code of the beneficiary bank.
     */
    private String beneIfscCode;
    
    /**
     * The name of the beneficiary bank.
     */
    private String beneBankName;
    
    /**
     * The base code.
     */
    private String baseCode;
    
    /**
     * The number of the cheque.
     */
    private String chequeNumber;
    
    /**
     * The date of the cheque.
     */
    private Date chequeDate;
    
    /**
     * The payable location.
     */
    private String payableLocation;
    
    /**
     * The print location.
     */
    private String printLocation;
    
    /**
     * The primary email address of the beneficiary.
     */
    private String beneEmailAddr1;
    
    /**
     * The mobile number of the beneficiary.
     */
    private String beneMobileNo;
    
    /**
     * The product code.
     */
    private String productCode;
    
    /**
     * The list of invoice details.
     */
    private ArrayList<InvoiceDetail> invoiceDetails;
    
    /**
     * The first enrichment.
     */
    private String enrichment1;
    
    /**
     * The second enrichment.
     */
    private String enrichment2;
    
    /**
     * The third enrichment.
     */
    private String enrichment3;
    
    /**
     * The fourth enrichment.
     */
    private String enrichment4;
    
    /**
     * The fifth enrichment.
     */
    private String enrichment5;
    
    /**
     * The sender-to-receiver information.
     */
    private String senderToReceiverInfo;
    
    /**
     * The Legal Entity Identifier (LEI) of the beneficiary.
     */
    private String beneLEI;
    
    /**
     * Initializes the valueDate attribute with the current date in the "Asia/Kolkata" time zone.
     */
    public PaymentDetail() {
        ZoneId zone = ZoneId.of("Asia/Kolkata");
        this.valueDate = CommonUtil.INSTANCE.getDateAsString(ZonedDateTime.now(zone));
    }
    
    /**
     * Sets the value of the valueDate attribute to the current date in the "Asia/Kolkata" time zone.
     * This method is used as a setter for valueDate.
     *
     * @param pValueDate The value of valueDate to be set.
     */
    public void setValueDate(String pValueDate) {
        ZoneId zone = ZoneId.of("Asia/Kolkata");
        this.valueDate = CommonUtil.INSTANCE.getDateAsString(ZonedDateTime.now(zone));
    }

    /**
     * Retrieves the value of the valueDate attribute.
     *
     * @return The value of valueDate.
     */
    public String getValueDate() {
        return this.valueDate;
    }
}
