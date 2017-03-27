package com.platform.common.weixin.dto;

import java.util.List;
import java.util.Optional;

/**
 * Created by tanghong on 2017/3/7.
 */
public class WxAuthorizationInfoDto {

    private String authorizer_appid;
    private List<WxFuncscopeCategoryDto> func_info;

    public String getAuthorizer_appid() {
        return authorizer_appid;
    }

    public void setAuthorizer_appid(String authorizer_appid) {
        this.authorizer_appid = authorizer_appid;
    }

    public List<WxFuncscopeCategoryDto> getFunc_info() {
        return func_info;
    }

    public void setFunc_info(List<WxFuncscopeCategoryDto> func_info) {
        this.func_info = func_info;
    }

}
