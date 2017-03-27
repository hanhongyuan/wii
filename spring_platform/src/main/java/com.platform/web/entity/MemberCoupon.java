package com.platform.web.entity;

import com.platform.common.utils.JodaUtils;

/**
 * Created by tanghong on 2017/3/17.
 */
public class MemberCoupon {
    private int relevanceId;
    private int couponId;
    private int memberInfoId;
    private int isUsed;
    private String grantTime;
    private String invalidTime;

    public MemberCoupon(){}

    public MemberCoupon(int couponId, int memberInfoId, String validTime){
        this.couponId = couponId;
        this.memberInfoId = memberInfoId;
        this.grantTime = JodaUtils.getDateTime();
        this.isUsed = 0; //未使用
        this.invalidTime = validTime;
    }

    public int getCouponId() {
        return couponId;
    }

    public void setCouponId(int couponId) {
        this.couponId = couponId;
    }

    public String getGrantTime() {
        return grantTime;
    }

    public void setGrantTime(String grantTime) {
        this.grantTime = grantTime;
    }

    public String getInvalidTime() {
        return invalidTime;
    }

    public void setInvalidTime(String invalidTime) {
        this.invalidTime = invalidTime;
    }

    public int getIsUsed() {
        return isUsed;
    }

    public void setIsUsed(int isUsed) {
        this.isUsed = isUsed;
    }

    public int getMemberInfoId() {
        return memberInfoId;
    }

    public void setMemberInfoId(int memberInfoId) {
        this.memberInfoId = memberInfoId;
    }

    public int getRelevanceId() {
        return relevanceId;
    }

    public void setRelevanceId(int relevanceId) {
        this.relevanceId = relevanceId;
    }
}
