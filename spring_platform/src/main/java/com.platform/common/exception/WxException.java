package com.platform.common.exception;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.util.Optional;

/**
 * Created by tanghong on 2017/3/6.
 */
public class WxException extends Exception {

    private String content;

    private Logger logger = LoggerFactory.getLogger(WxException.class);

    public WxException(String content){
        this.content = content;
    }

    public void log(){
        ObjectMapper om = new ObjectMapper();
        try {
            int errcode = om.readTree(content).get("errcode").asInt();
            if (errcode == 0){
                logger.info("weixin handle success: " + content);
            }
            else logger.error("weixin handle failure: " + content);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public <T> T toObj(Class<T> t){
       ObjectMapper om = new ObjectMapper();
        try {
            return om.readValue(content, t);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

}
