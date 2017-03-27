package com.platform.common.router;

import com.platform.common.configs.CommonConfig;

/**
 * Created by tanghong on 2017/2/21.
 */
public interface Url {

    class WxModule{
        public final static String SHOW_TEXT_REPLY = "/wechat/show/store/{storeId}/text/reply/info";

        public final static String RENEW_TEXT_REPLY = "/wechat/renew/store/{storeId}/text/reply/info";

        public final static String SHOW_KEYWORD_REPLAY = "/wechat/show/store/{storeId}/keyword/reply/info";

        public final static String RENEW_KEYWORD_REPLAY = "/wechat/renew/store/{storeId}/keyword/reply/info";

        public final static String REMOVE_KEYWORD_REPLY = "/wechat/remove/store/{storeId}/keyword/reply/info";
    }

    class WxPlatFormModule{
       //授权校验
       public final static String VERIFY_AUTH = "/wechat/verify/auth";
       // 显示公众号信息
       public final static String SHOW_APP_INFO = "/wechat/store/{storeId}/show/app/info";
       // 第三方平台推送事件消息
       public final static String PLATFORM_CENTER = "/wechat/eventmsg/{appId}";
       // 授权服务回调
       public final static String SERVICE_CALL_BACK = "/wechat/auth/service/callback/store/{sId}";
       // 平台接收消息中心
       public final static String PLATFORM_MAIL_BOX = "/wechat/receive/mail/info";
       // 授权触发
       public final static String AUTH_ADDRESS = "/wechat/auth/store/{storeId}/touch";
       // 显示App token
       public final static String SHOW_APP_TOKEN = "/wechat/show/store/{storeId}/app/token/info";
       // 设置模板消息所属行业
       public final static String SET_APP_INDUSTRY = "/wechat/set/store/{storeId}/app/industry/info";
    }

    class CouponModule{
        public final static String SHOW_PRODUCT_VOUCHER = "/wechat/store/{storeId}/product/voucher";

        public final static String COUPON_SHOW_BY_IDS = "/coupon/show/info";
    }

    class MemberModule{
        // 查询会员分组信息
        public final static String SHOW_SCREEN_MEMBER_INFO = "/wechat/store/{storeId}/show/screen/member/info";
    }

    /**
     * 微信公共模块
     */
    class WxCommonModule {
        // 获取授权用户信息
        public final static String SHOW_USER_INFO = "/wx/common/show/user/info";
        // 获取微信jssdk
        public final static String SHOW_JSSDK_INFO = "/wx/common/show/wx/jssdk/info";
    }

    class WxPromotionModule {

        public final static String WX_PROMOTION_INDEX = "/wx/promotion/{promotionId}/index";

        public final static String INTERACTION_ENTRY = "/wx/promotion/interaction/entry";

        public final static String APP_MARKETING_HOME = "http://" + CommonConfig.WxConfig.domain +
                "/static/app_marketing/vue/index.html#/";

    }

    class RedisKeyModule {
        /**微信开发平台 redis key*/
        // 第三方平台校验票据
        public final static String WX_PLATFORM_COMPONENT_VERIFY_TICKET_KEY = "wx_platform_component_verify_ticket_key";
        // 第三方平台调用凭据
        public final static String WX_PLATFORM_COMPONENT_ACCESS_TOKEN_KEY = "wx_platform_component_access_token_key";
        // 第三方平台公众号授权调用凭据
        public final static String WX_PLATFORM_AUTHORIZER_STORE_ACCESS_TOKEN_HASH_KEY = "wx_platform_authorizer_store_access_token";
        // 第三方平台公众号刷新调用凭据
        public final static String WX_PLATFORM_AUTHORIZER_STORE_REFRESH_TOKEN_HASH_KEY = "wx_platform_authorizer_store_refresh_token";
        // 第三方平台公众号jsapi票据
        public final static String WX_PLATFORM_STORE_JS_SDK_TICKET_HASH_KEY = "wx_platform_store_js_sdk_ticket";

        public final static String WX_PLATFORM_STORE_WECHAT_APP_ID_KEY_HASH_KEY = "wx_platform_store_wechat_app_id";

        /** 门店对应微信id的hash key */
        public final static String STORE_WECHAT_APP_ID_KEY_HASH_KEY = "store_wechat_app_id_key_hash_key";
        /** 门店对应微信secret的hash key */
        public final static String STORE_WECHAT_APP_SECRET_KEY_HASH = "store_wechat_app_secret_key_hash";
        /** 门店对应微信accessToken的hash key */
        public final static String STORE_WECHAT_ACCESS_TOKEN_KEY_HASH_KEY = "store_wechat_access_token_key_hash_key";

        public final static String STORE_REFRESH_WECHAT_ACCESS_TOKEN_KEY_HASH_KEY = "store_wechat_refresh_access_token_key_hash_key";

        /** 门店对应微信JS接口的临时票据 */
        public final static String STORE_WECHAT_JSAPI_TICKET_KEY_HASH_KEY = "store_wechat_jsapi_ticket_key_hash_key";
        public final static String WECHAT_OPENID_TO_SUBSCRIBE_AWARD_SET = "wechat_openid_to_subscribe_award_set";
        /** 微信用户关注状态的hash key */
        public final static String WECHAT_SUBSCRIBE_KEY_HASH = "wechat_subscribe_key_hash";
        /** 微信openid对应用户id(包括会员跟员工)的hash key前缀 */
        public final static String WECHAT_OPENID_TO_USERID_KEY_HASH = "wechat_openid_to_userid_key_hash";
        /** 会员标识对应微信openid的hash key */
        public final static String WECHAT_MEMBERID_TO_OPENID_KEY_HASH = "wechat_memberid_to_openid_key_hash";
        /** 员工标识对应微信openid的hash key */
        public final static String WECHAT_EMPLOYEEID_TO_OPENID_KEY_HASH = "wechat_employeeid_to_openid_key_hash";
    }

    class MsgErr {
        public final static String MQ_MSG_ERR_RECORD_KEY = "mq_msg_err_record";
    }
}
