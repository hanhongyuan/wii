package com.platform.actor.dto;

/**
 * Created by tanghong on 2017/3/20.
 */
public class UpPlatformAppToken {
    private String authAccessToken;
    private String refreshAccessToken;
    private int storeId;
    private String appId;

    public UpPlatformAppToken(
        String authAccessToken,
        String refreshAccessToken,
        int storeId,
        String appId
    ){
        this.authAccessToken = authAccessToken;
        this.refreshAccessToken = refreshAccessToken;
        this.storeId = storeId;
        this.appId = appId;
    }

    public String getAppId() {
        return appId;
    }

    public void setAppId(String appId) {
        this.appId = appId;
    }

    public String getAuthAccessToken() {
        return authAccessToken;
    }

    public void setAuthAccessToken(String authAccessToken) {
        this.authAccessToken = authAccessToken;
    }

    public String getRefreshAccessToken() {
        return refreshAccessToken;
    }

    public void setRefreshAccessToken(String refreshAccessToken) {
        this.refreshAccessToken = refreshAccessToken;
    }

    public int getStoreId() {
        return storeId;
    }

    public void setStoreId(int storeId) {
        this.storeId = storeId;
    }
}
