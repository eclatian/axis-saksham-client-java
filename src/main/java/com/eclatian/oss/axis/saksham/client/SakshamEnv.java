/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.eclatian.oss.axis.saksham.client;

import lombok.Getter;

/**
 *
 * @author Abhideep
 */
@Getter
public enum SakshamEnv {
    
    UAT("https://sakshamuat.axisbank.co.in/gateway/api/txb/v1"),
    PROD("");
    
    private String apiRootURL;
    
    SakshamEnv(String pValue) {
        this.apiRootURL = pValue;
    }
}
