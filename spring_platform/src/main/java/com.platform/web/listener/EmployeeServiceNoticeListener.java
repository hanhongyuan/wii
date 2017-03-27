package com.platform.web.listener;

import com.platform.common.consts.SysConsts;
import com.platform.web.service.TemplateNoticeService;
import com.rabbitmq.client.Channel;
import org.apache.log4j.Logger;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.core.ChannelAwareMessageListener;
import org.springframework.amqp.support.converter.MessageConversionException;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Map;

/**
 * Created by tanghong on 06/08/2016.
 */
public class EmployeeServiceNoticeListener implements ChannelAwareMessageListener {

    private static final Logger logger = Logger.getLogger(EmployeeServiceNoticeListener.class);

    @Autowired
    private MessageConverter msgConverter;

    @Autowired
    private TemplateNoticeService templateNoticeService;

    @Override
    public void onMessage(Message message, Channel channel) throws Exception {
        Object obj = null;
        try {
            obj = msgConverter.fromMessage(message);
        } catch (MessageConversionException e) {
            logger.error("convert MQ message error.", e);
        } finally {
            long deliveryTag = message.getMessageProperties().getDeliveryTag();
            if (deliveryTag != SysConsts.DELIVERIED_TAG) {
                channel.basicAck(deliveryTag, false);
                message.getMessageProperties().setDeliveryTag(SysConsts.DELIVERIED_TAG);
                logger.info("revice and ack msg: " + (obj == null ? message : new String((byte[]) obj)));
            }
        }
        if (obj == null) {
            return;
        }
        boolean flag = false;
        if (obj instanceof Map<?, ?>) {
            Map<?, ?> cpaMsg = (Map<?, ?>) obj;
            logger.info("cpaMsg : " + cpaMsg);
            String storeId = cpaMsg.get("storeId").toString();
            String url = cpaMsg.get("url").toString();
            String openId = cpaMsg.get("openId").toString();
            String serviceNmae = cpaMsg.get("serviceNmae").toString();
            String turnType = cpaMsg.get("turnType").toString();
            String title = cpaMsg.get("title").toString();
            String remark = cpaMsg.get("remark").toString();
            flag = templateNoticeService.sendServiceTurn(title, remark, storeId, url, openId, serviceNmae, turnType);
        } else {
            logger.warn("not a map msg, ingore it.");
        }
       /* if (!flag) {
            logger.error("hanler message " + obj + " failed, throw a exception, and it will be retried.");
            throw new RuntimeException("hanler message " + obj + " failed.");
        }*/
    }

}
