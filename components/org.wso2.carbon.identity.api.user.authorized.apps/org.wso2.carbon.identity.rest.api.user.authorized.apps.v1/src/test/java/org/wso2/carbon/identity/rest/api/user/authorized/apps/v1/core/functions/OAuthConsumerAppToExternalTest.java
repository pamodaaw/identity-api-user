/*
 * Copyright (c) 2019, WSO2 Inc. (http://www.wso2.org) All Rights Reserved.
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

package org.wso2.carbon.identity.rest.api.user.authorized.apps.v1.core.functions;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.wso2.carbon.identity.oauth.dto.OAuthConsumerAppDTO;
import org.wso2.carbon.identity.rest.api.user.authorized.apps.v1.dto.AuthorizedAppDTO;

public class OAuthConsumerAppToExternalTest {

    @Test
    public void testApply() throws Exception {

        OAuthConsumerAppDTO oAuthConsumerAppDTO = new OAuthConsumerAppDTO();
        oAuthConsumerAppDTO.setApplicationName("TestApp");
        oAuthConsumerAppDTO.setOauthConsumerKey("TestConsumerKey");
        AuthorizedAppDTO authorizedAppDTO = new OAuthConsumerAppToExternal().apply(oAuthConsumerAppDTO);

        Assert.assertEquals(authorizedAppDTO.getAppId(), oAuthConsumerAppDTO.getApplicationName());
        Assert.assertEquals(authorizedAppDTO.getClientId(), oAuthConsumerAppDTO.getOauthConsumerKey());
    }
}
