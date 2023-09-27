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
 * The data entered by the user as required by the registration flow.
 **/

import io.swagger.annotations.*;
import java.util.Objects;
import javax.validation.Valid;
import javax.xml.bind.annotation.*;
@ApiModel(description = "The data entered by the user as required by the registration flow.")
public class InputObject  {
  
    private String key;
    private String value;

    /**
    **/
    public InputObject key(String key) {

        this.key = key;
        return this;
    }
    
    @ApiModelProperty(example = "username", required = true, value = "")
    @JsonProperty("key")
    @Valid
    @NotNull(message = "Property key cannot be null.")

    public String getKey() {
        return key;
    }
    public void setKey(String key) {
        this.key = key;
    }

    /**
    **/
    public InputObject value(String value) {

        this.value = value;
        return this;
    }
    
    @ApiModelProperty(example = "johnd", required = true, value = "")
    @JsonProperty("value")
    @Valid
    @NotNull(message = "Property value cannot be null.")

    public String getValue() {
        return value;
    }
    public void setValue(String value) {
        this.value = value;
    }



    @Override
    public boolean equals(java.lang.Object o) {

        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        InputObject inputObject = (InputObject) o;
        return Objects.equals(this.key, inputObject.key) &&
            Objects.equals(this.value, inputObject.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(key, value);
    }

    @Override
    public String toString() {

        StringBuilder sb = new StringBuilder();
        sb.append("class InputObject {\n");
        
        sb.append("    key: ").append(toIndentedString(key)).append("\n");
        sb.append("    value: ").append(toIndentedString(value)).append("\n");
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

