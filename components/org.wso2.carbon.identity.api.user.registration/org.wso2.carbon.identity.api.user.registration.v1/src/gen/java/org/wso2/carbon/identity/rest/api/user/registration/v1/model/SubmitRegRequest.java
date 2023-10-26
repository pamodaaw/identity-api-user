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
import org.wso2.carbon.identity.rest.api.user.registration.v1.model.SelectedRegExecutor;
import javax.validation.constraints.*;

/**
 * The request object that will be communicated to the server as the intermediate steps associated with the registration flow. This will contain the user inputs for the attributes requested. 
 **/

import io.swagger.annotations.*;
import java.util.Objects;
import javax.validation.Valid;
import javax.xml.bind.annotation.*;
@ApiModel(description = "The request object that will be communicated to the server as the intermediate steps associated with the registration flow. This will contain the user inputs for the attributes requested. ")
public class SubmitRegRequest  {
  
    private String flowId;
    private SelectedRegExecutor selectedRegistrationExecutor;

    /**
    * A unique identifier for the registration flow returned from the server. This identifier will be used to track the continuation of the flow.
    **/
    public SubmitRegRequest flowId(String flowId) {

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
    **/
    public SubmitRegRequest selectedRegistrationExecutor(SelectedRegExecutor selectedRegistrationExecutor) {

        this.selectedRegistrationExecutor = selectedRegistrationExecutor;
        return this;
    }
    
    @ApiModelProperty(required = true, value = "")
    @JsonProperty("selectedRegistrationExecutor")
    @Valid
    @NotNull(message = "Property selectedRegistrationExecutor cannot be null.")

    public SelectedRegExecutor getSelectedRegistrationExecutor() {
        return selectedRegistrationExecutor;
    }
    public void setSelectedRegistrationExecutor(SelectedRegExecutor selectedRegistrationExecutor) {
        this.selectedRegistrationExecutor = selectedRegistrationExecutor;
    }



    @Override
    public boolean equals(java.lang.Object o) {

        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        SubmitRegRequest submitRegRequest = (SubmitRegRequest) o;
        return Objects.equals(this.flowId, submitRegRequest.flowId) &&
            Objects.equals(this.selectedRegistrationExecutor, submitRegRequest.selectedRegistrationExecutor);
    }

    @Override
    public int hashCode() {
        return Objects.hash(flowId, selectedRegistrationExecutor);
    }

    @Override
    public String toString() {

        StringBuilder sb = new StringBuilder();
        sb.append("class SubmitRegRequest {\n");
        
        sb.append("    flowId: ").append(toIndentedString(flowId)).append("\n");
        sb.append("    selectedRegistrationExecutor: ").append(toIndentedString(selectedRegistrationExecutor)).append("\n");
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

