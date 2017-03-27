package com.platform.common.weixin.dto;

import java.util.List;
import java.util.Optional;

/**
 * Created by tanghong on 2017/3/7.
 */
public class WxWebUserInfoDto {
    private String openid;
    private String nickname;
    private String sex;
    private String province;
    private String country;
    private String headimgurl;
    private String city;
    private List<String> privilege;
    private Optional<String> unionid;

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getHeadimgurl() {
        return headimgurl;
    }

    public void setHeadimgurl(String headimgurl) {
        this.headimgurl = headimgurl;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getOpenid() {
        return openid;
    }

    public void setOpenid(String openid) {
        this.openid = openid;
    }

    public List<String> getPrivilege() {
        return privilege;
    }

    public void setPrivilege(List<String> privilege) {
        this.privilege = privilege;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public Optional<String> getUnionid() {
        return unionid;
    }

    public void setUnionid(Optional<String> unionid) {
        this.unionid = unionid;
    }
}
