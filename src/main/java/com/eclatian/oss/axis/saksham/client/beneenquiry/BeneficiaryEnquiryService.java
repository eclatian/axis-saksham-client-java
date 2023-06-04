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

