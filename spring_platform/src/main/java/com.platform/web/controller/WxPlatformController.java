package com.platform.web.controller;

import akka.actor.ActorRef;
import com.platform.actor.dto.*;
import com.platform.common.configs.CommonConfig;
import com.platform.common.consts.WxConsts;
import com.platform.common.manage.WxCacheManage;
import com.platform.common.router.Url;
import com.platform.common.utils.Helpers;
import com.platform.common.utils.JsonUtils;
import com.platform.common.weixin.api.AesMsgApi;
import com.platform.common.weixin.api.PlatformApi;
import com.platform.common.weixin.dto.WxAuthorizationDataDto;
import com.platform.common.weixin.dto.WxAuthorizerAccountInfoDto;
import com.platform.common.weixin.model.BaseMsgOut;
import com.platform.common.weixin.model.OutTextMsg;
import com.platform.web.dto.ResultDto;
import com.platform.web.entity.WxAppInfo;
import com.platform.web.mapper.StoreInfoMapper;
import com.platform.web.mapper.WxAppInfoMapper;
import com.platform.web.mapper.WxAuthStoreMapper;
import com.platform.web.service.*;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import org.json.XML;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.bind.annotation.XmlRootElement;
import com.platform.common.consts.WxConsts.MsgTypeCons.*;
import com.platform.common.consts.WxConsts.EventCons.*;

import java.io.StringReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;

import static com.platform.common.consts.WxConsts.EventCons.*;
import static com.platform.common.consts.WxConsts.MsgTypeCons.*;
import static com.platform.common.exception.SysExcCode.SysExcDtoModule.NOT_DATA;
import static com.platform.common.exception.SysExcCode.SysExcDtoModule.SYS_ERROR;

/**
 * Created by tanghong on 2017/3/20.
 */
@RestController
public class WxPlatformController {

    @Autowired
    private WxPlatformService wxPlatformService;

    @Autowired
    private WxCacheManage wxCacheManage;

    @Autowired
    private WxPlatformMsgReplyService wxPlatformMsgReplyService;

    @Autowired
    private StoreInfoMapper storeInfoMapper;

    @Autowired
    private WxAppService wxAppService;

    @Resource(name="wxUserActor")
    private ActorRef wxUserActor;

    @Autowired
    private WxReplyService wxReplyService;

    @Resource(name="treatyManageActor")
    private ActorRef treatyManageActor;

    @Autowired
    private WxCommonService wxCommonService;


    private Logger logger = LoggerFactory.getLogger(WxPlatformController.class);

    @RequestMapping(value = Url.WxPlatFormModule.SERVICE_CALL_BACK, method = RequestMethod.GET)
    public String getMPAuthCode(@PathVariable int sId, HttpServletRequest req, HttpServletResponse res){
        logger.info("公众号正在授权.......");
        int storeId = storeInfoMapper.selectMainIdByStoreId(sId);
        String authCode = req.getParameter("auth_code");
        String url = req.getHeader("Host");
        String comAppId = CommonConfig.WxConfig.appId;
        Optional<String> tokenOpt = wxCacheManage.getComponentAccessToken();
        try {
            if (tokenOpt.isPresent() && authCode != null) {
                logger.info("公众号授权码为: " + authCode);
                String token = tokenOpt.get();
                Optional<WxAuthorizationDataDto> authOpt = PlatformApi.getAuthorizerInfo(
                    token, comAppId, authCode
                );
                if (authOpt.isPresent()) {
                    WxAuthorizationDataDto auth = authOpt.get();
                    String appId = auth.getAuthorization_info().getAuthorizer_appid();
                    Optional<WxAuthorizerAccountInfoDto> accountInfoOpt = PlatformApi
                    .getAuthorizerAccountInfo(token, comAppId, appId);

                    if (accountInfoOpt.isPresent()) {
                        WxAuthorizerAccountInfoDto authInfo = accountInfoOpt.get();
                        String authAccessToken = auth.getAuthorization_info().getAuthorizer_access_token();
                        String refreshAccessToken = auth.getAuthorization_info().getAuthorizer_refresh_token();
                        String funInfo = Helpers.mkString(new ArrayList<Object>(
                            authInfo.getAuthorization_info().getFunc_info().stream()
                            .map(m -> m.getFuncscope_category().getId())
                            .collect(Collectors.toList())
                        ), ",");

                        String businessInfo = JsonUtils.writeObjAsStr(authInfo.getAuthorizer_info().getBusiness_info());
                        String wechatId = authInfo.getAuthorizer_info().getUser_name();

                        logger.info("公众号账号信息为:" + appId);
                        int authId = wxAppService.provideRenewAuthStoreInfo(storeId, appId, authCode, refreshAccessToken);
                        WxAppInfo wxAppInfo = new WxAppInfo(
                            authId,
                            storeId,
                            appId,
                            authInfo.getAuthorizer_info().getNick_name(),
                            wechatId,
                            authInfo.getAuthorizer_info().getHead_img(),
                            authInfo.getAuthorizer_info().getService_type_info().getId(),
                            authInfo.getAuthorizer_info().getVerify_type_info().getId(),
                            authInfo.getAuthorizer_info().getAlias(),
                            authInfo.getAuthorizer_info().getQrcode_url(),
                            businessInfo,
                            funInfo
                        );
                        wxAppService.provideRenewAppInfo(wxAppInfo);
                        wxCommonService.addWechatInfo(storeId, wechatId, appId);
                        wxAppService.sendInitMsg(authAccessToken, refreshAccessToken, storeId, appId);
                        res.sendRedirect("http://"+url+"/zefun/storeinfo/view/showStoreMch");
                    }

                }
            }
            return "success";
        }
        catch (Exception e){
            e.printStackTrace();
            return "success";
        }
    }


