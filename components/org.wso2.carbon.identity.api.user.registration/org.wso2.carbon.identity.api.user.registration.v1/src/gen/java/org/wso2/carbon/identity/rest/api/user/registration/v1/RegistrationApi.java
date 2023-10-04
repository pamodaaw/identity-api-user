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

package org.wso2.carbon.identity.rest.api.user.registration.v1;

import org.springframework.beans.factory.annotation.Autowired;
import org.apache.cxf.jaxrs.ext.multipart.Attachment;
import org.apache.cxf.jaxrs.ext.multipart.Multipart;
import java.io.InputStream;
import java.util.List;

import org.wso2.carbon.identity.rest.api.user.registration.v1.model.Error;
import org.wso2.carbon.identity.rest.api.user.registration.v1.model.InitRegRequest;
import org.wso2.carbon.identity.rest.api.user.registration.v1.model.RegCompleteResponse;
import org.wso2.carbon.identity.rest.api.user.registration.v1.model.RegPromptResponse;
import org.wso2.carbon.identity.rest.api.user.registration.v1.model.SubmitRegRequest;
import org.wso2.carbon.identity.rest.api.user.registration.v1.RegistrationApiService;

import javax.validation.Valid;
import javax.ws.rs.*;
import javax.ws.rs.core.Response;
import io.swagger.annotations.*;

import javax.validation.constraints.*;

@Path("/registration")
@Api(description = "The registration API")

public class RegistrationApi  {

    @Autowired
    private RegistrationApiService delegate;

    @Valid
    @POST
    @Path("/initiate")
    @Consumes({ "application/json" })
    @Produces({ "application/json" })
    @ApiOperation(value = "", notes = "This API provides the capability to initiate a user registration according to the configurations of the application.", response = RegPromptResponse.class, tags={  })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "Ok", response = RegPromptResponse.class),
        @ApiResponse(code = 201, message = "Created", response = RegCompleteResponse.class),
        @ApiResponse(code = 400, message = "Bad Request", response = Error.class),
        @ApiResponse(code = 500, message = "Server Error", response = Error.class)
    })
    public Response initiateRegistration(@ApiParam(value = "User registration initiate request body." ,required=true) @Valid InitRegRequest initRegRequest) {

        return delegate.initiateRegistration(initRegRequest );
    }

    @Valid
    @POST
    @Path("/submit")
    @Consumes({ "application/json" })
    @Produces({ "application/json" })
    @ApiOperation(value = "", notes = "This API provides the capability to continue communication of data for an initiated registration", response = RegPromptResponse.class, tags={  })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "Ok", response = RegPromptResponse.class),
        @ApiResponse(code = 201, message = "Created", response = RegCompleteResponse.class),
        @ApiResponse(code = 400, message = "Bad Request", response = Error.class),
        @ApiResponse(code = 500, message = "Server Error", response = Error.class)
    })
    public Response submitRegistrationData(@ApiParam(value = "User registration initiate request body." ,required=true) @Valid SubmitRegRequest submitRegRequest) {

        return delegate.submitRegistrationData(submitRegRequest );
    }

}
