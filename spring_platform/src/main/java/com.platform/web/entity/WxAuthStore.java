package com.platform.web.entity;

import com.platform.common.consts.Consts;
import com.platform.common.utils.JodaUtils;

/**
 * 公众号授权门店对象
 */
public class WxAuthStore {
    private int authId;
    private int storeId;
    private String appId;
    private String authCode;
    private String refreshCode;
    private String createon;
    private int state;

    public WxAuthStore(
        int storeId,
        String appId,
        String authCode,
        String refreshCode){
        this.storeId = storeId;
        this.appId = appId;
        this.authCode = authCode;
        this.refreshCode = refreshCode;
        this.state = Consts.StatusCons.enable;
        this.createon = JodaUtils.getDate();
    }

    public WxAuthStore(
        int authId,
        int storeId,
        String appId,
        String authCode,
        String refreshCode){
        this.authId = authId;
        this.storeId = storeId;
        this.appId = appId;
        this.authCode = authCode;
        this.refreshCode = refreshCode;
        this.state = Consts.StatusCons.enable;
    }

    public WxAuthStore(){}

    public String getAppId() {
        return appId;
    }

    public void setAppId(String appId) {
        this.appId = appId;
    }

    public String getAuthCode() {
        return authCode;
    }

    public void setAuthCode(String authCode) {
        this.authCode = authCode;
    }

    public int getAuthId() {
        return authId;
    }

    public void setAuthId(int authId) {
        this.authId = authId;
    }

    public String getCreateon() {
        return createon;
    }

    public void setCreateon(String createon) {
        this.createon = createon;
    }

    public String getRefreshCode() {
        return refreshCode;
    }

    public void setRefreshCode(String refreshCode) {
        this.refreshCode = refreshCode;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    public int getStoreId() {
        return storeId;
    }

    public void setStoreId(int storeId) {
        this.storeId = storeId;
    }
}
