/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.eclatian.oss.axis.saksham.getstatus;

/**
 *
 * @author Abhideep
 */
import com.eclatian.oss.axis.saksham.client.base.SakshamClientException;
import com.eclatian.oss.axis.saksham.client.getstatus.GetStatusRequest;
import com.eclatian.oss.axis.saksham.client.getstatus.GetStatusService;
import com.eclatian.oss.axis.saksham.common.TestUtil;
import org.junit.Before;
import org.junit.Test;

public class GetStatusServiceTest {

    

    @Before
    public void setUp() {
        TestUtil.initialize();
        
    }

    @Test
    public void testTrigger() throws SakshamClientException {
        // Create a mock request
        GetStatusRequest bs2 = new GetStatusRequest();
        bs2.setCrn("ABCDREF");
        
        

        
        // Call the method under test
        GetStatusService gss = new GetStatusService();
        gss.trigger(bs2);

        // Verify the expected behavior
        //assertEquals("12344567", actualResponse.getBeneDetails().get(0).getBeneAccNum());
       
    }
}
