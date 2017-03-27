package com.platform.web.dto;

/**
 * Created by tanghong on 2017/3/14.
 */
public class VoucherOptionDto {
    private int id;
    private int storeId;
    private String name;
    private int price;
    private int couponTypeId;
    private String startTime;
    private String releaseTime;
    private String couponStopTime;
    private int hasExchangeCount;
    private int hasUseCount;
    private int effectiveDays;

    public String getCouponStopTime() {
        return couponStopTime;
    }

    public void setCouponStopTime(String couponStopTime) {
        this.couponStopTime = couponStopTime;
    }

    public int getCouponTypeId() {
        return couponTypeId;
    }

    public void setCouponTypeId(int couponTypeId) {
        this.couponTypeId = couponTypeId;
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

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getReleaseTime() {
        return releaseTime;
    }

    public void setReleaseTime(String releaseTime) {
        this.releaseTime = releaseTime;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public int getStoreId() {
        return storeId;
    }

    public void setStoreId(int storeId) {
        this.storeId = storeId;
    }
}
