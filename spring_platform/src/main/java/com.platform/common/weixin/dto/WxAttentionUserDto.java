package com.platform.common.weixin.dto;

/**
 * Created by tanghong on 2017/3/7.
 */
public class WxAttentionUserDto {

    private int total;
    private int count;
    private WxUserDto data;
    private String next_openid;

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public WxUserDto getData() {
        return data;
    }

    public void setData(WxUserDto data) {
        this.data = data;
    }

    public String getNext_openid() {
        return next_openid;
    }

    public void setNext_openid(String next_openid) {
        this.next_openid = next_openid;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }
}
