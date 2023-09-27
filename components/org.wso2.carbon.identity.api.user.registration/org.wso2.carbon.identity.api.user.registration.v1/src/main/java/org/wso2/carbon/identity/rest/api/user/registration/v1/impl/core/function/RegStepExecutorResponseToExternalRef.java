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
import org.wso2.carbon.identity.rest.api.user.registration.v1.model.Message;
import org.wso2.carbon.identity.rest.api.user.registration.v1.model.Param;
import org.wso2.carbon.identity.rest.api.user.registration.v1.model.RegistrationComponent;
import org.wso2.carbon.identity.user.registration.model.response.ExecutorResponse;
import org.wso2.carbon.identity.user.registration.model.response.RequiredParam;
import org.wso2.carbon.identity.user.registration.util.RegistrationFlowConstants;

import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * Converts ExecutorResponse to RegistrationComponent.
 */
public class RegStepExecutorResponseToExternalRef implements Function<ExecutorResponse, RegistrationComponent> {

    @Override
    public RegistrationComponent apply(ExecutorResponse executorResponse) {

        RegistrationComponent registrationComponent = new RegistrationComponent();

        registrationComponent.setName(executorResponse.getName());
        registrationComponent.setId(executorResponse.getId());
        registrationComponent.setType(executorResponse.getType());
        if (executorResponse.getMessages() != null) {
            registrationComponent.setMessages(executorResponse.getMessages().stream()
                    .map(internalMsgToExternalMsg).collect(Collectors.toList()));
        }
        if (executorResponse.getRequiredParams() != null) {
            registrationComponent.setRequiredParams(executorResponse.getRequiredParams().stream()
                    .map(internalParamToExternalParam).collect(Collectors.toList()));
        }

        return registrationComponent;
    }

    Function<org.wso2.carbon.identity.user.registration.model.response.Message, Message> internalMsgToExternalMsg
            = message -> {

        Message outputMessage = new Message();
        Message.TypeEnum type;
        if (RegistrationFlowConstants.MessageType.INFO.equals(message.getType())) {
            type = Message.TypeEnum.INFO;
        } else {
            type = Message.TypeEnum.ERROR;
        }
        outputMessage.setType(type);
        outputMessage.setMessageId(message.getMessageId());
        outputMessage.setMessage(message.getMessage());
        outputMessage.setContext(getContextDTOs(message.getContext()));
        outputMessage.setI18nKey(message.getI18nkey());
        return outputMessage;
    };

    Function<RequiredParam, Param> internalParamToExternalParam = requiredParam -> {

        Param outputParam = new Param();
        outputParam.setName(requiredParam.getName());
        outputParam.setType(getDataType(requiredParam.getDataType()));
        outputParam.setIsConfidential(requiredParam.isConfidential());
        outputParam.setIsMandatory(requiredParam.isMandatory());
        outputParam.setOrder(requiredParam.getOrder());
        outputParam.setValidationRegex(requiredParam.getValidationRegex());
        outputParam.setI18nKey(requiredParam.getI18nKey());
        return outputParam;

    };

    private Param.TypeEnum getDataType(RegistrationFlowConstants.DataType dataType) {

        if (dataType == null) {
            return null;
        }
        return Param.TypeEnum.valueOf(dataType.name());
    }

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
