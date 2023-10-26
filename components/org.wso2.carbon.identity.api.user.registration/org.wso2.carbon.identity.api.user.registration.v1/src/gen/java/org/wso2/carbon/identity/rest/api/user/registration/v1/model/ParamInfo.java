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
 * Contains the data related to a required parameter in the registration step. This data can be used to render the registration UI and collect data from the user
 **/

import io.swagger.annotations.*;
import java.util.Objects;
import javax.validation.Valid;
import javax.xml.bind.annotation.*;
@ApiModel(description = "Contains the data related to a required parameter in the registration step. This data can be used to render the registration UI and collect data from the user")
public class ParamInfo  {
  
    private String name;

@XmlType(name="TypeEnum")
@XmlEnum(String.class)
public enum TypeEnum {

    @XmlEnumValue("STRING") STRING(String.valueOf("STRING")), @XmlEnumValue("NUMBER") NUMBER(String.valueOf("NUMBER")), @XmlEnumValue("BOOLEAN") BOOLEAN(String.valueOf("BOOLEAN")), @XmlEnumValue("DATE") DATE(String.valueOf("DATE"));


    private String value;

    TypeEnum(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    @Override
    public String toString() {
        return String.valueOf(value);
    }

    public static TypeEnum fromValue(String value) {
        for (TypeEnum b : TypeEnum.values()) {
            if (b.value.equals(value)) {
                return b;
            }
        }
        throw new IllegalArgumentException("Unexpected value '" + value + "'");
    }
}

    private TypeEnum type;
    private Boolean isConfidential;
    private Boolean isMandatory;
    private Integer order;
    private String validationRegex;
    private String i18nKey;

    /**
    * The parameter identifier.
    **/
    public ParamInfo name(String name) {

        this.name = name;
        return this;
    }
    
    @ApiModelProperty(example = "username", required = true, value = "The parameter identifier.")
    @JsonProperty("name")
    @Valid
    @NotNull(message = "Property name cannot be null.")

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    /**
    * Indicates the data type of the parameter.
    **/
    public ParamInfo type(TypeEnum type) {

        this.type = type;
        return this;
    }
    
    @ApiModelProperty(example = "STRING", required = true, value = "Indicates the data type of the parameter.")
    @JsonProperty("type")
    @Valid
    @NotNull(message = "Property type cannot be null.")

    public TypeEnum getType() {
        return type;
    }
    public void setType(TypeEnum type) {
        this.type = type;
    }

    /**
    * Indicates whether the parameter is confidential or not.
    **/
    public ParamInfo isConfidential(Boolean isConfidential) {

        this.isConfidential = isConfidential;
        return this;
    }
    
    @ApiModelProperty(example = "false", required = true, value = "Indicates whether the parameter is confidential or not.")
    @JsonProperty("isConfidential")
    @Valid
    @NotNull(message = "Property isConfidential cannot be null.")

    public Boolean getIsConfidential() {
        return isConfidential;
    }
    public void setIsConfidential(Boolean isConfidential) {
        this.isConfidential = isConfidential;
    }

    /**
    * Indicates whether the parameter is mandatory to be filled.
    **/
    public ParamInfo isMandatory(Boolean isMandatory) {

        this.isMandatory = isMandatory;
        return this;
    }
    
    @ApiModelProperty(example = "true", required = true, value = "Indicates whether the parameter is mandatory to be filled.")
    @JsonProperty("isMandatory")
    @Valid
    @NotNull(message = "Property isMandatory cannot be null.")

    public Boolean getIsMandatory() {
        return isMandatory;
    }
    public void setIsMandatory(Boolean isMandatory) {
        this.isMandatory = isMandatory;
    }

    /**
    * Indicates the recommended display order of the parameter.
    **/
    public ParamInfo order(Integer order) {

        this.order = order;
        return this;
    }
    
    @ApiModelProperty(example = "1", required = true, value = "Indicates the recommended display order of the parameter.")
    @JsonProperty("order")
    @Valid
    @NotNull(message = "Property order cannot be null.")

    public Integer getOrder() {
        return order;
    }
    public void setOrder(Integer order) {
        this.order = order;
    }

    /**
    * Contains the regex pattern to validate the parameter value.
    **/
    public ParamInfo validationRegex(String validationRegex) {

        this.validationRegex = validationRegex;
        return this;
    }
    
    @ApiModelProperty(example = "^[\\S]{3,50}$", value = "Contains the regex pattern to validate the parameter value.")
    @JsonProperty("validationRegex")
    @Valid
    public String getValidationRegex() {
        return validationRegex;
    }
    public void setValidationRegex(String validationRegex) {
        this.validationRegex = validationRegex;
    }

    /**
    * The i18n key for the parameter. This can be used to get the localized text for the parameter.
    **/
    public ParamInfo i18nKey(String i18nKey) {

        this.i18nKey = i18nKey;
        return this;
    }
    
    @ApiModelProperty(example = "param.username", required = true, value = "The i18n key for the parameter. This can be used to get the localized text for the parameter.")
    @JsonProperty("i18nKey")
    @Valid
    @NotNull(message = "Property i18nKey cannot be null.")

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
        ParamInfo paramInfo = (ParamInfo) o;
        return Objects.equals(this.name, paramInfo.name) &&
            Objects.equals(this.type, paramInfo.type) &&
            Objects.equals(this.isConfidential, paramInfo.isConfidential) &&
            Objects.equals(this.isMandatory, paramInfo.isMandatory) &&
            Objects.equals(this.order, paramInfo.order) &&
            Objects.equals(this.validationRegex, paramInfo.validationRegex) &&
            Objects.equals(this.i18nKey, paramInfo.i18nKey);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, type, isConfidential, isMandatory, order, validationRegex, i18nKey);
    }

    @Override
    public String toString() {

        StringBuilder sb = new StringBuilder();
        sb.append("class ParamInfo {\n");
        
        sb.append("    name: ").append(toIndentedString(name)).append("\n");
        sb.append("    type: ").append(toIndentedString(type)).append("\n");
        sb.append("    isConfidential: ").append(toIndentedString(isConfidential)).append("\n");
        sb.append("    isMandatory: ").append(toIndentedString(isMandatory)).append("\n");
        sb.append("    order: ").append(toIndentedString(order)).append("\n");
        sb.append("    validationRegex: ").append(toIndentedString(validationRegex)).append("\n");
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

