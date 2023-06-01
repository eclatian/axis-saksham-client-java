/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.eclatian.oss.axis.saksham.transferpayment;

/**
 *
 * @author Abhideep
 */
import com.eclatian.oss.axis.saksham.client.SakshamManager;
import com.eclatian.oss.axis.saksham.client.base.SakshamClientException;
import com.eclatian.oss.axis.saksham.client.transferpayments.PaymentDetail;
import com.eclatian.oss.axis.saksham.client.transferpayments.TransferPaymentRequest;
import com.eclatian.oss.axis.saksham.client.transferpayments.TransferPaymentResponse;
import com.eclatian.oss.axis.saksham.client.transferpayments.TransferPaymentService;
import com.eclatian.oss.axis.saksham.client.transferpayments.TxnPayMode;
import com.eclatian.oss.axis.saksham.common.TestUtil;
import java.util.ArrayList;
import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.Test;

public class TransferPaymentServiceTest {

    

    @Before
    public void setUp() {
        TestUtil.initialize();
        
    }

    @Test
    public void testTrigger() throws SakshamClientException {
        // Create a mock request
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

        

        
        // Call the method under test
        TransferPaymentService ser = new TransferPaymentService();
        TransferPaymentResponse res = ser.trigger(req);

        // Verify the expected behavior
        assertEquals(null, res.getChecksum());
       
    }
}
