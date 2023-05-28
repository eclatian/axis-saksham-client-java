/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.eclatian.oss.axis.saksham.client.transferpayments;

import lombok.Getter;

/**
 *
 * @author Abhideep
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

    private TxnPayMode(String pHint) {
        this.hint = pHint;
    }
    
    
}
