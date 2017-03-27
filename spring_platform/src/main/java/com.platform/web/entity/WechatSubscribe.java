package com.platform.web.entity;

/**
 * Created by zhh on 2017/2/21.
 */
public class WechatSubscribe {
    /** 微信标识 */
    private String openId;

    /** 是否关注(0:未关注，1:已关注) */
    private int isSubscribe;

    public WechatSubscribe(String openid, int isSubscribe){
        this.openId = openid;
        this.isSubscribe = isSubscribe;
    }

    public WechatSubscribe(){}

    /** 关注时间 */
    private String createTime;

    /** 取消关注时间/再次关注时间 */
    private String updateTime;

    public String getOpenId() {
        return openId;
    }

    public void setOpenId(String openId) {
        this.openId = openId;
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
