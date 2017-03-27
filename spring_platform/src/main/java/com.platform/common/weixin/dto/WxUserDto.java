package com.platform.common.weixin.dto;

import java.util.List;

/**
 * Created by tanghong on 2017/3/7.
 */
public class WxUserDto {
    private List<String> openid;

    public List<String> getOpenid() {
        return openid;
    }

    public void setOpenid(List<String> openid) {
        this.openid = openid;
    }
}
