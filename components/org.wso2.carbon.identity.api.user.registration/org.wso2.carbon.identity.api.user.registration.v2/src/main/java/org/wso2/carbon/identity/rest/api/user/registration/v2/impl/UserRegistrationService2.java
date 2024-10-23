/*
 * Copyright (c) 2024, WSO2 LLC. (https://www.wso2.com) All Rights Reserved.
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

package org.wso2.carbon.identity.rest.api.user.registration.v2.impl;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.wso2.carbon.identity.api.user.common.error.APIError;
import org.wso2.carbon.identity.api.user.common.error.ErrorDTO;
import org.wso2.carbon.identity.api.user.registration.common.UserRegistrationServiceHolder;
import org.wso2.carbon.identity.rest.api.user.registration.v2.model.InitRegRequest;
import org.wso2.carbon.identity.rest.api.user.registration.v2.model.Option;
import org.wso2.carbon.identity.rest.api.user.registration.v2.model.Prompt;
import org.wso2.carbon.identity.rest.api.user.registration.v2.model.RegCompleteResponse;
import org.wso2.carbon.identity.rest.api.user.registration.v2.model.RegPromptResponse;
import org.wso2.carbon.identity.rest.api.user.registration.v2.model.Section;
import org.wso2.carbon.identity.rest.api.user.registration.v2.model.SectionData;
import org.wso2.carbon.identity.rest.api.user.registration.v2.model.SubmitRegRequest;
import org.wso2.carbon.identity.user.self.registration.UserRegistrationFlowService;
import org.wso2.carbon.identity.user.self.registration.exception.RegistrationFrameworkException;
import org.wso2.carbon.identity.user.self.registration.model.ExecutionState;
import org.wso2.carbon.identity.user.self.registration.model.InputData;
import org.wso2.carbon.identity.user.self.registration.model.InputMetaData;
import org.wso2.carbon.identity.user.self.registration.model.NodeResponse;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.ws.rs.core.Response;

import static org.wso2.carbon.identity.user.self.registration.util.Constants.STATUS_COMPLETE;
import static org.wso2.carbon.identity.user.self.registration.util.Constants.STATUS_USER_INPUT_REQUIRED;

/**
 * Implementation of the Rest APIs for user self registration.
 */
public class UserRegistrationService2 {

    private static final Log LOG = LogFactory.getLog(UserRegistrationService2.class);

    public Object triggerRegistration(InitRegRequest initRegRequest) {

        UserRegistrationFlowService service = UserRegistrationServiceHolder.getUserRegistrationFlowService();
        try {
            ExecutionState status = service.initiateFlow(initRegRequest.getApplicationId());
            return handleResponse(status);
        } catch (RegistrationFrameworkException e) {
            return  buildServerError(e);
        }
    }

    public Object continueRegistration(SubmitRegRequest request) {

        UserRegistrationFlowService service = UserRegistrationServiceHolder.getUserRegistrationFlowService();
        List<SectionData> inputData = request.getUserData();

        LinkedHashMap<String, InputData> inputList = new LinkedHashMap<>();
        for (SectionData sectionData : inputData) {
            InputData input = new InputData();
            input.setUserInput(sectionData.getInputs());
            inputList.put(sectionData.getId(), input);
        }

        try {
            ExecutionState status = service.continueFlow(request.getFlowId(), inputList);
            return handleResponse(status);
        } catch (RegistrationFrameworkException e) {
            return  buildServerError(e);
        }

    }

    private Object handleResponse(ExecutionState status) {

        NodeResponse response = status.getResponse();

        if (STATUS_COMPLETE.equals(response.getStatus())) {
            RegCompleteResponse regCompleteResponse = new RegCompleteResponse();
            regCompleteResponse.setFlowId(status.getFlowId());
            regCompleteResponse.setUserAssertion(response.getUserAssertion());
            return regCompleteResponse;
        }
        if (STATUS_USER_INPUT_REQUIRED.equals(response.getStatus())) {
            RegPromptResponse regPromptResponse = new RegPromptResponse();
            regPromptResponse.setFlowId(status.getFlowId());
            regPromptResponse.setFlowStatus(RegPromptResponse.FlowStatusEnum.INCOMPLETE);

            Map<String, List<InputMetaData>> inputDataMap = response.getInputMetaDataList();
            List<Section> sections = new ArrayList<>();

            if (inputDataMap != null) {
                for (Map.Entry<String, List<InputMetaData>> entry : inputDataMap.entrySet()) {
                    Section section = new Section();
                    section.setId(entry.getKey());
                    section.setOrder(sections.size() + 1);

                    List<Prompt> prompts = new ArrayList<>();
                    for (InputMetaData meta : entry.getValue()) {
                        prompts.add(convertIntoPrompt(meta, prompts));
                    }
                    section.setPrompts(prompts);
                    sections.add(section);
                }
            }
            regPromptResponse.setSections(sections);
            return regPromptResponse;
        }
        throw buildServerError(new Exception("Unexpected error occurred."));
    }

    private static Prompt convertIntoPrompt(InputMetaData meta, List<Prompt> prompts) {

        Prompt prompt = new Prompt();
        prompt.setName(meta.getName());
        prompt.setValue(meta.getAvailableValue());
        prompt.setDataType(meta.getDataType());
        prompt.setOrder(prompts.size() + 1);
        prompt.setIsMandatory(meta.isMandatory());
        prompt.setIsReadOnly(meta.isReadOnly());
        prompt.setValidationRegex(meta.getValidationRegex());
        prompt.setI18nKey(meta.getI18nKey());
        for (Object option : meta.getOptions()) {
            prompt.addOptionsItem(new Option().value((String) option));
        }
        return prompt;
    }


    private APIError buildServerError(Exception e) {

        ErrorDTO errorDTO = new ErrorDTO();
        errorDTO.setMessage(e.getMessage());
        errorDTO.setCode("USR-00001");

        LOG.error("Server Error", e);
        throw new APIError(Response.Status.INTERNAL_SERVER_ERROR, errorDTO);
    }
}
