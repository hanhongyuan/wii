package com.platform.common.weixin.api;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.platform.common.consts.WxConsts;
import com.platform.common.utils.http.LocalHttpClient;
import com.platform.common.weixin.dto.WxPreviewResultDto;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

/**
 * Created by tanghong on 2017/3/7.
 */
public class PreviewApi {
    /**
     * 图文消息预览api
     * @param accessToken
     * @param media_id
     * @param touser
     * @return
     * @throws Exception
     */
    public static Optional<WxPreviewResultDto> sendPervNews(String accessToken, String media_id, String touser)
    throws Exception{
        String location = WxConsts.WxUrlCons.BASE_API_URI
                + "/cgi-bin/message/mass/preview?access_token="+accessToken;
        HttpPost hp = new HttpPost(location);
        Map<String, Object> map = new HashMap<>();
        Map<String, Object> child = new HashMap<>();
        map.put("touser", touser);
        child.put("media_id", media_id);
        map.put("mpnews", child);
        map.put("msgtype", "mpnews");
        ObjectMapper om = new ObjectMapper();
        StringEntity entity = new StringEntity(om.writeValueAsString(map), ContentType.APPLICATION_JSON);
        hp.setEntity(entity);
        return LocalHttpClient.handleJson(hp, WxPreviewResultDto.class);
    }
}
