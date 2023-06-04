package com.eclatian.oss.axis.saksham.client.getstatus;

import com.eclatian.oss.axis.saksham.client.annotation.JsonTags;
import com.eclatian.oss.axis.saksham.client.base.Response;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * Represents a GetStatus response.
 * Extends the base Response class and includes additional attributes specific to GetStatus responses.
 *
 * The JSON tags for serialization and deserialization are configured using the @JsonTags annotation.
 * This class is annotated with Lombok annotations for getter, setter, and toString methods.
 * The @JsonProperty annotation is used to specify the JSON property name for the 'CUR_TXN_ENQ' attribute.
 *
 * Example JSON representation:
 * {
 *   "GetStatusResponse": {
 *     "data": {
 *       "CUR_TXN_ENQ": ["VALUE1", "VALUE2"]
 *     }
 *   }
 * }
 *
 * @see Response
 */
@Getter
@Setter
@ToString
@JsonTags(encrypted = "GetStatusResponseBodyEncrypted",
    root = "GetStatusResponse",
    body = "data")
public class GetStatusResponse extends Response {

    /**
     * The 'CUR_TXN_ENQ' attribute.
     * This field is annotated with @JsonProperty to specify the JSON property name.
     */
    @JsonProperty("CUR_TXN_ENQ")
    private List<TxnStatus> txnStatusList;

}
