package com.platform.common.weixin.api;

import com.platform.common.consts.WxConsts;
import com.platform.common.utils.http.LocalHttpClient;
import com.platform.common.weixin.dto.WxWebAccessTokenDto;
import com.platform.common.weixin.dto.WxWebUserInfoDto;
import org.apache.http.client.methods.HttpGet;

import java.util.Optional;

/**
 * Created by tanghong on 2017/3/7.
 */
public class WebAuthApi {

    /**
     * 获取网页授权url
     * @param appId
     * @param url
     * @param scope
     * @return
     */
    public static String getWebAuthCodeUrl(
        String appId,
        String url,
        String scope){
        return WxConsts.WxUrlCons.OPEN_URI + "/connect/oauth2/authorize?appid="+appId+
        "&redirect_uri="+url+"&response_type=code&scope="+scope+"&state=123#wechat_redirect";
    }

    /**
     * 获取网页授权accesstoken
     * @param appId
     * @param secret
     * @param code
     * @return
     */
    public static Optional<WxWebAccessTokenDto> getWebAccessToken(
        String appId,
        String secret,
        String code) throws Exception{
        String location = WxConsts.WxUrlCons.BASE_API_URI + "/sns/oauth2/access_token?appid="+appId+
        "&secret="+secret+"&code="+code+"&grant_type=authorization_code";
        HttpGet hg = new HttpGet(location);
        return LocalHttpClient.handleJson(hg, WxWebAccessTokenDto.class);
    }

    /**
     * 获取网页授权用户信息
     * @param access_token
     * @param openid
     * @return
     */
    public static Optional<WxWebUserInfoDto> getWebUserInfo(
        String access_token,
        String openid) throws Exception{
        String location = WxConsts.WxUrlCons.BASE_API_URI + "/sns/userinfo?access_token="+access_token+
        "&openid="+openid+"&lang=zh_CN";
        HttpGet hg = new HttpGet(location);
        return LocalHttpClient.handleJson(hg, WxWebUserInfoDto.class);
    }


    ////////////////////////
    ////第三平台网页授权API////
    ///////////////////////

    /**
     * 获取平台授权码url
     * @param appId
     * @param comAppId
     * @param redirectUri
     * @param actionScope 授权方式 snsapi_userinfo 弹出授权页面; snsapi_base不弹出授权页面
     * @return
     */
    public static String getTerraceWebAuthCodeUrl(
        String appId, String comAppId, String redirectUri,
        String actionScope){
        return "https://open.weixin.qq.com/connect/oauth2/authorize?appid="+appId+"&redirect_uri="+redirectUri+
        "&response_type=code&scope="+actionScope+"&state=123&component_appid="+comAppId+"#wechat_redirect";
    }

    /**
     * 获取网页授权access_token
     * @param appId 公众号appid
     * @param code 授权码
     * @param comAppId 第三方平台component_appid
     * @param comAccessToken 第三方平台授权码
     * @return
     */
    public static Optional<WxWebAccessTokenDto> getTerraceWebAccessToken(
        String appId, String code,
        String comAppId,
        String comAccessToken) throws Exception {
        String location = "https://api.weixin.qq.com/sns/oauth2/component/access_token?" +
                "appid="+appId+"&code="+code+"&grant_type=authorization_code&component_appid=" +
                comAppId + "&component_access_token=" + comAccessToken;
        // 这里可以拿到unid需要验证
        HttpGet hg = new HttpGet(location);
        return LocalHttpClient.handleJson(hg, WxWebAccessTokenDto.class);
    }

    /**
     * 刷新网页授权access_token
     */
    public static Optional<WxWebAccessTokenDto> refreshTerraceWebAccessToken(
        String appId,
        String refreshToken,
        String comAppId,
        String comAccessToken) throws Exception{
        String location = "https://api.weixin.qq.com/sns/oauth2/component/refresh_token?appid="+appId+"&"
                + "grant_type=authorization_code&component_appid=" +comAppId+
                "&component_access_token="+comAccessToken+"&refresh_token="+refreshToken;
        HttpGet hg = new HttpGet(location);
        return LocalHttpClient.handleJson(hg, WxWebAccessTokenDto.class);
    }

    /**
     * 获取网页授权用户信息 要求scope必须为snsapi_userinfo
     */
    public static Optional<WxWebUserInfoDto> getTerraceWebUserInfo(
        String webAccessToken, String openid) throws Exception {
        String location = "https://api.weixin.qq.com/sns/userinfo?access_token="+webAccessToken+"&openid="+
        openid +"&lang=zh_CN";
        HttpGet hg = new HttpGet(location);
        return LocalHttpClient.handleJson(hg, WxWebUserInfoDto.class);
    }

}
