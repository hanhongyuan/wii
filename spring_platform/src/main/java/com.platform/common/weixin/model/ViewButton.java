package com.platform.common.weixin.model;

/**
 * Created by tanghong on 2017/3/20.
 */
public class ViewButton {
    private String type = "view";
    private String name;
    private String url;

    public ViewButton(){}

    public ViewButton(String name, String url){
        this.name = name;
        this.url = url;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
