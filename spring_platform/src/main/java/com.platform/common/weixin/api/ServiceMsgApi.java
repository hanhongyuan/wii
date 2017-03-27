package com.platform.common.weixin.api;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.platform.common.configs.CommonConfig;
import com.platform.common.consts.WxConsts;
import com.platform.common.utils.http.LocalHttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

/**
 * Created by tanghong on 2017/3/7.
 */
public class ServiceMsgApi {
    /**
     * 客服消息发送
     * @param toUser
     * @param content
     * @param accessToken
     * @return
     */
    public Optional<String> sendServiceMsg(String toUser,  String content, String accessToken)
    throws Exception{
        String location = WxConsts.WxUrlCons.BASE_API_URI + "/cgi-bin/message/custom/send?access_token=" + accessToken;
        HttpPost hp = new HttpPost(location);
        ObjectMapper om = new ObjectMapper();
        Map<String, Object> map = new HashMap<String, Object>();
        Map<String, Object> child = new HashMap<String, Object>();
        map.put("touser", toUser);
        map.put("msgtype", "text");
        child.put("content", content);
        map.put("text", child);
        StringEntity entity = new StringEntity(om.writeValueAsString(map), ContentType.APPLICATION_JSON);
        hp.setEntity(entity);
        return LocalHttpClient.handle(hp);
    }

}
