package com.platform.actor.weixin;

import akka.actor.UntypedActor;
import com.platform.actor.config.AkkaBeanFactory;
import com.platform.actor.dto.DelPlatformAppToken;
import com.platform.actor.dto.RefreshAppToken;
import com.platform.actor.dto.UpPlatformAppToken;
import com.platform.actor.dto.UpPlatformTicket;
import com.platform.common.configs.CommonConfig;
import com.platform.common.exception.WxException;
import com.platform.common.manage.RedisManage;
import com.platform.common.manage.WxCacheManage;
import com.platform.common.weixin.api.JssdkApi;
import com.platform.common.weixin.api.PlatformApi;
import com.platform.common.weixin.api.TokenApi;
import com.platform.common.weixin.dto.WxComponentAccessTokenDto;
import com.platform.common.weixin.dto.WxJssdkTicketDto;
import com.platform.common.weixin.dto.WxRefreshAuthorizerAccessTokenDto;
import com.platform.web.entity.WxAuthStore;
import com.platform.web.mapper.WxAuthStoreMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Optional;

import static com.platform.common.router.Url.RedisKeyModule.*;

/**
 * Created by tanghong on 2017/3/19.
 */
public class TreatyManageActor extends UntypedActor {

    private Logger logger = LoggerFactory.getLogger(TreatyManageActor.class);

    @Override
    public void onReceive(Object message) throws Throwable {
        if (message instanceof UpPlatformTicket) {
            UpPlatformTicket msg = (UpPlatformTicket)message;
            renewPlatformTicket(msg.getTicket());
        }
        else if (message instanceof UpPlatformAppToken) {
            UpPlatformAppToken msg = (UpPlatformAppToken)message;
            setAppToken(msg);
        }
        else if (message instanceof DelPlatformAppToken) {
            DelPlatformAppToken msg = (DelPlatformAppToken)message;
            delAppToken(msg);
        }
        else if (message instanceof RefreshAppToken) {
            refreshPlatformToken();
        }
    }

