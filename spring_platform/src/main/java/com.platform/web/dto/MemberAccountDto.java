package com.promotion.web.dto;

import java.math.BigDecimal;

/**
 * Created by tanghong on 2017/3/17.
 */
public class MemberAccountDto {
    private int accountId;
    private BigDecimal totalGiftMoneyAmount;
    private BigDecimal balanceGiftMoneyAmount;
    private int totalIntegral;
    private int balanceIntegral;

    public int getAccountId() {
        return accountId;
    }

    public void setAccountId(int accountId) {
        this.accountId = accountId;
    }

    public BigDecimal getBalanceGiftMoneyAmount() {
        return balanceGiftMoneyAmount;
    }

    public void setBalanceGiftMoneyAmount(BigDecimal balanceGiftMoneyAmount) {
        this.balanceGiftMoneyAmount = balanceGiftMoneyAmount;
    }

    public int getBalanceIntegral() {
        return balanceIntegral;
    }

    public void setBalanceIntegral(int balanceIntegral) {
        this.balanceIntegral = balanceIntegral;
    }

    public BigDecimal getTotalGiftMoneyAmount() {
        return totalGiftMoneyAmount;
    }

    public void setTotalGiftMoneyAmount(BigDecimal totalGiftMoneyAmount) {
        this.totalGiftMoneyAmount = totalGiftMoneyAmount;
    }

    public int getTotalIntegral() {
        return totalIntegral;
    }

    public void setTotalIntegral(int totalIntegral) {
        this.totalIntegral = totalIntegral;
    }
}
