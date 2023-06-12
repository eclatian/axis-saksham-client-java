/*
 *
 * Axis Saksham Java Client SDK
 * This is the java SDK to consume Axis Sakham APIs. This reduces the boiler plate coding required to make API calls
 * and hence speeds up the developers to integrate with Saksham API in faster and productive way.
 *
 * 2023 Eclatian Technologies Pvt. Ltd.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
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
        if (res != null) {
            assertEquals(null, res.getChecksum());            
        }

        
        
        
       
    }
}
