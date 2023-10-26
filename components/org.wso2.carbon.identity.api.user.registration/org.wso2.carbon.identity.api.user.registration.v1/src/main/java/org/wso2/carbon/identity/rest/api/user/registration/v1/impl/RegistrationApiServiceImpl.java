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
import org.wso2.carbon.identity.api.user.common.ContextLoader;
import org.wso2.carbon.identity.core.ServiceURLBuilder;
import org.wso2.carbon.identity.core.URLBuilderException;
import org.wso2.carbon.identity.rest.api.user.registration.v1.RegistrationApiService;
import org.wso2.carbon.identity.rest.api.user.registration.v1.impl.core.UserRegistrationService;
import org.wso2.carbon.identity.rest.api.user.registration.v1.model.InitRegRequest;
import org.wso2.carbon.identity.rest.api.user.registration.v1.model.RegCompleteResponse;
import org.wso2.carbon.identity.rest.api.user.registration.v1.model.SubmitRegRequest;

import java.net.URI;
import javax.ws.rs.core.Response;

/**
 * Implementation of the Rest APIs for user self registration.
 */
public class RegistrationApiServiceImpl implements RegistrationApiService {

    @Autowired
    UserRegistrationService userRegistrationService;

    @Override
    public Response initiateRegistration(InitRegRequest initRegRequest) {

        Object response = userRegistrationService.initiateUserRegistration(initRegRequest);
        if (response instanceof RegCompleteResponse) {
            String resourceId = "user-uuid";
            URI location = ContextLoader.buildURIForHeader("/v1/registration/" + resourceId);
            return Response.created(location).entity(response).build();
        }
        return Response.ok().entity(response).build();
    }

    @Override
    public Response submitRegistrationData(SubmitRegRequest submitRegRequest) {

        Object response = userRegistrationService.handleIntermediateRequests(submitRegRequest);
        if (response instanceof RegCompleteResponse) {
            String resourceId = ((RegCompleteResponse) response).getUserAssertion();
            try {
                String context = "t/carbon.super/scim2/Users/" + resourceId;
                String url = ServiceURLBuilder.create().addPath(context).build().getAbsolutePublicURL();
                return Response.created(URI.create(url)).entity(response).build();
            } catch (URLBuilderException e) {
                String errorDescription = "Server encountered an error while building URL for response header.";
                return Response.serverError().entity(errorDescription).build();
            }
        }
        return Response.ok().entity(response).build();
    }
}
