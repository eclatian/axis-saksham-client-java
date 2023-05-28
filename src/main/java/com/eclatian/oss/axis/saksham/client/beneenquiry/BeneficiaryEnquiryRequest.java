
package com.eclatian.oss.axis.saksham.client.beneenquiry;

import com.eclatian.oss.axis.saksham.client.annotation.JsonTags;
import com.eclatian.oss.axis.saksham.client.base.Request;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import java.util.ArrayList;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;


/**
 * The {@code BeneficiaryEnquiryRequest} class represents a request for beneficiary enquiry.
 * It extends the {@link Request} class and includes additional fields specific to beneficiary enquiry.
 *
 * <p>The {@code BeneficiaryEnquiryRequest} class provides getter and setter methods for its fields,
 * as well as a overridden {@code toString()} method for easy string representation.</p>
 *
 * <p>The JSON tags for serialization/deserialization are specified using the {@link JsonTags} annotation.
 * The {@code root} tag is set to "BeneficiaryEnquiryRequest",
 * the {@code body} tag is set to "BeneficiaryEnquiryRequestBody",
 * and the {@code encrypted} tag is set to "BeneficiaryEnquiryRequestBodyEncrypted".</p>
 *
 * <p><strong>Example Usage:</strong></p>
 * <pre>{@code
 * BeneficiaryEnquiryRequest request = new BeneficiaryEnquiryRequest();
 * request.setFromDate("2022-01-01");
 * request.setToDate("2022-12-31");
 * request.setEmailId("example@example.com");
 * request.setStatus(BeneStatus.Active);
 * request.setBeneCode(new ArrayList<>(Arrays.asList("B001", "B002")));
 *
 * System.out.println(request.toString());
 * }</pre>
 *
 * <p><strong>Author:</strong> Abhideep Chakravarty</p>
 */
@Getter
@Setter
@ToString
@JsonTags(encrypted = "BeneficiaryEnquiryRequestBodyEncrypted",
    root = "BeneficiaryEnquiryRequest",
    body = "BeneficiaryEnquiryRequestBody")
public class BeneficiaryEnquiryRequest extends Request {
    private String fromDate;
    private String toDate;

    /**
     * The email ID for beneficiary inquiry.
     */
    @Email
    private String emailId;

    /**
     * The status of beneficiaries to include in the inquiry.
     */
    @NotNull
    private BeneStatus status;

    /**
     * The list of beneficiary codes for inquiry.
     */
    @NotEmpty
    private ArrayList<String> beneCode;
}
