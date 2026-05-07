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

import javax.ws.rs.core.Response;

/**
 * Service class for the admin backup code endpoint.
 */
public abstract class UserIdApiService {

    /**
     * Delete backup codes of a given user.
     *
     * @param userId User ID of the target user.
     * @return API response.
     */
    public abstract Response userBackupCodesDelete(String userId);

    /**
     * Retrieve remaining backup codes count of a given user.
     *
     * @param userId User ID of the target user.
     * @return API response.
     */
    public abstract Response userBackupCodesGet(String userId);

    /**
     * Generate backup codes for a given user.
     *
     * @param userId User ID of the target user.
     * @return API response.
     */
    public abstract Response userBackupCodesPost(String userId);
}
