/*
 * Copyright (c) 2026, WSO2 LLC. (http://www.wso2.com).
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

package org.wso2.carbon.identity.rest.api.user.backupcode.v1;

import org.wso2.carbon.identity.rest.api.user.backupcode.v1.dto.BackupCodeResponseDTO;
import org.wso2.carbon.identity.rest.api.user.backupcode.v1.dto.RemainingBackupCodeResponseDTO;
import org.wso2.carbon.identity.rest.api.user.backupcode.v1.factories.UserIdApiServiceFactory;

import javax.validation.Valid;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

@Path("/{user-id}")
@Consumes({ "application/json" })
@Produces({ "application/json" })
@io.swagger.annotations.Api(value = "/{user-id}", description = "the admin backup code API")
public class UserIdApi {

    private final UserIdApiService delegate;

    public UserIdApi() {

        this.delegate = UserIdApiServiceFactory.getUserIdApi();
    }

    @Valid
    @DELETE
    @Path("/backup-codes")
    @Consumes({ "application/json" })
    @Produces({ "application/json" })
    @io.swagger.annotations.ApiOperation(value = "Delete backup codes of a given user.",
            notes = "This API is used to delete backup codes of a given user.\n\n" +
                    "<b>Permission required:</b>\n" +
                    "    * /permission/admin/manage/identity/user/backup-code/delete\n" +
                    "<b>Scope required:</b>\n" +
                    "    * internal_backup_code_delete\n",
            response = void.class)
    @io.swagger.annotations.ApiResponses(value = {
        @io.swagger.annotations.ApiResponse(code = 204, message = "Backup codes deleted successfully."),
        @io.swagger.annotations.ApiResponse(code = 400, message = "Bad Request"),
        @io.swagger.annotations.ApiResponse(code = 401, message = "Unauthorized"),
        @io.swagger.annotations.ApiResponse(code = 403, message = "Forbidden"),
        @io.swagger.annotations.ApiResponse(code = 404, message = "Not Found"),
        @io.swagger.annotations.ApiResponse(code = 500, message = "Server Error") })

    public Response userBackupCodesDelete(
            @io.swagger.annotations.ApiParam(value = "ID of the user.", required = true)
            @PathParam("user-id") String userId) {

        return delegate.userBackupCodesDelete(userId);
    }

    @Valid
    @GET
    @Path("/backup-codes")
    @Consumes({ "application/json" })
    @Produces({ "application/json" })
    @io.swagger.annotations.ApiOperation(value = "Retrieve the count of remaining backup codes of a given user.",
            notes = "This API is used to retrieve the count of remaining backup codes of a given user.\n\n" +
                    "<b>Permission required:</b>\n" +
                    "    * /permission/admin/manage/identity/user/backup-code/view\n" +
                    "<b>Scope required:</b>\n" +
                    "    * internal_backup_code_view\n",
            response = RemainingBackupCodeResponseDTO.class)
    @io.swagger.annotations.ApiResponses(value = {
        @io.swagger.annotations.ApiResponse(code = 200, message = "OK"),
        @io.swagger.annotations.ApiResponse(code = 400, message = "Bad Request"),
        @io.swagger.annotations.ApiResponse(code = 401, message = "Unauthorized"),
        @io.swagger.annotations.ApiResponse(code = 403, message = "Forbidden"),
        @io.swagger.annotations.ApiResponse(code = 404, message = "Not Found"),
        @io.swagger.annotations.ApiResponse(code = 500, message = "Server Error") })

    public Response userBackupCodesGet(
            @io.swagger.annotations.ApiParam(value = "ID of the user.", required = true)
            @PathParam("user-id") String userId) {

        return delegate.userBackupCodesGet(userId);
    }

    @Valid
    @POST
    @Path("/backup-codes")
    @Consumes({ "application/json" })
    @Produces({ "application/json" })
    @io.swagger.annotations.ApiOperation(value = "Generate backup codes for a given user.",
            notes = "This API is used to generate backup codes for a given user.\n\n" +
                    "<b>Permission required:</b>\n" +
                    "    * /permission/admin/manage/identity/user/backup-code/create\n" +
                    "<b>Scope required:</b>\n" +
                    "    * internal_backup_code_create\n",
            response = BackupCodeResponseDTO.class)
    @io.swagger.annotations.ApiResponses(value = {
        @io.swagger.annotations.ApiResponse(code = 201, message = "Created"),
        @io.swagger.annotations.ApiResponse(code = 400, message = "Bad Request"),
        @io.swagger.annotations.ApiResponse(code = 401, message = "Unauthorized"),
        @io.swagger.annotations.ApiResponse(code = 403, message = "Forbidden"),
        @io.swagger.annotations.ApiResponse(code = 404, message = "Not Found"),
        @io.swagger.annotations.ApiResponse(code = 500, message = "Server Error") })

    public Response userBackupCodesPost(
            @io.swagger.annotations.ApiParam(value = "ID of the user.", required = true)
            @PathParam("user-id") String userId) {

        return delegate.userBackupCodesPost(userId);
    }
}
