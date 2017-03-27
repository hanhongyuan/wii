package com.platform.common.weixin.api;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.platform.common.consts.WxConsts;
import com.platform.common.utils.http.LocalHttpClient;
import com.platform.common.weixin.dto.WxAccessTokenDto;
import com.platform.common.weixin.dto.WxComponentAccessTokenDto;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

/**
 * Created by tanghong on 2017/3/7.
 */
public class TokenApi {
    /**
     * 获取第三方平台的 access_token
     */
    public static Optional<WxComponentAccessTokenDto> getPlatFormAccessToken(String appId, String secret, String ticket)
    throws Exception{
        String location = WxConsts.WxUrlCons.PLAT_BASE_API_URL + "api_component_token";
        HttpPost hp = new HttpPost(location);
        Map<String, String> map = new HashMap<>();
        map.put("component_appid", appId);
        map.put("component_appsecret", secret);
        map.put("component_verify_ticket", ticket);
        ObjectMapper om = new ObjectMapper();
        StringEntity entity = new StringEntity(om.writeValueAsString(map), ContentType.APPLICATION_JSON);
        hp.setEntity(entity);
        return LocalHttpClient.handleJson(hp, WxComponentAccessTokenDto.class);
    }

    /**
     * 获取普通公众号的 access_token
     * @return
     */
    public static Optional<WxAccessTokenDto> getCommonAccessToken(String appId, String secret)
    throws Exception{
        String location = WxConsts.WxUrlCons.BASE_API_URI +
            "/cgi-bin/token?grant_type=client_credential&appid="+appId+"&secret="+secret;
        HttpGet hp = new HttpGet(location);
        return LocalHttpClient.handleJson(hp, WxAccessTokenDto.class);
    }
}
