package com.platform.web.entity;

import java.sql.Timestamp;

/**
 * Created by zhh on 2017/2/21.
 */
public class WechatStore {
    /** 微信标识 */
    private String openId;

    /** 门店标识 */
    private int storeId;

    /** 创建时间 */
    private Timestamp createTime;

    public String getOpenId() {
        return openId;
    }

    public void setOpenId(String openId) {
        this.openId = openId;
    }

    public int getStoreId() {
        return storeId;
    }

    public void setStoreId(int storeId) {
        this.storeId = storeId;
    }

    public Timestamp getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Timestamp createTime) {
        this.createTime = createTime;
    }
}
