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

import org.wso2.carbon.identity.rest.api.user.registration.v1.model.ParamInfo;
import org.wso2.carbon.identity.rest.api.user.registration.v1.model.RegExecutorMetadata;
import org.wso2.carbon.identity.rest.api.user.registration.v1.model.RegStepExecutor;
import org.wso2.carbon.identity.user.registration.model.response.ExecutorMetadata;
import org.wso2.carbon.identity.user.registration.model.response.ExecutorResponse;
import org.wso2.carbon.identity.user.registration.model.response.RequiredParam;
import org.wso2.carbon.identity.user.registration.util.RegistrationFlowConstants;

import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * Converts ExecutorResponse to RegistrationComponent.
 */
public class RegStepExecutorResponseToExternalRef implements Function<ExecutorResponse, RegStepExecutor> {

    @Override
    public RegStepExecutor apply(ExecutorResponse executorResponse) {

        RegStepExecutor regStepExecutor = new RegStepExecutor();
        regStepExecutor.setId(executorResponse.getId());
        regStepExecutor.setName(executorResponse.getName());
        regStepExecutor.executor(executorResponse.getExecutorName());

        if (executorResponse.getMetadata() != null) {
            regStepExecutor.setMetadata(internalMetadataToExternal.apply(executorResponse.getMetadata()));
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

    private ParamInfo.TypeEnum getDataType(RegistrationFlowConstants.DataType dataType) {

        if (dataType == null) {
            return null;
        }
        return ParamInfo.TypeEnum.valueOf(dataType.name());
    }

    private RegExecutorMetadata.PromptTypeEnum getPromptType(RegistrationFlowConstants.PromptType promptType) {


        if (promptType == RegistrationFlowConstants.PromptType.USER_PROMPT) {
            return RegExecutorMetadata.PromptTypeEnum.USER_PROMPT;
        } else {
            return null;
        }
    }
}
