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
import javax.validation.constraints.*;


import io.swagger.annotations.*;
import java.util.Objects;
import javax.validation.Valid;
import javax.xml.bind.annotation.*;

public class ErrorResponse  {
  
    private String code;
    private String message;
    private String description;
    private String traceId;

    /**
    * Error code corresponding to the error
    **/
    public ErrorResponse code(String code) {

        this.code = code;
        return this;
    }
    
    @ApiModelProperty(example = "UAR-10001", value = "Error code corresponding to the error")
    @JsonProperty("code")
    @Valid
    public String getCode() {
        return code;
    }
    public void setCode(String code) {
        this.code = code;
    }

    /**
    * Error message
    **/
    public ErrorResponse message(String message) {

        this.message = message;
        return this;
    }
    
    @ApiModelProperty(example = "invalid_request", value = "Error message")
    @JsonProperty("message")
    @Valid
    public String getMessage() {
        return message;
    }
    public void setMessage(String message) {
        this.message = message;
    }

    /**
    * Description about the error
    **/
    public ErrorResponse description(String description) {

        this.description = description;
        return this;
    }
    
    @ApiModelProperty(example = "Invalid claim uri", value = "Description about the error")
    @JsonProperty("description")
    @Valid
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }

    /**
    * Some Correlation for Error Instance
    **/
    public ErrorResponse traceId(String traceId) {

        this.traceId = traceId;
        return this;
    }
    
    @ApiModelProperty(example = "2345dfgh678h789bhjk", value = "Some Correlation for Error Instance")
    @JsonProperty("traceId")
    @Valid
    public String getTraceId() {
        return traceId;
    }
    public void setTraceId(String traceId) {
        this.traceId = traceId;
    }



    @Override
    public boolean equals(java.lang.Object o) {

        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        ErrorResponse errorResponse = (ErrorResponse) o;
        return Objects.equals(this.code, errorResponse.code) &&
            Objects.equals(this.message, errorResponse.message) &&
            Objects.equals(this.description, errorResponse.description) &&
            Objects.equals(this.traceId, errorResponse.traceId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(code, message, description, traceId);
    }

    @Override
    public String toString() {

        StringBuilder sb = new StringBuilder();
        sb.append("class ErrorResponse {\n");
        
        sb.append("    code: ").append(toIndentedString(code)).append("\n");
        sb.append("    message: ").append(toIndentedString(message)).append("\n");
        sb.append("    description: ").append(toIndentedString(description)).append("\n");
        sb.append("    traceId: ").append(toIndentedString(traceId)).append("\n");
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

