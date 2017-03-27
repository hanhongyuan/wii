package com.platform.web.entity;

/**
 * Created by tanghong on 2017/3/13.
 */
public class MemberScreening {
    /** 主键 */
   private int screeningId;
    /** 筛选器名称 */
   private String screeningName;
    /** 筛选器创建时间 */
   private String createTime;
    /** 储值余额 */
   private int unusedBalanceStart;
    /** 储值余额 */
   private int unusedBalanceEnd;
    /** 积分余额 */
   private int integralBalanceStart;
    /** 积分余额 */
   private int integralBalanceEnd;
    /** 生日 */
   private String birthdayStart;
    /** 生日 */
   private String birthdayEnd;
    /** 注册日期 */
   private String registrationDateStart;
    /** 注册日期 */
   private String registrationDateEnd;
    /** 消费均额 */
   private int consumptionAverageStart;
    /** 消费均额 */
   private int consumptionAverageEnd;
    /** 累计消费 */
   private int cumulativeConsumptionStart;
    /** 累计消费 */
   private int cumulativeConsumptionEnd;
    /** 挂账 */
   private double debtAmountStart;
    /** 挂账 */
   private double debtAmountEnd;
    /** 礼金余额 */
   private double giftMoneyAmountStart;
    /** 礼金余额 */
   private double giftMoneyAmountEnd;
    /** 距离上次消费 */
   private int lastConsumeTimeStart;
    /** 距离上次消费 */
   private int lastConsumeTimeEnd;
    /** 门店 */
   private int storeId;
    /** 分店门店id */
   private String branchStoreIds;

    public String getBirthdayEnd() {
        return birthdayEnd;
    }

    public void setBirthdayEnd(String birthdayEnd) {
        this.birthdayEnd = birthdayEnd;
    }

    public String getBirthdayStart() {
        return birthdayStart;
    }

    public void setBirthdayStart(String birthdayStart) {
        this.birthdayStart = birthdayStart;
    }

    public String getBranchStoreIds() {
        return branchStoreIds;
    }

    public void setBranchStoreIds(String branchStoreIds) {
        this.branchStoreIds = branchStoreIds;
    }

    public int getConsumptionAverageEnd() {
        return consumptionAverageEnd;
    }

    public void setConsumptionAverageEnd(int consumptionAverageEnd) {
        this.consumptionAverageEnd = consumptionAverageEnd;
    }

    public int getConsumptionAverageStart() {
        return consumptionAverageStart;
    }

    public void setConsumptionAverageStart(int consumptionAverageStart) {
        this.consumptionAverageStart = consumptionAverageStart;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public int getCumulativeConsumptionEnd() {
        return cumulativeConsumptionEnd;
    }

    public void setCumulativeConsumptionEnd(int cumulativeConsumptionEnd) {
        this.cumulativeConsumptionEnd = cumulativeConsumptionEnd;
    }

    public int getCumulativeConsumptionStart() {
        return cumulativeConsumptionStart;
    }

    public void setCumulativeConsumptionStart(int cumulativeConsumptionStart) {
        this.cumulativeConsumptionStart = cumulativeConsumptionStart;
    }

    public double getDebtAmountEnd() {
        return debtAmountEnd;
    }

    public void setDebtAmountEnd(double debtAmountEnd) {
        this.debtAmountEnd = debtAmountEnd;
    }

    public double getDebtAmountStart() {
        return debtAmountStart;
    }

    public void setDebtAmountStart(double debtAmountStart) {
        this.debtAmountStart = debtAmountStart;
    }

    public double getGiftMoneyAmountEnd() {
        return giftMoneyAmountEnd;
    }

    public void setGiftMoneyAmountEnd(double giftMoneyAmountEnd) {
        this.giftMoneyAmountEnd = giftMoneyAmountEnd;
    }

    public double getGiftMoneyAmountStart() {
        return giftMoneyAmountStart;
    }

    public void setGiftMoneyAmountStart(double giftMoneyAmountStart) {
        this.giftMoneyAmountStart = giftMoneyAmountStart;
    }

    public int getIntegralBalanceEnd() {
        return integralBalanceEnd;
    }

    public void setIntegralBalanceEnd(int integralBalanceEnd) {
        this.integralBalanceEnd = integralBalanceEnd;
    }

    public int getIntegralBalanceStart() {
        return integralBalanceStart;
    }

    public void setIntegralBalanceStart(int integralBalanceStart) {
        this.integralBalanceStart = integralBalanceStart;
    }

    public int getLastConsumeTimeEnd() {
        return lastConsumeTimeEnd;
    }

    public void setLastConsumeTimeEnd(int lastConsumeTimeEnd) {
        this.lastConsumeTimeEnd = lastConsumeTimeEnd;
    }

    public int getLastConsumeTimeStart() {
        return lastConsumeTimeStart;
    }

    public void setLastConsumeTimeStart(int lastConsumeTimeStart) {
        this.lastConsumeTimeStart = lastConsumeTimeStart;
    }

    public String getRegistrationDateEnd() {
        return registrationDateEnd;
    }

    public void setRegistrationDateEnd(String registrationDateEnd) {
        this.registrationDateEnd = registrationDateEnd;
    }

    public String getRegistrationDateStart() {
        return registrationDateStart;
    }

    public void setRegistrationDateStart(String registrationDateStart) {
        this.registrationDateStart = registrationDateStart;
    }

    public int getScreeningId() {
        return screeningId;
    }

    public void setScreeningId(int screeningId) {
        this.screeningId = screeningId;
    }

    public String getScreeningName() {
        return screeningName;
    }

    public void setScreeningName(String screeningName) {
        this.screeningName = screeningName;
    }

    public int getStoreId() {
        return storeId;
    }

    public void setStoreId(int storeId) {
        this.storeId = storeId;
    }

    public int getUnusedBalanceEnd() {
        return unusedBalanceEnd;
    }

    public void setUnusedBalanceEnd(int unusedBalanceEnd) {
        this.unusedBalanceEnd = unusedBalanceEnd;
    }

    public int getUnusedBalanceStart() {
        return unusedBalanceStart;
    }

    public void setUnusedBalanceStart(int unusedBalanceStart) {
        this.unusedBalanceStart = unusedBalanceStart;
    }
}
