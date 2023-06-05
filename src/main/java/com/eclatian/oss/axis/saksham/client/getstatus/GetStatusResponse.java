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
