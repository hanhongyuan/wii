package com.platform.web.entity;

import com.platform.common.consts.Consts;
import com.platform.common.utils.JodaUtils;

/**
 * Created by tanghong on 2017/3/19.
 */
public class WxTemplateInfo {
    private int id;
    private int authId;
    private int storeId;
    private String appId;
    // 模板编号
    private String tmCode;
    // 模板实例
    private String tmNo;
    private String createon;
    private String updateon;
    private int state;

    public WxTemplateInfo(
        int authId,
        int storeId,
        String tmCode,
        String appId){
        this.authId = authId;
        this.storeId = storeId;
        this.tmCode = tmCode;
        this.appId = appId;
        this.createon = JodaUtils.getDateTime();
        this.updateon = JodaUtils.getDateTime();
        this.state = Consts.StatusCons.enable;
    }

    public WxTemplateInfo(){}

    public String getAppId() {
        return appId;
    }

    public void setAppId(String appId) {
        this.appId = appId;
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

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public String getTmCode() {
        return tmCode;
    }

    public void setTmCode(String tmCode) {
        this.tmCode = tmCode;
    }

    public String getTmNo() {
        return tmNo;
    }

    public void setTmNo(String tmNo) {
        this.tmNo = tmNo;
    }

    public String getUpdateon() {
        return updateon;
    }

    public void setUpdateon(String updateon) {
        this.updateon = updateon;
    }
}
