package com.eclatian.oss.axis.saksham.client.transferpayments;

import com.eclatian.oss.axis.saksham.client.annotation.JsonTags;
import com.eclatian.oss.axis.saksham.client.base.Request;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotEmpty;
import java.util.ArrayList;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@JsonTags(encrypted = "TransferPaymentRequestBodyEncrypted",
    root = "TransferPaymentRequest",
    body = "TransferPaymentRequestBody")
public class TransferPaymentRequest extends Request {

    @NotEmpty 
   private ArrayList<@Valid PaymentDetail> paymentDetails;
    
}
