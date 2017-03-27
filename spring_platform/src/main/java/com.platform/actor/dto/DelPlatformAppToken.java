package com.platform.actor.dto;

/**
 * Created by tanghong on 2017/3/20.
 */
public class DelPlatformAppToken {
    private String appId;

    public DelPlatformAppToken(String appId){
        this.appId = appId;
    }

    public String getAppId() {
        return appId;
    }

    public void setAppId(String appId) {
        this.appId = appId;
    }
}
