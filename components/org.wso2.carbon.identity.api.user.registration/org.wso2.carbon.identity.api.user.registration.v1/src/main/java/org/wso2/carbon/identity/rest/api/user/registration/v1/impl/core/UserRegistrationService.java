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

package org.wso2.carbon.identity.rest.api.user.registration.v1.impl.core;

import org.wso2.carbon.identity.api.user.common.error.APIError;
import org.wso2.carbon.identity.api.user.common.error.ErrorDTO;
import org.wso2.carbon.identity.api.user.registration.common.UserRegistrationServiceHolder;
import org.wso2.carbon.identity.rest.api.user.registration.v1.impl.core.function.RegistrationResponseToExternalRef;
import org.wso2.carbon.identity.rest.api.user.registration.v1.impl.core.function.SubmitRequestToInternalRef;
import org.wso2.carbon.identity.rest.api.user.registration.v1.model.InitRegRequest;
import org.wso2.carbon.identity.rest.api.user.registration.v1.model.RegCompleteResponse;
import org.wso2.carbon.identity.rest.api.user.registration.v1.model.SubmitRegRequest;
import org.wso2.carbon.identity.user.registration.UserRegistrationFlowService;
import org.wso2.carbon.identity.user.registration.exception.RegistrationFrameworkException;
import org.wso2.carbon.identity.user.registration.model.RegistrationRequest;
import org.wso2.carbon.identity.user.registration.model.response.RegistrationResponse;
import org.wso2.carbon.identity.user.registration.util.RegistrationFlowConstants;

import javax.ws.rs.core.Response;

/**
 * Implementation of the Rest APIs for user self registration.
 */
public class UserRegistrationService {

    public Object initiateUserRegistration(InitRegRequest initRegRequest) {

        UserRegistrationFlowService service = UserRegistrationServiceHolder.getUserRegistrationFlowService();
        RegistrationResponse response = null;
        try {
            response = service.initiateUserRegistration(initRegRequest.getApplicationId(),
                    RegistrationFlowConstants.SupportedProtocol.API_BASED);
            if (RegistrationFlowConstants.Status.COMPLETE.equals(response.getStatus())) {
                RegCompleteResponse completeResponse = new RegCompleteResponse();
                completeResponse.setFlowId(response.getFlowId());
                completeResponse.setFlowStatus(RegCompleteResponse.FlowStatusEnum.COMPLETE);
                completeResponse.setUserAssertion(null);
                return completeResponse;
            }
        } catch (RegistrationFrameworkException e) {
            throw buildServerError(e.getMessage());
        }

        return new RegistrationResponseToExternalRef().apply(response);

    }

    public Object handleIntermediateRequests(SubmitRegRequest submitRegRequest) {

        UserRegistrationFlowService service = UserRegistrationServiceHolder.getUserRegistrationFlowService();
        RegistrationRequest request = new SubmitRequestToInternalRef().apply(submitRegRequest);
        RegistrationResponse response = null;
        try {
            response = service.processIntermediateUserRegistration(request);
            if (RegistrationFlowConstants.Status.COMPLETE.equals(response.getStatus())) {
               RegCompleteResponse completeResponse = new RegCompleteResponse();
               completeResponse.setFlowId(response.getFlowId());
               completeResponse.setFlowStatus(RegCompleteResponse.FlowStatusEnum.COMPLETE);
               completeResponse.setUserAssertion(null);
               return completeResponse;
            }
        } catch (RegistrationFrameworkException e) {
            throw buildServerError(e.getMessage());
        }
        return new RegistrationResponseToExternalRef().apply(response);
    }

    private APIError buildServerError(String message) {

        ErrorDTO errorDTO = new ErrorDTO();
        errorDTO.setMessage(message);
        errorDTO.setCode("USR-00001");
        return new APIError(Response.Status.INTERNAL_SERVER_ERROR, errorDTO);
    }
}
