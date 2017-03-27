package com.platform.common.consts;

/**
 * Created by tanghong on 2017/3/6.
 */
public interface WxConsts {

    public static class QiniuCons{
        public final static String QINIU_CDN = "http://cdn.maywant.com/";
    }

    public static class WxUrlCons{
        public final static String PLAT_BASE_API_URL = "https://api.weixin.qq.com/cgi-bin/component/";
        public final static String MEDIA_URI = "http://file.api.weixin.qq.com";
        public final static String QRCODE_DOWNLOAD_URI = "https://mp.weixin.qq.com";
        public final static String MCH_URI = "https://api.mch.weixin.qq.com";
        public final static String OPEN_URI = "https://open.weixin.qq.com";
        public final static String BASE_API_URI = "https://api.weixin.qq.com";
    }

    public static class ReqMethodCons{
        public final static String post = "POST";
        public final static String get = "GET";
    }

    public static class MsgTypeCons{
        ///////////////////////
        // 微信推送过来的消息的类型，和发送给微信xml格式消息的消息类型
        ///////////////////////
        public final static String XML_MSG_TEXT = "text";
        public final static String XML_MSG_IMAGE = "image";
        public final static String XML_MSG_VOICE = "voice";
        public final static String XML_MSG_VIDEO = "video";
        public final static String XML_MSG_NEWS = "news";
        public final static String XML_MSG_MUSIC = "music";
        public final static String XML_MSG_LOCATION = "location";
        public final static String XML_MSG_LINK = "link";
        public final static String XML_MSG_EVENT = "event";
        public final static String XML_TRANSFER_CUSTOMER_SERVICE = "transfer_customer_service";
        ///////////////////////
        // 主动发送消息的消息类型
        ///////////////////////
        public final static String CUSTOM_MSG_TEXT = "text";
        public final static String CUSTOM_MSG_IMAGE = "image";
        public final static String CUSTOM_MSG_VOICE = "voice";
        public final static String CUSTOM_MSG_VIDEO = "video";
        public final static String CUSTOM_MSG_MUSIC = "music";
        public final static String CUSTOM_MSG_NEWS = "news";
        public final static String CUSTOM_MSG_FILE = "file";
        ///////////////////////
        // 群发消息的消息类型
        ///////////////////////
        public final static String MASS_MSG_NEWS = "mpnews";
        public final static String MASS_MSG_TEXT = "text";
        public final static String MASS_MSG_VOICE = "voice";
        public final static String MASS_MSG_IMAGE = "image";
        public final static String MASS_MSG_VIDEO = "mpvideo";
    }

    public static class FeedBackCons{
        ///////////////////////
        // 群发消息后微信端推送给服务器的反馈消息
        ///////////////////////
        public final static String MASS_ST_SUCCESS = "send success";
        public final static String MASS_ST_FAIL = "send fail";
        public final static String MASS_ST_涉嫌广告 = "err(10001)";
        public final static String MASS_ST_涉嫌政治 = "err(20001)";
        public final static String MASS_ST_涉嫌社会 = "err(20004)";
        public final static String MASS_ST_涉嫌色情 = "err(20002)";
        public final static String MASS_ST_涉嫌违法犯罪 = "err(20006)";
        public final static String MASS_ST_涉嫌欺诈 = "err(20008)";
        public final static String MASS_ST_涉嫌版权 = "err(20013)";
        public final static String MASS_ST_涉嫌互推_互相宣传 = "err(22000)";
        public final static String MASS_ST_涉嫌其他 = "err(21000)";
    }

    public static class EventCons{
        ///////////////////////
        // 微信端推送过来的事件类型
        ///////////////////////
        public final static String EVT_SUBSCRIBE = "subscribe";
        public final static String EVT_UNSUBSCRIBE = "unsubscribe";
        public final static String EVT_SCAN = "SCAN";
        public final static String EVT_LOCATION = "LOCATION";
        public final static String EVT_CLICK = "CLICK";
        public final static String EVT_VIEW = "VIEW";
        public final static String EVT_MASS_SEND_JOB_FINISH = "MASSSENDJOBFINISH";
        public final static String EVT_SCANCODE_PUSH = "scancode_push";
        public final static String EVT_SCANCODE_WAITMSG = "scancode_waitmsg";
        public final static String EVT_PIC_SYSPHOTO = "pic_sysphoto";
        public final static String EVT_PIC_PHOTO_OR_ALBUM = "pic_photo_or_album";
        public final static String EVT_PIC_WEIXIN = "pic_weixin";
        public final static String EVT_LOCATION_SELECT = "location_select";
        public final static String EVT_TEMPLATESENDJOBFINISH = "TEMPLATESENDJOBFINISH";
        public final static String EVT_ENTER_AGENT = "enter_agent";
    }

