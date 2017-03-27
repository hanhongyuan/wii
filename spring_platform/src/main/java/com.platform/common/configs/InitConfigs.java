package com.platform.common.configs;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Component;

/**
 * Created by tanghong on 2017/3/19.
 */
@Component
public class InitConfigs implements InitializingBean {

    @Override
    public void afterPropertiesSet() throws Exception {
        //wxReplyMsgActorSystem.actorOf(AutoReplyMsgActor.props, "autoReplyMsgActor")
    }
}
