/*
 * Copyright (c) 2023, WSO2 LLC. (http://www.wso2.com).
 *
 * WSO2 LLC. licenses this file to you under the Apache License,
 * Version 2.0 (the "License"); you may not use this file except
 * in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */

package org.wso2.carbon.identity.rest.api.user.registration.v1.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import javax.validation.constraints.*;

/**
 * The request object to initiate a registration flow configured against the given application id. If the end result of the user creation should be aligned with a specific protol, that must be indicated in the initial request. 
 **/

import io.swagger.annotations.*;
import java.util.Objects;
import javax.validation.Valid;
import javax.xml.bind.annotation.*;
@ApiModel(description = "The request object to initiate a registration flow configured against the given application id. If the end result of the user creation should be aligned with a specific protol, that must be indicated in the initial request. ")
public class InitRegRequest  {
  

@XmlType(name="FlowTypeEnum")
@XmlEnum(String.class)
public enum FlowTypeEnum {

    @XmlEnumValue("INITIATE") INITIATE(String.valueOf("INITIATE")), @XmlEnumValue("SUBMIT") SUBMIT(String.valueOf("SUBMIT"));


    private String value;

    FlowTypeEnum(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    @Override
    public String toString() {
        return String.valueOf(value);
    }

    public static FlowTypeEnum fromValue(String value) {
        for (FlowTypeEnum b : FlowTypeEnum.values()) {
            if (b.value.equals(value)) {
                return b;
            }
        }
        throw new IllegalArgumentException("Unexpected value '" + value + "'");
    }
}

    private FlowTypeEnum flowType;
    private String applicationId;

@XmlType(name="ProtocolEnum")
@XmlEnum(String.class)
public enum ProtocolEnum {

    @XmlEnumValue("NONE") NONE(String.valueOf("NONE")), @XmlEnumValue("OIDC") OIDC(String.valueOf("OIDC"));


    private String value;

    ProtocolEnum(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    @Override
    public String toString() {
        return String.valueOf(value);
    }

    public static ProtocolEnum fromValue(String value) {
        for (ProtocolEnum b : ProtocolEnum.values()) {
            if (b.value.equals(value)) {
                return b;
            }
        }
        throw new IllegalArgumentException("Unexpected value '" + value + "'");
    }
}

    private ProtocolEnum protocol;

    /**
    * Indicates the type of the current step in the flow.
    **/
    public InitRegRequest flowType(FlowTypeEnum flowType) {

        this.flowType = flowType;
        return this;
    }
    
    @ApiModelProperty(example = "INITIATE", required = true, value = "Indicates the type of the current step in the flow.")
    @JsonProperty("flowType")
    @Valid
    @NotNull(message = "Property flowType cannot be null.")

    public FlowTypeEnum getFlowType() {
        return flowType;
    }
    public void setFlowType(FlowTypeEnum flowType) {
        this.flowType = flowType;
    }

    /**
    * The id of the application for which the useer registration is triggered. This will be used to retrieve the configured user registration flow.
    **/
    public InitRegRequest applicationId(String applicationId) {

        this.applicationId = applicationId;
        return this;
    }
    
    @ApiModelProperty(example = "3bd1f207-e5b5-4b45-8a91-13b0acfb2151", required = true, value = "The id of the application for which the useer registration is triggered. This will be used to retrieve the configured user registration flow.")
    @JsonProperty("applicationId")
    @Valid
    @NotNull(message = "Property applicationId cannot be null.")

    public String getApplicationId() {
        return applicationId;
    }
    public void setApplicationId(String applicationId) {
        this.applicationId = applicationId;
    }

    /**
    * Indicates whether registration is followed to a specific standard or protocol. Based on that the final result of successful registration will be decided
    **/
    public InitRegRequest protocol(ProtocolEnum protocol) {

        this.protocol = protocol;
        return this;
    }
    
    @ApiModelProperty(example = "OIDC", required = true, value = "Indicates whether registration is followed to a specific standard or protocol. Based on that the final result of successful registration will be decided")
    @JsonProperty("protocol")
    @Valid
    @NotNull(message = "Property protocol cannot be null.")

    public ProtocolEnum getProtocol() {
        return protocol;
    }
    public void setProtocol(ProtocolEnum protocol) {
        this.protocol = protocol;
    }



    @Override
    public boolean equals(java.lang.Object o) {

        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        InitRegRequest initRegRequest = (InitRegRequest) o;
        return Objects.equals(this.flowType, initRegRequest.flowType) &&
            Objects.equals(this.applicationId, initRegRequest.applicationId) &&
            Objects.equals(this.protocol, initRegRequest.protocol);
    }

    @Override
    public int hashCode() {
        return Objects.hash(flowType, applicationId, protocol);
    }

    @Override
    public String toString() {

        StringBuilder sb = new StringBuilder();
        sb.append("class InitRegRequest {\n");
        
        sb.append("    flowType: ").append(toIndentedString(flowType)).append("\n");
        sb.append("    applicationId: ").append(toIndentedString(applicationId)).append("\n");
        sb.append("    protocol: ").append(toIndentedString(protocol)).append("\n");
        sb.append("}");
        return sb.toString();
    }

    /**
    * Convert the given object to string with each line indented by 4 spaces
    * (except the first line).
    */
    private String toIndentedString(java.lang.Object o) {

        if (o == null) {
            return "null";
        }
        return o.toString().replace("\n", "\n");
    }
}

