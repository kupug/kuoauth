package com.kupug.kuoauth.platform.aliyun;

import com.kupug.kuoauth.model.KuOAuthToken;
import com.kupug.kuoauth.utils.JsonUtils;

/**
 * <p>
 * 阿里云 oauth token
 * </p>
 *
 * @author MaoHai.LV
 * @since 1.1
 */
final class OAuthToken {

    private String error;
    private String errorDescription;

    private String accessToken;
    private String refreshToken;
    private Integer expiresIn;
    private String scope;
    private String requestId;
    private String tokenType;
    private String idToken;

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    public String getErrorDescription() {
        return errorDescription;
    }

    public void setErrorDescription(String errorDescription) {
        this.errorDescription = errorDescription;
    }

    public String getAccessToken() {
        return accessToken;
    }

    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }

    public String getRefreshToken() {
        return refreshToken;
    }

    public void setRefreshToken(String refreshToken) {
        this.refreshToken = refreshToken;
    }

    public Integer getExpiresIn() {
        return expiresIn;
    }

    public void setExpiresIn(Integer expiresIn) {
        this.expiresIn = expiresIn;
    }

    public String getScope() {
        return scope;
    }

    public void setScope(String scope) {
        this.scope = scope;
    }

    public String getRequestId() {
        return requestId;
    }

    public void setRequestId(String requestId) {
        this.requestId = requestId;
    }

    public String getTokenType() {
        return tokenType;
    }

    public void setTokenType(String tokenType) {
        this.tokenType = tokenType;
    }

    public String getIdToken() {
        return idToken;
    }

    public void setIdToken(String idToken) {
        this.idToken = idToken;
    }

    @Override
    public String toString() {
        return "OAuthToken{" +
                "accessToken='" + accessToken + '\'' +
                ", refreshToken='" + refreshToken + '\'' +
                ", expiresIn=" + expiresIn +
                ", scope='" + scope + '\'' +
                ", requestId='" + requestId + '\'' +
                ", tokenType='" + tokenType + '\'' +
                ", idToken='" + idToken + '\'' +
                '}';
    }

    /**
     * 转化统一的 OAuth Token
     *
     * @return KuOAuthToken对象
     */
    public KuOAuthToken valueOf() {
        return KuOAuthToken.builder()
                .accessToken(this.getAccessToken())
                .refreshToken(this.getRefreshToken())
                .expiresIn(this.getExpiresIn())
                .rawInfo(JsonUtils.toJSONString(this))
                .build();
    }

}
