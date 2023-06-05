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
package com.eclatian.oss.axis.saksham.client.beneenquiry;

import com.eclatian.oss.axis.saksham.client.annotation.AxisAPI;
import com.eclatian.oss.axis.saksham.client.base.BaseService;


/**
 * The {@code BeneficiaryEnquiryService} class represents a service for beneficiary enquiry.
 * It extends the {@link BaseService} class and is annotated with {@link AxisAPI} to specify the API path.
 *
 * <p>The {@code BeneficiaryEnquiryService} class is responsible for handling beneficiary enquiry requests
 * and generating corresponding responses of type {@link BeneficiaryEnquiryRequest} and {@link BeneficiaryEnquiryResponse}.</p>
 *
 * <p>The API path for the beneficiary enquiry service is specified using the {@link AxisAPI} annotation,
 * with the {@code path} attribute set to "/payee-mgmt/beneficiary-enquiry".</p>
 *
 * <p><strong>Example Usage:</strong></p>
 * <pre>{@code
 * BeneficiaryEnquiryService service = new BeneficiaryEnquiryService();
 *
 * BeneficiaryEnquiryRequest request = new BeneficiaryEnquiryRequest();
 * request.setFromDate("2022-01-01");
 * request.setToDate("2022-12-31");
 * request.setEmailId("john@example.com");
 * request.setStatus(BeneStatus.Active);
 * request.setBeneCode(Arrays.asList("123", "456"));
 *
 * BeneficiaryEnquiryResponse response = service.trigger(request);
 *
 * System.out.println(response.toString());
 * }</pre>
 *
 * @author: Abhideep Chakravarty
 */
@AxisAPI(path = "/payee-mgmt/beneficiary-enquiry")
public class BeneficiaryEnquiryService extends BaseService<BeneficiaryEnquiryRequest,
    BeneficiaryEnquiryResponse> {
}

