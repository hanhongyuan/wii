package com.platform.web.dto;

import java.math.BigDecimal;
import java.util.List;

/**
 * Created by tanghong on 2017/3/19.
 */
public class MemberBaseDto {
    private int memberId;
    private int payPassword;
    private int storeId;
    private String storeName;
    private String levelName;
    private int levelId;
    private String name;
    private String headUrl;
    private String sex;
    private String birthday;
    private String phone;
    private String cardNo;
    private String community;
    private int messageType;
    private BigDecimal totalAmount;
    private BigDecimal balanceAmount;
    private BigDecimal giftmoneyAmount;
    private BigDecimal debtAmount;
    private int balanceIntegral;
    private BigDecimal avgConsumeAmount;
    private String lastConsumeTime;
    private int consumeCount;
    private int avgConsumeDays;
    private int totalConsumeAmount;
    private String lastProjectName;
    private int subAccountNum;
    private int subAccountId;
    private String createTime;
    private int isDeleted;
    private MemberSubAccountDto subAccountInfo;
    private List<Object> subAccountDtoList;
    private List<Object> memberComboDtoList;

    public BigDecimal getAvgConsumeAmount() {
        return avgConsumeAmount;
    }

    public void setAvgConsumeAmount(BigDecimal avgConsumeAmount) {
        this.avgConsumeAmount = avgConsumeAmount;
    }

    public int getAvgConsumeDays() {
        return avgConsumeDays;
    }

    public void setAvgConsumeDays(int avgConsumeDays) {
        this.avgConsumeDays = avgConsumeDays;
    }

    public BigDecimal getBalanceAmount() {
        return balanceAmount;
    }

    public void setBalanceAmount(BigDecimal balanceAmount) {
        this.balanceAmount = balanceAmount;
    }

    public int getBalanceIntegral() {
        return balanceIntegral;
    }

    public void setBalanceIntegral(int balanceIntegral) {
        this.balanceIntegral = balanceIntegral;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getCardNo() {
        return cardNo;
    }

    public void setCardNo(String cardNo) {
        this.cardNo = cardNo;
    }

    public String getCommunity() {
        return community;
    }

    public void setCommunity(String community) {
        this.community = community;
    }

    public int getConsumeCount() {
        return consumeCount;
    }

    public void setConsumeCount(int consumeCount) {
        this.consumeCount = consumeCount;
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

    public BigDecimal getGiftmoneyAmount() {
        return giftmoneyAmount;
    }

    public void setGiftmoneyAmount(BigDecimal giftmoneyAmount) {
        this.giftmoneyAmount = giftmoneyAmount;
    }

    public String getHeadUrl() {
        return headUrl;
    }

    public void setHeadUrl(String headUrl) {
        this.headUrl = headUrl;
    }

    public int getIsDeleted() {
        return isDeleted;
    }

    public void setIsDeleted(int isDeleted) {
        this.isDeleted = isDeleted;
    }

    public String getLastConsumeTime() {
        return lastConsumeTime;
    }

    public void setLastConsumeTime(String lastConsumeTime) {
        this.lastConsumeTime = lastConsumeTime;
    }

    public String getLastProjectName() {
        return lastProjectName;
    }

    public void setLastProjectName(String lastProjectName) {
        this.lastProjectName = lastProjectName;
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

    public List<Object> getMemberComboDtoList() {
        return memberComboDtoList;
    }

    public void setMemberComboDtoList(List<Object> memberComboDtoList) {
        this.memberComboDtoList = memberComboDtoList;
    }

    public int getMemberId() {
        return memberId;
    }

    public void setMemberId(int memberId) {
        this.memberId = memberId;
    }

    public int getMessageType() {
        return messageType;
    }

    public void setMessageType(int messageType) {
        this.messageType = messageType;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPayPassword() {
        return payPassword;
    }

    public void setPayPassword(int payPassword) {
        this.payPassword = payPassword;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
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

    public List<Object> getSubAccountDtoList() {
        return subAccountDtoList;
    }

    public void setSubAccountDtoList(List<Object> subAccountDtoList) {
        this.subAccountDtoList = subAccountDtoList;
    }

    public int getSubAccountId() {
        return subAccountId;
    }

    public void setSubAccountId(int subAccountId) {
        this.subAccountId = subAccountId;
    }

    public MemberSubAccountDto getSubAccountInfo() {
        return subAccountInfo;
    }

    public void setSubAccountInfo(MemberSubAccountDto subAccountInfo) {
        this.subAccountInfo = subAccountInfo;
    }

    public int getSubAccountNum() {
        return subAccountNum;
    }

    public void setSubAccountNum(int subAccountNum) {
        this.subAccountNum = subAccountNum;
    }

    public BigDecimal getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(BigDecimal totalAmount) {
        this.totalAmount = totalAmount;
    }

    public int getTotalConsumeAmount() {
        return totalConsumeAmount;
    }

    public void setTotalConsumeAmount(int totalConsumeAmount) {
        this.totalConsumeAmount = totalConsumeAmount;
    }
}
