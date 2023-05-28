/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
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
 * <p><strong>Author:</strong> Abhideep Chakravarty</p>
 */
@AxisAPI(path = "/payee-mgmt/beneficiary-registration")
public class BeneRegistrationService extends BaseService<BeneficiaryRegistrationRequest, BeneficiaryRegistrationResponse> {
}

