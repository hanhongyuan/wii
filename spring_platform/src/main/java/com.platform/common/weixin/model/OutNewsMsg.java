package com.platform.common.weixin.model;

import java.util.List;

import static com.platform.common.consts.WxConsts.MsgTypeCons.XML_MSG_NEWS;

/**
 * Created by tanghong on 2017/3/19.
 */
public class OutNewsMsg extends BaseMsgOut {
    String msgType = XML_MSG_NEWS;
    List<Article> articles;

    public OutNewsMsg(String toUser, String fromUser, List<Article> articles){
        this.toUser = toUser;
        this.fromUser = fromUser;
        this.articles = articles;
    }

    @Override
    public String other() {
        String art = articles.stream().map(article -> {
            return "<item>\n" +
                    "<Title><![CDATA["+article.getTitle()+"]]></Title>\n" +
                    "<Description><![CDATA["+article.getDescription()+"]]></Description>\n" +
                    "<PicUrl><![CDATA["+article.getPicUrl()+"]]></PicUrl>\n" +
                    "<Url><![CDATA["+article.getUri()+"]]></Url>\n" +
                    "</item>";
        }).reduce("", (a, b) -> a + b);

        return "<ArticleCount>"+articles.size()+"</ArticleCount>\n" +
                "<Articles>"+art+"</Articles>";
    }
}
