package com.platform.web.mapper;

import com.platform.web.entity.WxUserInfo;
import org.springframework.stereotype.Repository;

/**
 * Created by zhh on 2017/2/22.
 */
@Repository
public interface WxUserInfoMapper {
    int dynamicInsert(WxUserInfo user);

    WxUserInfo selectByOpenId(String openid);
}
