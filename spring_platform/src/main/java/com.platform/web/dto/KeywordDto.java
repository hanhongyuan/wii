package com.platform.web.dto;

import java.util.List;
import java.util.Optional;

/**
 * Created by tanghong on 2017/3/19.
 */
public class KeywordDto {
    private Optional<Integer> id;
    private int storeId;
    private String rule;
    private List<String> keyword;
    private List<Integer> teletexts;
    private Optional<String> content;
    private int replyType;

    public Optional<String> getContent() {
        return content;
    }

    public void setContent(Optional<String> content) {
        this.content = content;
    }

    public Optional<Integer> getId() {
        return id;
    }

    public void setId(Optional<Integer> id) {
        this.id = id;
    }

    public List<String> getKeyword() {
        return keyword;
    }

    public void setKeyword(List<String> keyword) {
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

    public int getStoreId() {
        return storeId;
    }

    public void setStoreId(int storeId) {
        this.storeId = storeId;
    }

    public List<Integer> getTeletexts() {
        return teletexts;
    }

    public void setTeletexts(List<Integer> teletexts) {
        this.teletexts = teletexts;
    }
}
