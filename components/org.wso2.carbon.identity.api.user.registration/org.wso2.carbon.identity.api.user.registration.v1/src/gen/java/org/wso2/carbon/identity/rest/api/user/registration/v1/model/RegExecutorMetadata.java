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
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.wso2.carbon.identity.rest.api.user.registration.v1.model.ParamInfo;
import javax.validation.constraints.*;

/**
 * Contains the metadata related to a registration executor.
 **/

import io.swagger.annotations.*;
import java.util.Objects;
import javax.validation.Valid;
import javax.xml.bind.annotation.*;
@ApiModel(description = "Contains the metadata related to a registration executor.")
public class RegExecutorMetadata  {
  
    private String i18nKey;

@XmlType(name="PromptTypeEnum")
@XmlEnum(String.class)
public enum PromptTypeEnum {

    @XmlEnumValue("USER_PROMPT") USER_PROMPT(String.valueOf("USER_PROMPT")), @XmlEnumValue("INTERNAL_PROMPT") INTERNAL_PROMPT(String.valueOf("INTERNAL_PROMPT")), @XmlEnumValue("REDIRECTION_PROMPT") REDIRECTION_PROMPT(String.valueOf("REDIRECTION_PROMPT"));


    private String value;

    PromptTypeEnum(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    @Override
    public String toString() {
        return String.valueOf(value);
    }

    public static PromptTypeEnum fromValue(String value) {
        for (PromptTypeEnum b : PromptTypeEnum.values()) {
            if (b.value.equals(value)) {
                return b;
            }
        }
        throw new IllegalArgumentException("Unexpected value '" + value + "'");
    }
}

    private PromptTypeEnum promptType;
    private List<ParamInfo> params = null;

    private Map<String, String> additionalData = null;


    /**
    * The i18n key for the registration executor. This can be used to get the localized text for the registration executor.
    **/
    public RegExecutorMetadata i18nKey(String i18nKey) {

        this.i18nKey = i18nKey;
        return this;
    }
    
    @ApiModelProperty(required = true, value = "The i18n key for the registration executor. This can be used to get the localized text for the registration executor.")
    @JsonProperty("i18nKey")
    @Valid
    @NotNull(message = "Property i18nKey cannot be null.")

    public String getI18nKey() {
        return i18nKey;
    }
    public void setI18nKey(String i18nKey) {
        this.i18nKey = i18nKey;
    }

    /**
    * The type of the prompt. The prompt can be one of the following. - USER_PROMPT - The prompt is for the user to input the required parameters for the registration. - INTERNAL_PROMPT - The prompt is for the system to perform an internal action which will result in   obtaining the required parameters - REDIRECTION_PROMPT - The prompt is for the user to be redirected to a different url which will result in obtaining the required parameters. ex: Register using a social authenticator which requires the user to be   redirect to the federation identity provider. In this case, other required data will be available in &#x60;additionalData&#x60;. 
    **/
    public RegExecutorMetadata promptType(PromptTypeEnum promptType) {

        this.promptType = promptType;
        return this;
    }
    
    @ApiModelProperty(example = "USER_PROMPT", value = "The type of the prompt. The prompt can be one of the following. - USER_PROMPT - The prompt is for the user to input the required parameters for the registration. - INTERNAL_PROMPT - The prompt is for the system to perform an internal action which will result in   obtaining the required parameters - REDIRECTION_PROMPT - The prompt is for the user to be redirected to a different url which will result in obtaining the required parameters. ex: Register using a social authenticator which requires the user to be   redirect to the federation identity provider. In this case, other required data will be available in `additionalData`. ")
    @JsonProperty("promptType")
    @Valid
    public PromptTypeEnum getPromptType() {
        return promptType;
    }
    public void setPromptType(PromptTypeEnum promptType) {
        this.promptType = promptType;
    }

    /**
    **/
    public RegExecutorMetadata params(List<ParamInfo> params) {

        this.params = params;
        return this;
    }
    
    @ApiModelProperty(value = "")
    @JsonProperty("params")
    @Valid
    public List<ParamInfo> getParams() {
        return params;
    }
    public void setParams(List<ParamInfo> params) {
        this.params = params;
    }

    public RegExecutorMetadata addParamsItem(ParamInfo paramsItem) {
        if (this.params == null) {
            this.params = new ArrayList<>();
        }
        this.params.add(paramsItem);
        return this;
    }

        /**
    * Contains any additional data related to the authenticator which would be needed for the application to perform authentication. ex: Fido2 challenge, redirectUrl for federated authentication. 
    **/
    public RegExecutorMetadata additionalData(Map<String, String> additionalData) {

        this.additionalData = additionalData;
        return this;
    }
    
    @ApiModelProperty(example = "{\"redirectUrl\":\"https://accounts.google.com/o/oauth2/auth?response_type=code&redirect_uri=https%3A%2F%2Fexample-app.com%2Fredirect&state=e12f-ed27-49e5-ad0a-8bbb5671d81e%2COIDC&client_id=231644702133-ds23592jt.apps.googleusercontent.com&scope=openid\"}", value = "Contains any additional data related to the authenticator which would be needed for the application to perform authentication. ex: Fido2 challenge, redirectUrl for federated authentication. ")
    @JsonProperty("additionalData")
    @Valid
    public Map<String, String> getAdditionalData() {
        return additionalData;
    }
    public void setAdditionalData(Map<String, String> additionalData) {
        this.additionalData = additionalData;
    }


    public RegExecutorMetadata putAdditionalDataItem(String key, String additionalDataItem) {
        if (this.additionalData == null) {
            this.additionalData = new HashMap<>();
        }
        this.additionalData.put(key, additionalDataItem);
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
        RegExecutorMetadata regExecutorMetadata = (RegExecutorMetadata) o;
        return Objects.equals(this.i18nKey, regExecutorMetadata.i18nKey) &&
            Objects.equals(this.promptType, regExecutorMetadata.promptType) &&
            Objects.equals(this.params, regExecutorMetadata.params) &&
            Objects.equals(this.additionalData, regExecutorMetadata.additionalData);
    }

    @Override
    public int hashCode() {
        return Objects.hash(i18nKey, promptType, params, additionalData);
    }

    @Override
    public String toString() {

        StringBuilder sb = new StringBuilder();
        sb.append("class RegExecutorMetadata {\n");
        
        sb.append("    i18nKey: ").append(toIndentedString(i18nKey)).append("\n");
        sb.append("    promptType: ").append(toIndentedString(promptType)).append("\n");
        sb.append("    params: ").append(toIndentedString(params)).append("\n");
        sb.append("    additionalData: ").append(toIndentedString(additionalData)).append("\n");
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

