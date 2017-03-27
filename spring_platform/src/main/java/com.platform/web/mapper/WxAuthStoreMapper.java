package com.platform.web.mapper;

import com.platform.web.entity.WxAuthStore;
import org.springframework.stereotype.Repository;

import java.util.Map;

/**
 * Created by tanghong on 2017/3/19.
 */
@Repository
public interface WxAuthStoreMapper {
    int insertDynamic(WxAuthStore was);

    int updateDynamic(WxAuthStore was);

    int deleteByAppId(Map<String, Object> map);

    int deleteById(Map<String, Integer> map);

    WxAuthStore selectById(int authId);

    WxAuthStore selectByEnableStoreId(int storeId);

    WxAuthStore selectByStoreId(int storeId);

    WxAuthStore selectByAppId(String appId);

    WxAuthStore selectAppInfo(String appId);
}
