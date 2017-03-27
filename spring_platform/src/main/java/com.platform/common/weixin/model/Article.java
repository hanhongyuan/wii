package com.platform.common.weixin.model;

/**
 * Created by tanghong on 2017/3/19.
 */
public class Article {
    private String title;
    private String description;
    private String picUrl;
    private String uri;

    public Article(String tile, String des, String picUrl, String uri){
        this.title = tile;
        this.description = des;
        this.picUrl = picUrl;
        this.uri = uri;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPicUrl() {
        return picUrl;
    }

    public void setPicUrl(String picUrl) {
        this.picUrl = picUrl;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getUri() {
        return uri;
    }

    public void setUri(String uri) {
        this.uri = uri;
    }
}
