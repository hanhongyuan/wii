package com.platform.common.weixin.dto;

/**
 * Created by tanghong on 2017/3/7.
 */
public class WxPreviewResultDto {
    private String errcode;
    private String errmsg;
    private String msg_id;

    public String getErrcode() {
        return errcode;
    }

    public void setErrcode(String errcode) {
        this.errcode = errcode;
    }

    public String getErrmsg() {
        return errmsg;
    }

    public void setErrmsg(String errmsg) {
        this.errmsg = errmsg;
    }

    public String getMsg_id() {
        return msg_id;
    }

    public void setMsg_id(String msg_id) {
        this.msg_id = msg_id;
    }
}
