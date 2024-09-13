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
import org.wso2.carbon.identity.rest.api.user.registration.v1.model.ParamInfo;
import org.wso2.carbon.identity.rest.api.user.registration.v1.model.RegExecutorMetadata;
import org.wso2.carbon.identity.rest.api.user.registration.v1.model.RegStepExecutor;
import org.wso2.carbon.identity.user.self.registration.model.response.ExecutorMetadata;
import org.wso2.carbon.identity.user.self.registration.model.response.ExecutorResponse;
import org.wso2.carbon.identity.user.self.registration.model.response.Message;
import org.wso2.carbon.identity.user.self.registration.model.response.RequiredParam;
import org.wso2.carbon.identity.user.self.registration.util.RegistrationConstants;

import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

import static org.wso2.carbon.identity.user.self.registration.util.RegistrationConstants.PromptType.USER_PROMPT;

/**
 * Converts ExecutorResponse to RegistrationComponent.
 */
public class RegStepExecutorResponseToExternalRef implements Function<ExecutorResponse, RegStepExecutor> {

    @Override
    public RegStepExecutor apply(ExecutorResponse executorResponse) {

        RegStepExecutor regStepExecutor = new RegStepExecutor();
        regStepExecutor.setId(executorResponse.getId());
        regStepExecutor.setName(executorResponse.getName());
        regStepExecutor.type(executorResponse.getType());

        if (executorResponse.getMetadata() != null) {
            regStepExecutor.setMetadata(internalMetadataToExternal.apply(executorResponse.getMetadata()));
        }
        if (executorResponse.getMessage() != null) {
            regStepExecutor.setMessage(internalMsgToExternalMsg.apply(executorResponse.getMessage()));
        }
        return regStepExecutor;
    }

    Function<RequiredParam, ParamInfo> internalParamToExternalParam = requiredParam -> {

        ParamInfo outputParam = new ParamInfo();
        outputParam.setName(requiredParam.getName());
        outputParam.setType(getDataType(requiredParam.getDataType()));
        outputParam.setIsConfidential(requiredParam.isConfidential());
        outputParam.setIsMandatory(requiredParam.isMandatory());
        outputParam.setOrder(requiredParam.getOrder());
        outputParam.setValidationRegex(requiredParam.getValidationRegex());
        outputParam.setI18nKey(requiredParam.getI18nKey());
        return outputParam;

    };

    Function<ExecutorMetadata, RegExecutorMetadata> internalMetadataToExternal = metadata -> {

        RegExecutorMetadata meta = new RegExecutorMetadata();
        meta.setI18nKey(metadata.getI18nKey());
        if (metadata.getRequiredParams() != null) {
            meta.setParams(metadata.getRequiredParams().stream()
                    .map(internalParamToExternalParam).collect(Collectors.toList()));
        }
        meta.setPromptType(getPromptType(metadata.getPromptType()));
        meta.setAdditionalData(metadata.getAdditionalData());
        return meta;
    };

    private ParamInfo.TypeEnum getDataType(RegistrationConstants.DataType dataType) {

        if (dataType == null) {
            return null;
        }
        return ParamInfo.TypeEnum.valueOf(dataType.name());
    }

    private RegExecutorMetadata.PromptTypeEnum getPromptType(RegistrationConstants.PromptType promptType) {


        if (promptType == USER_PROMPT) {
            return RegExecutorMetadata.PromptTypeEnum.USER_PROMPT;
        } else {
            return null;
        }
    }

    Function<Message, MessageInfo> internalMsgToExternalMsg = message -> {

        MessageInfo outputMessage = new MessageInfo();
        MessageInfo.TypeEnum type;
        if (RegistrationConstants.MessageType.INFO.equals(message.getType())) {
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
