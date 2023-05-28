/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.eclatian.oss.axis.saksham.benereg;

/**
 *
 * @author Abhideep
 */
import com.eclatian.oss.axis.saksham.client.base.SakshamClientException;
import com.eclatian.oss.axis.saksham.client.benereg.BeneInsert;
import com.eclatian.oss.axis.saksham.client.benereg.BeneRegistrationService;
import com.eclatian.oss.axis.saksham.client.benereg.BeneficiaryRegistrationRequest;
import com.eclatian.oss.axis.saksham.client.benereg.BeneficiaryRegistrationResponse;
import com.eclatian.oss.axis.saksham.common.TestUtil;
import java.util.ArrayList;
import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.Test;

public class BeneRegistrationServiceTest {

    

    @Before
    public void setUp() {
        TestUtil.initialize();
        
    }

    @Test
    public void testTrigger() throws SakshamClientException {
        // Create a mock request
        BeneficiaryRegistrationRequest beneficiaryRegistrationRequest = new BeneficiaryRegistrationRequest();
        ArrayList<BeneInsert> beneinsert = new ArrayList<>();
        beneficiaryRegistrationRequest.setBeneinsert(beneinsert);
        BeneInsert e = new BeneInsert();
        e.setBeneAccNum("12344567");
        e.setBeneCode("qwerty");
        e.setBeneIfscCode("DLEN004658");
        e.setBeneName("ABC");
        beneinsert.add(e);
        

        
        // Call the method under test
        BeneRegistrationService beneRegistrationService = new BeneRegistrationService();
        BeneficiaryRegistrationResponse actualResponse = beneRegistrationService
            .trigger(beneficiaryRegistrationRequest);

        // Verify the expected behavior
        assertEquals("12344567", actualResponse.getBeneDetails().get(0).getBeneAccNum());
       
    }
}
