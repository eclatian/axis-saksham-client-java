package com.eclatian.oss.axis.saksham.client.getstatus;

import com.eclatian.oss.axis.saksham.client.annotation.JsonTags;
import com.eclatian.oss.axis.saksham.client.base.Request;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * Represents a GetStatus request.
 * Extends the base Request class and includes additional attributes specific to GetStatus requests.
 *
 * The JSON tags for serialization and deserialization are configured using the @JsonTags annotation.
 * This class is annotated with Lombok annotations for getter, setter, and toString methods.
 *
 * Example JSON representation:
 * {
 *   "GetStatusRequest": {
 *     "GetStatusRequestBody": {
 *       "crn": "CRN_VALUE"
 *     }
 *   }
 * }
 *
 * @see Request
 */
@Getter
@Setter
@ToString
@JsonTags(encrypted = "GetStatusRequestBodyEncrypted",
    root = "GetStatusRequest",
    body = "GetStatusRequestBody")
public class GetStatusRequest extends Request {

    /**
     * The CRN (Customer Reference Number).
     * This field is annotated with @NotNull to enforce non-null values during validation.
     */
    @NotNull
    private String crn;

}
