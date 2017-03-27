package com.platform.web.entity;

import com.platform.common.consts.Consts;
import com.platform.common.utils.JodaUtils;

/**
 * 图文消息
 * Created by zhh on 2017/2/21.
 */
public class WxTeletext {
    /** 消息ID */
    private int id;

    /**所属活动类型**/
    private int promotionTypeId; // 1为纯图文, 其他标识为活动图文

    /** 门店ID */
    private int storeId;

    /** 图文消息的标题 */
    private String title;

    /** 作者 */
    private String author;

    /** 图文消息的描述 */
    private String digest;

    /**封面图片*/
    private String imgUrl;

    /** 图文消息textarea */
    private String content;

    private int showCoverPic;

    /** 原文地址 */
    private String contentSourceUrl;

    /** 复制的图文媒体ID */
    private int fId;

    /** 创建时间 */
    private String createon;
    private String updateon;
    private int state;

    public WxTeletext(int promotionTypeId, int storeId, String title, String author, String digest, String imgUrl, String content, int showCoverPic, String contentSourceUrl, int fId) {
        this.promotionTypeId = promotionTypeId;
        this.storeId = storeId;
        this.title = title;
        this.author = author;
        this.digest = digest;
        this.imgUrl = imgUrl;
        this.content = content;
        this.showCoverPic = showCoverPic;
        this.contentSourceUrl = contentSourceUrl;
        this.createon = JodaUtils.getDate();
        this.updateon = JodaUtils.getDate();
        this.fId = fId;
    }

    public WxTeletext(int promotionTypeId, int storeId, String title, String digest, String imgUrl, String content) {
        this.promotionTypeId = promotionTypeId;
        this.storeId = storeId;
        this.title = title;
        this.digest = digest;
        this.imgUrl = imgUrl;
        this.content = content;
        this.showCoverPic = 0;
        this.createon = JodaUtils.getDate();
        this.updateon = JodaUtils.getDate();
        this.state = Consts.StatusCons.enable;
    }

    public WxTeletext(){}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPromotionTypeId() {
        return promotionTypeId;
    }

    public void setPromotionTypeId(int promotionTypeId) {
        this.promotionTypeId = promotionTypeId;
    }

    public int getStoreId() {
        return storeId;
    }

    public void setStoreId(int storeId) {
        this.storeId = storeId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getDigest() {
        return digest;
    }

    public void setDigest(String digest) {
        this.digest = digest;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getShowCoverPic() {
        return showCoverPic;
    }

    public void setShowCoverPic(int showCoverPic) {
        this.showCoverPic = showCoverPic;
    }

    public String getContentSourceUrl() {
        return contentSourceUrl;
    }

    public void setContentSourceUrl(String contentSourceUrl) {
        this.contentSourceUrl = contentSourceUrl;
    }

    public int getfId() {
        return fId;
    }

    public void setfId(int fId) {
        this.fId = fId;
    }

    public String getCreateon() {
        return createon;
    }

    public void setCreateon(String createon) {
        this.createon = createon;
    }

    public String getUpdateon() {
        return updateon;
    }

    public void setUpdateon(String updateon) {
        this.updateon = updateon;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }
}
