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

package org.wso2.carbon.identity.rest.api.user.registration.v2.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.ArrayList;
import java.util.List;
import org.wso2.carbon.identity.rest.api.user.registration.v2.model.Prompt;
import javax.validation.constraints.*;

/**
 * User registration intermediate response body.
 **/

import io.swagger.annotations.*;
import java.util.Objects;
import javax.validation.Valid;
import javax.xml.bind.annotation.*;
@ApiModel(description = "User registration intermediate response body.")
public class RegPromptResponse  {
  
    private String flowId;

@XmlType(name="FlowStatusEnum")
@XmlEnum(String.class)
public enum FlowStatusEnum {

    @XmlEnumValue("INCOMPLETE") INCOMPLETE(String.valueOf("INCOMPLETE")), @XmlEnumValue("FAILURE") FAILURE(String.valueOf("FAILURE"));


    private String value;

    FlowStatusEnum(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    @Override
    public String toString() {
        return String.valueOf(value);
    }

    public static FlowStatusEnum fromValue(String value) {
        for (FlowStatusEnum b : FlowStatusEnum.values()) {
            if (b.value.equals(value)) {
                return b;
            }
        }
        throw new IllegalArgumentException("Unexpected value '" + value + "'");
    }
}

    private FlowStatusEnum flowStatus;

@XmlType(name="FlowTypeEnum")
@XmlEnum(String.class)
public enum FlowTypeEnum {

    @XmlEnumValue("REGISTRATION") REGISTRATION(String.valueOf("REGISTRATION"));


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
    private List<Prompt> prompts = null;


    /**
    * A unique identifier for the registration flow returned from the server. This identifier will be used to track the continuation of the flow. 
    **/
    public RegPromptResponse flowId(String flowId) {

        this.flowId = flowId;
        return this;
    }
    
    @ApiModelProperty(example = "d13ec8d2-2d1e-11ee-be56-0242ac120002", required = true, value = "A unique identifier for the registration flow returned from the server. This identifier will be used to track the continuation of the flow. ")
    @JsonProperty("flowId")
    @Valid
    @NotNull(message = "Property flowId cannot be null.")

    public String getFlowId() {
        return flowId;
    }
    public void setFlowId(String flowId) {
        this.flowId = flowId;
    }

    /**
    * The status of the registration flow. There is a seperate response modal for the COMPLETE state with a registration user assertion that can be used for initiating an authentication. 
    **/
    public RegPromptResponse flowStatus(FlowStatusEnum flowStatus) {

        this.flowStatus = flowStatus;
        return this;
    }
    
    @ApiModelProperty(example = "INCOMPLETE", required = true, value = "The status of the registration flow. There is a seperate response modal for the COMPLETE state with a registration user assertion that can be used for initiating an authentication. ")
    @JsonProperty("flowStatus")
    @Valid
    @NotNull(message = "Property flowStatus cannot be null.")

    public FlowStatusEnum getFlowStatus() {
        return flowStatus;
    }
    public void setFlowStatus(FlowStatusEnum flowStatus) {
        this.flowStatus = flowStatus;
    }

    /**
    * The type of the flow. This version only contains flowType REGISTRATION.
    **/
    public RegPromptResponse flowType(FlowTypeEnum flowType) {

        this.flowType = flowType;
        return this;
    }
    
    @ApiModelProperty(example = "REGISTRATION", value = "The type of the flow. This version only contains flowType REGISTRATION.")
    @JsonProperty("flowType")
    @Valid
    public FlowTypeEnum getFlowType() {
        return flowType;
    }
    public void setFlowType(FlowTypeEnum flowType) {
        this.flowType = flowType;
    }

    /**
    * Array of required elements
    **/
    public RegPromptResponse prompts(List<Prompt> prompts) {

        this.prompts = prompts;
        return this;
    }
    
    @ApiModelProperty(value = "Array of required elements")
    @JsonProperty("prompts")
    @Valid
    public List<Prompt> getPrompts() {
        return prompts;
    }
    public void setPrompts(List<Prompt> prompts) {
        this.prompts = prompts;
    }

    public RegPromptResponse addPromptsItem(Prompt promptsItem) {
        if (this.prompts == null) {
            this.prompts = new ArrayList<>();
        }
        this.prompts.add(promptsItem);
        return this;
    }

    

    @Override
    public boolean equals(java.lang.Object o) {

        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        RegPromptResponse regPromptResponse = (RegPromptResponse) o;
        return Objects.equals(this.flowId, regPromptResponse.flowId) &&
            Objects.equals(this.flowStatus, regPromptResponse.flowStatus) &&
            Objects.equals(this.flowType, regPromptResponse.flowType) &&
            Objects.equals(this.prompts, regPromptResponse.prompts);
    }

    @Override
    public int hashCode() {
        return Objects.hash(flowId, flowStatus, flowType, prompts);
    }

    @Override
    public String toString() {

        StringBuilder sb = new StringBuilder();
        sb.append("class RegPromptResponse {\n");
        
        sb.append("    flowId: ").append(toIndentedString(flowId)).append("\n");
        sb.append("    flowStatus: ").append(toIndentedString(flowStatus)).append("\n");
        sb.append("    flowType: ").append(toIndentedString(flowType)).append("\n");
        sb.append("    prompts: ").append(toIndentedString(prompts)).append("\n");
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

