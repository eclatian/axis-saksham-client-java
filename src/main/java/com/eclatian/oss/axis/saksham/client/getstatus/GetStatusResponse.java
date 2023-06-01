package com.eclatian.oss.axis.saksham.client.getstatus;

import com.eclatian.oss.axis.saksham.client.annotation.JsonTags;
import com.eclatian.oss.axis.saksham.client.base.Response;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@JsonTags(encrypted = "GetStatusResponseBodyEncrypted",
    root = "GetStatusResponse",
    body = "data")
public class GetStatusResponse extends Response {

    @JsonProperty("CUR_TXN_ENQ")
    private List<String> CUR_TXN_ENQ;

}
