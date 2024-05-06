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
import org.wso2.carbon.identity.rest.api.user.registration.v1.model.MessageInfo;
import org.wso2.carbon.identity.rest.api.user.registration.v1.model.RegExecutorMetadata;
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
  
    private String id;
    private String name;
    private String type;
    private RegExecutorMetadata metadata;
    private MessageInfo message;

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
    * The given name for the registration executor instance.
    **/
    public RegStepExecutor name(String name) {

        this.name = name;
        return this;
    }
    
    @ApiModelProperty(example = "Basic Attribute Collector", value = "The given name for the registration executor instance.")
    @JsonProperty("name")
    @Valid
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    /**
    * The type of the registration executor.
    **/
    public RegStepExecutor type(String type) {

        this.type = type;
        return this;
    }
    
    @ApiModelProperty(example = "Credential", value = "The type of the registration executor.")
    @JsonProperty("type")
    @Valid
    public String getType() {
        return type;
    }
    public void setType(String type) {
        this.type = type;
    }

    /**
    **/
    public RegStepExecutor metadata(RegExecutorMetadata metadata) {

        this.metadata = metadata;
        return this;
    }
    
    @ApiModelProperty(value = "")
    @JsonProperty("metadata")
    @Valid
    public RegExecutorMetadata getMetadata() {
        return metadata;
    }
    public void setMetadata(RegExecutorMetadata metadata) {
        this.metadata = metadata;
    }

    /**
    **/
    public RegStepExecutor message(MessageInfo message) {

        this.message = message;
        return this;
    }
    
    @ApiModelProperty(value = "")
    @JsonProperty("message")
    @Valid
    public MessageInfo getMessage() {
        return message;
    }
    public void setMessage(MessageInfo message) {
        this.message = message;
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
        return Objects.equals(this.id, regStepExecutor.id) &&
            Objects.equals(this.name, regStepExecutor.name) &&
            Objects.equals(this.type, regStepExecutor.type) &&
            Objects.equals(this.metadata, regStepExecutor.metadata) &&
            Objects.equals(this.message, regStepExecutor.message);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, type, metadata, message);
    }

    @Override
    public String toString() {

        StringBuilder sb = new StringBuilder();
        sb.append("class RegStepExecutor {\n");
        
        sb.append("    id: ").append(toIndentedString(id)).append("\n");
        sb.append("    name: ").append(toIndentedString(name)).append("\n");
        sb.append("    type: ").append(toIndentedString(type)).append("\n");
        sb.append("    metadata: ").append(toIndentedString(metadata)).append("\n");
        sb.append("    message: ").append(toIndentedString(message)).append("\n");
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

