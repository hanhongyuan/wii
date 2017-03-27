package com.platform.actor.weixin;

import akka.actor.ActorRef;
import akka.actor.UntypedActor;
import com.platform.actor.config.AkkaBeanFactory;
import com.platform.actor.dto.UserInfoByStoreMsg;
import com.platform.actor.dto.WxPushMsg;
import com.platform.common.consts.Consts;
import com.platform.common.consts.WxConsts;
import com.platform.common.utils.JsonUtils;
import com.platform.common.weixin.model.BaseMsgOut;
import com.platform.common.weixin.model.OutTextMsg;
import com.platform.web.entity.WxTextReply;
import com.platform.web.mapper.WxTextReplyMapper;
import com.platform.web.service.WxReplyService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

/**
 * Created by tanghong on 2017/3/19.
 */
public class AutoReplyMsgActor extends UntypedActor {
    private Logger logger = LoggerFactory.getLogger(AutoReplyMsgActor.class);

    @Override
    public void onReceive(Object message){
        if (message instanceof String) {
            String msg = (String)message;
            logger.info("receive zefun msg:" + msg);
            try {
                WxPushMsg push = JsonUtils.readObj(msg, WxPushMsg.class);
                if (push.getMac().equals("getWxAutoReply")) {
                    String toUser = push.getToUser();
                    String fromUser = push.getFromUser();
                    int storeId = push.getStoreId();
                    WxTextReplyMapper reply = AkkaBeanFactory.getBean("wxTextReplyMapper");
                    WxReplyService service = AkkaBeanFactory.getBean("wxReplyService");
                    Map<String, Integer> query = new HashMap<>();
                    query.put( "storeId", storeId);
                    String content = "";
                    if (push.getEventType().equals(WxConsts.EventCons.EVT_SUBSCRIBE)) {
                        ActorRef wxUserActor = AkkaBeanFactory.getBean("wxUserActor");
                        wxUserActor.tell(new UserInfoByStoreMsg(storeId, toUser), null);
                        query.put("category", Consts.WxAutoReplyCons.subscribeReply);
                        WxTextReply txt =  reply.selectByCategory(query);
                        if (txt != null) {
                            content = new OutTextMsg(toUser, fromUser, txt.getContent()).toXml();
                        }
                    }
                    else if (push.getEventType().equals(WxConsts.MsgTypeCons.CUSTOM_MSG_TEXT)) {
                        Optional<BaseMsgOut> out = service.provideQueryKeyword(toUser, fromUser, push.getContent(), storeId);
                        if (out.isPresent()) {
                            content = out.get().toXml();
                        }
                        else {
                            query.put("category", Consts.WxAutoReplyCons.msgReply);
                            WxTextReply txt =  reply.selectByCategory(query);
                            if (txt != null) {
                                content = new OutTextMsg(toUser, fromUser, txt.getContent()).toXml();
                            }
                        }
                    }
                    logger.info("回复内容:" + content);
                    sender().tell(content, getSelf());
                }
                else {
                    sender().tell("", getSelf());
                }
            }catch (Exception e){
                e.printStackTrace();
                sender().tell("", getSelf());

            }
        }
    }

}
