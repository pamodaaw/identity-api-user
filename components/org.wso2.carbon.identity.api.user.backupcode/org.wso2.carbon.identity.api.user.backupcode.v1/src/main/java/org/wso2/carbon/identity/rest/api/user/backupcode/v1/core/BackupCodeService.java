/*
 * Copyright (c) 2022, WSO2 Inc. (http://www.wso2.com) All Rights Reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.wso2.carbon.identity.rest.api.user.backupcode.v1.core;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.wso2.carbon.core.util.CryptoException;
import org.wso2.carbon.identity.api.user.backupcode.common.BackupCodeConstants;
import org.wso2.carbon.identity.api.user.common.ContextLoader;
import org.wso2.carbon.identity.api.user.common.error.APIError;
import org.wso2.carbon.identity.api.user.common.error.ErrorResponse;
import org.wso2.carbon.identity.api.user.common.function.UniqueIdToUser;
import org.wso2.carbon.identity.application.authentication.framework.exception.AuthenticationFailedException;
import org.wso2.carbon.identity.application.authenticator.backupcode.BackupCodeAPIHandler;
import org.wso2.carbon.identity.application.authenticator.backupcode.exception.BackupCodeException;
import org.wso2.carbon.identity.application.common.model.User;
import org.wso2.carbon.identity.core.util.IdentityUtil;
import org.wso2.carbon.identity.rest.api.user.backupcode.v1.dto.BackupCodeResponseDTO;
import org.wso2.carbon.identity.rest.api.user.backupcode.v1.dto.RemainingBackupCodeResponseDTO;
import org.wso2.carbon.identity.rest.api.user.backupcode.v1.util.BackupCodeServiceHolder;
import org.wso2.carbon.user.api.UserStoreException;

import java.util.List;

import javax.ws.rs.core.Response;

import static org.wso2.carbon.identity.api.user.backupcode.common.BackupCodeConstants.ErrorMessage.SERVER_ERROR_DELETING_BACKUP_CODES;
import static org.wso2.carbon.identity.api.user.backupcode.common.BackupCodeConstants.ErrorMessage.SERVER_ERROR_INIT_BACKUP_CODES;
import static org.wso2.carbon.identity.api.user.backupcode.common.BackupCodeConstants.ErrorMessage.SERVER_ERROR_RETRIEVE_BACKUP_CODES;
import static org.wso2.carbon.identity.api.user.backupcode.common.BackupCodeConstants.ErrorMessage.USER_ERROR_ACCESS_DENIED_FOR_BASIC_AUTH;
import static org.wso2.carbon.identity.api.user.backupcode.common.BackupCodeConstants.ErrorMessage.USER_ERROR_UNAUTHORIZED_USER;

/**
 * Backup code service.
 */
public class BackupCodeService {

    private static final Log log = LogFactory.getLog(BackupCodeService.class);

    /**
     * Retrieve remaining backup codes count of the authenticated user.
     *
     * @return Remaining backup codes count.
     */
    public RemainingBackupCodeResponseDTO getBackupCodes() {

        if (!isValidAuthenticationType()) {
            throw handleError(Response.Status.FORBIDDEN, USER_ERROR_ACCESS_DENIED_FOR_BASIC_AUTH);
        }
        return getBackupCodesForUser(getUser());
    }

    /**
     * Retrieve remaining backup codes count for a given user (admin operation).
     *
     * @param userId User ID (UUID) of the target user.
     * @return Remaining backup codes count.
     */
    public RemainingBackupCodeResponseDTO getBackupCodes(String userId) {

        return getBackupCodesForUser(resolveUser(userId));
    }

    /**
     * Generate backup codes for the authenticated user.
     *
     * @return Newly generated backup codes.
     */
    public BackupCodeResponseDTO initBackupCodes() {

        if (!isValidAuthenticationType()) {
            throw handleError(Response.Status.FORBIDDEN, USER_ERROR_ACCESS_DENIED_FOR_BASIC_AUTH);
        }
        return initBackupCodesForUser(getUser());
    }

    /**
     * Generate backup codes for a given user (admin operation).
     *
     * @param userId User ID (UUID) of the target user.
     * @return Newly generated backup codes.
     */
    public BackupCodeResponseDTO initBackupCodes(String userId) {

        return initBackupCodesForUser(resolveUser(userId));
    }

    /**
     * Delete backup codes of the authenticated user.
     */
    public void deleteBackupCodes() {

        if (!isValidAuthenticationType()) {
            throw handleError(Response.Status.FORBIDDEN, USER_ERROR_ACCESS_DENIED_FOR_BASIC_AUTH);
        }
        deleteBackupCodesForUser(getUser());
    }

    /**
     * Delete backup codes of a given user (admin operation).
     *
     * @param userId User ID (UUID) of the target user.
     */
    public void deleteBackupCodes(String userId) {

        deleteBackupCodesForUser(resolveUser(userId));
    }

