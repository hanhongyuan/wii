package com.platform.common.weixin.dto;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.JsonNodeFactory;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.fasterxml.jackson.datatype.jdk8.Jdk8Module;

import java.util.Optional;

/**
 * Created by tanghong on 2017/3/6.
 */
public class WxNewsMsgResultDto {
    private int errcode;
    private String errmsg;
    private int msg_id;
    private Optional<Integer> msg_data_id;

    public int getErrcode() {
        return errcode;
    }

    public void setErrcode(int errcode) {
        this.errcode = errcode;
    }

    public String getErrmsg() {
        return errmsg;
    }

    public void setErrmsg(String errmsg) {
        this.errmsg = errmsg;
    }

    public Optional<Integer> getMsg_data_id() {
        return msg_data_id;
    }

    public void setMsg_data_id(Optional<Integer> msg_data_id) {
        this.msg_data_id = msg_data_id;
    }

    public int getMsg_id() {
        return msg_id;
    }

    public void setMsg_id(int msg_id) {
        this.msg_id = msg_id;
    }

}

