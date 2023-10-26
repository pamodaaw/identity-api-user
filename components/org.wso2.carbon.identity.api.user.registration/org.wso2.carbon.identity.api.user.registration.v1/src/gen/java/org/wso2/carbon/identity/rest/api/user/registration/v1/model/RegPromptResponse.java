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
import java.util.ArrayList;
import java.util.List;
import org.wso2.carbon.identity.rest.api.user.registration.v1.model.Link;
import org.wso2.carbon.identity.rest.api.user.registration.v1.model.NextStep;
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
    private NextStep nextStep;
    private List<Link> links = new ArrayList<>();


    /**
    * A unique identifier for the registration flow returned from the server. This identifier will be used to track the continuation of the flow.
    **/
    public RegPromptResponse flowId(String flowId) {

        this.flowId = flowId;
        return this;
    }
    
    @ApiModelProperty(example = "d13ec8d2-2d1e-11ee-be56-0242ac120002", required = true, value = "A unique identifier for the registration flow returned from the server. This identifier will be used to track the continuation of the flow.")
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
    * The status of the registration flow. There is a seperate response modal for the COMPLETE state with user assertion related to be used in the authentication. 
    **/
    public RegPromptResponse flowStatus(FlowStatusEnum flowStatus) {

        this.flowStatus = flowStatus;
        return this;
    }
    
    @ApiModelProperty(example = "INCOMPLETE", required = true, value = "The status of the registration flow. There is a seperate response modal for the COMPLETE state with user assertion related to be used in the authentication. ")
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
    **/
    public RegPromptResponse nextStep(NextStep nextStep) {

        this.nextStep = nextStep;
        return this;
    }
    
    @ApiModelProperty(required = true, value = "")
    @JsonProperty("nextStep")
    @Valid
    @NotNull(message = "Property nextStep cannot be null.")

    public NextStep getNextStep() {
        return nextStep;
    }
    public void setNextStep(NextStep nextStep) {
        this.nextStep = nextStep;
    }

    /**
    * Contains the urls related to the registration flow.
    **/
    public RegPromptResponse links(List<Link> links) {

        this.links = links;
        return this;
    }
    
    @ApiModelProperty(required = true, value = "Contains the urls related to the registration flow.")
    @JsonProperty("links")
    @Valid
    @NotNull(message = "Property links cannot be null.")

    public List<Link> getLinks() {
        return links;
    }
    public void setLinks(List<Link> links) {
        this.links = links;
    }

    public RegPromptResponse addLinksItem(Link linksItem) {
        this.links.add(linksItem);
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
            Objects.equals(this.nextStep, regPromptResponse.nextStep) &&
            Objects.equals(this.links, regPromptResponse.links);
    }

    @Override
    public int hashCode() {
        return Objects.hash(flowId, flowStatus, nextStep, links);
    }

    @Override
    public String toString() {

        StringBuilder sb = new StringBuilder();
        sb.append("class RegPromptResponse {\n");
        
        sb.append("    flowId: ").append(toIndentedString(flowId)).append("\n");
        sb.append("    flowStatus: ").append(toIndentedString(flowStatus)).append("\n");
        sb.append("    nextStep: ").append(toIndentedString(nextStep)).append("\n");
        sb.append("    links: ").append(toIndentedString(links)).append("\n");
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

