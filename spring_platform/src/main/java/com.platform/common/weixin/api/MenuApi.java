package com.platform.common.weixin.api;

import com.platform.common.consts.WxConsts;
import com.platform.common.utils.http.LocalHttpClient;
import com.platform.common.weixin.dto.WxResultDto;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;

import java.util.Optional;

/**
 * Created by tanghong on 2017/3/7.
 */
public class MenuApi {

    public static Optional<WxResultDto> createMenu(String menus, String accessToken)
    throws Exception{
        String location = WxConsts.WxUrlCons.BASE_API_URI + "/cgi-bin/menu/create?access_token=" + accessToken;
        HttpPost hp = new HttpPost(location);
        StringEntity entity = new StringEntity(menus, ContentType.APPLICATION_JSON);
        hp.setEntity(entity);
        return LocalHttpClient.handleJson(hp, WxResultDto.class);
    }

    public static Optional<WxResultDto> deleteMenu(String accessToken)
    throws Exception{
        String location = WxConsts.WxUrlCons.BASE_API_URI + "/cgi-bin/menu/delete?access_token=" + accessToken;
        HttpGet hg = new HttpGet(location);
        return LocalHttpClient.handleJson(hg, WxResultDto.class);
    }
}
