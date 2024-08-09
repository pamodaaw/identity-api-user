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

/**
 * The user attribute information required by the registration executor to perform the registration.
 **/

import io.swagger.annotations.*;
import java.util.Objects;
import javax.validation.Valid;
import javax.xml.bind.annotation.*;
@ApiModel(description = "The user attribute information required by the registration executor to perform the registration.")
public class Element  {
  
    private String name;
    private String value;

@XmlType(name="DataTypeEnum")
@XmlEnum(String.class)
public enum DataTypeEnum {

    @XmlEnumValue("STRING") STRING(String.valueOf("STRING")), @XmlEnumValue("NUMBER") NUMBER(String.valueOf("NUMBER")), @XmlEnumValue("BOOLEAN") BOOLEAN(String.valueOf("BOOLEAN")), @XmlEnumValue("DATE") DATE(String.valueOf("DATE"));


    private String value;

    DataTypeEnum(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    @Override
    public String toString() {
        return String.valueOf(value);
    }

    public static DataTypeEnum fromValue(String value) {
        for (DataTypeEnum b : DataTypeEnum.values()) {
            if (b.value.equals(value)) {
                return b;
            }
        }
        throw new IllegalArgumentException("Unexpected value '" + value + "'");
    }
}

    private DataTypeEnum dataType;
    private Boolean isMandatory;
    private Boolean isReadOnly;
    private Integer order;
    private String validationRegex;
    private String i18nKey;

    /**
    * The display name of the attribute.
    **/
    public Element name(String name) {

        this.name = name;
        return this;
    }
    
    @ApiModelProperty(example = "username", required = true, value = "The display name of the attribute.")
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
    * The value of the attribute if already available.
    **/
    public Element value(String value) {

        this.value = value;
        return this;
    }
    
    @ApiModelProperty(example = "johndoe", value = "The value of the attribute if already available.")
    @JsonProperty("value")
    @Valid
    public String getValue() {
        return value;
    }
    public void setValue(String value) {
        this.value = value;
    }

    /**
    * Indicates the data type of the parameter.
    **/
    public Element dataType(DataTypeEnum dataType) {

        this.dataType = dataType;
        return this;
    }
    
    @ApiModelProperty(example = "STRING", required = true, value = "Indicates the data type of the parameter.")
    @JsonProperty("dataType")
    @Valid
    @NotNull(message = "Property dataType cannot be null.")

    public DataTypeEnum getDataType() {
        return dataType;
    }
    public void setDataType(DataTypeEnum dataType) {
        this.dataType = dataType;
    }

    /**
    * Indicates whether the attribute is mandatory to be filled.
    **/
    public Element isMandatory(Boolean isMandatory) {

        this.isMandatory = isMandatory;
        return this;
    }
    
    @ApiModelProperty(example = "true", value = "Indicates whether the attribute is mandatory to be filled.")
    @JsonProperty("isMandatory")
    @Valid
    public Boolean getIsMandatory() {
        return isMandatory;
    }
    public void setIsMandatory(Boolean isMandatory) {
        this.isMandatory = isMandatory;
    }

    /**
    * Indicates whether the attribute is read only if a value is already available.
    **/
    public Element isReadOnly(Boolean isReadOnly) {

        this.isReadOnly = isReadOnly;
        return this;
    }
    
    @ApiModelProperty(example = "true", value = "Indicates whether the attribute is read only if a value is already available.")
    @JsonProperty("isReadOnly")
    @Valid
    public Boolean getIsReadOnly() {
        return isReadOnly;
    }
    public void setIsReadOnly(Boolean isReadOnly) {
        this.isReadOnly = isReadOnly;
    }

    /**
    * Indicates the display order of the attribute.
    **/
    public Element order(Integer order) {

        this.order = order;
        return this;
    }
    
    @ApiModelProperty(example = "1", required = true, value = "Indicates the display order of the attribute.")
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
    * Contains the regex pattern to validate the value of the attribute.
    **/
    public Element validationRegex(String validationRegex) {

        this.validationRegex = validationRegex;
        return this;
    }
    
    @ApiModelProperty(example = "^[\\S]{3,50}$", value = "Contains the regex pattern to validate the value of the attribute.")
    @JsonProperty("validationRegex")
    @Valid
    public String getValidationRegex() {
        return validationRegex;
    }
    public void setValidationRegex(String validationRegex) {
        this.validationRegex = validationRegex;
    }

    /**
    * The i18n key for the attribute. This can be used to get the localized text for the attribute.
    **/
    public Element i18nKey(String i18nKey) {

        this.i18nKey = i18nKey;
        return this;
    }
    
    @ApiModelProperty(example = "attribute.username", value = "The i18n key for the attribute. This can be used to get the localized text for the attribute.")
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
        Element element = (Element) o;
        return Objects.equals(this.name, element.name) &&
            Objects.equals(this.value, element.value) &&
            Objects.equals(this.dataType, element.dataType) &&
            Objects.equals(this.isMandatory, element.isMandatory) &&
            Objects.equals(this.isReadOnly, element.isReadOnly) &&
            Objects.equals(this.order, element.order) &&
            Objects.equals(this.validationRegex, element.validationRegex) &&
            Objects.equals(this.i18nKey, element.i18nKey);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, value, dataType, isMandatory, isReadOnly, order, validationRegex, i18nKey);
    }

    @Override
    public String toString() {

        StringBuilder sb = new StringBuilder();
        sb.append("class Element {\n");
        
        sb.append("    name: ").append(toIndentedString(name)).append("\n");
        sb.append("    value: ").append(toIndentedString(value)).append("\n");
        sb.append("    dataType: ").append(toIndentedString(dataType)).append("\n");
        sb.append("    isMandatory: ").append(toIndentedString(isMandatory)).append("\n");
        sb.append("    isReadOnly: ").append(toIndentedString(isReadOnly)).append("\n");
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

