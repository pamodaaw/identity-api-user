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

package org.wso2.carbon.identity.rest.api.user.backupcode.v1.impl;

import org.wso2.carbon.identity.rest.api.user.backupcode.v1.UserIdApiService;
import org.wso2.carbon.identity.rest.api.user.backupcode.v1.core.BackupCodeService;
import org.wso2.carbon.identity.rest.api.user.backupcode.v1.factories.BackupCodeServiceFactory;

import javax.ws.rs.core.Response;

/**
 * Implementation of the admin backup code API service.
 */
public class UserIdApiServiceImpl extends UserIdApiService {

    private final BackupCodeService backupCodeService;

    public UserIdApiServiceImpl() {

        backupCodeService = BackupCodeServiceFactory.getBackupCodeService();
    }

    @Override
    public Response userBackupCodesDelete(String userId) {

        backupCodeService.deleteBackupCodes(userId);
        return Response.noContent().build();
    }

    @Override
    public Response userBackupCodesGet(String userId) {

        return Response.ok().entity(backupCodeService.getBackupCodes(userId)).build();
    }

    @Override
    public Response userBackupCodesPost(String userId) {

        return Response.status(Response.Status.CREATED)
                .entity(backupCodeService.initBackupCodes(userId)).build();
    }
}
