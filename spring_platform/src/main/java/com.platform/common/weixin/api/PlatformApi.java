package com.platform.common.weixin.api;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.platform.common.consts.WxConsts;
import com.platform.common.utils.JsonUtils;
import com.platform.common.utils.http.LocalHttpClient;
import com.platform.common.weixin.dto.*;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

/**
 * Created by tanghong on 2017/3/7.
 */
public class PlatformApi {

    /**
     * 获取预授权码
     */
    public static Optional<WxPreAuthDto> getPreAuthcode(
        String component_access_token,
        String component_appid) throws Exception{
        String location = WxConsts.WxUrlCons.PLAT_BASE_API_URL +
        "api_create_preauthcode?component_access_token=" + component_access_token;

        Map<String, String> map = new HashMap<>();
        map.put("component_appid", component_appid);

        HttpPost hp = new HttpPost(location);
        StringEntity entity = new StringEntity(JsonUtils.writeObjAsStr(map), ContentType.APPLICATION_JSON);
        hp.setEntity(entity);
        return LocalHttpClient.handleJson(hp, WxPreAuthDto.class);
    }

    /**
     * 使用授权码换取公众号信息
     */
    public static Optional<WxAuthorizationDataDto> getAuthorizerInfo(
        String component_access_token,
        String component_appid,
        String authorization_code) throws Exception{
        String location = WxConsts.WxUrlCons.PLAT_BASE_API_URL +
        "api_query_auth?component_access_token=" + component_access_token;

        Map<String, String> map = new HashMap<>();
        map.put("component_appid", component_appid);
        map.put("authorization_code", authorization_code);

        HttpPost hp = new HttpPost(location);
        StringEntity entity = new StringEntity(JsonUtils.writeObjAsStr(map), ContentType.APPLICATION_JSON);
        hp.setEntity(entity);
        return LocalHttpClient.handleJson(hp,  WxAuthorizationDataDto.class);
    }

    /**
     * 刷新授权公众号令牌
     */
    public static Optional<WxRefreshAuthorizerAccessTokenDto> refreshAuthorizerAccessToken(
        String component_access_token,
        String component_appid,
        String authorizer_appid,
        String authorizer_refresh_token) throws Exception{
        String location = WxConsts.WxUrlCons.PLAT_BASE_API_URL +
        "api_authorizer_token?component_access_token=" + component_access_token;

        Map<String, String> map = new HashMap<>();
        map.put("component_appid", component_appid);
        map.put("authorizer_appid", authorizer_appid);
        map.put("authorizer_refresh_token", authorizer_refresh_token);

        HttpPost hp = new HttpPost(location);
        StringEntity entity = new StringEntity(JsonUtils.writeObjAsStr(map), ContentType.APPLICATION_JSON);
        hp.setEntity(entity);
        return LocalHttpClient.handleJson(hp, WxRefreshAuthorizerAccessTokenDto.class);
    }

    /**
     * 获取授权方账户信息
     */
    public static Optional<WxAuthorizerAccountInfoDto> getAuthorizerAccountInfo(
        String component_access_token,
        String component_appid,
        String authorizer_appid) throws Exception {
        String location = WxConsts.WxUrlCons.PLAT_BASE_API_URL +
        "api_get_authorizer_info?component_access_token=" + component_access_token;

        Map<String, String> map = new HashMap<>();
        map.put("component_appid", component_appid);
        map.put("authorizer_appid", authorizer_appid);

        HttpPost hp = new HttpPost(location);
        StringEntity entity = new StringEntity(JsonUtils.writeObjAsStr(map), ContentType.APPLICATION_JSON);
        hp.setEntity(entity);
        return LocalHttpClient.handleJson(hp, WxAuthorizerAccountInfoDto.class);
    }

    /**
     * 获取授权方设置信息
     */
    public static Optional<WxAuthorizerOptionInfoDto> getAuthorizerOptionInfo(
        String component_access_token,
        String component_appid,
        String authorizer_appid,
        String option_name) throws Exception{
        String location = WxConsts.WxUrlCons.PLAT_BASE_API_URL +
        "api_get_authorizer_option?component_access_token=" + component_access_token;

        Map<String, String> map = new HashMap<>();
        map.put("component_appid", component_appid);
        map.put("authorizer_appid", authorizer_appid);
        map.put("option_name", option_name);

        HttpPost hp = new HttpPost(location);
        StringEntity entity = new StringEntity(JsonUtils.writeObjAsStr(map), ContentType.APPLICATION_JSON);
        hp.setEntity(entity);
        return LocalHttpClient.handleJson(hp, WxAuthorizerOptionInfoDto.class);
    }

    /**
     * 设置授权方选项信息
     */
    public static Optional<WxResultDto> setAuthorizerOptionInfo(
        String component_access_token,
        String component_appid,
        String authorizer_appid,
        String option_name,
        String option_value) throws Exception{
        String location = WxConsts.WxUrlCons.PLAT_BASE_API_URL +
        "api_set_authorizer_option?component_access_token=" + component_access_token;

        Map<String, String> map = new HashMap<>();
        map.put("component_appid", component_appid);
        map.put("authorizer_appid", authorizer_appid);
        map.put("option_name", option_name);
        map.put("option_value", option_value);

        HttpPost hp = new HttpPost(location);
        StringEntity entity = new StringEntity(JsonUtils.writeObjAsStr(map), ContentType.APPLICATION_JSON);
        hp.setEntity(entity);
        return LocalHttpClient.handleJson(hp, WxResultDto.class);
    }

}
