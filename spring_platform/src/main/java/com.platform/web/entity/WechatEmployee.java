package com.platform.web.entity;

/**
 * Created by zhh on 2017/2/21.
 */
public class WechatEmployee {
    /** 微信标识 */
   private String openId;

    /** 员工标识 */
   private int employeeId;

    /** 是否关注(0:未关注,1:已关注) */
   private int isSubscribe;

    /** 创建时间 */
   private String createTime;

    /** 修改时间 */
   private String updateTime;

    public String getOpenId() {
        return openId;
    }

    public void setOpenId(String openId) {
        this.openId = openId;
    }

    public int getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }

    public int getIsSubscribe() {
        return isSubscribe;
    }

    public void setIsSubscribe(int isSubscribe) {
        this.isSubscribe = isSubscribe;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public String getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(String updateTime) {
        this.updateTime = updateTime;
    }
}
