package com.platform.common.weixin.model;

import static com.platform.common.consts.WxConsts.MsgTypeCons.XML_MSG_TEXT;

/**
 * Created by tanghong on 2017/3/19.
 */
public class OutTextMsg extends BaseMsgOut {
    String msgType = XML_MSG_TEXT;
    String content;

    public OutTextMsg(String toUser, String fromUser, String content) {
        this.toUser = toUser;
        this.fromUser = fromUser;
        this.content = content;
    }


    public String other() {
        return "<Content><![CDATA[" + content + "]]></Content>";
    }
}
