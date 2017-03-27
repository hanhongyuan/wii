package com.platform.actor.dto;

/**
 * Created by tanghong on 2017/3/20.
 */
public class SetIndustry {
    private int storeId;

    public SetIndustry(){}

    public SetIndustry(int storeId){
        this.storeId = storeId;
    }

    public int getStoreId() {
        return storeId;
    }

    public void setStoreId(int storeId) {
        this.storeId = storeId;
    }
}
