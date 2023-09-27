/*
 * Copyright (c) 2023, WSO2 LLC. (https://www.wso2.com) All Rights Reserved.
 *
 * WSO2 LLC. licenses this file to you under the Apache License,
 * Version 2.0 (the "License"); you may not use this file except
 * in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied. See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */

package org.wso2.carbon.identity.rest.api.user.registration.v1.impl.core.function;

import org.wso2.carbon.identity.rest.api.user.registration.v1.model.InputObject;
import org.wso2.carbon.identity.rest.api.user.registration.v1.model.SubmitRegRequest;
import org.wso2.carbon.identity.user.registration.model.RegistrationRequest;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

/**
 * Converts the SubmitRegRequest to RegistrationRequest.
 */
public class SubmitRequestToInternalRef implements Function<SubmitRegRequest, RegistrationRequest> {

    @Override
    public RegistrationRequest apply(SubmitRegRequest submitRegRequest) {

        RegistrationRequest registrationRequest = new RegistrationRequest();
        registrationRequest.setFlowId(submitRegRequest.getFlowId());
        registrationRequest.setFlowType(submitRegRequest.getFlowType().toString());
        registrationRequest.setInputType(submitRegRequest.getInputType().toString());

        Map<String, String> inputValues = new HashMap<>();
        if (submitRegRequest.getInput() != null) {
            for (InputObject inputObject : submitRegRequest.getInput()) {
                inputValues.put(inputObject.getKey(), inputObject.getValue());
            }
        }
        registrationRequest.setInputs(inputValues);
        return  registrationRequest;
    }
}
