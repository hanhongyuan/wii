package com.platform.actor.config;

import akka.actor.ActorRef;
import akka.actor.ActorSystem;
import akka.actor.Props;
import com.platform.actor.weixin.*;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

/**
 * Created by tanghong on 2017/3/10.
 */
@Service
public class ActorFactory {
    private static ActorSystem getActorSystem(String name) {
        return (ActorSystem) AkkaBeanFactory.getBean(name);
    }

    @Bean(name="wxUserActor")
    public ActorRef getWxUserActor(){
        return getActorSystem("wxActorSystem").actorOf(Props.create(WxUserActor.class), "wx-user-actor");
    }

    @Bean(name="autoReplyMsgActor")
    public ActorRef getAutoReplyMsgActor(){
        return getActorSystem("wxRemoteMsgSystem").actorOf(Props.create(AutoReplyMsgActor.class), "auto-reply-actor");
    }

    @Bean(name="templateMsgActor")
    public ActorRef getTemplateMsgActor(){
        return getActorSystem("wxActorSystem").actorOf(Props.create(TemplateMsgActor.class), "template-msg-actor");
    }

    @Bean(name="treatyManageActor")
    public ActorRef getTreatyManageActor(){
        return getActorSystem("wxActorSystem").actorOf(Props.create(TreatyManageActor.class), "treaty-manage-actor");
    }

    @Bean(name="menuActor")
    public ActorRef getMenuActor(){
        return getActorSystem("wxActorSystem").actorOf(Props.create(MenuActor.class), "menu-actor");
    }




}
