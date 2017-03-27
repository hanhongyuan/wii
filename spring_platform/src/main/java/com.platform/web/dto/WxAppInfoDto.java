package com.platform.web.dto;

/**
 * Created by tanghong on 2017/3/14.
 */
public class WxAppInfoDto {
   private int id;
   private String qrcode;
   private String wechatId;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getQrcode() {
        return qrcode;
    }

    public void setQrcode(String qrcode) {
        this.qrcode = qrcode;
    }

    public String getWechatId() {
        return wechatId;
    }

    public void setWechatId(String wechatId) {
        this.wechatId = wechatId;
    }
}
