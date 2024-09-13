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
import javax.validation.constraints.*;


import io.swagger.annotations.*;
import java.util.Objects;
import javax.validation.Valid;
import javax.xml.bind.annotation.*;

public class Option  {
  
    private String value;
    private String i18nKey;

    /**
    * The value for the option
    **/
    public Option value(String value) {

        this.value = value;
        return this;
    }
    
    @ApiModelProperty(example = "password", value = "The value for the option")
    @JsonProperty("value")
    @Valid
    public String getValue() {
        return value;
    }
    public void setValue(String value) {
        this.value = value;
    }

    /**
    * Internationalization key for the option label
    **/
    public Option i18nKey(String i18nKey) {

        this.i18nKey = i18nKey;
        return this;
    }
    
    @ApiModelProperty(example = "authMethod.password", value = "Internationalization key for the option label")
    @JsonProperty("i18nKey")
    @Valid
    public String getI18nKey() {
        return i18nKey;
    }
    public void setI18nKey(String i18nKey) {
        this.i18nKey = i18nKey;
    }



    @Override
    public boolean equals(java.lang.Object o) {

        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Option option = (Option) o;
        return Objects.equals(this.value, option.value) &&
            Objects.equals(this.i18nKey, option.i18nKey);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value, i18nKey);
    }

    @Override
    public String toString() {

        StringBuilder sb = new StringBuilder();
        sb.append("class Option {\n");
        
        sb.append("    value: ").append(toIndentedString(value)).append("\n");
        sb.append("    i18nKey: ").append(toIndentedString(i18nKey)).append("\n");
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

