package com.platform.common.weixin.api;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.platform.common.consts.WxConsts;
import com.platform.common.utils.http.LocalHttpClient;
import com.platform.common.weixin.dto.WxNewsMsgResultDto;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;

import java.util.HashMap;
import java.util.List;
import java.util.Optional;

/**
 * Created by tanghong on 2017/3/6.
 */
public class NewsMsgApi {

    public static Optional<WxNewsMsgResultDto> sendNewsByOpenIds(String accessToken, String mediaId, List<String> touser)
    throws Exception {
        String location = WxConsts.WxUrlCons.BASE_API_URI + "/cgi-bin/message/mass/send?access_token=" + accessToken;
        HttpPost hp = new HttpPost(location);
        ObjectMapper om = new ObjectMapper();
        HashMap<String, Object> map = new HashMap<String, Object>();
        HashMap<String, Object> child = new HashMap<String, Object>();
        child.put("media_id", mediaId);
        map.put("touser", touser);
        map.put("mpnews", child);
        map.put("msgtype", "mpnews");
        String content = om.writeValueAsString(map);
        StringEntity entity = new StringEntity(content, ContentType.APPLICATION_JSON);
        hp.setEntity(entity);
        return LocalHttpClient.handleJson(hp, WxNewsMsgResultDto.class);
    }

}
