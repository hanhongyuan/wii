package com.platform.web.entity;

import com.platform.common.utils.JodaUtils;

/**
 * Created by tanghong on 2017/3/19.
 */
public class StoreApplyAgent {

    private int storeId;
    private int agentId;
    private int isDeleted;
    private String createTime;
    private String updateTime;

    public StoreApplyAgent(){}

    public StoreApplyAgent(int storeId, int agentId){
        this.agentId = agentId;
        this.storeId = storeId;
        this.isDeleted = 0;
        this.createTime = JodaUtils.getDateTime();
        this.updateTime = JodaUtils.getDateTime();
    }

    public int getAgentId() {
        return agentId;
    }

    public void setAgentId(int agentId) {
        this.agentId = agentId;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public int getIsDeleted() {
        return isDeleted;
    }

    public void setIsDeleted(int isDeleted) {
        this.isDeleted = isDeleted;
    }

    public int getStoreId() {
        return storeId;
    }

    public void setStoreId(int storeId) {
        this.storeId = storeId;
    }

    public String getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(String updateTime) {
        this.updateTime = updateTime;
    }
}