    /**
     * Handle errors.
     *
     * @param errorEnum Error enum.
     * @param data      Data needed to be passed.
     * @return A new API Error.
     */
    public APIError handleInvalidInput(BackupCodeConstants.ErrorMessage errorEnum, String... data) {

        return handleError(Response.Status.HTTP_VERSION_NOT_SUPPORTED, errorEnum);
    }

    private RemainingBackupCodeResponseDTO getBackupCodesForUser(User user) {

        try {
            RemainingBackupCodeResponseDTO dto = new RemainingBackupCodeResponseDTO();
            dto.setRemainingBackupCodesCount(
                    BackupCodeAPIHandler.getRemainingBackupCodesCount(user.toFullQualifiedUsername()));
            return dto;
        } catch (BackupCodeException e) {
            throw handleException(e, SERVER_ERROR_RETRIEVE_BACKUP_CODES);
        }
    }

    private BackupCodeResponseDTO initBackupCodesForUser(User user) {

        try {
            BackupCodeResponseDTO dto = new BackupCodeResponseDTO();
            dto.setBackupCodes(BackupCodeAPIHandler.generateBackupCodes(user.toFullQualifiedUsername()));
            return dto;
        } catch (BackupCodeException e) {
            throw handleException(e, SERVER_ERROR_INIT_BACKUP_CODES);
        }
    }

    private void deleteBackupCodesForUser(User user) {

        try {
            BackupCodeAPIHandler.deleteBackupCodes(user.toFullQualifiedUsername());
        } catch (BackupCodeException e) {
            throw handleException(e, SERVER_ERROR_DELETING_BACKUP_CODES);
        }
    }

    /**
     * Resolve a user from a UUID user ID using the current tenant context.
     *
     * @param userId User ID (UUID).
     * @return Resolved User object.
     */
    private User resolveUser(String userId) {

        String tenantDomain = ContextLoader.getTenantDomainFromContext();
        return new UniqueIdToUser().apply(
                BackupCodeServiceHolder.getRealmService(), userId, tenantDomain);
    }

    /**
     * Get authenticated user.
     *
     * @return Authenticated user.
     */
    public static User getUser() {

        return ContextLoader.getUserFromContext();
    }

    private boolean isValidAuthenticationType() {

        /*
         * Check whether the request is authenticated with basic auth. Backup code endpoint should not be allowed for
         * basic authentication. This approach can be improved by providing a Level of Assurance (LOA) and
         * checking that in BackupCodeService.
         */
        if (Boolean.parseBoolean((String) IdentityUtil.threadLocalProperties.get()
                .get(BackupCodeConstants.AUTHENTICATED_WITH_BASIC_AUTH))) {
            if (log.isDebugEnabled()) {
                log.debug("Not a valid authentication method. " +
                        "This method is blocked for the requests with basic authentication.");
            }
            return false;
        }
        return true;
    }

    /**
     * Handle User errors.
     *
     * @param status Response status.
     * @param error  Error message.
     * @return APIError.
     */
    private APIError handleError(Response.Status status, BackupCodeConstants.ErrorMessage error) {

        return new APIError(status, getErrorBuilder(error).build());
    }

    /**
     * Get ErrorResponse Builder for Error enum.
     *
     * @param errorEnum Error message.
     * @return ErrorResponse.
     */
    private ErrorResponse.Builder getErrorBuilder(BackupCodeConstants.ErrorMessage errorEnum) {

        return new ErrorResponse.Builder().withCode(errorEnum.getCode()).withMessage(errorEnum.getMessage())
                .withDescription(errorEnum.getDescription());
    }

    /**
     * Handle Exceptions.
     *
     * @param e         Exception.
     * @param errorEnum Error message.
     * @return APIError.
     */
    private APIError handleException(Exception e, BackupCodeConstants.ErrorMessage errorEnum, String... data) {

        ErrorResponse errorResponse;
        if (data != null) {
            errorResponse = getErrorBuilder(errorEnum).build(log, e,
                    String.format(errorEnum.getDescription(), (Object[]) data));
        } else {
            errorResponse = getErrorBuilder(errorEnum).build(log, e, errorEnum.getDescription());
        }

        if (e instanceof AuthenticationFailedException) {
            return handleError(Response.Status.UNAUTHORIZED, USER_ERROR_UNAUTHORIZED_USER);
        } else if (e instanceof UserStoreException | e instanceof CryptoException) {
            return new APIError(Response.Status.INTERNAL_SERVER_ERROR, errorResponse);
        } else if (e instanceof BackupCodeException) {
            errorResponse.setDescription(e.getMessage());
            return new APIError(Response.Status.INTERNAL_SERVER_ERROR, errorResponse);
        } else {
            return new APIError(Response.Status.BAD_REQUEST, errorResponse);
        }
    }
}
