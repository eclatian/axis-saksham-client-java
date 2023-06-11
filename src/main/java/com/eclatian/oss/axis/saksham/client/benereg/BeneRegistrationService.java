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
package com.eclatian.oss.axis.saksham.client.benereg;

import com.eclatian.oss.axis.saksham.client.annotation.AxisAPI;
import com.eclatian.oss.axis.saksham.client.base.BaseService;

/**
 * The {@code BeneRegistrationService} class represents a service for beneficiary registration.
 * It extends the {@link BaseService} class and is annotated with {@link AxisAPI} to specify the API path.
 *
 * <p>The {@code BeneRegistrationService} class is responsible for handling beneficiary registration requests
 * and generating corresponding responses of type {@link BeneficiaryRegistrationRequest} and {@link BeneficiaryRegistrationResponse}.</p>
 *
 * <p>The API path for the beneficiary registration service is specified using the {@link AxisAPI} annotation,
 * with the {@code path} attribute set to "/payee-mgmt/beneficiary-registration".</p>
 *
 * <p><strong>Example Usage:</strong></p>
 * <pre>{@code
 * BeneRegistrationService service = new BeneRegistrationService();
 *
 * BeneficiaryRegistrationRequest request = new BeneficiaryRegistrationRequest();
 * // Set beneficiary registration request properties
 *
 * BeneficiaryRegistrationResponse response = service.trigger(request);
 *
 * System.out.println(response.toString());
 * }</pre>
 *
 * @author Abhideep Chakravarty
 */
@AxisAPI(path = "/payee-mgmt/beneficiary-registration")
public class BeneRegistrationService extends BaseService<BeneficiaryRegistrationRequest, BeneficiaryRegistrationResponse> {
}

