package com.platform.web.entity;

import com.platform.common.consts.Consts;
import com.platform.common.utils.JodaUtils;

/**
 * 微信粉丝模块
 * Created by zhh on 2017/2/21.
 */
public class WxUserInfo {
    private int id;
    private int storeId;
    private String openid;
    private String nickName;
    private String sex;
    private String headImgUrl;
    private String city;
    private String province;
    private String country;
    private String createon;
    private String updateon;
    private int state; // 启用, 停用, 删除
    private int isSubscribe; // 0是已订阅, 1是未订阅

    public WxUserInfo() {
    }

    public WxUserInfo(int storeId, String openid, String nickName, String sex, String headImgUrl, String city, String province, String country, int subscribe) {
        this.storeId = storeId;
        this.openid = openid;
        this.nickName = nickName;
        this.sex = sex;
        this.city = city;
        this.province = province;
        this.country = country;
        this.createon = JodaUtils.getDateTime();
        this.updateon = JodaUtils.getDateTime();
        this.state = Consts.StatusCons.enable;
        this.headImgUrl = headImgUrl;
        this.isSubscribe = subscribe;
    }
    public WxUserInfo(int storeId, String openId) {
        this.storeId = storeId;
        this.openid = openId;
        this.createon = JodaUtils.getDateTime();
        this.updateon = JodaUtils.getDateTime();
        this.state = Consts.StatusCons.enable;
        this.isSubscribe = 1;
    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getStoreId() {
        return storeId;
    }

    public void setStoreId(int storeId) {
        this.storeId = storeId;
    }

    public String getOpenid() {
        return openid;
    }

    public void setOpenid(String openid) {
        this.openid = openid;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getHeadImgUrl() {
        return headImgUrl;
    }

    public void setHeadImgUrl(String headImgUrl) {
        this.headImgUrl = headImgUrl;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCreateon() {
        return createon;
    }

    public void setCreateon(String createon) {
        this.createon = createon;
    }

    public String getUpdateon() {
        return updateon;
    }

    public void setUpdateon(String updateon) {
        this.updateon = updateon;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    public int getIsSubscribe() {
        return isSubscribe;
    }

    public void setIsSubscribe(int isSubscribe) {
        this.isSubscribe = isSubscribe;
    }
}
