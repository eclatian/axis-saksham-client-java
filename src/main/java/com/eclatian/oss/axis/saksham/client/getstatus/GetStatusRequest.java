/*
 *
 * Axis Saksham Java Client SDK
 * This is the java SDK to consume Axis Sakham APIs. This reduces the boiler plate coding required to make API calls
 * and hence speeds up the developers to integrate with Saksham API in faster and productive way.
 *
 * 2023 Eclatian Technologies Pvt. Ltd.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
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
