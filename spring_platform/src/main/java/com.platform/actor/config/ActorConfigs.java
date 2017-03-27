package com.platform.actor.config;

import akka.actor.ActorSystem;
import com.typesafe.config.ConfigFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by tanghong on 2017/3/10.
 */
@Configuration
public class ActorConfigs {

    @Bean(name = "wxRemoteMsgSystem")
    public ActorSystem remoteMsgActorSystem(){
        return ActorSystem.create("wxRemoteMsgSystem", ConfigFactory.parseResources("configs/akka.conf"));
    }

    @Bean(name="wxActorSystem")
    public ActorSystem wxActorSystem(){
        return ActorSystem.create("wxActorSystem");
    }
}
