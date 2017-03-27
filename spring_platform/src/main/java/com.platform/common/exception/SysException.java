package com.platform.common.exception;

/**
 * 自定义系统异常
 */
public class SysException extends Exception {

    private Integer errorCode = 0;

    public SysException(){
        super();
    }

    public SysException(Throwable cause, Integer code, String msg){
        super(msg, cause);
        this.errorCode = code;
    }

    public Integer getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(int errorCode) {
        this.errorCode = errorCode;
    }
}
