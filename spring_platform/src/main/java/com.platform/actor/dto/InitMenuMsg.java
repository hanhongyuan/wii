package com.platform.actor.dto;

/**
 * Created by tanghong on 2017/3/20.
 */
public class InitMenuMsg {
    private int storeId;
    private String accessToken;

    public InitMenuMsg(int storeId, String accessToken){
        this.storeId = storeId;
        this.accessToken = accessToken;
    }

    public String getAccessToken() {
        return accessToken;
    }

    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }

    public int getStoreId() {
        return storeId;
    }

    public void setStoreId(int storeId) {
        this.storeId = storeId;
    }
}
