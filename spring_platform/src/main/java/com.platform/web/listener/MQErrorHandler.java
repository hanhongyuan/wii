package com.platform.web.listener;

import com.platform.common.manage.RedisManage;
import com.platform.common.router.Url;
import org.apache.commons.lang3.reflect.FieldUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.listener.exception.ListenerExecutionFailedException;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.ErrorHandler;

import java.lang.reflect.Field;

/**
 * Created by tanghong on 2017/3/19.
 */
public class MQErrorHandler implements ErrorHandler {

    private Logger logger = LoggerFactory.getLogger(MQErrorHandler.class);

    @Autowired
    private RedisManage redisManage;

    @Autowired
    private MessageConverter msgConverter;

    @Override
    public void handleError(Throwable t){
        Field fil = FieldUtils.getField(ListenerExecutionFailedException.class, "failedMessage", true);
        if (fil != null) {
            try {
                Message msg = (Message)fil.get(t);
                Object obj = msgConverter.fromMessage(msg);
                logger.error("handle MQ msg: " + obj + " failed, record it to redis.", t);
                redisManage.zadd(Url.MsgErr.MQ_MSG_ERR_RECORD_KEY, Double.valueOf(System.currentTimeMillis()), obj.toString());
            } catch(Exception e){
                logger.info("hand MQ exceoption :" + e.getMessage());
            }
        }
        else {
            logger.error("An error occurred.", t);
        }
    }
}
