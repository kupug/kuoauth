package com.kupug.kuoauth.platform.alipay;

import com.kupug.kuoauth.model.KuOAuthCallback;
import com.kupug.kuoauth.model.KuOAuthConfig;
import com.kupug.kuoauth.model.KuOAuthLogin;
import com.kupug.kuoauth.model.KuOAuthToken;
import com.kupug.kuoauth.model.KuOAuthUser;
import com.kupug.kuoauth.OAuthConfigTest;
import com.kupug.kuoauth.utils.JsonUtils;
import com.kupug.kuoauth.utils.OAuthUtils;
import org.junit.Before;
import org.junit.Test;

public class AlipayPlatformTest {

    private AlipayPlatform platform;

    @Before
    public void init() {

        KuOAuthConfig kuOAuthConfig = KuOAuthConfig.builder()
                .clientId(OAuthConfigTest.ALIPAY_CLIENTID)
                .clientSecret(OAuthConfigTest.ALIPAY_CLIENTSECRET)
                .redirectUri(OAuthConfigTest.ALIPAY_REDIRECTURI)
                .alipayPublicKey(OAuthConfigTest.ALIPAY_PUBLICKEY)
                .build();

        platform = new AlipayPlatform(kuOAuthConfig);
    }

    @Test
    public void authorize() {
        String authorizeUrl = platform.authorize(OAuthUtils.randomState());

        System.out.println(authorizeUrl);
    }

    @Test
    public void accessToken() {

        KuOAuthCallback oAuthCallback = KuOAuthCallback.buider()
                .code("3b7d7635924f40b7a378aa76edb2QX17")
                .state("33440e820b5b219c21af265f41afae27")
                .build();

        KuOAuthToken oAuthToken = platform.getAccessToken(oAuthCallback);

        System.out.println(JsonUtils.toJSONString(oAuthToken));
    }

    @Test
    public void userInfo() {

        KuOAuthToken oAuthToken = KuOAuthToken.builder()
                .accessToken("authusrBe69f69e6e40a46318d9626cad92fdX17")
                .refreshToken("authusrB13147c6b941848b6a4f636c11ea87X17")
                .expiresIn(1296000)
                .build();

        KuOAuthUser oAuthUser = platform.getUserInfo(oAuthToken);

        System.out.println(JsonUtils.toJSONString(oAuthUser));
    }

    @Test
    public void refresh() {

        KuOAuthToken oAuthToken = KuOAuthToken.builder()
                .accessToken("121.7e718843026d2142708e15163cae162b.Y7KKrxyLbmkcGOjfFMu781dx4v41w0osJLi9UHO.ddjpwQ")
                .refreshToken("122.793bf1d40d971f75d15c03bf6f14f3b9.YCUSmUQrV3vL_xh60f1ZyO-OSE2XBj7vev05pGD.M0SXdA")
                .expiresIn(2592000)
                .build();

        oAuthToken = platform.refresh(oAuthToken);

        System.out.println(JsonUtils.toJSONString(oAuthToken));
    }

    @Test
    public void revoke() {

        KuOAuthToken oAuthToken = KuOAuthToken.builder()
                .accessToken("121.93d112af384fce43fe79fe87c60d3e47.Y77S7ZL6vj494m5S3iu4uYoBy2a2-NSou8aQ_In.0NkRzg")
                .refreshToken("122.30c1f9e51f935c3af7686eb51059de81.Y_9rrj4q_xeuFx-p0wgmNZCwElLFOS1M4jb6BPY.NoLWMg")
                .expiresIn(2592000)
                .build();

        boolean isOK = platform.revoke(oAuthToken);

        System.out.println(isOK);
    }

    @Test
    public void login() {

        KuOAuthCallback oAuthCallback = KuOAuthCallback.buider()
                .code("b8ede40bb13a60c470ec5a5eea949c457aa0fd7f71b81cf230fe43ea7d9bef49")
                .state("95e7ab5eb20186211b2fec71851291c3")
                .build();

        KuOAuthLogin oAuthLogin = platform.login(oAuthCallback);

        System.out.println(JsonUtils.toJSONString(oAuthLogin));
    }
}