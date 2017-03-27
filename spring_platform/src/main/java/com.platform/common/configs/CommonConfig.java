package com.platform.common.configs;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
/**
 * Created by tanghong on 2017/3/6.
 */
@Configuration
@PropertySource("classpath:application.yml")
public class CommonConfig implements InitializingBean {

    @Value("${weixin.platform.appid}")
    String appId;

    @Value("${weixin.platform.secret}")
    String secret;

    @Value("${weixin.platform.token}")
    String token;

    @Value("${weixin.platform.aeskey}")
    String aesKey;

    @Value("${weixin.platform.host}")
    String domain;

    public static class WxConfig{
        public static String domain;
        public static String appId;
        public static String token;
        public static String aesKey;
        public static String secret;
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        WxConfig.domain = domain;
        WxConfig.appId = appId;
        WxConfig.token = token;
        WxConfig.aesKey = aesKey;
        WxConfig.secret = secret;
    }
}
