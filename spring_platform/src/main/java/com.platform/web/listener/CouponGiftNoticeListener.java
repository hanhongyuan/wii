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
import java.util.Optional;

/**
 * Created by tanghong on 10/01/2017.
 */
public class CouponGiftNoticeListener implements ChannelAwareMessageListener {

    private static final Logger logger = Logger.getLogger(CouponGiftNoticeListener.class);

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
            String title = cpaMsg.get("title").toString();
            String remark = Optional.ofNullable(cpaMsg.get("remark")).map(c -> c.toString()).orElse("");
            String storeId = cpaMsg.get("storeId").toString();
            String storeName = cpaMsg.get("storeName").toString();
            String openId = cpaMsg.get("openId").toString();
            String url = cpaMsg.get("url").toString();
            String couponName = cpaMsg.get("couponName").toString();
            String userNme = cpaMsg.get("userName").toString();
            String giveTime = cpaMsg.get("giveTime").toString();

            flag = templateNoticeService.sendCouponGift(title, remark, storeId, url, openId, storeName, userNme, couponName, giveTime);
        } else {
            logger.warn("not a map msg, ingore it.");
        }
      }
}
