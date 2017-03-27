package com.platform.web.listener;

import com.platform.common.consts.SysConsts;
import com.platform.common.router.Url;
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
 * Created by tanghong on 2017/2/7.
 */
public class MemberVisitNoticeListener implements ChannelAwareMessageListener {
    private static final Logger logger = Logger.getLogger(MemberVisitNoticeListener.class);

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
        String visitId = null;
        try {
            if (obj instanceof Map<?, ?>) {
                Map<?, ?> cpaMsg = (Map<?, ?>) obj;
                logger.info("cpaMsg : " + cpaMsg);
                String title = Optional.ofNullable(cpaMsg.get("title")).map(m -> m.toString()).orElse("");
                String remark = Optional.ofNullable(cpaMsg.get("remark")).map(m -> m.toString()).orElse("");
                visitId = cpaMsg.get("visitId").toString();
                String storeId = cpaMsg.get("storeId").toString();
                String teletextId = cpaMsg.get("teletextId").toString();
                String openId = cpaMsg.get("openId").toString();
                String projectName = cpaMsg.get("projectName").toString();
                String visitTitle = Optional.ofNullable(cpaMsg.get("visitTitle")).map(m -> m.toString()).orElse("");
                String url = Url.WxPromotionModule.APP_MARKETING_HOME
                        + "material/news/show/content?teletextId=" + teletextId;
                flag = templateNoticeService.sendMemberVisit(title, remark, storeId, url, openId, projectName, visitTitle);
            } else {
                logger.warn("not a map msg, ingore it.");
            }
        } catch (Exception e){
            throw e;
        }
        /*if (!flag) {
            logger.error("hanler message " + obj + " failed, throw a exception, and it will be retried.");
            throw new RuntimeException("hanler message " + obj + " failed.");
        }*/
    }

}
