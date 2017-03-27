package com.platform.common.consts;

/**
 * Created by tanghong on 2017/3/9.
 */
public interface SysConsts {

    public final static int DELIVERIED_TAG = -1;

    /** 系统基础常量 */
    class System {
        /** 智放公众号的门店标识 */
        public final static int WECHAT_ZEFUN_STORE_ID = 1;
        public final static String QRCODE_SALESMAN_PREFIX = "agent_salesman_";

    }

    class Redis{
        /**门店微信appid*/
        public final static String STORE_WECHAT_APP_ID_KEY_HASH = "store_wechat_app_id_key_hash";
        //门店jssdk票据
        public final static String STORE_WECHAT_JSAPI_TICKET_KEY_HASH = "store_wechat_jsapi_ticket_key_hash";

        /** 门店对应微信secret的hash key */
        public final static String STORE_WECHAT_APP_SECRET_KEY_HASH = "store_wechat_app_secret_key_hash";

        // 第三方平台调用凭据
        public final static String WX_PLATFORM_COMPONENT_ACCESS_TOKEN_KEY = "wx_platform_component_access_token_key";
        // 第三方平台公众号授权调用凭据
        public final static String WX_PLATFORM_AUTHORIZER_STORE_ACCESS_TOKEN_HASH_KEY = "wx_platform_authorizer_store_access_token";
        // 第三方平台公众号刷新调用凭据
        public final static String WX_PLATFORM_AUTHORIZER_STORE_REFRESH_TOKEN_HASH_KEY = "wx_platform_authorizer_store_refresh_token";
        // 第三方平台公众号jsapi票据
        public final static String WX_PLATFORM_STORE_JS_SDK_TICKET_HASH_KEY = "wx_platform_store_js_sdk_ticket";
        // 第三方平台公众号appid
        public final static String WX_PLATFORM_STORE_WECHAT_APP_ID_KEY_HASH_KEY = "wx_platform_store_wechat_app_id";

        /** 员工标识对应微信openid的hash key */
        public final static String WECHAT_EMPLOYEEID_TO_OPENID_KEY_HASH = "wechat_employeeid_to_openid_key_hash";

        /** 门店对应微信accessToken的hash key */
        public final static String STORE_WECHAT_ACCESS_TOKEN_KEY_HASH = "store_wechat_access_token_key_hash";

        /** 会员基本信息的hash key，key为会员标识，value为会员基本信息，对应memberBaseDto */
        public final static String MEMBER_BASE_INFO_KEY_HASH = "member_base_info_key_hash";

        /** 渠道/业务员推荐的hash key */
        public final static String WECHAT_AGENT_RECOMMEND_HASH = "wechat_agent_recommend_hash";

        /** 微信openid对应用户id(包括会员跟员工)的hash key前缀 */
        public final static String WECHAT_OPENID_TO_USERID_KEY_HASH = "wechat_openid_to_userid_key_hash";

        public final static String WECHAT_OPENID_TO_SUBSCRIBE_AWARD_SET = "wechat_openid_to_subscribe_award_set";

        public final static String WECHAT_SUBSCRIBE_KEY_HASH = "wechat_subscribe_key_hash";

    }

}
