package com.platform.common.weixin.api;

import com.platform.common.consts.WxConsts;
import com.platform.common.utils.JsonUtils;
import com.platform.common.utils.http.LocalHttpClient;
import com.platform.common.weixin.dto.WxAttentionUserDto;
import com.platform.common.weixin.dto.WxUserTagInfoDto;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import static com.platform.common.consts.WxConsts.WxUrlCons.BASE_API_URI;

/**
 * Created by tanghong on 2017/3/7.
 */
public class UserApi {

    public static Optional<WxUserTagInfoDto> createUserTag(String accessToken, String name)
    throws Exception{
        String location =  BASE_API_URI + "/cgi-bin/groups/create?access_token=" + accessToken;
        HttpPost hp = new HttpPost(location);
        Map<String, Object> map = new HashMap<>();
        Map<String, Object> group = new HashMap<>();
        group.put("name", name);
        map.put("group", group);
        String content = JsonUtils.writeObjAsStr(map);
        StringEntity entity  = new StringEntity(content, ContentType.APPLICATION_JSON);
        hp.setEntity(entity);
        return LocalHttpClient.handleJson(hp, WxUserTagInfoDto.class);
    }

    public static Optional<String> delUserGroup(String accessToken, int groupId)
    throws Exception{
        String location = BASE_API_URI + "/cgi-bin/groups/delete?access_token=" + accessToken;
        HttpPost hp = new HttpPost(location);
        Map<String, Object> map = new HashMap<>();
        Map<String, Object> group = new HashMap<>();
        group.put("id", groupId);
        map.put("group", group);
        String content = JsonUtils.writeObjAsStr(map);
        StringEntity entity  = new StringEntity(content, ContentType.APPLICATION_JSON);
        hp.setEntity(entity);
        return LocalHttpClient.handle(hp);
    }

    /**
     * 获取所有关注用户信息
     * @param accessToken
     * @return
     * @throws Exception
     */
    public static Optional<WxAttentionUserDto> getAttentionUser(String accessToken) {
        String location = BASE_API_URI + "/cgi-bin/user/get?access_token=" + accessToken;
        HttpGet hp = new HttpGet(location);
        try {
            return LocalHttpClient.handleJson(hp, WxAttentionUserDto.class);
        } catch (Exception e) {
            e.printStackTrace();
            return Optional.empty();
        }
    }
}
