/*
 * Copyright (c) 2023, WSO2 LLC. (https://www.wso2.com) All Rights Reserved.
 *
 * WSO2 LLC. licenses this file to you under the Apache License,
 * Version 2.0 (the "License"); you may not use this file except
 * in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied. See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */

package org.wso2.carbon.identity.rest.api.user.registration.v1.impl.core.function;

import org.wso2.carbon.identity.rest.api.user.registration.v1.model.CurrentStep;
import org.wso2.carbon.identity.rest.api.user.registration.v1.model.RegistrationComponent;
import org.wso2.carbon.identity.user.registration.model.response.CurrentStepResponse;
import org.wso2.carbon.identity.user.registration.util.RegistrationFlowConstants;

import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * Converts the current step response to the external reference.
 */
public class CurrentStepInfoToExternalRef implements Function<CurrentStepResponse, CurrentStep> {

    @Override
    public CurrentStep apply(CurrentStepResponse currentStepResponse) {

        CurrentStep step = new CurrentStep();

        if (currentStepResponse != null) {
            if (RegistrationFlowConstants.StepType.MULTI_OPTION.equals(currentStepResponse.getType())) {
                step.setStepType(CurrentStep.StepTypeEnum.MULTI_OPTIONS_PROMPT);
            } else {
                step.setStepType(CurrentStep.StepTypeEnum.SINGLE_OPTION_USER_PROMPT);
            }

            List<RegistrationComponent> regComDTOs = currentStepResponse.getExecutors().stream()
                    .map(new RegStepExecutorResponseToExternalRef())
                    .collect(Collectors.toList());

            step.setRegistrationComponents(regComDTOs);
        }
        return step;
    }
}
