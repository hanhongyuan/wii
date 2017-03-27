package com.platform.web.entity;

/**
 * Created by tanghong on 2017/2/21.
 */
public class StoreInfo {
    /** 门店标识 */
   private int storeId;

    /** 总店标识(总店为本身id) */
    private int hqStoreId;

    /** 门店类型(1：单店，2：连锁总店，3：连锁分店,4:管理员) */
    private int storeType ;

    /** 门店名称 */
    private String storeName ;

    /** 门店联系人 */
    private String storeLinkname;

    /** 门店联系电话 */
    private String storeLinkphone;

    /** 门店所属城市 */
    private String storeCity;

    /** 门店所属省份 */
    private String storeProvince;

    /** 店铺地址 */
    private String storeAddress;

    /** 店铺电话 */
    private String storeTel;

    /** 店铺LOGO */
    private String storeLogo;

    /** 店铺轮播图片 */
    private String carouselPicture;

    /** 门店介绍 */
    private String storeDesc;

    /** 技术展示 */
    private String technical;

    /** 特色服务 */
    private String characteristic;

    /** 名师介绍 */
    private String teacherIntroduction;

    /** 门店状态(1:申请中，2:试运营，3:正常营业，4:已过期，5:已删除) */
    private int storeStatus ;

    /** 创建时间 */
    private String createTime;

    /** 修改时间 */
    private String updateTime;

    /**
     * 推荐人名字(店铺查询推荐人业务员创建) by DavidLiang 2016-01-21 17:55:00
     */
    private String recommendName;

    /** 纬度 */
    private String latitude;

    /** 经度 */
    private String longitude;

    public String getCarouselPicture() {
        return carouselPicture;
    }

    public void setCarouselPicture(String carouselPicture) {
        this.carouselPicture = carouselPicture;
    }

    public String getCharacteristic() {
        return characteristic;
    }

    public void setCharacteristic(String characteristic) {
        this.characteristic = characteristic;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public int getHqStoreId() {
        return hqStoreId;
    }

    public void setHqStoreId(int hqStoreId) {
        this.hqStoreId = hqStoreId;
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    public String getRecommendName() {
        return recommendName;
    }

    public void setRecommendName(String recommendName) {
        this.recommendName = recommendName;
    }

    public String getStoreAddress() {
        return storeAddress;
    }

    public void setStoreAddress(String storeAddress) {
        this.storeAddress = storeAddress;
    }

    public String getStoreCity() {
        return storeCity;
    }

    public void setStoreCity(String storeCity) {
        this.storeCity = storeCity;
    }

    public String getStoreDesc() {
        return storeDesc;
    }

    public void setStoreDesc(String storeDesc) {
        this.storeDesc = storeDesc;
    }

    public int getStoreId() {
        return storeId;
    }

    public void setStoreId(int storeId) {
        this.storeId = storeId;
    }

    public String getStoreLinkname() {
        return storeLinkname;
    }

    public void setStoreLinkname(String storeLinkname) {
        this.storeLinkname = storeLinkname;
    }

    public String getStoreLinkphone() {
        return storeLinkphone;
    }

    public void setStoreLinkphone(String storeLinkphone) {
        this.storeLinkphone = storeLinkphone;
    }

    public String getStoreLogo() {
        return storeLogo;
    }

    public void setStoreLogo(String storeLogo) {
        this.storeLogo = storeLogo;
    }

    public String getStoreName() {
        return storeName;
    }

    public void setStoreName(String storeName) {
        this.storeName = storeName;
    }

    public String getStoreProvince() {
        return storeProvince;
    }

    public void setStoreProvince(String storeProvince) {
        this.storeProvince = storeProvince;
    }

    public int getStoreStatus() {
        return storeStatus;
    }

    public void setStoreStatus(int storeStatus) {
        this.storeStatus = storeStatus;
    }

    public String getStoreTel() {
        return storeTel;
    }

    public void setStoreTel(String storeTel) {
        this.storeTel = storeTel;
    }

    public int getStoreType() {
        return storeType;
    }

    public void setStoreType(int storeType) {
        this.storeType = storeType;
    }

    public String getTeacherIntroduction() {
        return teacherIntroduction;
    }

    public void setTeacherIntroduction(String teacherIntroduction) {
        this.teacherIntroduction = teacherIntroduction;
    }

    public String getTechnical() {
        return technical;
    }

    public void setTechnical(String technical) {
        this.technical = technical;
    }

    public String getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(String updateTime) {
        this.updateTime = updateTime;
    }
}
