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

package org.wso2.carbon.identity.rest.api.user.backupcode.v1.factories;

import org.wso2.carbon.identity.rest.api.user.backupcode.v1.UserIdApiService;
import org.wso2.carbon.identity.rest.api.user.backupcode.v1.impl.UserIdApiServiceImpl;

/**
 * Service factory class for the admin backup code endpoint.
 */
public class UserIdApiServiceFactory {

    private static final UserIdApiService SERVICE = new UserIdApiServiceImpl();

    /**
     * Get the admin backup code API service.
     *
     * @return UserIdApiService instance.
     */
    public static UserIdApiService getUserIdApi() {

        return SERVICE;
    }
}