    /**
     * 获取第三方平台ticket, 微信统一要求返回字符串
     * 每隔10分钟推送一次票据
     */
    @RequestMapping(value = Url.WxPlatFormModule.PLATFORM_MAIL_BOX, method = RequestMethod.POST)
    public String platFormMailBox(@RequestBody String xml, HttpServletRequest req){
        String msgSignature = req.getParameter("msg_signature");
        String nonce = req.getParameter("nonce");
        String timestamp = req.getParameter("timestamp");
        String signature = req.getParameter("signature");
        SAXReader saxReader = new SAXReader();
        try{

            if (Helpers.verifySignature(timestamp, nonce, signature, CommonConfig.WxConfig.token)) {

                Document doc = saxReader.read(new StringReader(AesMsgApi.getDecryptContent(msgSignature, timestamp, nonce, xml)));
                Element elem = doc.getRootElement();
                String infoType = elem.element("InfoType").getText();
                logger.info("推送开放平台消息解密内容:" + doc.asXML());
                if(infoType.equals("component_verify_ticket")){
                    String ticket = elem.elementText("ComponentVerifyTicket");
                    //wxTreatyManageActor ! UpPlatformTicket(ticket)
                    wxPlatformService.renewPlatformTicket(ticket);
                    logger.info("微信推送开放平台票据:" + ticket);
                    return "success";
                }
                else if (infoType.equals("unauthorized")) {
                    logger.info("公众号正在取消授权......");
                    String appId = elem.elementText("AuthorizerAppid");
                    treatyManageActor.tell(new DelPlatformAppToken(appId), null);
                    wxAppService.provideRemoveAuthStore(appId);
                    wxAppService.provideRemoveAppInfo(appId);
                    return "success";
                }
                return "success";

            }
            return "success";
        }
        catch (Exception e){
            e.printStackTrace();
            return "success";
        }
    }

