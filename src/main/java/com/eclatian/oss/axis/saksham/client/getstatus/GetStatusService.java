package com.eclatian.oss.axis.saksham.client.getstatus;

import com.eclatian.oss.axis.saksham.client.annotation.AxisAPI;
import com.eclatian.oss.axis.saksham.client.base.BaseService;

/**
 * Represents the GetStatusService, which is a concrete implementation of the BaseService class.
 * The @AxisAPI annotation is used to specify the API path for the service.
 * This class extends the BaseService and specifies the generic types for the request and response.
 *
 * Example usage:
 * GetStatusRequest request = new GetStatusRequest();
 * // Set request attributes
 *
 * GetStatusService service = new GetStatusService();
 * GetStatusResponse response = service.trigger(request);
 *
 * @see BaseService
 */
@AxisAPI(path = "/acct-recon/get-status")
public class GetStatusService extends BaseService<GetStatusRequest, GetStatusResponse> {

    // No additional methods or attributes in this class

}