    public static class MaterialCons{
        public final static String STUFF_THUMB = "thumb"; // 缩略图,临时素材
        public final static String IMAGE = "image";
    }

    public static class MenuButtonCons{
        ///////////////////////
        // 自定义菜单的按钮类型
        ///////////////////////
        /** 点击推事件 */
        public final static String BUTTON_CLICK = "click";
        /** 跳转URL */
        public final static String BUTTON_VIEW = "view";
        /** 扫码推事件 */
        public final static String BUTTON_SCANCODE_PUSH = "scancode_push";
        /** 扫码推事件且弹出“消息接收中”提示框 */
        public final static String BUTTON_SCANCODE_WAITMSG = "scancode_waitmsg";
        /** 弹出系统拍照发图 */
        public final static String PIC_SYSPHOTO = "pic_sysphoto";
        /** 弹出拍照或者相册发图 */
        public final static String PIC_PHOTO_OR_ALBUM = "pic_photo_or_album";
        /** 弹出微信相册发图器 */
        public final static String PIC_WEIXIN = "pic_weixin";
        /** 弹出地理位置选择器 */
        public final static String LOCATION_SELECT = "location_select";
        ///////////////////////
        // oauth2网页授权的scope
        ///////////////////////
        /** 不弹出授权页面，直接跳转，只能获取用户openid */
        public final static String OAUTH2_SCOPE_BASE = "snsapi_base";
        /** 弹出授权页面，可通过openid拿到昵称、性别、所在地。并且，即使在未关注的情况下，只要用户授权，也能获取其信息 */
        public final static String OAUTH2_SCOPE_USER_INFO = "snsapi_userinfo";
    }

    public static class TemplateCons{

        // 任务处理通知
        public final static String HANDLE_TASK_INFORM = "OPENTM200605630";
        // 客户预约通知
        public final static String CONSUMER_ORDER_INFORM = "OPENTM206215295";
        // 商户结算提醒
        public final static String BUSINESS_BALANCE_INFORM = "OPENTM203043676";
        // 代金券库存
        public final static String VOUCHER_STOCK_INFORM =  "OPENTM401383289";
        // 会员充值
        public final static String MEMBER_CHARGE_INFORM =  "OPENTM207696107";
        // 推荐消费
        public final static String RECOMMEND_CONSUME_INFORM = "OPENTM201187348";
        // 待处理通知
        public final static String PENDING_TREATMENT_INFORM = "OPENTM213722270";
        // 预约服务
        public final static String ORDER_SERVICE_INFORM =  "OPENTM206990916";
        // 预约结果
        public final static String ORDER_RESULT_INFORM = "OPENTM206305207";
        // 参团通知
        public final static String GROUP_PURCHASE_INFORM = "OPENTM400048581";

        public final static String MEMBER_GIFT_INFORM = "OPENTM200772305";

        public final static String MEMBER_VISIT_INFORM = "OPENTM401761205";

        public final static String INDUSTRY_ID1 = "1";
        public final static String INDUSTRY_ID2 = "2";
        public final static String PRIMARY_INDUSTRY1 = "IT科技";
        public final static String PRIMARY_INDUSTRY2 = "互联网|电子商务";
        public final static String SECONDARY_INDUSTRY1 = "IT科技";
        public final static String SECONDARY_INDUSTRY2 = "IT软件与服务";
    }

    public static class QrCodeCons{
        public final static String TEMPORARY_ACTION_NAME = "QR_SCENE";
    }

    public static class ERRCodeCons{
        public final static String ERR_CODE = "errcode";
    }

    enum  UserTagCons{
        MEMBER_CREATE(1, "会员_智放系统创建"),
        EMPLOYEE_CREATE(2, "员工_智放系统创建"),
        BOSS_CREATE(3, "老板_智放系统创建"),
        NO_BIND_CREATE(4, "未绑定_智放系统创建");

        private int id;
        private String name;
        UserTagCons(int id, String name) {
            this.id = id;
            this.name = name;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }

}
