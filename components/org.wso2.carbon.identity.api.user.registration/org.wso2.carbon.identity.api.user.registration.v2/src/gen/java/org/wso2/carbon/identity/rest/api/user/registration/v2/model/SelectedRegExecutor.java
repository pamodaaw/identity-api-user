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
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.validation.constraints.*;

/**
 * Contains the data related to a selected registration executor.
 **/

import io.swagger.annotations.*;
import java.util.Objects;
import javax.validation.Valid;
import javax.xml.bind.annotation.*;
@ApiModel(description = "Contains the data related to a selected registration executor.")
public class SelectedRegExecutor  {
  
    private String id;
    private Map<String, String> params = null;


    /**
    * The unique identifier of the selected registration executor.
    **/
    public SelectedRegExecutor id(String id) {

        this.id = id;
        return this;
    }
    
    @ApiModelProperty(example = "db1220160cb14f0a8d74b831e0939b62", required = true, value = "The unique identifier of the selected registration executor.")
    @JsonProperty("id")
    @Valid
    @NotNull(message = "Property id cannot be null.")

    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }

    /**
    * The parameters required by the registration executor to perform user onboarding.
    **/
    public SelectedRegExecutor params(Map<String, String> params) {

        this.params = params;
        return this;
    }
    
    @ApiModelProperty(example = "{\"username\":\"johnd\",\"firstname\":\"John\",\"lastname\":\"Doe\"}", value = "The parameters required by the registration executor to perform user onboarding.")
    @JsonProperty("params")
    @Valid
    public Map<String, String> getParams() {
        return params;
    }
    public void setParams(Map<String, String> params) {
        this.params = params;
    }


    public SelectedRegExecutor putParamsItem(String key, String paramsItem) {
        if (this.params == null) {
            this.params = new HashMap<>();
        }
        this.params.put(key, paramsItem);
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
        SelectedRegExecutor selectedRegExecutor = (SelectedRegExecutor) o;
        return Objects.equals(this.id, selectedRegExecutor.id) &&
            Objects.equals(this.params, selectedRegExecutor.params);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, params);
    }

    @Override
    public String toString() {

        StringBuilder sb = new StringBuilder();
        sb.append("class SelectedRegExecutor {\n");
        
        sb.append("    id: ").append(toIndentedString(id)).append("\n");
        sb.append("    params: ").append(toIndentedString(params)).append("\n");
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

