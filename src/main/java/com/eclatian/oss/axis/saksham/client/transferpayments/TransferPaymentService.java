package com.eclatian.oss.axis.saksham.client.transferpayments;

import com.eclatian.oss.axis.saksham.client.annotation.AxisAPI;
import com.eclatian.oss.axis.saksham.client.base.BaseService;


/**
 * Represents a transfer payment service.
 * This class extends the BaseService class and is associated with the TransferPaymentRequest and TransferPaymentResponse classes.
 *
 * @author  Abhideep Chakravarty
 */
@AxisAPI(path = "/payments/transfer-payment")
public class TransferPaymentService extends BaseService<TransferPaymentRequest, TransferPaymentResponse> {

    // Implementation specific to the transfer payment service
    
}

