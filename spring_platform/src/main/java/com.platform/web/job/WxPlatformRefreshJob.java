package com.platform.web.job;

import akka.actor.ActorRef;
import com.platform.actor.dto.RefreshAppToken;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by tanghong on 2017/3/20.
 */
public class WxPlatformRefreshJob {

    @Autowired
    private ActorRef treatyManageActor;

    private Logger logger = LoggerFactory.getLogger(WxPlatformRefreshJob.class);

    public void execute(){
        logger.info("开始刷新票据!");
        treatyManageActor.tell(new RefreshAppToken(), null);
    }
}
