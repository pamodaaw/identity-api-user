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

import org.wso2.carbon.identity.rest.api.user.registration.v1.model.Context;
import org.wso2.carbon.identity.rest.api.user.registration.v1.model.MessageInfo;
import org.wso2.carbon.identity.rest.api.user.registration.v1.model.NextStep;
import org.wso2.carbon.identity.rest.api.user.registration.v1.model.RegStepExecutor;
import org.wso2.carbon.identity.user.registration.model.response.Message;
import org.wso2.carbon.identity.user.registration.model.response.NextStepResponse;
import org.wso2.carbon.identity.user.registration.util.RegistrationFlowConstants;

import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * Converts the next step response to the external reference.
 */
public class NextStepToExternalRef implements Function<NextStepResponse, NextStep> {

    @Override
    public NextStep apply(NextStepResponse stepResponse) {

        NextStep step = new NextStep();

        if (stepResponse != null) {
            if (RegistrationFlowConstants.StepType.MULTI_OPTION.equals(stepResponse.getType())) {
                step.setStepType(NextStep.StepTypeEnum.MULTI_OPTIONS);
            } else {
                step.setStepType(NextStep.StepTypeEnum.SINGLE_OPTION);
            }

            List<RegStepExecutor> regComDTOs = stepResponse.getExecutors().stream()
                    .map(new RegStepExecutorResponseToExternalRef())
                    .collect(Collectors.toList());

            step.setRegistrationStepExecutors(regComDTOs);
            step.setMessages(stepResponse.getMessages().stream().map(internalMsgToExternalMsg)
                    .collect(Collectors.toList()));
        }
        return step;
    }

    Function<Message, MessageInfo> internalMsgToExternalMsg = message -> {

        MessageInfo outputMessage = new MessageInfo();
        MessageInfo.TypeEnum type;
        if (RegistrationFlowConstants.MessageType.INFO.equals(message.getType())) {
            type = MessageInfo.TypeEnum.INFO;
        } else {
            type = MessageInfo.TypeEnum.ERROR;
        }
        outputMessage.setType(type);
        outputMessage.setMessageId(message.getMessageId());
        outputMessage.setMessage(message.getMessage());
        outputMessage.setContext(getContextDTOs(message.getContext()));
        outputMessage.setI18nKey(message.getI18nkey());
        return outputMessage;
    };


    private List<Context> getContextDTOs(Map<String, String> messageContext) {

        return messageContext.entrySet().stream().map(p -> getContextDTO(p.getKey(), p.getValue()))
                .collect(Collectors.toList());
    }

    private Context getContextDTO(String key, String value) {

        Context context = new Context();
        context.setKey(key);
        context.setValue(value);
        return context;
    }
}
