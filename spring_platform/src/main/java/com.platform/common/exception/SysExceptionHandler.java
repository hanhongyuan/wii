package com.platform.common.exception;


import com.platform.web.dto.ResultDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 全局异常处理
 */
@ControllerAdvice
@RestController
public class SysExceptionHandler {

    Logger logger = LoggerFactory.getLogger(SysExceptionHandler.class);

    @ExceptionHandler(RuntimeException.class)
    public ResultDto runOperateExp(
        RuntimeException ex,
        HttpServletRequest req,
        HttpServletResponse res){
        ex.printStackTrace();
        int code = SysExcCode.SysExcCodeModule.SYS_ERROR;
        res.setStatus(code);
        return new ResultDto(code, ex.getMessage());
    }

    @ExceptionHandler(SysException.class)
    public ResultDto sysOperateExp(
        SysException se,
        HttpServletRequest req,
        HttpServletResponse res){
        Integer code = se.getErrorCode();
        String msg = se.getMessage();
        se.printStackTrace();
        if (code != null) {
            res.setStatus(code);
        }
        else {
            code = -1;
        }
        return new ResultDto(code, msg);
    }

}
