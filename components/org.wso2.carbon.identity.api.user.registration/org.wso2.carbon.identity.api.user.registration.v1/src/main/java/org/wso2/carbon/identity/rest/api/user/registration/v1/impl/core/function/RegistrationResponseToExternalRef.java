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

import org.wso2.carbon.identity.rest.api.user.registration.v1.model.RegPromptResponse;
import org.wso2.carbon.identity.user.registration.model.response.RegistrationResponse;
import org.wso2.carbon.identity.user.registration.util.RegistrationFlowConstants;

import java.util.function.Function;

/**
 * Function to convert RegistrationResponse to RegPromptResponse.
 */
public class RegistrationResponseToExternalRef implements Function<RegistrationResponse, RegPromptResponse> {

    @Override
    public RegPromptResponse apply(RegistrationResponse registrationResponse) {

        RegPromptResponse regPromptResponse = new RegPromptResponse();
        regPromptResponse.setFlowId(registrationResponse.getFlowId());

        RegPromptResponse.FlowStatusEnum status;

        if (RegistrationFlowConstants.Status.INCOMPLETE.equals(registrationResponse.getStatus())) {
            status = RegPromptResponse.FlowStatusEnum.INCOMPLETE;
        } else {
            status = RegPromptResponse.FlowStatusEnum.FAILURE;
        }
        regPromptResponse.setFlowStatus(status);
        regPromptResponse.setCurrentStep((
                new CurrentStepInfoToExternalRef().apply(registrationResponse.getCurrentStep())));
        return  regPromptResponse;
    }
}
