package com.platform.common.weixin.model;

import java.util.List;

/**
 * Created by tanghong on 2017/3/20.
 */
public class SubButton {
    private String name;
    private List<ViewButton> sub_button;

    public SubButton(){}

    public SubButton(String name, List<ViewButton> subs){
        this.name = name;
        this.sub_button = subs;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<ViewButton> getSub_button() {
        return sub_button;
    }

    public void setSub_button(List<ViewButton> sub_button) {
        this.sub_button = sub_button;
    }
}
