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
import org.wso2.carbon.identity.rest.api.user.registration.v1.model.Param;
import javax.validation.constraints.*;

/**
 * Some description
 **/

import io.swagger.annotations.*;
import java.util.Objects;
import javax.validation.Valid;
import javax.xml.bind.annotation.*;
@ApiModel(description = "Some description")
public class RegistrationComponent  {
  
    private String name;
    private String id;
    private String type;
    private List<Param> requiredParams = null;


    /**
    * The name given to the registration component.
    **/
    public RegistrationComponent name(String name) {

        this.name = name;
        return this;
    }
    
    @ApiModelProperty(example = "Basic Attribute Collector", value = "The name given to the registration component.")
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
    public RegistrationComponent id(String id) {

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
    * The type of the registration component.
    **/
    public RegistrationComponent type(String type) {

        this.type = type;
        return this;
    }
    
    @ApiModelProperty(example = "Attribute Collection", value = "The type of the registration component.")
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
    public RegistrationComponent requiredParams(List<Param> requiredParams) {

        this.requiredParams = requiredParams;
        return this;
    }
    
    @ApiModelProperty(value = "")
    @JsonProperty("requiredParams")
    @Valid
    public List<Param> getRequiredParams() {
        return requiredParams;
    }
    public void setRequiredParams(List<Param> requiredParams) {
        this.requiredParams = requiredParams;
    }

    public RegistrationComponent addRequiredParamsItem(Param requiredParamsItem) {
        if (this.requiredParams == null) {
            this.requiredParams = new ArrayList<>();
        }
        this.requiredParams.add(requiredParamsItem);
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
        RegistrationComponent registrationComponent = (RegistrationComponent) o;
        return Objects.equals(this.name, registrationComponent.name) &&
            Objects.equals(this.id, registrationComponent.id) &&
            Objects.equals(this.type, registrationComponent.type) &&
            Objects.equals(this.requiredParams, registrationComponent.requiredParams);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, id, type, requiredParams);
    }

    @Override
    public String toString() {

        StringBuilder sb = new StringBuilder();
        sb.append("class RegistrationComponent {\n");
        
        sb.append("    name: ").append(toIndentedString(name)).append("\n");
        sb.append("    id: ").append(toIndentedString(id)).append("\n");
        sb.append("    type: ").append(toIndentedString(type)).append("\n");
        sb.append("    requiredParams: ").append(toIndentedString(requiredParams)).append("\n");
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

