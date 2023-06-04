package com.eclatian.oss.axis.saksham.client.transferpayments;

import com.eclatian.oss.axis.saksham.client.annotation.JsonTags;
import com.eclatian.oss.axis.saksham.client.base.Response;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * Represents a transfer payment response.
 * This class extends the base Response class.
 * It contains the data field for the response.
 *
 * <p>
 * @author Abhideep Chakravarty
 * </p>
 */
@Getter
@Setter
@ToString
@JsonTags(encrypted = "TransferPaymentResponseBodyEncrypted",
    root = "TransferPaymentResponse",
    body = "data")
@JsonInclude(JsonInclude.Include.ALWAYS)
public class TransferPaymentResponse extends Response {

    /**
     * The data field for the response.
     */
    private Object data;
    
}

