package com.platform.common.weixin.dto;

/**
 * Created by tanghong on 2017/3/10.
 */
public class WxWebAuthDto {
    private String accessToken;
    private String openid;

    public WxWebAuthDto(String accessToken, String openid){
        this.accessToken = accessToken;
        this.openid = openid;
    }
    public String getAccessToken() {
        return accessToken;
    }

    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }

    public String getOpenid() {
        return openid;
    }

    public void setOpenid(String openid) {
        this.openid = openid;
    }
}
