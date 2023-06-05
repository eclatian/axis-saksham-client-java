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
 * @author: Abhideep Chakravarty
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
