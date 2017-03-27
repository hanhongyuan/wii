package com.platform.common.weixin.api;

import com.platform.common.consts.WxConsts;
import com.platform.common.utils.JsonUtils;
import com.platform.common.utils.http.LocalHttpClient;
import com.platform.common.weixin.dto.IndustryInfoDto;
import com.platform.common.weixin.dto.PrimaryIndustryDto;
import com.platform.common.weixin.dto.SecondaryIndustryDto;
import com.platform.common.weixin.dto.TemplateNumberDto;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import static com.platform.common.consts.WxConsts.WxUrlCons.BASE_API_URI;

/**
 * Created by tanghong on 2017/3/19.
 */
public class TemplateMsgApi {
    private static Logger logger = LoggerFactory.getLogger(TemplateMsgApi.class);

    /**
     * 设置公众号所属行业 id1为主行业, id2为副行业
     */
    public static Optional<String> setIndustryInfo(String accesstoken, String id1, String id2)
    throws Exception{
        if (id1 == null) {
            id1 = "1";
        }
        if (id2 == null) {
            id2 = "2";
        }
        String location = BASE_API_URI +  "/cgi-bin/template/api_set_industry?access_token=" + accesstoken;
        HttpPost hp = new HttpPost(location);
        Map<String, String> map = new HashMap<>();
        map.put("industry_id1", id1);
        map.put("industry_id2", id2);
        String content = JsonUtils.writeObjAsStr(map);
        StringEntity entity = new StringEntity(content, ContentType.APPLICATION_JSON);
        hp.setEntity(entity);
        return LocalHttpClient.handle(hp);
    }

    /**
     * 获取行业设置信息
     * @return
     */
    public static Optional<IndustryInfoDto> getIndustryInfo(String accessToken)
    throws Exception{
        String location = BASE_API_URI + "/cgi-bin/template/get_industry?access_token=" + accessToken;
        HttpGet hg = new HttpGet(location);
        return LocalHttpClient.handleJson(hg, IndustryInfoDto.class);
    }

    /**
     * 获取模板编号
     */
    public static Optional<TemplateNumberDto> getTemplateID(String accessToken, String template_id_short)
    throws Exception{
        String location = BASE_API_URI + "/cgi-bin/template/api_add_template?access_token=" + accessToken;
        HttpPost hp = new HttpPost(location);
        Map<String, String> map = new HashMap<>();
        map.put("template_id_short", template_id_short);
        String content = JsonUtils.writeObjAsStr(map);
        StringEntity entity = new StringEntity(content, ContentType.APPLICATION_JSON);
        hp.setEntity(entity);
        return LocalHttpClient.handleJson(hp, TemplateNumberDto.class);
    }

    // 设置行业
    public static void setSpecificIndustry(String accessToken)
    throws Exception{
        Optional<IndustryInfoDto> opt = getIndustryInfo(accessToken);
        if (opt != null && opt.isPresent()) {
           IndustryInfoDto info = opt.get();
            PrimaryIndustryDto primary = info.getPrimary_industry();
            SecondaryIndustryDto secondary = info.getSecondary_industry();

            logger.info("当前主业:" + primary.getFirst_class() + "-----" + primary.getSecond_class());
            logger.info("当前副业:" + secondary.getFirst_class() + "-----" + secondary.getSecond_class());

            boolean bool = primary.getFirst_class().equals(WxConsts.TemplateCons.PRIMARY_INDUSTRY1) &&
            primary.getSecond_class().equals(WxConsts.TemplateCons.PRIMARY_INDUSTRY2) &&
            secondary.getFirst_class().equals(WxConsts.TemplateCons.SECONDARY_INDUSTRY1) &&
            secondary.getSecond_class().equals(WxConsts.TemplateCons.SECONDARY_INDUSTRY2);

            if (!bool) {
                logger.info("正在更新行业........");
                setIndustryInfo(accessToken, null, null);
            }
        }
        else {
            logger.info("正在更新行业........");
            setIndustryInfo(accessToken, null, null);
        }
    }
}
