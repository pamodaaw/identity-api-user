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
import org.wso2.carbon.identity.rest.api.user.registration.v1.model.Message;
import org.wso2.carbon.identity.rest.api.user.registration.v1.model.RegistrationComponent;
import javax.validation.constraints.*;

/**
 * Contains the registration details related to the current step.
 **/

import io.swagger.annotations.*;
import java.util.Objects;
import javax.validation.Valid;
import javax.xml.bind.annotation.*;
@ApiModel(description = "Contains the registration details related to the current step.")
public class CurrentStep  {
  

@XmlType(name="StepTypeEnum")
@XmlEnum(String.class)
public enum StepTypeEnum {

    @XmlEnumValue("MULTI_OPTIONS_PROMPT") MULTI_OPTIONS_PROMPT(String.valueOf("MULTI_OPTIONS_PROMPT")), @XmlEnumValue("SINGLE_OPTION_USER_PROMPT") SINGLE_OPTION_USER_PROMPT(String.valueOf("SINGLE_OPTION_USER_PROMPT")), @XmlEnumValue("AGG_OPTIONS_USER_PROMPT") AGG_OPTIONS_USER_PROMPT(String.valueOf("AGG_OPTIONS_USER_PROMPT"));


    private String value;

    StepTypeEnum(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    @Override
    public String toString() {
        return String.valueOf(value);
    }

    public static StepTypeEnum fromValue(String value) {
        for (StepTypeEnum b : StepTypeEnum.values()) {
            if (b.value.equals(value)) {
                return b;
            }
        }
        throw new IllegalArgumentException("Unexpected value '" + value + "'");
    }
}

    private StepTypeEnum stepType;
    private List<RegistrationComponent> registrationComponents = null;

    private List<Message> messages = null;


    /**
    * The type of the current step in the registration flow. - MULTI_OPTIONS_PROMPT - The current step is for the selection of the registration option. - REGISTRATION_USER_PROMPT - The current step is for obtaining information from the user to proceed the registration 
    **/
    public CurrentStep stepType(StepTypeEnum stepType) {

        this.stepType = stepType;
        return this;
    }
    
    @ApiModelProperty(example = "SINGLE_OPTION_USER_PROMPT", value = "The type of the current step in the registration flow. - MULTI_OPTIONS_PROMPT - The current step is for the selection of the registration option. - REGISTRATION_USER_PROMPT - The current step is for obtaining information from the user to proceed the registration ")
    @JsonProperty("stepType")
    @Valid
    public StepTypeEnum getStepType() {
        return stepType;
    }
    public void setStepType(StepTypeEnum stepType) {
        this.stepType = stepType;
    }

    /**
    **/
    public CurrentStep registrationComponents(List<RegistrationComponent> registrationComponents) {

        this.registrationComponents = registrationComponents;
        return this;
    }
    
    @ApiModelProperty(value = "")
    @JsonProperty("registrationComponents")
    @Valid
    public List<RegistrationComponent> getRegistrationComponents() {
        return registrationComponents;
    }
    public void setRegistrationComponents(List<RegistrationComponent> registrationComponents) {
        this.registrationComponents = registrationComponents;
    }

    public CurrentStep addRegistrationComponentsItem(RegistrationComponent registrationComponentsItem) {
        if (this.registrationComponents == null) {
            this.registrationComponents = new ArrayList<>();
        }
        this.registrationComponents.add(registrationComponentsItem);
        return this;
    }

        /**
    **/
    public CurrentStep messages(List<Message> messages) {

        this.messages = messages;
        return this;
    }
    
    @ApiModelProperty(value = "")
    @JsonProperty("messages")
    @Valid
    public List<Message> getMessages() {
        return messages;
    }
    public void setMessages(List<Message> messages) {
        this.messages = messages;
    }

    public CurrentStep addMessagesItem(Message messagesItem) {
        if (this.messages == null) {
            this.messages = new ArrayList<>();
        }
        this.messages.add(messagesItem);
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
        CurrentStep currentStep = (CurrentStep) o;
        return Objects.equals(this.stepType, currentStep.stepType) &&
            Objects.equals(this.registrationComponents, currentStep.registrationComponents) &&
            Objects.equals(this.messages, currentStep.messages);
    }

    @Override
    public int hashCode() {
        return Objects.hash(stepType, registrationComponents, messages);
    }

    @Override
    public String toString() {

        StringBuilder sb = new StringBuilder();
        sb.append("class CurrentStep {\n");
        
        sb.append("    stepType: ").append(toIndentedString(stepType)).append("\n");
        sb.append("    registrationComponents: ").append(toIndentedString(registrationComponents)).append("\n");
        sb.append("    messages: ").append(toIndentedString(messages)).append("\n");
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

