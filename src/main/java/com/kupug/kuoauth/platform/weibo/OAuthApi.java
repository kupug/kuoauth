package com.kupug.kuoauth.platform.weibo;

import com.kupug.kuoauth.platform.IOAuthApi;

/**
 * <p>
 * Weibo oauth api
 * </p>
 *
 * @author MaoHai.LV
 * @since 1.0
 */
enum OAuthApi implements IOAuthApi {

    DEFAULT {
        @Override
        public String authorize() {
            return "https://api.weibo.com/oauth2/authorize";
        }

        @Override
        public String accessToken() {
            return "https://api.weibo.com/oauth2/access_token";
        }

        @Override
        public String userInfo() {
            return "https://api.weibo.com/2/users/show.json";
        }

        @Override
        public String revoke() {
            return "https://api.weibo.com/oauth2/revokeoauth2";
        }
    }
}
