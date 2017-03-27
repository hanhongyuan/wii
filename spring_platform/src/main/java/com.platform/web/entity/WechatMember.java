package com.platform.web.entity;

/**
 * Created by zhh on 2017/2/21.
 */
public class WechatMember {
    /** 微信标识 */
    private String openId;

    /** 会员标识 */
    private int memberId;

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

    public int getMemberId() {
        return memberId;
    }

    public void setMemberId(int memberId) {
        this.memberId = memberId;
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
