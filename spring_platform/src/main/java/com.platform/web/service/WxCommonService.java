package com.platform.web.service;

import com.platform.web.entity.StoreWechat;
import com.platform.web.entity.WxUserInfo;
import com.platform.web.mapper.StoreWechatMapper;
import com.platform.web.mapper.WxUserInfoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * Created by tanghong on 2017/3/19.
 */
@Service
public class WxCommonService {
    @Autowired
    private StoreWechatMapper storeWechatMapper;

    @Autowired
    private WxUserInfoMapper  wxUserInfoMapper;

    public void addWechatInfo(int storeId, String wechatId, String appId){
        Optional<StoreWechat> opt = Optional.ofNullable(storeWechatMapper.selectByPrimaryKey(storeId));
        if (opt.isPresent()) {
            storeWechatMapper.updateByPrimaryKey(new StoreWechat(storeId, wechatId, appId));
        }
        else {
            storeWechatMapper.updateByPrimaryKey(new StoreWechat(storeId, wechatId, appId));
        }
    }

    public WxUserInfo provideWxUserInfo(String openid){
        return wxUserInfoMapper.selectByOpenId(openid);
    }

}
