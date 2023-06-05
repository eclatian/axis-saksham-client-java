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
