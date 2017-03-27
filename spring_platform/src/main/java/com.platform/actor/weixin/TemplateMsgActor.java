package com.platform.actor.weixin;

import akka.actor.UntypedActor;
import com.platform.actor.config.AkkaBeanFactory;
import com.platform.actor.dto.SetIndustry;
import com.platform.common.manage.WxCacheManage;
import com.platform.common.weixin.api.TemplateMsgApi;

import java.util.Optional;

import static com.platform.common.configs.CommonConfig.WxConfig.token;

/**
 * Created by tanghong on 2017/3/19.
 */
public class TemplateMsgActor extends UntypedActor {

    private void initTemplateInfo(int storeId){
        WxCacheManage manage =  AkkaBeanFactory.getBean("wxCacheManage");
        Optional<String> tokenOpt = manage.getAuthAccessToken(storeId);
        if (tokenOpt.isPresent()) {
            try {
                TemplateMsgApi.setSpecificIndustry(token);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    private void initTemplateInfo(String token){
        try {
            TemplateMsgApi.setSpecificIndustry(token);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onReceive(Object message) throws Throwable {
        if (message instanceof SetIndustry) {
            SetIndustry msg = (SetIndustry)message;
            initTemplateInfo(msg.getStoreId());
        }
        else if (message instanceof String) {
            initTemplateInfo((String) message);
        }
    }
}
