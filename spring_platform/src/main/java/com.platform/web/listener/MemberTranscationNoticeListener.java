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
 * Created by tanghong on 06/08/2016.
 */
public class MemberTranscationNoticeListener implements ChannelAwareMessageListener {

    private static final Logger logger = Logger.getLogger(MemberTranscationNoticeListener.class);

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
            String type = cpaMsg.get("type") != null ? cpaMsg.get("type").toString() : "";
            String title = Optional.ofNullable(cpaMsg.get("title")).map(m -> m.toString()).orElse("");
            String remark = Optional.ofNullable(cpaMsg.get("remark")).map(m -> m.toString()).orElse("");
            String url = cpaMsg.get("url").toString();
            String storeId = cpaMsg.get("storeId").toString();
            String openId = cpaMsg.get("openId").toString();
            String storeName = cpaMsg.get("storeName").toString();
            String phone = cpaMsg.get("phone").toString();
            String projectName = cpaMsg.get("projectName").toString();
            String comboProjectList = cpaMsg.get("comboProjectList") != null ? cpaMsg.get("comboProjectList").toString() : "";
            String goodsList = cpaMsg.get("goodsList") != null ? cpaMsg.get("goodsList").toString() : "";
            String comboList = cpaMsg.get("comboList") != null ? cpaMsg.get("comboList").toString() : "";
            String receivableAmount = Optional.ofNullable(cpaMsg.get("receivableAmount")).map(m -> m.toString()).orElse("");
            String discountAmount = Optional.ofNullable(cpaMsg.get("discountAmount")).map(m -> m.toString()).orElse("");
            String payTime = cpaMsg.get("payTime").toString();
            String debtAmount = cpaMsg.get("debtAmount") != null ? cpaMsg.get("debtAmount").toString() : "";
            String balanceAmount = cpaMsg.get("balanceAmount") != null ? cpaMsg.get("balanceAmount").toString() : "";
            String balanceIntegral = cpaMsg.get("balanceIntegral") != null ? cpaMsg.get("balanceIntegral").toString() : "";
            String integralNumber = cpaMsg.get("integralNumber") != null ? cpaMsg.get("integralNumber").toString() : "";
            flag = templateNoticeService.sendPaymentNotice(title, remark, storeId, url, openId, storeName,
                    phone, projectName, receivableAmount, discountAmount, balanceAmount, balanceIntegral, debtAmount, integralNumber, payTime, type,
                    comboProjectList, goodsList, comboList);
        } else {
            logger.warn("not a map msg, ingore it.");
        }
        /*if (!flag) {
            logger.error("hanler message " + obj + " failed, throw a exception, and it will be retried.");
            throw new RuntimeException("hanler message " + obj + " failed.");
        }*/
    }

}