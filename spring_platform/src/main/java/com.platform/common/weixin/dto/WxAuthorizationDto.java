package com.platform.common.weixin.dto;

import java.util.List;

/**
 * Created by tanghong on 2017/3/7.
 */
public class WxAuthorizationDto {
    private String authorizer_appid;
    private String authorizer_access_token;
    private int expires_in;
    private String authorizer_refresh_token;
    private List<WxFuncscopeCategoryDto> func_info;

    public String getAuthorizer_access_token() {
        return authorizer_access_token;
    }

    public void setAuthorizer_access_token(String authorizer_access_token) {
        this.authorizer_access_token = authorizer_access_token;
    }

    public String getAuthorizer_appid() {
        return authorizer_appid;
    }

    public void setAuthorizer_appid(String authorizer_appid) {
        this.authorizer_appid = authorizer_appid;
    }

    public String getAuthorizer_refresh_token() {
        return authorizer_refresh_token;
    }

    public void setAuthorizer_refresh_token(String authorizer_refresh_token) {
        this.authorizer_refresh_token = authorizer_refresh_token;
    }

    public int getExpires_in() {
        return expires_in;
    }

    public void setExpires_in(int expires_in) {
        this.expires_in = expires_in;
    }

    public List<WxFuncscopeCategoryDto> getFunc_info() {
        return func_info;
    }

    public void setFunc_info(List<WxFuncscopeCategoryDto> func_info) {
        this.func_info = func_info;
    }
}
