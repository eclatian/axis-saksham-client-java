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