    /**
     * 用户点击进入授权页面
     */
    @RequestMapping(value = Url.WxPlatFormModule.AUTH_ADDRESS, method = RequestMethod.GET)
    public ResultDto getAuthAddress(@PathVariable int storeId, HttpServletRequest req){
        String host = req.getHeader("Host");
        String comAppId = CommonConfig.WxConfig.appId;
        Optional<String> tokenOpt = wxCacheManage.getComponentAccessToken();
        try {
            if (tokenOpt.isPresent()) {
                return PlatformApi.getPreAuthcode(tokenOpt.get(), comAppId).map(pre -> {
                    String url = "https://mp.weixin.qq.com/cgi-bin/componentloginpage?" +
                    "component_appid="+comAppId+"&pre_auth_code="+pre.getPre_auth_code()+"&redirect_uri=" +
                    "http://"+host+"/platform/wechat/auth/service/callback/store/" + storeId;
                    Map<String, String> map = new HashMap<String, String>();
                    map.put("preAuthUrl", url);
                    return new ResultDto(0, map);
                }).orElse(NOT_DATA);
            }
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return SYS_ERROR;
    }



    /**
     * 微信第三方平台处理中心
     *
     * @param appId
     * @param xml
     * @param req
     * @return
     */
    @RequestMapping(
        value = Url.WxPlatFormModule.PLATFORM_CENTER,
        method = RequestMethod.POST,
        produces = {MediaType.APPLICATION_XML_VALUE, MediaType.TEXT_XML_VALUE}
    )
    public String platFormCenter(@PathVariable String appId, @RequestBody String xml, HttpServletRequest req){
        String msgSignature = req.getParameter("msg_signature");
        String nonce = req.getParameter("nonce");
        String timestamp = req.getParameter("timestamp");
        SAXReader saxReader = new SAXReader();
        try {
            Document doc = saxReader.read(new StringReader(AesMsgApi.getDecryptContent(msgSignature, timestamp, nonce, xml)));
            logger.info("weixin push xml: " + doc.getXMLEncoding());
            Element elem = doc.getRootElement();
            String toUserName = elem.element("ToUserName").getText();
            String fromUserName = elem.element("FromUserName").getText();
            String msgType = elem.elementText("MsgType");
            Function<BaseMsgOut, String> sendReplyContent = reply -> {
                return AesMsgApi.getEncryptContent(reply.toXml(), String.valueOf(reply.getCreateTime()), nonce);
            };

            if (msgType.equals(XML_MSG_TEXT)) {
                String content = elem.elementText("Content");
                Optional<String> resOpt = wxReplyService.provideAppQueryKeyword(fromUserName, toUserName, content, appId)
                .map(sendReplyContent::apply);
                if (resOpt.isPresent()) {
                    return resOpt.get();
                }
                else {
                    Optional<String> txtOpt = wxReplyService.provideQueryTextInfo(appId, 2).map(m -> {
                        logger.info("自动回复内容: " + m.getContent());
                        return sendReplyContent.apply(new OutTextMsg(fromUserName, toUserName, m.getContent()));
                    });
                    if (txtOpt.isPresent()) return txtOpt.get();
                    else return "";
                }
            }
            else if (msgType.equals(XML_MSG_EVENT)){
                String eventKey = elem.elementText("EventKey");
                String event = elem.elementText("Event");
                if (event.equals(EVT_SUBSCRIBE)) {
                    wxPlatformMsgReplyService.attentionGift(fromUserName, eventKey);
                    wxUserActor.tell(new UserInfoByAppMsg(appId, fromUserName), null);
                    Optional<String> opt = wxReplyService.provideQueryTextInfo(appId, 1).map( m -> {
                        logger.info("关注回复内容: " + m.getContent());
                        return sendReplyContent.apply(new OutTextMsg(fromUserName, toUserName, m.getContent()));
                    });
                    if (opt.isPresent()) return opt.get();
                    else return "";
                }
                else if (event.equals(EVT_UNSUBSCRIBE)) {
                    wxPlatformMsgReplyService.cancelAttention(fromUserName);
                    return "";
                }
                else if (event.equals("EVT_SCAN")){
                    wxPlatformMsgReplyService.channelBind(fromUserName, eventKey);
                    return "";
                }
            }
            return "";

        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }

    /**
     * 发起授权页的体验验证方法
     *
     * @return
     */
    @RequestMapping(value = Url.WxPlatFormModule.VERIFY_AUTH, method = RequestMethod.GET)
    public String verifyAuth(HttpServletRequest req, HttpServletResponse res){
        return "success";
    }

    /***
     * 显示授权公众号信息
     * @param storeId
     * @return
     */
    @RequestMapping(value = Url.WxPlatFormModule.SHOW_APP_INFO, method = RequestMethod.GET)
    public ResultDto showAppInfo(@PathVariable int storeId){
        return wxAppService.provideQueryAppInfo(storeId);
    }

    @RequestMapping(value = Url.WxPlatFormModule.SET_APP_INDUSTRY, method = RequestMethod.GET)
    public String setIndustryTemplate(@PathVariable int storeId){
        wxAppService.setIndustryTemplate(storeId);
        return "success";
    }

}
