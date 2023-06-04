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

