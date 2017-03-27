package com.platform.web.entity;

import com.platform.common.utils.JodaUtils;

/**
 * Created by tanghong on 2017/3/19.
 */
public class StoreApplySalesman {
   private int storeId;
   private int salesmanId;
   private int isDeleted;
   private String createTime;
   private String updateTime;

    public StoreApplySalesman(){}

    public StoreApplySalesman(
        int storeId,
        int salesmanId){
        this.storeId = storeId;
        this.salesmanId = salesmanId;
        this.isDeleted = 0;
        this.createTime = JodaUtils.getDateTime();
        this.updateTime = JodaUtils.getDateTime();
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

    public int getSalesmanId() {
        return salesmanId;
    }

    public void setSalesmanId(int salesmanId) {
        this.salesmanId = salesmanId;
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
