package com.platform.common.weixin.api;

import com.platform.common.configs.CommonConfig;
import com.platform.common.weixin.api.aes.AesException;
import com.platform.common.weixin.api.aes.WXBizMsgCrypt;

/**
 * Created by tanghong on 2017/3/6.
 */
public class AesMsgApi {

    /**
     * 解密微信消息内容
     */
    public static String getDecryptContent(
        String msg_signature, String timeStamp,
        String none, String postData){
        String appId = CommonConfig.WxConfig.appId;
        String token = CommonConfig.WxConfig.token;
        String aseKey = CommonConfig.WxConfig.aesKey;
        try {
            WXBizMsgCrypt crypt = new WXBizMsgCrypt(token, aseKey, appId);
            return crypt.decryptMsg(msg_signature, timeStamp, none, postData);
        } catch (AesException e) {
            e.printStackTrace();
            return "";
        }
    }

    /**
     * 加密微信消息内容
     */
    public static String getEncryptContent(
        String replyMsg, String timeStamp,
        String nonce){
        String appId = CommonConfig.WxConfig.appId;
        String token = CommonConfig.WxConfig.token;
        String aseKey = CommonConfig.WxConfig.aesKey;
        try {
            WXBizMsgCrypt msgCrypt = new WXBizMsgCrypt(token, aseKey, appId);
            return msgCrypt.encryptMsg(replyMsg, timeStamp, nonce);
        }
        catch (AesException e){
            e.printStackTrace();
            return "";
        }
    }

}
