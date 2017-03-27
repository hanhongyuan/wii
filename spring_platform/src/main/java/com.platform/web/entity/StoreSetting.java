package com.platform.web.entity;

/**
 * Created by tanghong on 2017/3/19.
 */
public class StoreSetting {
    private int storeId;
    private int giftCleanDays;
    private int integralCleanDays;
    private int paymentVerifyType;
    private int costCommissionType;
    private int commissionFixedType;
    private int isPerformanceCommission;
    private int percentageFixedType;
    private int giftCommissionRate;
    private int couponCommissionRate;
    private int appointRemindHour;
    private int speechType;
    private int speechTurnUse;
    private String firstFollowCoupon;
    private int firstFollowGift;
    private String memberShareReward;
    private String memberShareTitle;
    private int smsFee;
    private int appointmentDiscount;
    private String lastFacilitator;
    private String weixinPicUrl;
    private String aliPicUrl;
    private int giftUseType;
    private int receiptsUseType;
    private int smsMessageType;
    private int orderType;
    private int orderCodeType;
    private int showProjectPrice;
    private int debtWarning;
    private int giftDiscountType;
    private int conservedInformation;

    public String getAliPicUrl() {
        return aliPicUrl;
    }

    public void setAliPicUrl(String aliPicUrl) {
        this.aliPicUrl = aliPicUrl;
    }

    public int getAppointmentDiscount() {
        return appointmentDiscount;
    }

    public void setAppointmentDiscount(int appointmentDiscount) {
        this.appointmentDiscount = appointmentDiscount;
    }

    public int getAppointRemindHour() {
        return appointRemindHour;
    }

    public void setAppointRemindHour(int appointRemindHour) {
        this.appointRemindHour = appointRemindHour;
    }

    public int getCommissionFixedType() {
        return commissionFixedType;
    }

    public void setCommissionFixedType(int commissionFixedType) {
        this.commissionFixedType = commissionFixedType;
    }

    public int getConservedInformation() {
        return conservedInformation;
    }

    public void setConservedInformation(int conservedInformation) {
        this.conservedInformation = conservedInformation;
    }

    public int getCostCommissionType() {
        return costCommissionType;
    }

    public void setCostCommissionType(int costCommissionType) {
        this.costCommissionType = costCommissionType;
    }

    public int getCouponCommissionRate() {
        return couponCommissionRate;
    }

    public void setCouponCommissionRate(int couponCommissionRate) {
        this.couponCommissionRate = couponCommissionRate;
    }

    public int getDebtWarning() {
        return debtWarning;
    }

    public void setDebtWarning(int debtWarning) {
        this.debtWarning = debtWarning;
    }

    public String getFirstFollowCoupon() {
        return firstFollowCoupon;
    }

    public void setFirstFollowCoupon(String firstFollowCoupon) {
        this.firstFollowCoupon = firstFollowCoupon;
    }

    public int getFirstFollowGift() {
        return firstFollowGift;
    }

    public void setFirstFollowGift(int firstFollowGift) {
        this.firstFollowGift = firstFollowGift;
    }

    public int getGiftCleanDays() {
        return giftCleanDays;
    }

    public void setGiftCleanDays(int giftCleanDays) {
        this.giftCleanDays = giftCleanDays;
    }

    public int getGiftCommissionRate() {
        return giftCommissionRate;
    }

    public void setGiftCommissionRate(int giftCommissionRate) {
        this.giftCommissionRate = giftCommissionRate;
    }

    public int getGiftDiscountType() {
        return giftDiscountType;
    }

    public void setGiftDiscountType(int giftDiscountType) {
        this.giftDiscountType = giftDiscountType;
    }

    public int getGiftUseType() {
        return giftUseType;
    }

    public void setGiftUseType(int giftUseType) {
        this.giftUseType = giftUseType;
    }

    public int getIntegralCleanDays() {
        return integralCleanDays;
    }

    public void setIntegralCleanDays(int integralCleanDays) {
        this.integralCleanDays = integralCleanDays;
    }

    public int getIsPerformanceCommission() {
        return isPerformanceCommission;
    }

    public void setIsPerformanceCommission(int isPerformanceCommission) {
        this.isPerformanceCommission = isPerformanceCommission;
    }

    public String getLastFacilitator() {
        return lastFacilitator;
    }

    public void setLastFacilitator(String lastFacilitator) {
        this.lastFacilitator = lastFacilitator;
    }

    public String getMemberShareReward() {
        return memberShareReward;
    }

    public void setMemberShareReward(String memberShareReward) {
        this.memberShareReward = memberShareReward;
    }

    public String getMemberShareTitle() {
        return memberShareTitle;
    }

    public void setMemberShareTitle(String memberShareTitle) {
        this.memberShareTitle = memberShareTitle;
    }

    public int getOrderCodeType() {
        return orderCodeType;
    }

    public void setOrderCodeType(int orderCodeType) {
        this.orderCodeType = orderCodeType;
    }

    public int getOrderType() {
        return orderType;
    }

    public void setOrderType(int orderType) {
        this.orderType = orderType;
    }

    public int getPaymentVerifyType() {
        return paymentVerifyType;
    }

    public void setPaymentVerifyType(int paymentVerifyType) {
        this.paymentVerifyType = paymentVerifyType;
    }

    public int getPercentageFixedType() {
        return percentageFixedType;
    }

    public void setPercentageFixedType(int percentageFixedType) {
        this.percentageFixedType = percentageFixedType;
    }

    public int getReceiptsUseType() {
        return receiptsUseType;
    }

    public void setReceiptsUseType(int receiptsUseType) {
        this.receiptsUseType = receiptsUseType;
    }

    public int getShowProjectPrice() {
        return showProjectPrice;
    }

    public void setShowProjectPrice(int showProjectPrice) {
        this.showProjectPrice = showProjectPrice;
    }

    public int getSmsFee() {
        return smsFee;
    }

    public void setSmsFee(int smsFee) {
        this.smsFee = smsFee;
    }

    public int getSmsMessageType() {
        return smsMessageType;
    }

    public void setSmsMessageType(int smsMessageType) {
        this.smsMessageType = smsMessageType;
    }

    public int getSpeechTurnUse() {
        return speechTurnUse;
    }

    public void setSpeechTurnUse(int speechTurnUse) {
        this.speechTurnUse = speechTurnUse;
    }

    public int getSpeechType() {
        return speechType;
    }

    public void setSpeechType(int speechType) {
        this.speechType = speechType;
    }

    public int getStoreId() {
        return storeId;
    }

    public void setStoreId(int storeId) {
        this.storeId = storeId;
    }

    public String getWeixinPicUrl() {
        return weixinPicUrl;
    }

    public void setWeixinPicUrl(String weixinPicUrl) {
        this.weixinPicUrl = weixinPicUrl;
    }
}
