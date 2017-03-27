package com.platform.web.entity;

import com.platform.common.consts.Consts;
import com.platform.common.utils.JodaUtils;

/**
 * Created by tanghong on 2017/3/19.
 */
public class WxKeywordReply {
    private int id;
    private int storeId;
    private String rule;
    private String keyword;
    private int replyType; // 1为文本, 2为图文
    private String teletexts;
    private String content;
    private String createon;
    private String updateon;
    private int state;

    public WxKeywordReply(
        int storeId,
        String rule,
        String keyword,
        String content,
        int replyType){
        this.storeId = storeId;
        this.rule = rule;
        this.keyword = keyword;
        this.content = content;
        this.createon = JodaUtils.getDate();
        this.updateon = JodaUtils.getDate();
        this.state = Consts.StatusCons.enable;
        this.replyType = replyType;
    }

    public WxKeywordReply(){}

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

    public String getKeyword() {
        return keyword;
    }

    public void setKeyword(String keyword) {
        this.keyword = keyword;
    }

    public int getReplyType() {
        return replyType;
    }

    public void setReplyType(int replyType) {
        this.replyType = replyType;
    }

    public String getRule() {
        return rule;
    }

    public void setRule(String rule) {
        this.rule = rule;
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

    public String getTeletexts() {
        return teletexts;
    }

    public void setTeletexts(String teletexts) {
        this.teletexts = teletexts;
    }

    public String getUpdateon() {
        return updateon;
    }

    public void setUpdateon(String updateon) {
        this.updateon = updateon;
    }
}
