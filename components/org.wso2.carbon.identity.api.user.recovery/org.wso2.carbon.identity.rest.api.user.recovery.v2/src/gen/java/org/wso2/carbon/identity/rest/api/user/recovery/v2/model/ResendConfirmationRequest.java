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

package org.wso2.carbon.identity.rest.api.user.recovery.v2.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.ArrayList;
import java.util.List;
import org.wso2.carbon.identity.rest.api.user.recovery.v2.model.Property;
import javax.validation.constraints.*;

/**
 * Request to resend the confirmation code in password recovery
 **/

import io.swagger.annotations.*;
import java.util.Objects;
import javax.validation.Valid;
import javax.xml.bind.annotation.*;
@ApiModel(description = "Request to resend the confirmation code in password recovery")
public class ResendConfirmationRequest  {
  
    private String resendCode;
    private List<Property> properties = null;


    /**
    * Resend code returned by the password recovery API
    **/
    public ResendConfirmationRequest resendCode(String resendCode) {

        this.resendCode = resendCode;
        return this;
    }
    
    @ApiModelProperty(example = "1234-2ws34-1234", value = "Resend code returned by the password recovery API")
    @JsonProperty("resendCode")
    @Valid
    public String getResendCode() {
        return resendCode;
    }
    public void setResendCode(String resendCode) {
        this.resendCode = resendCode;
    }

    /**
    * (OPTIONAL) Additional META properties
    **/
    public ResendConfirmationRequest properties(List<Property> properties) {

        this.properties = properties;
        return this;
    }
    
    @ApiModelProperty(value = "(OPTIONAL) Additional META properties")
    @JsonProperty("properties")
    @Valid
    public List<Property> getProperties() {
        return properties;
    }
    public void setProperties(List<Property> properties) {
        this.properties = properties;
    }

    public ResendConfirmationRequest addPropertiesItem(Property propertiesItem) {
        if (this.properties == null) {
            this.properties = new ArrayList<>();
        }
        this.properties.add(propertiesItem);
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
        ResendConfirmationRequest resendConfirmationRequest = (ResendConfirmationRequest) o;
        return Objects.equals(this.resendCode, resendConfirmationRequest.resendCode) &&
            Objects.equals(this.properties, resendConfirmationRequest.properties);
    }

    @Override
    public int hashCode() {
        return Objects.hash(resendCode, properties);
    }

    @Override
    public String toString() {

        StringBuilder sb = new StringBuilder();
        sb.append("class ResendConfirmationRequest {\n");
        
        sb.append("    resendCode: ").append(toIndentedString(resendCode)).append("\n");
        sb.append("    properties: ").append(toIndentedString(properties)).append("\n");
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

