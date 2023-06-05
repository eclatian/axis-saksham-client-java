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
