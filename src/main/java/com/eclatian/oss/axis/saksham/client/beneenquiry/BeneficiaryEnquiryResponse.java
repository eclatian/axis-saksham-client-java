/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.eclatian.oss.axis.saksham.client.beneenquiry;

import com.eclatian.oss.axis.saksham.client.annotation.JsonTags;
import com.eclatian.oss.axis.saksham.client.base.Response;
import com.eclatian.oss.axis.saksham.client.benereg.BeneDetail;
import java.util.List;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;


/**
 * The {@code BeneficiaryEnquiryResponse} class represents a response for beneficiary enquiry.
 * It extends the {@link Response} class and includes additional fields specific to beneficiary enquiry.
 *
 * <p>The {@code BeneficiaryEnquiryResponse} class provides getter and setter methods for its fields,
 * as well as an overridden {@code toString()} method for easy string representation.</p>
 *
 * <p>The JSON tags for serialization/deserialization are specified using the {@link JsonTags} annotation.
 * The {@code root} tag is set to "BeneficiaryEnquiryResponse",
 * the {@code body} tag is set to "data",
 * and the {@code encrypted} tag is set to "BeneficiaryEnquiryResponseBodyEncrypted".</p>
 *
 * <p><strong>Example Usage:</strong></p>
 * <pre>{@code
 * BeneficiaryEnquiryResponse response = new BeneficiaryEnquiryResponse();
 * response.setCount(2);
 *
 * BeneDetail detail1 = new BeneDetail();
 * detail1.setName("John Doe");
 * detail1.setAccountNumber("1234567890");
 *
 * BeneDetail detail2 = new BeneDetail();
 * detail2.setName("Jane Smith");
 * detail2.setAccountNumber("0987654321");
 *
 * response.setBeneDetails(Arrays.asList(detail1, detail2));
 *
 * System.out.println(response.toString());
 * }</pre>
 *
 * <p><strong>Author:</strong> Abhideep Chakravarty</p>
 */
@Getter
@Setter
@ToString
@JsonTags(encrypted = "BeneficiaryEnquiryResponseBodyEncrypted",
    root = "BeneficiaryEnquiryResponse",
    body = "data")
public class BeneficiaryEnquiryResponse extends Response {
    
    /**
     * The count of beneficiary details returned in the response.
     */
    private int count;
    
    /**
     * The list of beneficiary details.
     */
    private List<BeneDetail> beneDetails;
}
