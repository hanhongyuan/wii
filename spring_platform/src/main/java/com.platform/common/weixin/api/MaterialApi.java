package com.platform.common.weixin.api;

import com.platform.common.consts.WxConsts;
import com.platform.common.utils.IOUtils;
import com.platform.common.utils.JsonUtils;
import com.platform.common.utils.http.LocalHttpClient;
import com.platform.common.weixin.dto.*;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;

import javax.swing.text.html.Option;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

/**
 * Created by tanghong on 2017/3/7.
 */
public class MaterialApi {
    //上传图文内容图片
    public static Optional<WxNewsContentImgUrlDto> addNewsContentImgUrl(
        String  accessToken, String imgUrl ) throws Exception{
        WxFileDto file = IOUtils.getInputStream(imgUrl);
        String location = WxConsts.WxUrlCons.BASE_API_URI + "/cgi-bin/media/uploadimg?access_token=" + accessToken;
        return LocalHttpClient.handleWxUpload(location,
            file.getFileStream(),
            file.getFileName(),
            WxNewsContentImgUrlDto.class
        );
    }

    //上传图文内容图片
    public static Optional<WxNewsContentImgUrlDto> addNewsContentImgUrl(
        String accessToken,
        byte[] file,
        String fileName)throws Exception{
        String location = WxConsts.WxUrlCons.BASE_API_URI + "/cgi-bin/media/uploadimg?access_token=" + accessToken;
        return LocalHttpClient.handleWxUpload(location, file, fileName, WxNewsContentImgUrlDto.class);
    }

    // 添加临时素材
    public static Optional<WxMediaInfoDto> addTemporaryMaterial(
        String accessToken,
        byte[] inputStream,
        String fileName,
        String category) throws Exception{
        String location = WxConsts.WxUrlCons.BASE_API_URI + "/cgi-bin/media/upload?access_token="+
        accessToken +"&type=" + category;
        return LocalHttpClient.handleWxUpload(location, inputStream, fileName, WxMediaInfoDto.class);
    }

    // 添加永久图片
    public static Optional<WxMediaInfoDto> addImgMaterial(
        String accessToken,
        byte[] inputStream,
        String fileName,
        String category)throws Exception{
        String location = WxConsts.WxUrlCons.BASE_API_URI + "/cgi-bin/material/add_material?access_token="+
        accessToken +"&type=" + category;
        return LocalHttpClient.handleWxUpload(location, inputStream, fileName, WxMediaInfoDto.class);
    }


    // 添加永久图文素材
    public static Optional<WxMediaInfoDto> addImageTextMaterial(
            String accessToken,
            List<WxNewsDetailDto> articles)throws Exception{
        //val location = s"${BASE_API_URI}/cgi-bin/media/uploadnews?access_token=${accessToken}"
        String location = WxConsts.WxUrlCons.BASE_API_URI +
        "/cgi-bin/material/add_news?access_token=" + accessToken;
        HttpPost hp = new HttpPost(location);
        Map<String, Object> map = new HashMap<>();
        map.put("articles", articles);
        StringEntity entity = new StringEntity(JsonUtils.writeObjAsStr(map), ContentType.APPLICATION_JSON);
        hp.setEntity(entity);
        return LocalHttpClient.handleJson(hp, WxMediaInfoDto.class);
    }


    // 获取图文素材
    public static Optional<WxNewsItemsDto> getImageTextMaterial(String accessToken, String media_id)
    throws Exception{
        String location = WxConsts.WxUrlCons.BASE_API_URI +
        "/cgi-bin/material/get_material?access_token=" + accessToken;
        HttpPost hp = new HttpPost(location);

        Map<String, String> map = new HashMap<>();
        map.put("media_id", media_id);
        StringEntity entity = new StringEntity(JsonUtils.writeObjAsStr(map), ContentType.APPLICATION_JSON);
        hp.setEntity(entity);
        return LocalHttpClient.handleJson(hp, WxNewsItemsDto.class);
    }

    // 删除永久素材
    public static Optional<String> removeImageTextMaterial(String accessToken, String media_id)
    throws Exception{
        String location = WxConsts.WxUrlCons.BASE_API_URI +
        "/cgi-bin/material/del_material?access_token=" + accessToken;
        HttpPost hp = new HttpPost(location);
        Map<String, String> map = new HashMap<>();
        map.put("media_id", media_id);
        StringEntity entity = new StringEntity(JsonUtils.writeObjAsStr(map), ContentType.APPLICATION_JSON);
        hp.setEntity(entity);
        return LocalHttpClient.handle(hp);
    }

    // 获取素材总数
    public static Optional<WxMediaInfoDto> getMaterialCount(String accessToken)
    throws Exception{
        String location = WxConsts.WxUrlCons.BASE_API_URI
        + "/cgi-bin/material/get_materialcount?access_token=" + accessToken;
        HttpGet hg = new HttpGet(location);
        return LocalHttpClient.handleJson(hg, WxMediaInfoDto.class);
    }

    // 批量获取图片素材
    public static Optional<String> getBatchMaterial(String accessToken, int count)
    throws Exception{
        String location = WxConsts.WxUrlCons.BASE_API_URI +
        "/cgi-bin/material/batchget_material?access_token=" + accessToken;

        Map<String, Object> map = new HashMap<>();
        map.put("type", "news");
        map.put("offset", "0");
        map.put("count", count);

        HttpPost hp = new HttpPost(location);
        StringEntity entity = new StringEntity(JsonUtils.writeObjAsStr(map), ContentType.APPLICATION_JSON);
        hp.setEntity(entity);
        return LocalHttpClient.handle(hp);
    }
}
