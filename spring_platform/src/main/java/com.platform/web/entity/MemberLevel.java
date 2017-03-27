package com.platform.web.entity;

/**
 * Created by tanghong on 2017/3/13.
 */
public class MemberLevel {

    /** 等级标识 */
   private int levelId;

    /** 门店标识 */
   private int storeId;

    /** 等级名称 */
   private String levelName;

    /** 项目折扣 */
   private int projectDiscount;

    /** 商品折扣 */
   private int goodsDiscount;

    /** 售卡开卡金额 */
   private int sellAmount;

    /** 现金支付是否打折 */
   private int cashDiscountType;

    /** 最低充值金额 */
   private int chargeMinMoney;

    /** 消费积分单位 */
   private int integralUnit;

    /** 单位积分数量 */
   private int integralNumber;

    /** 业绩折扣比例(0-100) */
   private int performanceDiscountPercent;

    /** 等级说明 */
   private String levelNotice;

    /** 开卡提成方式(1：比例，2：固定) */
   private int openCommisionType;

    /** 开卡提成方案 */
   private String openCommisionJson;

    /** 充值提成方式(1：比例，2：固定) */
   private int chargeCommisionType;

    /** 充值提成方案 */
   private String chargeCommisionJson;

    /** 是否删除(0:未删除,1:已删除) */
   private int isDeleted;

    /** 是否默认等级(0:否,1:是) */
   private int isDefault;

    /** 创建时间 */
   private String createTime;

    /** 修改时间 */
   private String updateTime;

    /** 最后操作人标识 */
   private int lastOperatorId;

    public int getCashDiscountType() {
        return cashDiscountType;
    }

    public void setCashDiscountType(int cashDiscountType) {
        this.cashDiscountType = cashDiscountType;
    }

    public String getChargeCommisionJson() {
        return chargeCommisionJson;
    }

    public void setChargeCommisionJson(String chargeCommisionJson) {
        this.chargeCommisionJson = chargeCommisionJson;
    }

    public int getChargeCommisionType() {
        return chargeCommisionType;
    }

    public void setChargeCommisionType(int chargeCommisionType) {
        this.chargeCommisionType = chargeCommisionType;
    }

    public int getChargeMinMoney() {
        return chargeMinMoney;
    }

    public void setChargeMinMoney(int chargeMinMoney) {
        this.chargeMinMoney = chargeMinMoney;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public int getGoodsDiscount() {
        return goodsDiscount;
    }

    public void setGoodsDiscount(int goodsDiscount) {
        this.goodsDiscount = goodsDiscount;
    }

    public int getIntegralNumber() {
        return integralNumber;
    }

    public void setIntegralNumber(int integralNumber) {
        this.integralNumber = integralNumber;
    }

    public int getIntegralUnit() {
        return integralUnit;
    }

    public void setIntegralUnit(int integralUnit) {
        this.integralUnit = integralUnit;
    }

    public int getIsDefault() {
        return isDefault;
    }

    public void setIsDefault(int isDefault) {
        this.isDefault = isDefault;
    }

    public int getIsDeleted() {
        return isDeleted;
    }

    public void setIsDeleted(int isDeleted) {
        this.isDeleted = isDeleted;
    }

    public int getLastOperatorId() {
        return lastOperatorId;
    }

    public void setLastOperatorId(int lastOperatorId) {
        this.lastOperatorId = lastOperatorId;
    }

    public int getLevelId() {
        return levelId;
    }

    public void setLevelId(int levelId) {
        this.levelId = levelId;
    }

    public String getLevelName() {
        return levelName;
    }

    public void setLevelName(String levelName) {
        this.levelName = levelName;
    }

    public String getLevelNotice() {
        return levelNotice;
    }

    public void setLevelNotice(String levelNotice) {
        this.levelNotice = levelNotice;
    }

    public String getOpenCommisionJson() {
        return openCommisionJson;
    }

    public void setOpenCommisionJson(String openCommisionJson) {
        this.openCommisionJson = openCommisionJson;
    }

    public int getOpenCommisionType() {
        return openCommisionType;
    }

    public void setOpenCommisionType(int openCommisionType) {
        this.openCommisionType = openCommisionType;
    }

    public int getPerformanceDiscountPercent() {
        return performanceDiscountPercent;
    }

    public void setPerformanceDiscountPercent(int performanceDiscountPercent) {
        this.performanceDiscountPercent = performanceDiscountPercent;
    }

    public int getProjectDiscount() {
        return projectDiscount;
    }

    public void setProjectDiscount(int projectDiscount) {
        this.projectDiscount = projectDiscount;
    }

    public int getSellAmount() {
        return sellAmount;
    }

    public void setSellAmount(int sellAmount) {
        this.sellAmount = sellAmount;
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
