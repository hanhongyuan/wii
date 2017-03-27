package com.platform.common.weixin.model;

import com.sun.xml.internal.ws.util.xml.CDATA;

import java.util.List;

import static com.platform.common.consts.WxConsts.MsgTypeCons.XML_MSG_NEWS;
import static com.platform.common.consts.WxConsts.MsgTypeCons.XML_MSG_TEXT;

/**
 * Created by tanghong on 2017/3/19.
 */
public abstract class BaseMsgOut {
    String toUser = null;
    String fromUser = null;
    String msgType = null;
    long createTime = System.currentTimeMillis() / 1000;

    abstract String other();

    public String toXml() {
        return " <xml>\n" +
        "<ToUserName><![CDATA["+toUser+"]]></ToUserName>\n" +
        "<FromUserName><![CDATA["+fromUser+"]]></FromUserName>\n" +
        "<CreateTime>"+createTime+"</CreateTime>\n" +
        "<MsgType><![CDATA["+msgType+"]]></MsgType>\n" +
        other() + "\n" +
        "</xml>";
    }

    public long getCreateTime() {
        return createTime;
    }

    public void setCreateTime(long createTime) {
        this.createTime = createTime;
    }

    public String getFromUser() {
        return fromUser;
    }

    public void setFromUser(String fromUser) {
        this.fromUser = fromUser;
    }

    public String getMsgType() {
        return msgType;
    }

    public void setMsgType(String msgType) {
        this.msgType = msgType;
    }

    public String getToUser() {
        return toUser;
    }

    public void setToUser(String toUser) {
        this.toUser = toUser;
    }
}
