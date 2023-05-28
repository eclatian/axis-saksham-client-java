package com.eclatian.oss.axis.saksham.client.getstatus;

import com.eclatian.oss.axis.saksham.client.annotation.JsonTags;
import com.eclatian.oss.axis.saksham.client.base.Request;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@JsonTags(encrypted = "GetStatusRequestBodyEncrypted",
    root = "GetStatusRequest",
    body = "GetStatusRequestBody")
public class GetStatusRequest extends Request {

    @NotNull
    private String crn;

}
