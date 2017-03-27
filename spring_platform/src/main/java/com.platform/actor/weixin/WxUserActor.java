package com.platform.actor.weixin;

import akka.actor.UntypedActor;
import akka.remote.transport.ThrottlerTransportAdapter;
import com.platform.actor.config.AkkaBeanFactory;
import com.platform.actor.dto.UserInfoByAppMsg;
import com.platform.actor.dto.UserInfoByStoreMsg;
import com.platform.web.entity.WxAuthStore;
import com.platform.web.entity.WxUserInfo;
import com.platform.web.mapper.WxAuthStoreMapper;
import com.platform.web.mapper.WxUserInfoMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Optional;

/**
 * Created by tanghong on 2017/3/19.
 */
public class WxUserActor extends UntypedActor {

    private Logger logger = LoggerFactory.getLogger(WxUserActor.class);

    @Override
    public void onReceive(Object message) throws Throwable {
        if (message instanceof UserInfoByStoreMsg) {
            UserInfoByStoreMsg msg = (UserInfoByStoreMsg)message;
            addFans(msg.getStoreId(), msg.getOpenid());
        }
        else if (message instanceof UserInfoByAppMsg){
            UserInfoByAppMsg msg = (UserInfoByAppMsg)message;
            addAppFans(msg.getAppId(), msg.getOpenid());
        }
    }

    private void addFans(int storeId, String openid){
        WxUserInfoMapper userInfo = AkkaBeanFactory.getBean("wxUserInfoMapper");
        Optional<WxUserInfo> opt = Optional.ofNullable(userInfo.selectByOpenId(openid));
        if (!opt.isPresent()){
            logger.info("门店"+storeId+"添加一个新粉丝" + openid);
            userInfo.dynamicInsert(new WxUserInfo(storeId, openid));
        }
    }

    private void addAppFans(String appId, String openid){
        WxAuthStoreMapper authStore = AkkaBeanFactory.getBean("wxAuthStoreMapper");
        WxAuthStore auth = authStore.selectAppInfo(appId);
        if (auth != null) {
            addFans(auth.getStoreId(), openid);
        }
    }
}
