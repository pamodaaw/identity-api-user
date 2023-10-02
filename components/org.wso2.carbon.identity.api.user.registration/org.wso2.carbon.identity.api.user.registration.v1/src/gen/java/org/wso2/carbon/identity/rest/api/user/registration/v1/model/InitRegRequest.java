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
  
    private String applicationId;

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



    @Override
    public boolean equals(java.lang.Object o) {

        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        InitRegRequest initRegRequest = (InitRegRequest) o;
        return Objects.equals(this.applicationId, initRegRequest.applicationId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(applicationId);
    }

    @Override
    public String toString() {

        StringBuilder sb = new StringBuilder();
        sb.append("class InitRegRequest {\n");
        
        sb.append("    applicationId: ").append(toIndentedString(applicationId)).append("\n");
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

