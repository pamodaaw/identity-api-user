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

package org.wso2.carbon.identity.rest.api.user.registration.v1.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.wso2.carbon.identity.rest.api.user.registration.v1.RegistrationApiService;
import org.wso2.carbon.identity.rest.api.user.registration.v1.impl.core.UserRegistrationService;
import org.wso2.carbon.identity.rest.api.user.registration.v1.model.InitRegRequest;
import org.wso2.carbon.identity.rest.api.user.registration.v1.model.SubmitRegRequest;
import org.wso2.carbon.identity.user.registration.exception.RegistrationFrameworkException;

import javax.ws.rs.core.Response;

/**
 * Implementation of the Rest APIs for user self registration.
 */
public class RegistrationApiServiceImpl implements RegistrationApiService {

    @Autowired
    UserRegistrationService userRegistrationService;

    @Override
    public Response initiateRegistration(InitRegRequest initRegRequest) {

        try {
            return Response.ok().entity(userRegistrationService.initiateUserRegistration(initRegRequest)).build();
        } catch (RegistrationFrameworkException e) {
            return Response.serverError().entity(e.getMessage()).build();
        }
    }

    @Override
    public Response passThroughRegistration(SubmitRegRequest submitRegRequest) {

        try {
            return  Response.ok().entity(userRegistrationService.handleIntermediateRequests(submitRegRequest)).build();
        } catch (RegistrationFrameworkException e) {
            return Response.serverError().entity(e.getMessage()).build();
        }
    }
}
