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
import java.util.List;
import org.wso2.carbon.identity.rest.api.user.registration.v1.model.Context;
import javax.validation.constraints.*;

/**
 * Contains the data related to a message in the registration step.
 **/

import io.swagger.annotations.*;
import java.util.Objects;
import javax.validation.Valid;
import javax.xml.bind.annotation.*;
@ApiModel(description = "Contains the data related to a message in the registration step.")
public class MessageInfo  {
  

@XmlType(name="TypeEnum")
@XmlEnum(String.class)
public enum TypeEnum {

    @XmlEnumValue("INFO") INFO(String.valueOf("INFO")), @XmlEnumValue("ERROR") ERROR(String.valueOf("ERROR"));


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
    private String messageId;
    private String message;
    private List<Context> context = new ArrayList<>();

    private String i18nKey;

    /**
    * Indicates the type of the message.
    **/
    public MessageInfo type(TypeEnum type) {

        this.type = type;
        return this;
    }
    
    @ApiModelProperty(example = "ERROR", required = true, value = "Indicates the type of the message.")
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
    * The message identifier.
    **/
    public MessageInfo messageId(String messageId) {

        this.messageId = messageId;
        return this;
    }
    
    @ApiModelProperty(example = "msg_invalid_username", required = true, value = "The message identifier.")
    @JsonProperty("messageId")
    @Valid
    @NotNull(message = "Property messageId cannot be null.")

    public String getMessageId() {
        return messageId;
    }
    public void setMessageId(String messageId) {
        this.messageId = messageId;
    }

    /**
    * The message.
    **/
    public MessageInfo message(String message) {

        this.message = message;
        return this;
    }
    
    @ApiModelProperty(example = "The username is not available.", required = true, value = "The message.")
    @JsonProperty("message")
    @Valid
    @NotNull(message = "Property message cannot be null.")

    public String getMessage() {
        return message;
    }
    public void setMessage(String message) {
        this.message = message;
    }

    /**
    **/
    public MessageInfo context(List<Context> context) {

        this.context = context;
        return this;
    }
    
    @ApiModelProperty(required = true, value = "")
    @JsonProperty("context")
    @Valid
    @NotNull(message = "Property context cannot be null.")

    public List<Context> getContext() {
        return context;
    }
    public void setContext(List<Context> context) {
        this.context = context;
    }

    public MessageInfo addContextItem(Context contextItem) {
        this.context.add(contextItem);
        return this;
    }

        /**
    * The i18n key for the message. This can be used to get the localized text for the message.
    **/
    public MessageInfo i18nKey(String i18nKey) {

        this.i18nKey = i18nKey;
        return this;
    }
    
    @ApiModelProperty(example = "error.invalid.username", required = true, value = "The i18n key for the message. This can be used to get the localized text for the message.")
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
        MessageInfo messageInfo = (MessageInfo) o;
        return Objects.equals(this.type, messageInfo.type) &&
            Objects.equals(this.messageId, messageInfo.messageId) &&
            Objects.equals(this.message, messageInfo.message) &&
            Objects.equals(this.context, messageInfo.context) &&
            Objects.equals(this.i18nKey, messageInfo.i18nKey);
    }

    @Override
    public int hashCode() {
        return Objects.hash(type, messageId, message, context, i18nKey);
    }

    @Override
    public String toString() {

        StringBuilder sb = new StringBuilder();
        sb.append("class MessageInfo {\n");
        
        sb.append("    type: ").append(toIndentedString(type)).append("\n");
        sb.append("    messageId: ").append(toIndentedString(messageId)).append("\n");
        sb.append("    message: ").append(toIndentedString(message)).append("\n");
        sb.append("    context: ").append(toIndentedString(context)).append("\n");
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