    private void renewPlatformTicket(String ticket){
        RedisManage redisManage = AkkaBeanFactory.getBean("redisManage");
        redisManage.del(WX_PLATFORM_COMPONENT_VERIFY_TICKET_KEY);
        redisManage.set(WX_PLATFORM_COMPONENT_VERIFY_TICKET_KEY, ticket.trim());
        String comTicket = redisManage.get(WX_PLATFORM_COMPONENT_VERIFY_TICKET_KEY);
        String comAppId = CommonConfig.WxConfig.appId; // 第三平台公众号
        String secret = CommonConfig.WxConfig.secret;
        if (comTicket != null && !comTicket.equals("")) {
            redisManage.del(WX_PLATFORM_COMPONENT_ACCESS_TOKEN_KEY);
            try {
                Optional<WxComponentAccessTokenDto>  tokenOpt = TokenApi.getPlatFormAccessToken(comAppId, secret, comTicket);
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

    private void setAppToken(UpPlatformAppToken msg){
        int storeId = msg.getStoreId();
        RedisManage redisManage = AkkaBeanFactory.getBean("redisManage");
        redisManage.hdel(WX_PLATFORM_AUTHORIZER_STORE_ACCESS_TOKEN_HASH_KEY, storeId);
        redisManage.hset(WX_PLATFORM_AUTHORIZER_STORE_ACCESS_TOKEN_HASH_KEY, storeId, msg.getAuthAccessToken());

        redisManage.hdel(WX_PLATFORM_STORE_WECHAT_APP_ID_KEY_HASH_KEY, storeId);
        redisManage.hset(WX_PLATFORM_STORE_WECHAT_APP_ID_KEY_HASH_KEY, storeId, msg.getAppId());

        redisManage.hdel(WX_PLATFORM_AUTHORIZER_STORE_REFRESH_TOKEN_HASH_KEY, storeId);
        redisManage.hset(WX_PLATFORM_AUTHORIZER_STORE_REFRESH_TOKEN_HASH_KEY, storeId, msg.getRefreshAccessToken());
    }

    private void delAppToken(DelPlatformAppToken msg){
        WxAuthStoreMapper wxAuthStoreMapper = AkkaBeanFactory.getBean("wxAuthStoreMapper");
        WxAuthStore auth = wxAuthStoreMapper.selectAppInfo(msg.getAppId());
        RedisManage redisManage = AkkaBeanFactory.getBean("redisManage");
        if (auth != null) {
            int storeId = auth.getStoreId();
            logger.info("门店"+storeId+"正在取消授权.......");
            redisManage.hdel(WX_PLATFORM_AUTHORIZER_STORE_ACCESS_TOKEN_HASH_KEY, storeId);
            redisManage.hdel(WX_PLATFORM_STORE_WECHAT_APP_ID_KEY_HASH_KEY, storeId);
            redisManage.hdel(WX_PLATFORM_AUTHORIZER_STORE_REFRESH_TOKEN_HASH_KEY, storeId);
            redisManage.hdel(WX_PLATFORM_STORE_JS_SDK_TICKET_HASH_KEY, storeId);
        }
    }

    private void refreshPlatformToken(){
        logger.info("start refresh platform token ......");
        WxCacheManage manage = AkkaBeanFactory.getBean("wxCacheManage");
        RedisManage redisManage = AkkaBeanFactory.getBean("redisManage");
        manage.getCacheStores().stream().forEach( v -> {
            int storeId = Integer.valueOf(v);
            Optional<String> appOpt = manage.getCacheAppId(storeId);
            Optional<String> tokenOpt = manage.getComponentAccessToken();
            Optional<String> refreshOpt = manage.getRefreshAccessToken(storeId);
            if (appOpt.isPresent()&&tokenOpt.isPresent()&&refreshOpt.isPresent()){
                try {
                    Optional<WxRefreshAuthorizerAccessTokenDto> dtoOpt =
                    PlatformApi.refreshAuthorizerAccessToken(
                      tokenOpt.get(),
                      CommonConfig.WxConfig.appId,
                      appOpt.get(),
                      refreshOpt.get()
                    );
                    if (dtoOpt.isPresent()) {
                        String authAccessToken = dtoOpt.get().getAuthorizer_access_token();
                        logger.info("正在刷新公众号授权码:" + authAccessToken);
                        redisManage.hdel(WX_PLATFORM_AUTHORIZER_STORE_ACCESS_TOKEN_HASH_KEY, storeId);
                        redisManage.hset(WX_PLATFORM_AUTHORIZER_STORE_ACCESS_TOKEN_HASH_KEY, storeId, authAccessToken);

                        Optional<WxJssdkTicketDto> sdkOpt = JssdkApi.getSdkTicket(authAccessToken);
                        if (sdkOpt.isPresent()) {
                            String ticket = sdkOpt.get().getTicket();
                            logger.info("正在刷新JSSDK票据:" + ticket);
                            redisManage.hdel(WX_PLATFORM_STORE_JS_SDK_TICKET_HASH_KEY, storeId);
                            redisManage.hset(WX_PLATFORM_STORE_JS_SDK_TICKET_HASH_KEY, storeId, ticket);
                        }
                    }

                }
                catch (WxException e){
                    WxJssdkTicketDto sdk = e.toObj(WxJssdkTicketDto.class);
                    if (sdk != null) {
                        String ticket = sdk.getTicket();
                        logger.info("正在刷新JSSDK票据: " + ticket);
                        redisManage.hdel(WX_PLATFORM_STORE_JS_SDK_TICKET_HASH_KEY, storeId);
                        redisManage.hset(WX_PLATFORM_STORE_JS_SDK_TICKET_HASH_KEY, storeId, ticket);
                    }
                }
                catch (Exception e) {
                    logger.info("JSSDk票据刷新异常");
                    e.printStackTrace();
                }
            }
        });
    }

}
