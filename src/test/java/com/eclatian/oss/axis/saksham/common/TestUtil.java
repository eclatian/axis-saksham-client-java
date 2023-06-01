/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.eclatian.oss.axis.saksham.common;

import com.eclatian.oss.axis.saksham.client.InitializationOptions;
import com.eclatian.oss.axis.saksham.client.SakshamEnv;
import com.eclatian.oss.axis.saksham.client.SakshamManager;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import org.slf4j.impl.SimpleLogger;

/**
 *
 * @author Abhideep
 */
public class TestUtil {
    
    public static void initialize()  {
        System.setProperty(SimpleLogger.DEFAULT_LOG_LEVEL_KEY, "DEBUG");
        String certPath = System.getenv("axis-saksham-cert-path");
        String clientId = System.getenv("axis-saksham-clientId");
        String secret = System.getenv("axis-saksham-secret");
        String key = System.getenv("axis-saksham-key");
        String certPassPhrase = System.getenv("axis-saksham-cert-passphrase");
        String channelId = System.getenv("axis-saksham-channelId");
        String corpCode = System.getenv("axis-saksham-corpCode");
        InitializationOptions pOptions = null;
        try {
            pOptions = new InitializationOptions.Builder()
                .env(SakshamEnv.UAT)
                .corpCode(corpCode)
                .channelId(channelId)
                .clientId(clientId)
                .clientSecret(secret)
                .key(key)
                .certFileStream(new FileInputStream(certPath))
                .certPassPhrase(certPassPhrase)
                .autoPopulateSubHeader(true)
                .hideRequestRawJson(true)
                .build();
        } catch (FileNotFoundException ex) {
            
        }

        SakshamManager.INSTANCE.initialize(pOptions);
    }
    
}
