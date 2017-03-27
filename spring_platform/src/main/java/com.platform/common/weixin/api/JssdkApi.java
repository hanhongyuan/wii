package com.platform.common.weixin.api;

import com.platform.common.consts.WxConsts;
import com.platform.common.utils.DataUtils;
import com.platform.common.utils.http.LocalHttpClient;
import com.platform.common.weixin.dto.WxJssdkTicketDto;
import org.apache.http.client.methods.HttpGet;

import java.util.Optional;

/**
 * Created by tanghong on 2017/3/7.
 */
public class JssdkApi {

    public static Optional<WxJssdkTicketDto> getSdkTicket(
        String  accessToken) throws Exception{
        String location = WxConsts.WxUrlCons.BASE_API_URI +
        "/cgi-bin/ticket/getticket?access_token="+accessToken+"&type=jsapi";
        HttpGet hg = new HttpGet(location);
        return LocalHttpClient.handleJson(hg, WxJssdkTicketDto.class);
    }

    /**
     * 生成JSSDK签名
     * @param noncestr
     * @param jsapi_ticket
     * @param timestamp
     * @param url
     * @return
     */
    public static String spawnSignature(
        String noncestr,
        String jsapi_ticket,
        long timestamp,
        String url) throws Exception {
        if (jsapi_ticket != null && jsapi_ticket.equals("")){
            String str = "jsapi_ticket="+jsapi_ticket+"&noncestr="+noncestr+"&timestamp="+timestamp+"&url="+url;
            return DataUtils.sha1Hex(str);
        }
        else return null;
    }


}
