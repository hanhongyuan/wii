package com.platform.web.entity;

import com.platform.common.consts.Consts;
import com.platform.common.utils.JodaUtils;

/**
 * Created by tanghong on 2017/3/19.
 */
public class WxTextReply {
    private int id;
    private int storeId;
    private int category; // 1为关注自动回复, 2为消息自动回复
    private String content;
    private String createon;
    private String updateon;
    private int state;

    public WxTextReply(
        int category,
        int storeId,
        String content){
        this.category = category;
        this.storeId = storeId;
        this.content = content;
        this.updateon = JodaUtils.getDate();
        this.createon = JodaUtils.getDate();
        this.state = Consts.StatusCons.enable;
    }

    public WxTextReply(){}

    public int getCategory() {
        return category;
    }

    public void setCategory(int category) {
        this.category = category;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getCreateon() {
        return createon;
    }

    public void setCreateon(String createon) {
        this.createon = createon;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public String getUpdateon() {
        return updateon;
    }

    public void setUpdateon(String updateon) {
        this.updateon = updateon;
    }
}
