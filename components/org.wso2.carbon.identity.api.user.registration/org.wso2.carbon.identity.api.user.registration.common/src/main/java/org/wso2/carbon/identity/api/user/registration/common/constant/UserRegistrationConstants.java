/*
 * Copyright (c) 2019, WSO2 Inc. (http://www.wso2.org) All Rights Reserved.
 *
 * WSO2 Inc. licenses this file to you under the Apache License,
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

package org.wso2.carbon.identity.api.user.registration.common.constant;

/**
 * Contains all constants related to user registration.
 */
public class UserRegistrationConstants {

    public static final String ERROR_CODE_DELIMITER = "-";
    public static final String USER_SELF_REGISTRATION_PREFIX = "USR";

    /**
     * Enum for user error messages.
     */
    public enum ErrorMessage {

        ERROR_CODE_PAGINATION_NOT_IMPLEMENTED("10003",
                "Pagination not supported",
                "Pagination capabilities are not supported in this version of the API."),
        ERROR_CODE_FILTERING_NOT_IMPLEMENTED("10004",
                "Filtering not supported",
                "Filtering capability is not supported in this version of the API."),
        ERROR_CODE_SORTING_NOT_IMPLEMENTED("10005",
                "Sorting not supported",
                "Sorting capability is not supported in this version of the API."),
        ERROR_CODE_SESSION_TERMINATE_FORBIDDEN("10010",
                "Action Forbidden",
                "User is not authorized to terminate the session/s."),
        ERROR_CODE_UNABLE_TO_RETRIEVE_FEDERATED_USERID("10011",
                "Unable to retrieve federated userId",
                "Error occurred while retrieving federated userId of the user: %s in the tenant domain: %s.");

        private final String code;
        private final String message;
        private final String description;

        ErrorMessage(String code, String message, String description) {

            this.code = code;
            this.message = message;
            this.description = description;
        }

        public String getCode() {

            return USER_SELF_REGISTRATION_PREFIX + ERROR_CODE_DELIMITER + code;
        }

        public String getMessage() {

            return message;
        }

        public String getDescription() {

            return description;
        }

        @Override
        public String toString() {

            return getCode() + " | " + message;
        }
    }
}
