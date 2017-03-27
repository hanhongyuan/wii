package com.platform.web.dto;

/**
 * Created by tanghong on 2017/2/21.
 */
public class ResultDto {
    private int code;
    private Object msg;

    public ResultDto(int code, Object msg){
        this.code = code;
        this.msg = msg;
    }

    @Override
    public String toString(){
        return "ResultDto [code=" + code + ", msg=" + msg + "]";
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public Object getMsg() {
        return msg;
    }

    public void setMsg(Object msg) {
        this.msg = msg;
    }
}
