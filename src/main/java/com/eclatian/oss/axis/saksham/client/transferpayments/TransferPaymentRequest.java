package com.eclatian.oss.axis.saksham.client.transferpayments;

import com.eclatian.oss.axis.saksham.client.annotation.JsonTags;
import com.eclatian.oss.axis.saksham.client.base.Request;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotEmpty;
import java.util.ArrayList;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * Represents a transfer payment request.
 * This class extends the base Request class.
 * It contains a list of payment details for the transfer.
 *
 * <p>
 * @author Abhideep Chakravarty
 * </p>
 */
@Getter
@Setter
@ToString
@JsonTags(encrypted = "TransferPaymentRequestBodyEncrypted",
    root = "TransferPaymentRequest",
    body = "TransferPaymentRequestBody")
public class TransferPaymentRequest extends Request {

    /**
     * The list of payment details for the transfer.
     * The field is mandatory and cannot be empty.
     */
    @NotEmpty(message = "paymentDetails is mandatory")
    private ArrayList<@Valid PaymentDetail> paymentDetails;
    
}

