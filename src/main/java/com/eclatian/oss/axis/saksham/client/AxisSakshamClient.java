/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */
package com.eclatian.oss.axis.saksham.client;

import com.eclatian.oss.axis.saksham.client.transferpayments.PaymentDetail;
import com.eclatian.oss.axis.saksham.client.transferpayments.TransferPaymentRequest;
import com.eclatian.oss.axis.saksham.client.transferpayments.TransferPaymentService;
import com.eclatian.oss.axis.saksham.client.transferpayments.TxnPayMode;
import java.io.FileInputStream;
import java.util.ArrayList;
import org.slf4j.impl.SimpleLogger;

/**
 *
 * @author Abhideep
 */
public class AxisSakshamClient {

    public static void main(String[] args) throws Exception {
        
        System.setProperty(SimpleLogger.DEFAULT_LOG_LEVEL_KEY, "DEBUG");
        //Logger logger = LoggerFactory.getLogger(AxisSakshamClient.class);
    
        //logger.debug("Hello World!");
        InitializationOptions pOptions = null;
        pOptions = new InitializationOptions.Builder()
            .env(SakshamEnv.UAT)
            .corpCode("DEMOCORP245")
            .channelId("ECLATIAN")
            .clientId("17958ab3-ee2f-4b4c-a4e6-30cd510018e6")
            .clientSecret("N6oB2jW8vJ1eG4kF7iV4cG4jN5gX0nT4vD2rQ4fY2iP1mS7kE6")
            .key("C7D6E723A5638043753CCDD5FE761ACF")
            .certFileStream(new FileInputStream("api.eclatian.net.p12"))
            .certPassPhrase("HelloAxis!1you")
            .autoPopulateSubHeader(true)
            .hideRequestRawJson(true)
            .build();

        SakshamManager.INSTANCE.initialize(pOptions);
        
        
        /*BeneficiaryRegistrationRequest beneficiaryRegistrationRequest = new BeneficiaryRegistrationRequest();
        ArrayList<BeneInsert> beneinsert = new ArrayList<>();
        beneficiaryRegistrationRequest.setBeneinsert(beneinsert);
        BeneInsert e = new BeneInsert();
        e.setBeneAccNum("12344567");
        e.setBeneCode("qwerty");
        e.setBeneIfscCode("DLEN004658");
        e.setBeneName("ABC");
        beneinsert.add(e);
        BeneRegistrationService bs = new BeneRegistrationService();
        bs.trigger(beneficiaryRegistrationRequest);*/
        
        
        TransferPaymentRequest req = new TransferPaymentRequest();
        req.setChannelId(SakshamManager.INSTANCE.getOptions()
            .getChannelId());
        req.setCorpCode(SakshamManager.INSTANCE.getOptions()
            .getCorpCode());
        ArrayList<PaymentDetail> paymentDetails = new ArrayList<>();
        req.setPaymentDetails(paymentDetails);
        PaymentDetail e2 = new PaymentDetail();
        paymentDetails.add(e2);
        
        e2.setCorpAccNum("337010100099891");
        e2.setCustUniqRef("ABCDREF");
        e2.setTxnAmount("200");
        e2.setBeneAccNum("337010100099891");
        e2.setBeneCode("BCODE");
        e2.setValueDate("lsdkjfh");
        e2.setTxnPaymode(TxnPayMode.NE);
        e2.setBeneName("MyName");
        
        
        TransferPaymentService ts = new TransferPaymentService();
        ts.trigger(req);
        
        /*System.out.println("Checksum test = " + ChecksumUtil.encodeCheckSumWithSHA256("ECLATIANDEMOCORP245NEABCDREF2003370101000998912023-02-06MyNameBCODE337010100099891"));*/
        
        /*BeneficiaryEnquiryRequest r = new BeneficiaryEnquiryRequest();
        r.setEmailId("abhideep.chakravarty@eclatian.com");
        r.setStatus(BeneStatus.All);
        ArrayList<String> beneCode = new ArrayList<>();
        beneCode.add("qwerty");
        r.setBeneCode(beneCode);
        BeneficiaryEnquiryService s = new BeneficiaryEnquiryService();
        s.trigger(r);*/
        
        /*GetStatusRequest bs2 = new GetStatusRequest();
        bs2.setCrn("akjsdh");
        GetStatusService gss = new GetStatusService();
        gss.trigger(bs2);*/
    }
}
