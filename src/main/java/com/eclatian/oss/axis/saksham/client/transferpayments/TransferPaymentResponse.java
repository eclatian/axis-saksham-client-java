package com.eclatian.oss.axis.saksham.client.transferpayments;

import com.eclatian.oss.axis.saksham.client.annotation.JsonTags;
import com.eclatian.oss.axis.saksham.client.base.Response;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@JsonTags(encrypted = "TransferPaymentResponseBodyEncrypted",
    root = "TransferPaymentResponse",
    body = "data")
@JsonInclude(JsonInclude.Include.ALWAYS)
public class TransferPaymentResponse extends Response {

    
    
}
