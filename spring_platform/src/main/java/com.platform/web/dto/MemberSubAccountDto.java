package com.platform.web.dto;

import java.math.BigDecimal;

/**
 * Created by tanghong on 2017/3/19.
 */
public class MemberSubAccountDto {
    private int subAccountId;
    private int accountId;
    private int storeId;
    private String cardNo;
    private BigDecimal totalAmount;
    private BigDecimal totalPresentAmount;
    private BigDecimal balanceAmount;
    private BigDecimal useAmount;
    private BigDecimal totalGiftmoneyAmount;
    private BigDecimal balanceGiftmoneyAmount;
    private BigDecimal overdueGiftmoneyAmount;
    private BigDecimal debtAmount;
    private int levelId;
    private String storeName;
    private String levelName;
    private int projectDiscount;
    private int goodsDiscount;
    private int cashDiscountType;
    private int integralUnit;
    private int integralNumber;
    private int performanceDiscountPercent;
    private String levelNotice;
    private int blackOrDeleted;
    private String createTime;
    private String lastOperatorName;
    private String endDate;
    private BigDecimal debtConsumedAmt;
    private BigDecimal debtCardAmt;

    public int getAccountId() {
        return accountId;
    }

    public void setAccountId(int accountId) {
        this.accountId = accountId;
    }

    public BigDecimal getBalanceAmount() {
        return balanceAmount;
    }

    public void setBalanceAmount(BigDecimal balanceAmount) {
        this.balanceAmount = balanceAmount;
    }

    public BigDecimal getBalanceGiftmoneyAmount() {
        return balanceGiftmoneyAmount;
    }

    public void setBalanceGiftmoneyAmount(BigDecimal balanceGiftmoneyAmount) {
        this.balanceGiftmoneyAmount = balanceGiftmoneyAmount;
    }

    public int getBlackOrDeleted() {
        return blackOrDeleted;
    }

    public void setBlackOrDeleted(int blackOrDeleted) {
        this.blackOrDeleted = blackOrDeleted;
    }

    public String getCardNo() {
        return cardNo;
    }

    public void setCardNo(String cardNo) {
        this.cardNo = cardNo;
    }

    public int getCashDiscountType() {
        return cashDiscountType;
    }

    public void setCashDiscountType(int cashDiscountType) {
        this.cashDiscountType = cashDiscountType;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public BigDecimal getDebtAmount() {
        return debtAmount;
    }

    public void setDebtAmount(BigDecimal debtAmount) {
        this.debtAmount = debtAmount;
    }

    public BigDecimal getDebtCardAmt() {
        return debtCardAmt;
    }

    public void setDebtCardAmt(BigDecimal debtCardAmt) {
        this.debtCardAmt = debtCardAmt;
    }

    public BigDecimal getDebtConsumedAmt() {
        return debtConsumedAmt;
    }

    public void setDebtConsumedAmt(BigDecimal debtConsumedAmt) {
        this.debtConsumedAmt = debtConsumedAmt;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
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

    public String getLastOperatorName() {
        return lastOperatorName;
    }

    public void setLastOperatorName(String lastOperatorName) {
        this.lastOperatorName = lastOperatorName;
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

    public BigDecimal getOverdueGiftmoneyAmount() {
        return overdueGiftmoneyAmount;
    }

    public void setOverdueGiftmoneyAmount(BigDecimal overdueGiftmoneyAmount) {
        this.overdueGiftmoneyAmount = overdueGiftmoneyAmount;
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

    public int getStoreId() {
        return storeId;
    }

    public void setStoreId(int storeId) {
        this.storeId = storeId;
    }

    public String getStoreName() {
        return storeName;
    }

    public void setStoreName(String storeName) {
        this.storeName = storeName;
    }

    public int getSubAccountId() {
        return subAccountId;
    }

    public void setSubAccountId(int subAccountId) {
        this.subAccountId = subAccountId;
    }

    public BigDecimal getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(BigDecimal totalAmount) {
        this.totalAmount = totalAmount;
    }

    public BigDecimal getTotalGiftmoneyAmount() {
        return totalGiftmoneyAmount;
    }

    public void setTotalGiftmoneyAmount(BigDecimal totalGiftmoneyAmount) {
        this.totalGiftmoneyAmount = totalGiftmoneyAmount;
    }

    public BigDecimal getTotalPresentAmount() {
        return totalPresentAmount;
    }

    public void setTotalPresentAmount(BigDecimal totalPresentAmount) {
        this.totalPresentAmount = totalPresentAmount;
    }

    public BigDecimal getUseAmount() {
        return useAmount;
    }

    public void setUseAmount(BigDecimal useAmount) {
        this.useAmount = useAmount;
    }
}
