package com.platform.actor.dto;

/**
 * Created by tanghong on 2017/3/20.
 */
public class UserInfoByAppMsg {
    private String appId;
    private String openid;

    public UserInfoByAppMsg(String appId, String openid){
        this.appId = appId;
        this.openid = openid;
    }

    public String getAppId() {
        return appId;
    }

    public void setAppId(String appId) {
        this.appId = appId;
    }

    public String getOpenid() {
        return openid;
    }

    public void setOpenid(String openid) {
        this.openid = openid;
    }
}
