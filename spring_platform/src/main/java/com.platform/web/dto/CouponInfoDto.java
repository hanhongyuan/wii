package com.platform.web.dto;

/**
 * Created by tanghong on 2017/3/14.
 */
public class CouponInfoDto {
    private int couponId;
    /**名称*/
    private String couponName;
    /**抵扣金额*/
    private int couponPrice;
    /**兑换所需积分*/
    private int couponVantages;
    /**优惠劵类型(0:通用 1:项目 2:商品 3:疗程)*/
    private String couponType;
    /**所对应的项目商品疗程名称*/
    private String couponUse;
    /**开始时间*/
    private String couponStartTime;
    /**结束时间*/
    private String couponStopTime;
    /**是否可用*/
    private String couponIsUse;
    /**发布时间*/
    private String releaseTime;
    /**已经发送次数*/
    private int hasExchangeCount;
    /**已经使用次数*/
    private int hasUseCount;
    /**有效天数*/
    private int effectiveDays;
    /**创造业绩*/
    private double createPerformance;
    /**使用率*/
    private double useRate;
    /**已发布天数*/
    private int issuedDays;

    public int getCouponId() {
        return couponId;
    }

    public void setCouponId(int couponId) {
        this.couponId = couponId;
    }

    public String getCouponIsUse() {
        return couponIsUse;
    }

    public void setCouponIsUse(String couponIsUse) {
        this.couponIsUse = couponIsUse;
    }

    public String getCouponName() {
        return couponName;
    }

    public void setCouponName(String couponName) {
        this.couponName = couponName;
    }

    public int getCouponPrice() {
        return couponPrice;
    }

    public void setCouponPrice(int couponPrice) {
        this.couponPrice = couponPrice;
    }

    public String getCouponStartTime() {
        return couponStartTime;
    }

    public void setCouponStartTime(String couponStartTime) {
        this.couponStartTime = couponStartTime;
    }

    public String getCouponStopTime() {
        return couponStopTime;
    }

    public void setCouponStopTime(String couponStopTime) {
        this.couponStopTime = couponStopTime;
    }

    public String getCouponType() {
        return couponType;
    }

    public void setCouponType(String couponType) {
        this.couponType = couponType;
    }

    public String getCouponUse() {
        return couponUse;
    }

    public void setCouponUse(String couponUse) {
        this.couponUse = couponUse;
    }

    public int getCouponVantages() {
        return couponVantages;
    }

    public void setCouponVantages(int couponVantages) {
        this.couponVantages = couponVantages;
    }

    public double getCreatePerformance() {
        return createPerformance;
    }

    public void setCreatePerformance(double createPerformance) {
        this.createPerformance = createPerformance;
    }

    public int getEffectiveDays() {
        return effectiveDays;
    }

    public void setEffectiveDays(int effectiveDays) {
        this.effectiveDays = effectiveDays;
    }

    public int getHasExchangeCount() {
        return hasExchangeCount;
    }

    public void setHasExchangeCount(int hasExchangeCount) {
        this.hasExchangeCount = hasExchangeCount;
    }

    public int getHasUseCount() {
        return hasUseCount;
    }

    public void setHasUseCount(int hasUseCount) {
        this.hasUseCount = hasUseCount;
    }

    public int getIssuedDays() {
        return issuedDays;
    }

    public void setIssuedDays(int issuedDays) {
        this.issuedDays = issuedDays;
    }

    public String getReleaseTime() {
        return releaseTime;
    }

    public void setReleaseTime(String releaseTime) {
        this.releaseTime = releaseTime;
    }

    public double getUseRate() {
        return useRate;
    }

    public void setUseRate(double useRate) {
        this.useRate = useRate;
    }
}
