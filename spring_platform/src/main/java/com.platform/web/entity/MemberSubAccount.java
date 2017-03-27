package com.platform.web.entity;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * Created by tanghong on 2017/2/22.
 */
public class MemberSubAccount implements Serializable {
    /** 子账户标识 */
    private Integer subAccountId;

    /** 子账户所在的门店*/
    private Integer storeId;

    /** 账户标识 */
    private Integer accountId;

    /** 级别标识 */
    private Integer levelId;

    /** 卡号 */
    private String cardNo;

    /** 储值总额 */
    private BigDecimal totalAmount;

    /** 赠送总额 */
    private BigDecimal totalPresentAmount;

    /** 储值余额 */
    private BigDecimal balanceAmount;

    /** 使用金额 */
    private BigDecimal useAmount;

    /** 礼金储值总额 */
    private BigDecimal totalGiftmoneyAmount;

    /** 礼金储值余额 */
    private BigDecimal balanceGiftmoneyAmount;

    /** 礼金过期金额*/
    private BigDecimal overdueGiftmoneyAmount;

    /** 欠款金额*/
    private BigDecimal debtAmount;

    /** 是否删除 */
    private Integer isDeleted;

    /** 创建时间 */
    private String createTime;

    /** 修改时间 */
    private String updateTime;

    /** 最后操作人标识 */
    private Integer lastOperatorId;

    /** 删卡还是退卡*/
    private Integer blackOrDeleted;

    /**消费欠款*/
    private BigDecimal debtConsumedAmt;

    /**开充卡欠款*/
    private BigDecimal debtCardAmt;

    /**有效期(结束时间)*/
    private String endDate;

    private Integer policyMemberId;

    private String policyCardNo;

    private String remarks;

    /** 是否扣除管理费(0：否，1：是) */
    private Integer smsCostType;

    /** @param subAccountId	子账户标识 */
    public void setSubAccountId(Integer subAccountId){
        this.subAccountId = subAccountId;
    }

    /** @return	子账户标识 */
    public Integer getSubAccountId(){
        return subAccountId;
    }

    /** @return	子账户所在门店标识 */
    public Integer getStoreId() {
        return storeId;
    }

    public void setStoreId(Integer storeId) {
        this.storeId = storeId;
    }

    /** @param accountId	账户标识 */
    public void setAccountId(Integer accountId){
        this.accountId = accountId;
    }

    /** @return	账户标识 */
    public Integer getAccountId(){
        return accountId;
    }

    /** @param levelId	级别标识 */
    public void setLevelId(Integer levelId){
        this.levelId = levelId;
    }

    /** @return	级别标识 */
    public Integer getLevelId(){
        return levelId;
    }

    /** @param totalAmount	储值总额 */
    public void setTotalAmount(BigDecimal totalAmount){
        this.totalAmount = totalAmount;
    }

    /** @return	储值总额 */
    public BigDecimal getTotalAmount(){
        return totalAmount;
    }

    /** @param totalPresentAmount	赠送总额 */
    public void setTotalPresentAmount(BigDecimal totalPresentAmount){
        this.totalPresentAmount = totalPresentAmount;
    }

    /** @return	赠送总额 */
    public BigDecimal getTotalPresentAmount(){
        return totalPresentAmount;
    }

    /** @param balanceAmount	储值余额 */
    public void setBalanceAmount(BigDecimal balanceAmount){
        this.balanceAmount = balanceAmount;
    }

    /** @return	储值余额 */
    public BigDecimal getBalanceAmount(){
        return balanceAmount;
    }

    /** @param useAmount	使用金额 */
    public void setUseAmount(BigDecimal useAmount){
        this.useAmount = useAmount;
    }

    /** @return	使用金额 */
    public BigDecimal getUseAmount(){
        return useAmount;
    }

    public Integer getIsDeleted() {
        return isDeleted;
    }

    public void setIsDeleted(Integer isDeleted) {
        this.isDeleted = isDeleted;
    }

    /** @param createTime	创建时间 */
    public void setCreateTime(String createTime){
        this.createTime = createTime;
    }

    /** @return	创建时间 */
    public String getCreateTime(){
        return createTime;
    }

    /** @param updateTime	修改时间 */
    public void setUpdateTime(String updateTime){
        this.updateTime = updateTime;
    }

    /** @return	修改时间 */
    public String getUpdateTime(){
        return updateTime;
    }

    /** @param lastOperatorId	最后操作人标识 */
    public void setLastOperatorId(Integer lastOperatorId){
        this.lastOperatorId = lastOperatorId;
    }

    /** @return	最后操作人标识 */
    public Integer getLastOperatorId(){
        return lastOperatorId;
    }

    public String getCardNo() {
        return cardNo;
    }

    public void setCardNo(String cardNo) {
        this.cardNo = cardNo;
    }

    public BigDecimal getTotalGiftmoneyAmount() {
        return totalGiftmoneyAmount;
    }

    public void setTotalGiftmoneyAmount(BigDecimal totalGiftmoneyAmount) {
        this.totalGiftmoneyAmount = totalGiftmoneyAmount;
    }

    public BigDecimal getBalanceGiftmoneyAmount() {
        return balanceGiftmoneyAmount;
    }

    public void setBalanceGiftmoneyAmount(BigDecimal balanceGiftmoneyAmount) {
        this.balanceGiftmoneyAmount = balanceGiftmoneyAmount;
    }

    public BigDecimal getOverdueGiftmoneyAmount() {
        return overdueGiftmoneyAmount;
    }

    public void setOverdueGiftmoneyAmount(BigDecimal overdueGiftmoneyAmount) {
        this.overdueGiftmoneyAmount = overdueGiftmoneyAmount;
    }

    public BigDecimal getDebtAmount() {
        return debtAmount;
    }

    public void setDebtAmount(BigDecimal debtAmount) {
        this.debtAmount = debtAmount;
    }

    public Integer getBlackOrDeleted() {
        return blackOrDeleted;
    }

    public void setBlackOrDeleted(Integer blackOrDeleted) {
        this.blackOrDeleted = blackOrDeleted;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public BigDecimal getDebtConsumedAmt() {
        return debtConsumedAmt;
    }

    public void setDebtConsumedAmt(BigDecimal debtConsumedAmt) {
        this.debtConsumedAmt = debtConsumedAmt;
    }

    public BigDecimal getDebtCardAmt() {
        return debtCardAmt;
    }

    public void setDebtCardAmt(BigDecimal debtCardAmt) {
        this.debtCardAmt = debtCardAmt;
    }

    public Integer getPolicyMemberId() {
        return policyMemberId;
    }

    public void setPolicyMemberId(Integer policyMemberId) {
        this.policyMemberId = policyMemberId;
    }

    public String getPolicyCardNo() {
        return policyCardNo;
    }

    public void setPolicyCardNo(String policyCardNo) {
        this.policyCardNo = policyCardNo;
    }

    public Integer getSmsCostType() {
        return smsCostType;
    }

    public void setSmsCostType(Integer smsCostType) {
        this.smsCostType = smsCostType;
    }

    public String getRemarks(){
        return remarks;
    }

    public void setRemarks(String remarks){
        this.remarks = remarks;
    }
}
