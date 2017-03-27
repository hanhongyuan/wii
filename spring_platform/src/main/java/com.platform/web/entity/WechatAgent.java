package com.platform.web.entity;

import java.sql.Timestamp;

/**
 * Created by zhh on 2017/2/21.
 */
public class WechatAgent {

    /**微信标识*/
    private  String openId;

    /**代理标识*/
    private int agentId;

    /**创建时间*/
    private Timestamp createTime;

    public String getOpenId() {
        return openId;
    }

    public void setOpenId(String openId) {
        this.openId = openId;
    }

    public int getAgentId() {
        return agentId;
    }

    public void setAgentId(int agentId) {
        this.agentId = agentId;
    }

    public Timestamp getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Timestamp createTime) {
        this.createTime = createTime;
    }


}
