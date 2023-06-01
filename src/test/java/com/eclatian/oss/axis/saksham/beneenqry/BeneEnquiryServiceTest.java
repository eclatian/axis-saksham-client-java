/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.eclatian.oss.axis.saksham.beneenqry;

/**
 *
 * @author Abhideep
 */
import com.eclatian.oss.axis.saksham.client.base.SakshamClientException;
import com.eclatian.oss.axis.saksham.client.beneenquiry.BeneStatus;
import com.eclatian.oss.axis.saksham.client.beneenquiry.BeneficiaryEnquiryRequest;
import com.eclatian.oss.axis.saksham.client.beneenquiry.BeneficiaryEnquiryResponse;
import com.eclatian.oss.axis.saksham.client.beneenquiry.BeneficiaryEnquiryService;
import com.eclatian.oss.axis.saksham.common.TestUtil;
import java.util.ArrayList;
import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.Test;

public class BeneEnquiryServiceTest {

    

    @Before
    public void setUp() {
        TestUtil.initialize();
        
    }

    @Test
    public void testTrigger() throws SakshamClientException {
        // Create a mock request
        BeneficiaryEnquiryRequest r = new BeneficiaryEnquiryRequest();
        r.setEmailId("abhideep.chakravarty@eclatian.com");
        r.setStatus(BeneStatus.All);
        ArrayList<String> beneCode = new ArrayList<>();
        beneCode.add("qwerty");
        r.setBeneCode(beneCode);
        

        
        // Call the method under test
        BeneficiaryEnquiryService service = new BeneficiaryEnquiryService();
        BeneficiaryEnquiryResponse actualResponse = service
            .trigger(r);

        // Verify the expected behavior
        assertEquals("12344567", actualResponse.getBeneDetails().get(0).getBeneAccNum());
       
    }
}
