package com.platform.web.entity;

import com.platform.common.consts.Consts;
import com.platform.common.utils.JodaUtils;

/**
 * 微信公众号信息对象
 */
public class WxAppInfo {
   private int id;
   private int authId;
   private int storeId;
   private String appId;
   private String nickName;
   private String headImg;
   private int serviceType;
   private int verifyType;
   private String userName; // 原始id
   private String alias; //授权方公众号所设置的微信号,可能为null
   private String qrCodeUrl;
   private String businessInfo;
   private String funcInfo;
   private String createon;
   private int state;

   public WxAppInfo(
      int authId, int storeId, String appId, String nickName,
      String userName, String headImg, int serviceType, int verifyType,
      String alias, String qrCodeUrl, String businessInfo,
      String funcInfo) {
        this.authId = authId;
        this.storeId = storeId;
        this.appId = appId;
        this.nickName = nickName;
        this.userName = userName;
        this.headImg = headImg;
        this.serviceType = serviceType;
        this.verifyType = verifyType;
        this.alias = alias;
        this.qrCodeUrl = qrCodeUrl;
        this.businessInfo = businessInfo;
        this.funcInfo = funcInfo;
        this.createon = JodaUtils.getDate();
        this.state = Consts.StatusCons.enable;
    }

    public WxAppInfo(){}

    public String getAlias() {
        return alias;
    }

    public void setAlias(String alias) {
        this.alias = alias;
    }

    public String getAppId() {
        return appId;
    }

    public void setAppId(String appId) {
        this.appId = appId;
    }

    public int getAuthId() {
        return authId;
    }

    public void setAuthId(int authId) {
        this.authId = authId;
    }

    public String getBusinessInfo() {
        return businessInfo;
    }

    public void setBusinessInfo(String businessInfo) {
        this.businessInfo = businessInfo;
    }

    public String getCreateon() {
        return createon;
    }

    public void setCreateon(String createon) {
        this.createon = createon;
    }

    public String getFuncInfo() {
        return funcInfo;
    }

    public void setFuncInfo(String funcInfo) {
        this.funcInfo = funcInfo;
    }

    public String getHeadImg() {
        return headImg;
    }

    public void setHeadImg(String headImg) {
        this.headImg = headImg;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getQrCodeUrl() {
        return qrCodeUrl;
    }

    public void setQrCodeUrl(String qrCodeUrl) {
        this.qrCodeUrl = qrCodeUrl;
    }

    public int getServiceType() {
        return serviceType;
    }

    public void setServiceType(int serviceType) {
        this.serviceType = serviceType;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    public int getStoreId() {
        return storeId;
    }

    public void setStoreId(int storeId) {
        this.storeId = storeId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public int getVerifyType() {
        return verifyType;
    }

    public void setVerifyType(int verifyType) {
        this.verifyType = verifyType;
    }
}
