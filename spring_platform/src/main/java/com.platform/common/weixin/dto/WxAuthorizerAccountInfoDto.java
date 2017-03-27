package com.platform.common.weixin.dto;

/**
 * Created by tanghong on 2017/3/7.
 */
public class WxAuthorizerAccountInfoDto {

    private WxAuthorizerInfoDto authorizer_info;
    private WxAuthorizationInfoDto authorization_info;

    public WxAuthorizationInfoDto getAuthorization_info() {
        return authorization_info;
    }

    public void setAuthorization_info(WxAuthorizationInfoDto authorization_info) {
        this.authorization_info = authorization_info;
    }

    public WxAuthorizerInfoDto getAuthorizer_info() {
        return authorizer_info;
    }

    public void setAuthorizer_info(WxAuthorizerInfoDto authorizer_info) {
        this.authorizer_info = authorizer_info;
    }
}
