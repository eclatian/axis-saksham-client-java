package com.eclatian.oss.axis.saksham.client.transferpayments;

import com.eclatian.oss.axis.saksham.client.annotation.JsonTags;
import com.eclatian.oss.axis.saksham.client.base.Response;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@JsonTags(encrypted = "TransferPaymentResponseBodyEncrypted",
    root = "TransferPaymentResponse",
    body = "data")
public class TransferPaymentResponse extends Response {

    
    
}
