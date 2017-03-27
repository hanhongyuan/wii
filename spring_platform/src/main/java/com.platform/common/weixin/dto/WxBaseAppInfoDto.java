package com.platform.common.weixin.dto;

/**
 * Created by tanghong on 2017/3/10.
 */
public class WxBaseAppInfoDto {
    private String appId;
    private String secret;

    public WxBaseAppInfoDto(String appId, String secret){
        this.appId = appId;
        this.secret = secret;
    }

    public String getAppId() {
        return appId;
    }

    public void setAppId(String appId) {
        this.appId = appId;
    }

    public String getSecret() {
        return secret;
    }

    public void setSecret(String secret) {
        this.secret = secret;
    }
}