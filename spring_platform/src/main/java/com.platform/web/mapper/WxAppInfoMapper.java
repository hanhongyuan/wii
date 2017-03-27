package com.platform.web.mapper;

import com.platform.web.entity.WxAppInfo;
import org.springframework.stereotype.Repository;

import java.util.Map;

/**
 * Created by tanghong on 2017/3/19.
 */
@Repository
public interface WxAppInfoMapper {
    int insertDynamic(WxAppInfo was);

    int updateDynamic(WxAppInfo was);

    int deleteById(Map<String, Integer> map);

    int deleteByAppId(Map<String, Object> map);

    WxAppInfo selectById(int authId);

    WxAppInfo selectByEnableStoreId(int storeId);

    WxAppInfo selectByStoreId(int storeId);

    WxAppInfo selectByAppId(String appId);

}
