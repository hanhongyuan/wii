package com.platform.web.dto;

/**
 * Created by tanghong on 2017/3/14.
 */
public class GoodsAppointDto {
    private int goodsId;
    private String goodsName;
    private double goodsPrice;
    private double costPrice;
    private String goodsImage;
    private String goodsDesc;
    private String affiliatedImage;

    public String getAffiliatedImage() {
        return affiliatedImage;
    }

    public void setAffiliatedImage(String affiliatedImage) {
        this.affiliatedImage = affiliatedImage;
    }

    public double getCostPrice() {
        return costPrice;
    }

    public void setCostPrice(double costPrice) {
        this.costPrice = costPrice;
    }

    public String getGoodsDesc() {
        return goodsDesc;
    }

    public void setGoodsDesc(String goodsDesc) {
        this.goodsDesc = goodsDesc;
    }

    public int getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(int goodsId) {
        this.goodsId = goodsId;
    }

    public String getGoodsImage() {
        return goodsImage;
    }

    public void setGoodsImage(String goodsImage) {
        this.goodsImage = goodsImage;
    }

    public String getGoodsName() {
        return goodsName;
    }

    public void setGoodsName(String goodsName) {
        this.goodsName = goodsName;
    }

    public double getGoodsPrice() {
        return goodsPrice;
    }

    public void setGoodsPrice(double goodsPrice) {
        this.goodsPrice = goodsPrice;
    }
}
