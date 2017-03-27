package com.platform.web.mapper;

import com.platform.web.entity.WxTemplateInfo;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.Map;

/**
 * Created by tanghong on 2017/3/19.
 */
@Repository
public interface WxTemplateInfoMapper {
    int insertDynamic(WxTemplateInfo was);

    int updateDynamic(WxTemplateInfo was);

    int deleteById(Map<String, Integer> map);

    WxTemplateInfo selectById(int authId);

    WxTemplateInfo selectByStoreId(int storeId);

    WxTemplateInfo selectByAppId(String appId);

    WxTemplateInfo selectTemplateNo(@Param("storeId") int storeId, @Param("tmCode") String tmCode);
}
