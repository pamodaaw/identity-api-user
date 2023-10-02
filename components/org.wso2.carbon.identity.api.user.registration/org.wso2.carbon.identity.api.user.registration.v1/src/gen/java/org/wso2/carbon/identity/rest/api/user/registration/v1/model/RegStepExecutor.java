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
import org.wso2.carbon.identity.rest.api.user.registration.v1.model.MessageInfo;
import org.wso2.carbon.identity.rest.api.user.registration.v1.model.RequestedParamInfo;
import javax.validation.constraints.*;

/**
 * The details of an executor which perform a specific task of the registration flow.
 **/

import io.swagger.annotations.*;
import java.util.Objects;
import javax.validation.Valid;
import javax.xml.bind.annotation.*;
@ApiModel(description = "The details of an executor which perform a specific task of the registration flow.")
public class RegStepExecutor  {
  
    private String givenName;
    private String name;
    private String id;
    private List<RequestedParamInfo> requestedParameters = null;

    private List<MessageInfo> messages = null;


    /**
    * The unique name given to the instance of the registration component.
    **/
    public RegStepExecutor givenName(String givenName) {

        this.givenName = givenName;
        return this;
    }
    
    @ApiModelProperty(example = "Basic Attribute Collector", value = "The unique name given to the instance of the registration component.")
    @JsonProperty("givenName")
    @Valid
    public String getGivenName() {
        return givenName;
    }
    public void setGivenName(String givenName) {
        this.givenName = givenName;
    }

    /**
    * The name of the registration component.
    **/
    public RegStepExecutor name(String name) {

        this.name = name;
        return this;
    }
    
    @ApiModelProperty(example = "Basic Attribute Collector", value = "The name of the registration component.")
    @JsonProperty("name")
    @Valid
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    /**
    * The unique identifier of the registration component.
    **/
    public RegStepExecutor id(String id) {

        this.id = id;
        return this;
    }
    
    @ApiModelProperty(example = "e54636fe-2f7a-11ee-be56-0242ac120002", value = "The unique identifier of the registration component.")
    @JsonProperty("id")
    @Valid
    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }

    /**
    **/
    public RegStepExecutor requestedParameters(List<RequestedParamInfo> requestedParameters) {

        this.requestedParameters = requestedParameters;
        return this;
    }
    
    @ApiModelProperty(value = "")
    @JsonProperty("requestedParameters")
    @Valid
    public List<RequestedParamInfo> getRequestedParameters() {
        return requestedParameters;
    }
    public void setRequestedParameters(List<RequestedParamInfo> requestedParameters) {
        this.requestedParameters = requestedParameters;
    }

    public RegStepExecutor addRequestedParametersItem(RequestedParamInfo requestedParametersItem) {
        if (this.requestedParameters == null) {
            this.requestedParameters = new ArrayList<>();
        }
        this.requestedParameters.add(requestedParametersItem);
        return this;
    }

        /**
    **/
    public RegStepExecutor messages(List<MessageInfo> messages) {

        this.messages = messages;
        return this;
    }
    
    @ApiModelProperty(value = "")
    @JsonProperty("messages")
    @Valid
    public List<MessageInfo> getMessages() {
        return messages;
    }
    public void setMessages(List<MessageInfo> messages) {
        this.messages = messages;
    }

    public RegStepExecutor addMessagesItem(MessageInfo messagesItem) {
        if (this.messages == null) {
            this.messages = new ArrayList<>();
        }
        this.messages.add(messagesItem);
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
        RegStepExecutor regStepExecutor = (RegStepExecutor) o;
        return Objects.equals(this.givenName, regStepExecutor.givenName) &&
            Objects.equals(this.name, regStepExecutor.name) &&
            Objects.equals(this.id, regStepExecutor.id) &&
            Objects.equals(this.requestedParameters, regStepExecutor.requestedParameters) &&
            Objects.equals(this.messages, regStepExecutor.messages);
    }

    @Override
    public int hashCode() {
        return Objects.hash(givenName, name, id, requestedParameters, messages);
    }

    @Override
    public String toString() {

        StringBuilder sb = new StringBuilder();
        sb.append("class RegStepExecutor {\n");
        
        sb.append("    givenName: ").append(toIndentedString(givenName)).append("\n");
        sb.append("    name: ").append(toIndentedString(name)).append("\n");
        sb.append("    id: ").append(toIndentedString(id)).append("\n");
        sb.append("    requestedParameters: ").append(toIndentedString(requestedParameters)).append("\n");
        sb.append("    messages: ").append(toIndentedString(messages)).append("\n");
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

