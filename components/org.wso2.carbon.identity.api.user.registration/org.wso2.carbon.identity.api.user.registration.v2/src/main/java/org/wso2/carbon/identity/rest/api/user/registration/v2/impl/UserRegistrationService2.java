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
import org.wso2.carbon.identity.rest.api.user.registration.v2.model.RegCompleteResponse;
import org.wso2.carbon.identity.rest.api.user.registration.v2.model.RegPromptResponse;
import org.wso2.carbon.identity.rest.api.user.registration.v2.model.Section;
import org.wso2.carbon.identity.user.registration.UserRegistrationFlowService;
import org.wso2.carbon.identity.user.registration.graphexecutor.model.Element;
import org.wso2.carbon.identity.user.registration.graphexecutor.model.ExecutionState;
import org.wso2.carbon.identity.user.registration.graphexecutor.model.ProcessResult;
import org.wso2.carbon.identity.user.registration.graphexecutor.model.RequiredData;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.core.Response;

/**
 * Implementation of the Rest APIs for user self registration.
 */
public class UserRegistrationService2 {

    private static final Log LOG = LogFactory.getLog(UserRegistrationService2.class);

    public Object triggerRegistration(InitRegRequest initRegRequest) {

        UserRegistrationFlowService service = UserRegistrationServiceHolder.getUserRegistrationFlowService();
        ExecutionState response = service.triggerRegFlow(null, null);

        for (ProcessResult result : response.getResults()) {
            if ("SUCCESSFUL".equals(result.getStatus())) {
                return new RegCompleteResponse();
            }
            if ("INCOMPLETE".equals(result.getStatus())) {
                RegPromptResponse regPromptResponse = new RegPromptResponse();
                regPromptResponse.setFlowId(response.getFlowId());
                regPromptResponse.setFlowStatus(RegPromptResponse.FlowStatusEnum.INCOMPLETE);

                List<Section> sections = new ArrayList<>();
                regPromptResponse.setSections(sections);

               LOG.info("Node returns incomplete.");
                if (result.getInputDataList() != null && !result.getInputDataList().isEmpty()) {
                    int count = 0;
                    for (RequiredData data : result.getInputDataList()) {
                        Section section = new Section();
                        section.setId(data.getNodeName());
                        section.setOrder(++count);
                        List<org.wso2.carbon.identity.rest.api.user.registration.v2.model.Element> uiElements =
                                new ArrayList<>();
                        if ("USER_INPUT".equals(data.getInputType())) {
                            section.setMode(Section.ModeEnum.ALLOF);


                        } else if ("USER_CHOICE".equals(data.getInputType())) {
                            section.setMode(Section.ModeEnum.ONEOF);
                        }
                        for (Element element : data.getRequiredData()) {
                            org.wso2.carbon.identity.rest.api.user.registration.v2.model.Element uiElement =
                                    new org.wso2.carbon.identity.rest.api.user.registration.v2.model.Element();
                            uiElement.setName(element.getName());
                            uiElement.setDataType(
                                    org.wso2.carbon.identity.rest.api.user.registration.v2.model.Element
                                            .DataTypeEnum.STRING);
                            uiElement.setOrder(1);
                            uiElements.add(uiElement);
                        }
                        section.setElements(uiElements);
                        sections.add(section);
                    }
                }
                return regPromptResponse;
            }
        }
        throw buildServerError(new Exception("Unexpected error occurred."));
    }

    private APIError buildServerError(Exception e) {

        ErrorDTO errorDTO = new ErrorDTO();
        errorDTO.setMessage(e.getMessage());
        errorDTO.setCode("USR-00001");

        LOG.error("Server Error", e);
        return new APIError(Response.Status.INTERNAL_SERVER_ERROR, errorDTO);
    }
}
