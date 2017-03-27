package com.platform.web.service;

import com.platform.common.configs.CommonConfig;
import com.platform.common.manage.RedisManage;
import com.platform.common.weixin.api.TokenApi;
import com.platform.common.weixin.dto.WxComponentAccessTokenDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

import static com.platform.common.router.Url.RedisKeyModule.*;

/**
 * Created by tanghong on 2017/3/19.
 */
@Service
public class WxPlatformService {

    @Autowired
    private RedisManage redisManage;

    private Logger logger = LoggerFactory.getLogger(WxPlatformService.class);

    public void renewPlatformTicket(String ticket){
        logger.info("正在更新微信推送ticket......");
        redisManage.del(WX_PLATFORM_COMPONENT_VERIFY_TICKET_KEY);
        redisManage.set(WX_PLATFORM_COMPONENT_VERIFY_TICKET_KEY, ticket.trim());
        redisManage.del(WX_PLATFORM_COMPONENT_VERIFY_TICKET_KEY);
        redisManage.set(WX_PLATFORM_COMPONENT_VERIFY_TICKET_KEY, ticket.trim());
        String comTicket = redisManage.get(WX_PLATFORM_COMPONENT_VERIFY_TICKET_KEY);
        String comAppId = CommonConfig.WxConfig.appId; // 第三平台公众号
        String secret = CommonConfig.WxConfig.secret;
        if (comTicket != null && !comTicket.equals("")) {
            redisManage.del(WX_PLATFORM_COMPONENT_ACCESS_TOKEN_KEY);
            try {
                Optional<WxComponentAccessTokenDto> tokenOpt = TokenApi.getPlatFormAccessToken(comAppId, secret, comTicket);
                if (tokenOpt.isPresent()) {
                    String token = tokenOpt.get().getComponent_access_token();
                    redisManage.set(WX_PLATFORM_COMPONENT_ACCESS_TOKEN_KEY, token);
                    logger.info("redis start set component_access_token:" + token);
                }
            } catch (Exception e) {
                logger.info("redis set component_access_token failure");
                e.printStackTrace();
            }
        }
        else {
            logger.info("redis set platform ticket failure");
        }
    }
}
