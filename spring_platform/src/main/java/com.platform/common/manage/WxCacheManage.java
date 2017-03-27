package com.platform.common.manage;

import com.platform.common.configs.CommonConfig;
import com.platform.common.consts.WxConsts;
import com.platform.common.weixin.api.WebAuthApi;
import com.platform.common.weixin.dto.WxBaseAppInfoDto;
import com.platform.common.weixin.dto.WxWebAuthDto;
import com.platform.web.entity.WxAuthStore;
import com.platform.web.mapper.StoreInfoMapper;
import com.platform.web.mapper.WxAuthStoreMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.platform.common.consts.SysConsts.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Optional;
import java.util.Set;

import static com.platform.common.router.Url.RedisKeyModule.*;

/**
 * Created by tanghong on 2017/3/10.
 */
@Component
public class WxCacheManage {

    @Autowired
    private RedisManage redisManage;

    @Autowired
    private WxAuthStoreMapper wxAuthStoreMapper;

    private Logger logger = LoggerFactory.getLogger(WxCacheManage.class);

    /**
     * 获取员工对应的openid
     */
    public Optional<String> getEmployeeOpenId(int employeeId){
        return Optional.ofNullable(redisManage.hget(Redis.WECHAT_EMPLOYEEID_TO_OPENID_KEY_HASH, employeeId));
    }

    // 缓存openid
    public String setWxOpenId(String openid, HttpServletRequest req){
        HttpSession session = req.getSession(false);
        Optional<Integer> storeOpt = getStoreId(req);
        if (storeOpt.isPresent()) {
            String key = storeOpt.get() + "_openid";
            if (session != null) {
                logger.info("session not null");
                session.removeAttribute(key);
                session.setAttribute(key, openid);
                return (String) session.getAttribute(key);
            }
            else {
                HttpSession ss = req.getSession(true);
                logger.info("create new session");
                ss.removeAttribute(key);
                ss.setAttribute(key, openid);
                return (String) ss.getAttribute(key);
            }
        }
        return null;
    }

    // 获取微信openid
    public Optional<String> getWxOpenId(HttpServletRequest request){
        return getStoreId(request).flatMap(storeId -> {
            String key = storeId + "_openid";
            return Optional.ofNullable(request.getSession(false)).flatMap(session -> {
               String openid = (String) session.getAttribute(key);
                logger.info("当前openid:" + openid);
                return Optional.ofNullable(openid);
            });
        });
    }

    // 设置门店id
    public Integer setStoreId(int storeId, HttpServletRequest req){
        HttpSession session = req.getSession(false);
        //session.setMaxInactiveInterval(3600 * 12)
        if (session != null) {
            logger.info("store session not null");
            session.removeAttribute("WxStoreId");
            session.setAttribute("WxStoreId", storeId);
            return (Integer)session.getAttribute("WxStoreId");
        }
        else {
            HttpSession ss = req.getSession(true);
            logger.info("store create new session");
            ss.removeAttribute("WxStoreId");
            ss.setAttribute("WxStoreId", storeId);
            return (Integer)ss.getAttribute("WxStoreId");
        }
    }

    // 获取门店ID
    public Optional<Integer> getStoreId(HttpServletRequest req){
        return Optional.ofNullable(req.getSession(false)).map(m -> (Integer) m.getAttribute("WxStoreId"));
    }

    // 获取平台缓存的AppId
    public Optional<String> getCacheAppId(int storeId){
        Optional<String> opt = Optional.ofNullable(redisManage.hget(WX_PLATFORM_STORE_WECHAT_APP_ID_KEY_HASH_KEY, storeId));
        if (opt.isPresent()) return opt;
        else {
            return Optional.ofNullable(
                wxAuthStoreMapper.selectByEnableStoreId(storeId)
            ).map(WxAuthStore::getAppId);
        }
    }

    // 获取缓存APPID中的所有门店
    public Set<String> getCacheStores(){
        return redisManage.hkeys(WX_PLATFORM_STORE_WECHAT_APP_ID_KEY_HASH_KEY);
    }

    public Optional<String> getAuthAccessToken(int storeId){
        return Optional.ofNullable(redisManage.hget(WX_PLATFORM_AUTHORIZER_STORE_ACCESS_TOKEN_HASH_KEY, storeId));
    }

    public Optional<String> getRefreshAccessToken(int storeId) {
        Optional<String> opt = Optional.ofNullable(redisManage.hget(WX_PLATFORM_AUTHORIZER_STORE_REFRESH_TOKEN_HASH_KEY, storeId));
        if (opt.isPresent()) return opt;
        else {
            return Optional.ofNullable(wxAuthStoreMapper.selectByEnableStoreId(storeId))
            .map(WxAuthStore::getRefreshCode);
        }
    }

    public Optional<String> getPlatformTicket(){
        return Optional.ofNullable(redisManage.get(WX_PLATFORM_COMPONENT_VERIFY_TICKET_KEY));
    }

    public Optional<String> getComponentAccessToken(){
        return Optional.ofNullable(redisManage.get(WX_PLATFORM_COMPONENT_ACCESS_TOKEN_KEY));
    }

    public Optional<String> getJssdkTicket(int storeId){
        return Optional.ofNullable(redisManage.hget(WX_PLATFORM_STORE_JS_SDK_TICKET_HASH_KEY, storeId));
    }

}
