package com.platform.common.weixin.dto;

/**
 * Created by tanghong on 2017/3/7.
 */
public class WxAuthorizationDataDto {
    private WxAuthorizationDto authorization_info;

    public WxAuthorizationDto getAuthorization_info() {
        return authorization_info;
    }

    public void setAuthorization_info(WxAuthorizationDto authorization_info) {
        this.authorization_info = authorization_info;
    }
}
