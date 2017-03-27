package com.platform.web.entity;

/**
 * Created by zhh on 2017/2/21.
 */
public class StoreWechat {
    /** 门店ID */
    private int storeId;

    /** 公众号原始id */
    private String wechatId;

    /** 公众号应用ID */
    private String wechatAppid;

    /** 公众号应用密钥 */
    private String wechatAppsecret;

    /** 客户预约申请通知 */
    private String tmAppointApply;

    /** 客户预约结果通知 */
    private String tmAppointResult;

    /** 客户预约到时提醒 */
    private String tmAppointRemind;

    /** 客户充值结果提醒 */
    private String tmChargeResult;

    /** 客户结账信息通知 */
    private String tmPaymentInfo;

    /** 员工服务移交通知 */
    private String tmServiceTurn;

    /** 优惠券到期提醒 */
    private String tmCouponOverdue;

    public StoreWechat(
        int storeId, String wechatId,
        String appId){
        this.storeId = storeId;
        this.wechatId = wechatId;
        this.wechatAppid = appId;
    }

    public StoreWechat(){}

    public int getStoreId() {
        return storeId;
    }

    public void setStoreId(int storeId) {
        this.storeId = storeId;
    }

    public String getWechatId() {
        return wechatId;
    }

    public void setWechatId(String wechatId) {
        this.wechatId = wechatId;
    }

    public String getWechatAppid() {
        return wechatAppid;
    }

    public void setWechatAppid(String wechatAppid) {
        this.wechatAppid = wechatAppid;
    }

    public String getWechatAppsecret() {
        return wechatAppsecret;
    }

    public void setWechatAppsecret(String wechatAppsecret) {
        this.wechatAppsecret = wechatAppsecret;
    }

    public String getTmAppointApply() {
        return tmAppointApply;
    }

    public void setTmAppointApply(String tmAppointApply) {
        this.tmAppointApply = tmAppointApply;
    }

    public String getTmAppointResult() {
        return tmAppointResult;
    }

    public void setTmAppointResult(String tmAppointResult) {
        this.tmAppointResult = tmAppointResult;
    }

    public String getTmAppointRemind() {
        return tmAppointRemind;
    }

    public void setTmAppointRemind(String tmAppointRemind) {
        this.tmAppointRemind = tmAppointRemind;
    }

    public String getTmChargeResult() {
        return tmChargeResult;
    }

    public void setTmChargeResult(String tmChargeResult) {
        this.tmChargeResult = tmChargeResult;
    }

    public String getTmPaymentInfo() {
        return tmPaymentInfo;
    }

    public void setTmPaymentInfo(String tmPaymentInfo) {
        this.tmPaymentInfo = tmPaymentInfo;
    }

    public String getTmServiceTurn() {
        return tmServiceTurn;
    }

    public void setTmServiceTurn(String tmServiceTurn) {
        this.tmServiceTurn = tmServiceTurn;
    }

    public String getTmCouponOverdue() {
        return tmCouponOverdue;
    }

    public void setTmCouponOverdue(String tmCouponOverdue) {
        this.tmCouponOverdue = tmCouponOverdue;
    }
}
