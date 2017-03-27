package com.platform.actor.dto;

/**
 * Created by tanghong on 2017/3/20.
 */
public class UserInfoByStoreMsg {
    private int storeId;
    private String openid;

    public UserInfoByStoreMsg(){}

    public UserInfoByStoreMsg(int storeId, String openid){
        this.storeId = storeId;
        this.openid = openid;
    }

    public String getOpenid() {
        return openid;
    }

    public void setOpenid(String openid) {
        this.openid = openid;
    }

    public int getStoreId() {
        return storeId;
    }

    public void setStoreId(int storeId) {
        this.storeId = storeId;
    }
}
