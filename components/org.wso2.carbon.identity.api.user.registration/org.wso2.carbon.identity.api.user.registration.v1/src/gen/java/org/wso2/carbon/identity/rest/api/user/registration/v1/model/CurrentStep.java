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
import org.wso2.carbon.identity.rest.api.user.registration.v1.model.RegStepExecutor;
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

    @XmlEnumValue("MULTI_OPTIONS") MULTI_OPTIONS(String.valueOf("MULTI_OPTIONS")), @XmlEnumValue("SINGLE_OPTION") SINGLE_OPTION(String.valueOf("SINGLE_OPTION")), @XmlEnumValue("AGG_OPTIONS") AGG_OPTIONS(String.valueOf("AGG_OPTIONS"));


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
    private List<RegStepExecutor> registrationStepExecutors = null;


    /**
    * The type of the current step in the registration flow. - MULTI_OPTIONS - The current step is for the selection of the registration option. - SINGLE_OPTION - The current step is for obtaining information from the user to proceed the registration 
    **/
    public CurrentStep stepType(StepTypeEnum stepType) {

        this.stepType = stepType;
        return this;
    }
    
    @ApiModelProperty(example = "SINGLE_OPTION", value = "The type of the current step in the registration flow. - MULTI_OPTIONS - The current step is for the selection of the registration option. - SINGLE_OPTION - The current step is for obtaining information from the user to proceed the registration ")
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
    public CurrentStep registrationStepExecutors(List<RegStepExecutor> registrationStepExecutors) {

        this.registrationStepExecutors = registrationStepExecutors;
        return this;
    }
    
    @ApiModelProperty(value = "")
    @JsonProperty("registrationStepExecutors")
    @Valid
    public List<RegStepExecutor> getRegistrationStepExecutors() {
        return registrationStepExecutors;
    }
    public void setRegistrationStepExecutors(List<RegStepExecutor> registrationStepExecutors) {
        this.registrationStepExecutors = registrationStepExecutors;
    }

    public CurrentStep addRegistrationStepExecutorsItem(RegStepExecutor registrationStepExecutorsItem) {
        if (this.registrationStepExecutors == null) {
            this.registrationStepExecutors = new ArrayList<>();
        }
        this.registrationStepExecutors.add(registrationStepExecutorsItem);
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
            Objects.equals(this.registrationStepExecutors, currentStep.registrationStepExecutors);
    }

    @Override
    public int hashCode() {
        return Objects.hash(stepType, registrationStepExecutors);
    }

    @Override
    public String toString() {

        StringBuilder sb = new StringBuilder();
        sb.append("class CurrentStep {\n");
        
        sb.append("    stepType: ").append(toIndentedString(stepType)).append("\n");
        sb.append("    registrationStepExecutors: ").append(toIndentedString(registrationStepExecutors)).append("\n");
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

