package com.platform.web.service;

import akka.actor.ActorRef;
import com.platform.actor.dto.InitMenuMsg;
import com.platform.actor.dto.SetIndustry;
import com.platform.actor.dto.UpPlatformAppToken;
import com.platform.common.consts.Consts;
import com.platform.web.dto.ResultDto;
import com.platform.web.entity.WxAppInfo;
import com.platform.web.entity.WxAuthStore;
import com.platform.web.mapper.StoreInfoMapper;
import com.platform.web.mapper.WxAppInfoMapper;
import com.platform.web.mapper.WxAuthStoreMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import static com.platform.common.exception.SysExcCode.SysExcDtoModule.NOT_DATA;

/**
 * Created by tanghong on 2017/3/19.
 */
@Service
public class WxAppService {

    @Autowired
    private WxAppInfoMapper wxAppInfoMapper;

    @Autowired
    private StoreInfoMapper storeInfoMapper;

    @Autowired
    private WxAuthStoreMapper wxAuthStoreMapper;

    @Resource(name = "treatyManageActor")
    private ActorRef treatyManageActor;

    @Resource(name = "menuActor")
    private ActorRef menuActor;

    @Resource(name = "templateMsgActor")
    private ActorRef templateMsgActor;

    public void setIndustryTemplate(int storeId){
        templateMsgActor.tell(new SetIndustry(storeId), null);
    }

    // 发送初始化信息
    public void sendInitMsg(String authAccessToken, String refreshAccessToken, int storeId, String appId){
        // 缓存协议信息:
        treatyManageActor.tell(
            new UpPlatformAppToken(authAccessToken, refreshAccessToken, storeId, appId), null
        );
        // 发送模板行业设置:
        templateMsgActor.tell(authAccessToken, null);
        // 初始化菜单信息:
        menuActor.tell(new InitMenuMsg(storeId, authAccessToken), null);
    }


    private Map<String, Object> getQueryParams(String appId){
        String state = String.valueOf(Consts.StatusCons.remove);
        Map<String, Object> map = new HashMap<>();
        map.put("appId", appId);
        map.put("state", state);
        return map;
    }


    public int provideRenewAppInfo(WxAppInfo wxAppInfo){
        Optional<Integer> opt = Optional.ofNullable(wxAppInfoMapper.selectByStoreId(wxAppInfo.getStoreId()))
        .map(m -> {
            wxAppInfo.setId(m.getId());
            wxAppInfoMapper.updateDynamic(wxAppInfo);
            return m.getId();
        });
        if (!opt.isPresent()) {
            wxAppInfoMapper.insertDynamic(wxAppInfo);
            return wxAppInfo.getId();
        }
        else return opt.get();
    }

    public int provideRemoveAppInfo(String appId){
        return wxAppInfoMapper.deleteByAppId(getQueryParams(appId));
    }

    public ResultDto provideQueryAppInfo(int storeId){
        return Optional.ofNullable(storeInfoMapper.selectMainIdByStoreId(storeId))
        .flatMap(mStoreId -> {
            return Optional.ofNullable(wxAppInfoMapper.selectByEnableStoreId(mStoreId))
            .map(s -> {
                Map<String, Object> map = new HashMap<String, Object>();
                map.put("storeId", s.getStoreId());
                map.put("userName", s.getUserName());
                map.put("alias", s.getAlias());
                map.put("nickName", s.getNickName());
                map.put("headImg", s.getHeadImg());
                map.put("qrCode", s.getQrCodeUrl());
                map.put("appId", s.getAppId());
                return new ResultDto(0, map);
            });
        }).orElse(NOT_DATA);
    }

    public int provideRenewAuthStoreInfo(
        int storeId, String appId,
        String authCode,
        String refreshCode){
        WxAuthStore authStore = new WxAuthStore(storeId, appId, authCode, refreshCode);
        Optional<Integer> opt = Optional.ofNullable(wxAuthStoreMapper.selectByStoreId(storeId)).map( m -> {
            authStore.setAuthId(m.getAuthId());
            wxAuthStoreMapper.updateDynamic(authStore);
            return m.getAuthId();
        });

        if (opt.isPresent()) return opt.get();
        else {
            wxAuthStoreMapper.insertDynamic(authStore);
            return authStore.getAuthId();
        }
    }

    public int provideRemoveAuthStore(String appId){
        return wxAuthStoreMapper.deleteByAppId(getQueryParams(appId));
    }

}
