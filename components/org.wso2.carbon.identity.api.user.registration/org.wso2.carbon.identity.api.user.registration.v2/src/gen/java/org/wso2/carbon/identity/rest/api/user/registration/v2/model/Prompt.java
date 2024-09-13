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
import java.util.ArrayList;
import java.util.List;
import org.wso2.carbon.identity.rest.api.user.registration.v2.model.Option;
import javax.validation.constraints.*;


import io.swagger.annotations.*;
import java.util.Objects;
import javax.validation.Valid;
import javax.xml.bind.annotation.*;

public class Prompt  {
  
    private String name;
    private String value;
    private String dataType;
    private Boolean isMandatory;
    private Boolean isReadOnly;
    private Integer order;
    private String validationRegex;
    private String i18nKey;
    private List<Option> options = null;


    /**
    * The name or identifier of the prompt
    **/
    public Prompt name(String name) {

        this.name = name;
        return this;
    }
    
    @ApiModelProperty(example = "firstName", value = "The name or identifier of the prompt")
    @JsonProperty("name")
    @Valid
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    /**
    * The current value of the prompt (can be pre-filled)
    **/
    public Prompt value(String value) {

        this.value = value;
        return this;
    }
    
    @ApiModelProperty(value = "The current value of the prompt (can be pre-filled)")
    @JsonProperty("value")
    @Valid
    public String getValue() {
        return value;
    }
    public void setValue(String value) {
        this.value = value;
    }

    /**
    * Data type of the prompt (e.g., string, number, selection)
    **/
    public Prompt dataType(String dataType) {

        this.dataType = dataType;
        return this;
    }
    
    @ApiModelProperty(example = "string", value = "Data type of the prompt (e.g., string, number, selection)")
    @JsonProperty("dataType")
    @Valid
    public String getDataType() {
        return dataType;
    }
    public void setDataType(String dataType) {
        this.dataType = dataType;
    }

    /**
    * Indicates if the prompt is required
    **/
    public Prompt isMandatory(Boolean isMandatory) {

        this.isMandatory = isMandatory;
        return this;
    }
    
    @ApiModelProperty(example = "true", value = "Indicates if the prompt is required")
    @JsonProperty("isMandatory")
    @Valid
    public Boolean getIsMandatory() {
        return isMandatory;
    }
    public void setIsMandatory(Boolean isMandatory) {
        this.isMandatory = isMandatory;
    }

    /**
    * Indicates if the prompt is read-only
    **/
    public Prompt isReadOnly(Boolean isReadOnly) {

        this.isReadOnly = isReadOnly;
        return this;
    }
    
    @ApiModelProperty(example = "false", value = "Indicates if the prompt is read-only")
    @JsonProperty("isReadOnly")
    @Valid
    public Boolean getIsReadOnly() {
        return isReadOnly;
    }
    public void setIsReadOnly(Boolean isReadOnly) {
        this.isReadOnly = isReadOnly;
    }

    /**
    * The order in which the prompt appears
    **/
    public Prompt order(Integer order) {

        this.order = order;
        return this;
    }
    
    @ApiModelProperty(example = "1", value = "The order in which the prompt appears")
    @JsonProperty("order")
    @Valid
    public Integer getOrder() {
        return order;
    }
    public void setOrder(Integer order) {
        this.order = order;
    }

    /**
    * Validation regex for the prompt (if applicable)
    **/
    public Prompt validationRegex(String validationRegex) {

        this.validationRegex = validationRegex;
        return this;
    }
    
    @ApiModelProperty(example = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$", value = "Validation regex for the prompt (if applicable)")
    @JsonProperty("validationRegex")
    @Valid
    public String getValidationRegex() {
        return validationRegex;
    }
    public void setValidationRegex(String validationRegex) {
        this.validationRegex = validationRegex;
    }

    /**
    * Internationalization key for the prompt label
    **/
    public Prompt i18nKey(String i18nKey) {

        this.i18nKey = i18nKey;
        return this;
    }
    
    @ApiModelProperty(example = "userInfo.firstName", value = "Internationalization key for the prompt label")
    @JsonProperty("i18nKey")
    @Valid
    public String getI18nKey() {
        return i18nKey;
    }
    public void setI18nKey(String i18nKey) {
        this.i18nKey = i18nKey;
    }

    /**
    * Available options for selection prompts (if applicable)
    **/
    public Prompt options(List<Option> options) {

        this.options = options;
        return this;
    }
    
    @ApiModelProperty(value = "Available options for selection prompts (if applicable)")
    @JsonProperty("options")
    @Valid
    public List<Option> getOptions() {
        return options;
    }
    public void setOptions(List<Option> options) {
        this.options = options;
    }

    public Prompt addOptionsItem(Option optionsItem) {
        if (this.options == null) {
            this.options = new ArrayList<>();
        }
        this.options.add(optionsItem);
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
        Prompt prompt = (Prompt) o;
        return Objects.equals(this.name, prompt.name) &&
            Objects.equals(this.value, prompt.value) &&
            Objects.equals(this.dataType, prompt.dataType) &&
            Objects.equals(this.isMandatory, prompt.isMandatory) &&
            Objects.equals(this.isReadOnly, prompt.isReadOnly) &&
            Objects.equals(this.order, prompt.order) &&
            Objects.equals(this.validationRegex, prompt.validationRegex) &&
            Objects.equals(this.i18nKey, prompt.i18nKey) &&
            Objects.equals(this.options, prompt.options);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, value, dataType, isMandatory, isReadOnly, order, validationRegex, i18nKey, options);
    }

    @Override
    public String toString() {

        StringBuilder sb = new StringBuilder();
        sb.append("class Prompt {\n");
        
        sb.append("    name: ").append(toIndentedString(name)).append("\n");
        sb.append("    value: ").append(toIndentedString(value)).append("\n");
        sb.append("    dataType: ").append(toIndentedString(dataType)).append("\n");
        sb.append("    isMandatory: ").append(toIndentedString(isMandatory)).append("\n");
        sb.append("    isReadOnly: ").append(toIndentedString(isReadOnly)).append("\n");
        sb.append("    order: ").append(toIndentedString(order)).append("\n");
        sb.append("    validationRegex: ").append(toIndentedString(validationRegex)).append("\n");
        sb.append("    i18nKey: ").append(toIndentedString(i18nKey)).append("\n");
        sb.append("    options: ").append(toIndentedString(options)).append("\n");
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

