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
public enum SakshamManager {
    INSTANCE;
    
    private InitializationOptions options;
    
    public void initialize(InitializationOptions pOptions) {
        this.options = pOptions;
    }
}
