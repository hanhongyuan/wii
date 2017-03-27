package com.platform.web.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.platform.common.consts.SysConsts;
import com.platform.common.consts.WxConsts;
import com.platform.common.manage.RedisManage;
import com.platform.common.router.Url;
import com.platform.common.utils.http.LocalHttpClient;
import org.apache.commons.lang3.StringUtils;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

/**
 * Created by tanghong on 2017/3/20.
 */
@Service
public class TemplateNoticeService {

    @Autowired
    private RedisManage redisManage;    
    
    @Autowired
    private WxTemplateService wxTemplateService;
    
    

    private Logger logger = Logger.getLogger(TemplateNoticeService.class);

    public boolean sendServiceTurn(String title, String remark, String storeId, String url, String openId, String serviceNmae, String turnType){
        String templateId = wxTemplateService.getTemplateNo(storeId, WxConsts.TemplateCons.ORDER_SERVICE_INFORM);
        if (StringUtils.isBlank(templateId)) {
            return true;
        }
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("touser", openId);
        params.put("template_id", templateId);
        params.put("url", url);
        params.put("topcolor", "#FF0000");
        Map<String, Map<String, String>> data = new HashMap<String, Map<String,String>>();

        //标题
        Map<String, String> keyword0 = new HashMap<String, String>();
        keyword0.put("value", title + "\r\n");
        keyword0.put("color", "#173177");
        data.put("first", keyword0);

        Map<String, String> keyword1 = new HashMap<String, String>();
        keyword1.put("value", serviceNmae);
        keyword1.put("color", "#173177");
        data.put("keyword1", keyword1);

        Map<String, String> keyword2 = new HashMap<String, String>();
        keyword2.put("value", turnType);
        keyword2.put("color", "#173177");
        data.put("keyword2", keyword2);

        //备注
        Map<String, String> keyword6 = new HashMap<String, String>();
        keyword6.put("value", remark);
        keyword6.put("color", "#173177");
        data.put("remark", keyword6);

        params.put("data", data);

        ObjectMapper om = new ObjectMapper();
        Boolean bool = false;
        try {
            bool = sendTmpl(getTemplSendUrl(storeId), om.writeValueAsString(params));
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        finally {
            return bool;
        }
    }


    /**
     * 会员预约申请通知,发送给员工
     * @author 张进军
     * @date Nov 4, 2015 2:33:09 PM
     * @param storeId        门店标识
     * @param url            跳转链接
     * @param openId         接受者id
     * @param memberName     会员名称
     * @param memberLevel    会员等级
     * @param projectName    服务项目
     * @param createTime     下单时间
     * @param appointTime    预约时间
     * @return   成功返回true，失败返回false
     */
    public boolean sendAppointmentApply(String storeId, String url, String openId, String memberName, String memberLevel, String projectName, String createTime, String appointTime){
        String templateId = wxTemplateService.getTemplateNo(storeId, WxConsts.TemplateCons.CONSUMER_ORDER_INFORM);
        if (StringUtils.isBlank(templateId)) {
            return true;
        }
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("touser", openId);
        params.put("template_id", templateId);
        params.put("url", url);
        params.put("topcolor", "#FF0000");
        Map<String, Map<String, String>> data = new HashMap<String, Map<String,String>>();

        //标题
        Map<String, String> keyword0 = new HashMap<String, String>();
        keyword0.put("value", "您有新的预约\r\n");
        keyword0.put("color", "#173177");
        data.put("first", keyword0);

        Map<String, String> keyword1 = new HashMap<String, String>();
        keyword1.put("value", "\r\n预约顾客：" + memberName + "\r\n顾客等级：" + memberLevel + "\r\n预约项目：" + projectName + "\r\n预约时间：" + appointTime);
        keyword1.put("color", "#173177");
        data.put("keyword1", keyword1);

        Map<String, String> keyword2 = new HashMap<String, String>();
        keyword2.put("value", createTime);
        keyword2.put("color", "#173177");
        data.put("keyword2", keyword2);

        //备注
        Map<String, String> keyword6 = new HashMap<String, String>();
        keyword6.put("value", "\r\n您可以在\"我的-我的预约\"中随时查看预约情况");
        keyword6.put("color", "#173177");
        data.put("remark", keyword6);

        params.put("data", data);
        ObjectMapper om = new ObjectMapper();
        Boolean bool = false;
        try {
            bool = sendTmpl(getTemplSendUrl(storeId), om.writeValueAsString(params));
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        finally {
            return bool;
        }
    }


    /**
     * 预约操作结果通知，包括员工同意/拒绝、会员取消
     * @author 张进军
     * @date Nov 4, 2015 2:33:09 PM
     * @param storeId        门店标识
     * @param url            跳转链接
     * @param openId         接受者id
     * @param memberName     会员名称
     * @param memberLevel    会员等级
     * @param projectName    服务项目
     * @param appointTime    预约时间
     * @param result         预约结果
     * @param title          标题
     * @param remark         备注
     * @return   成功返回true，失败返回false
     */
    public boolean sendAppointmentResult(String storeId, String url, String openId, String memberName, String memberLevel,
                                         String projectName, String appointTime, String result, String title, String remark){
        // 需要获取具体的模板id
        String templateId = wxTemplateService.getTemplateNo(storeId, WxConsts.TemplateCons.ORDER_RESULT_INFORM);
        if (StringUtils.isBlank(templateId)) {
            return true;
        }
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("touser", openId);
        params.put("template_id", templateId);
        params.put("url", url);
        params.put("topcolor", "#FF0000");
        Map<String, Map<String, String>> data = new HashMap<String, Map<String,String>>();

        //标题
        Map<String, String> keyword0 = new HashMap<String, String>();
        keyword0.put("value", title + "\r\n");
        keyword0.put("color", "#173177");
        data.put("first", keyword0);

        Map<String, String> keyword1 = new HashMap<String, String>();
        keyword1.put("value", memberName + "\r\n客户等级：" + memberLevel);
        keyword1.put("color", "#173177");
        data.put("keyword1", keyword1);

        Map<String, String> keyword2 = new HashMap<String, String>();
        keyword2.put("value", projectName);
        keyword2.put("color", "#173177");
        data.put("keyword2", keyword2);

        Map<String, String> keyword3 = new HashMap<String, String>();
        keyword3.put("value", appointTime);
        keyword3.put("color", "#173177");
        data.put("keyword3", keyword3);

        Map<String, String> keyword4 = new HashMap<String, String>();
        keyword4.put("value", result);
        keyword4.put("color", "#173177");
        data.put("keyword4", keyword4);

        //备注
        Map<String, String> keyword6 = new HashMap<String, String>();
        keyword6.put("value", "\r\n" + remark);
        keyword6.put("color", "#173177");
        data.put("remark", keyword6);

        params.put("data", data);

        ObjectMapper om = new ObjectMapper();
        Boolean bool = false;
        try {
            bool = sendTmpl(getTemplSendUrl(storeId), om.writeValueAsString(params));
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        finally {
            return bool;
        }
    }


    /**
     * 会员消费提醒通知
     * @author 张进军
     * @date Nov 4, 2015 3:05:02 PM
     * @param title          标题
     * @param remark         备注
     * @param storeId        门店标识
     * @param url            跳转链接
     * @param openId         接受者id
     * @param storeName      门店名称
     * @param phone          会员手机号码
     * @param receivableAmount   应付金额
     * @param discountAmount     结算金额
     * @param projectName    消费项目
     * @param balanceAmount  当前余额
     * @param debtAmount     欠款金额
     * @param payTime        消费时间
     * @param type           1.通知用户结账，2.为用户结账
     * @return   成功返回true，失败返回false
     */
    public boolean sendPaymentNotice(String title, String remark, String storeId, String url, String openId, String storeName,
                                     String phone, String projectName, String receivableAmount, String discountAmount,
                                     String balanceAmount, String balanceIntegral, String debtAmount, String integralNumber, String payTime, String type,
                                     String comboProjectList, String goodsList, String comboList){
        String templateId = wxTemplateService.getTemplateNo(storeId, WxConsts.TemplateCons.BUSINESS_BALANCE_INFORM);
        if (StringUtils.isBlank(templateId)) {
            return true;
        }
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("touser", openId);
        params.put("template_id", templateId);
        params.put("url", url);
        params.put("topcolor", "#FF0000");
        Map<String, Map<String, String>> data = new HashMap<String, Map<String,String>>();

        //标题
        Map<String, String> keyword0 = new HashMap<String, String>();
        keyword0.put("value", title + "\r\n");
        keyword0.put("color", "#173177");
        data.put("first", keyword0);

        //会员卡号
        phone = phone.substring(0, 3) + "****" + phone.substring(7, 11);

        String projectContent = "";
        if(StringUtils.isNotBlank(projectName))
        {
            projectContent += "\r\n消费项目：" + projectName;
        }
        if(StringUtils.isNotBlank(comboProjectList))
        {
            projectContent += "\r\n疗程消费：" + comboProjectList;
        }
        if(StringUtils.isNotBlank(goodsList))
        {
            projectContent += "\r\n商品购买：" + goodsList;
        }
        if(StringUtils.isNotBlank(comboList))
        {
            projectContent += "\r\n疗程购买：" + comboList;
        }

        Map<String, String> keyword1 = new HashMap<String, String>();
        keyword1.put("value", phone + projectContent);
        keyword1.put("color", "#173177");
        data.put("keyword1", keyword1);

        //消费金额
        Map<String, String> keyword2 = new HashMap<String, String>();
        keyword2.put("value", receivableAmount);
        keyword2.put("color", "#173177");
        data.put("keyword2", keyword2);

        //交易时间
        Map<String, String> keyword3 = new HashMap<String, String>();
        keyword3.put("value", payTime);
        keyword3.put("color", "#173177");
        data.put("keyword3", keyword3);

        if ("1".equals(type)) {
            discountAmount = "待您结算";
        }
        else {
            discountAmount += "\r\n获赠积分：" + integralNumber
                    + "\r\n卡金余额：" + balanceAmount
                    + "\r\n积分余额：" + balanceIntegral;
            if (StringUtils.isNotBlank(debtAmount) && !"0".equals(debtAmount)) {
                discountAmount += "\r\n欠款金额：" + debtAmount;
            }
        }

        //结算金额
        Map<String, String> keyword4 = new HashMap<String, String>();
        keyword4.put("value", discountAmount);
        keyword4.put("color", "#173177");
        data.put("keyword4", keyword4);

        //备注
        Map<String, String> keyword6 = new HashMap<String, String>();
        keyword6.put("value", "\r\n" + remark);
        keyword6.put("color", "#173177");
        data.put("remark", keyword6);

        params.put("data", data);

        ObjectMapper om = new ObjectMapper();
        Boolean bool = false;
        try {
            bool = sendTmpl(getTemplSendUrl(storeId), om.writeValueAsString(params));
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        finally {
            return bool;
        }
    }

    public boolean sendCouponGift(String title, String remark, String storeId, String url, String openId, String storeName,
                                  String userName, String couponName, String giveTime){
        String templateId = wxTemplateService.getTemplateNo(storeId, WxConsts.TemplateCons.MEMBER_GIFT_INFORM);
        if (StringUtils.isBlank(templateId)) {
            return true;
        }
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("touser", openId);
        params.put("template_id", templateId);
        params.put("url", url);
        params.put("topcolor", "#FF0000");
        Map<String, Map<String, String>> data = new HashMap<String, Map<String,String>>();

        //标题
        Map<String, String> keyword0 = new HashMap<String, String>();
        keyword0.put("value", title);
        keyword0.put("color", "#173177");
        data.put("first", keyword0);

        //会员卡号
        Map<String, String> keyword1 = new HashMap<String, String>();
        keyword1.put("value", userName);
        keyword1.put("color", "#173177");
        data.put("keyword1", keyword1);

        Map<String, String> keyword2 = new HashMap<String, String>();
        keyword2.put("value", storeName + "送你优惠券: " + couponName);
        keyword2.put("color", "#173177");
        data.put("keyword2", keyword2);

        Map<String, String> keyword3 = new HashMap<String, String>();
        keyword3.put("value", giveTime);
        keyword3.put("color", "#173177");
        data.put("keyword3", keyword3);

        Map<String, String> keyword6 = new HashMap<String, String>();
        keyword6.put("value", remark);
        keyword6.put("color", "#173177");
        data.put("remark", keyword6);

        params.put("data", data);

        ObjectMapper om = new ObjectMapper();
        Boolean bool = false;
        try {
            bool = sendTmpl(getTemplSendUrl(storeId), om.writeValueAsString(params));
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        finally {
            return bool;
        }
    }


    public boolean sendMemberGiftMoney(String title, String remark, String storeId, String url, String openId, String storeName,
                                       String userName, String giftMoney, String giveTime, String cardNo){
        String templateId = wxTemplateService.getTemplateNo(storeId, WxConsts.TemplateCons.MEMBER_GIFT_INFORM);
        if (StringUtils.isBlank(templateId)) {
            return true;
        }
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("touser", openId);
        params.put("template_id", templateId);
        params.put("url", url);
        Map<String, Map<String, String>> data = new HashMap<String, Map<String,String>>();

        Map<String, String> keyword0 = new HashMap<String, String>();
        keyword0.put("value", title);
        keyword0.put("color", "#173177");
        data.put("first", keyword0);

        Map<String, String> keyword1 = new HashMap<String, String>();
        keyword1.put("value", userName);
        keyword1.put("color", "#173177");
        data.put("keyword1", keyword1);

        String desc = storeName + "送你礼金" + giftMoney + "元";

        Map<String, String> keyword2 = new HashMap<String, String>();
        keyword2.put("value", desc);
        keyword2.put("color", "#173177");
        data.put("keyword2", keyword2);

        Map<String, String> keyword3 = new HashMap<String, String>();
        keyword3.put("value", giveTime);
        keyword3.put("color", "#173177");
        data.put("keyword3", keyword3);

        Map<String, String> keyword6 = new HashMap<String, String>();
        keyword6.put("value", remark);
        keyword6.put("color", "#173177");
        data.put("remark", keyword6);

        params.put("data", data);

        ObjectMapper om = new ObjectMapper();
        Boolean bool = false;
        try {
            bool = sendTmpl(getTemplSendUrl(storeId), om.writeValueAsString(params));
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        finally {
            return bool;
        }
    }

    public boolean sendMemberVisit(String title, String remark, String storeId, String url, String openId,
                                   String projectName, String visitTitle){
        String templateId = wxTemplateService.getTemplateNo(storeId, WxConsts.TemplateCons.MEMBER_VISIT_INFORM);
        if (StringUtils.isBlank(templateId)) {
            return true;
        }
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("touser", openId);
        params.put("template_id", templateId);
        params.put("url", url);
        Map<String, Map<String, String>> data = new HashMap<String, Map<String,String>>();

        Map<String, String> keyword0 = new HashMap<String, String>();
        keyword0.put("value", title);
        keyword0.put("color", "#173177");
        data.put("first", keyword0);

        Map<String, String> keyword1 = new HashMap<String, String>();
        keyword1.put("value", projectName);
        keyword1.put("color", "#173177");
        data.put("keyword1", keyword1);

        Map<String, String> keyword2 = new HashMap<String, String>();
        keyword2.put("value", visitTitle);
        keyword2.put("color", "#173177");
        data.put("keyword2", keyword2);

        Map<String, String> keyword6 = new HashMap<String, String>();
        keyword6.put("value", remark);
        keyword6.put("color", "#173177");
        data.put("remark", keyword6);

        params.put("data", data);

        ObjectMapper om = new ObjectMapper();
        Boolean bool = false;
        try {
            bool = sendTmpl(getTemplSendUrl(storeId), om.writeValueAsString(params));
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        finally {
            return bool;
        }
    }

    /**
     * 会员充值通知
     * @author 张进军
     * @date Nov 4, 2015 3:05:02 PM
     * @param storeId        门店标识
     * @param url            跳转链接
     * @param openId         接受者id
     * @param storeName      门店名称
     * @param memberLevel    会员等级
     * @param chargeAmount   充值金额
     * @param balanceAmount  当前余额
     * @param chargeTime     充值时间
     * @return   成功返回true，失败返回false
     */
    public boolean sendMemberCharge(String storeId, String url, String openId, String storeName,
                                    String memberLevel, String chargeAmount, String balanceAmount, String chargeTime){
        String templateId = wxTemplateService.getTemplateNo(storeId, WxConsts.TemplateCons.MEMBER_CHARGE_INFORM);
        if (StringUtils.isBlank(templateId)) {
            return true;
        }
        String title = "感谢您选择" + storeName;
        String remark = "您可以在\"我的-储值余额\"中随时查看资金流水记录";
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("touser", openId);
        params.put("template_id", templateId);
        params.put("url", url);
        params.put("topcolor", "#FF0000");
        Map<String, Map<String, String>> data = new HashMap<String, Map<String,String>>();

        //标题
        Map<String, String> keyword0 = new HashMap<String, String>();
        keyword0.put("value", title + "\r\n");
        keyword0.put("color", "#173177");
        data.put("first", keyword0);

        //店铺名称
        Map<String, String> keyword1 = new HashMap<String, String>();
        keyword1.put("value", storeName);
        keyword1.put("color", "#173177");
        data.put("keyword1", keyword1);

        //会员类型
        Map<String, String> keyword2 = new HashMap<String, String>();
        keyword2.put("value", memberLevel);
        keyword2.put("color", "#173177");
        data.put("keyword2", keyword2);

        //充值金额
        Map<String, String> keyword3 = new HashMap<String, String>();
        keyword3.put("value", chargeAmount);
        keyword3.put("color", "#173177");
        data.put("keyword3", keyword3);

        //当前余额
        Map<String, String> keyword4 = new HashMap<String, String>();
        keyword4.put("value", balanceAmount);
        keyword4.put("color", "#173177");
        data.put("keyword4", keyword4);

        //充值时间
        Map<String, String> keyword5 = new HashMap<String, String>();
        keyword5.put("value", chargeTime);
        keyword5.put("color", "#173177");
        data.put("keyword5", keyword5);

        //备注
        Map<String, String> keyword6 = new HashMap<String, String>();
        keyword6.put("value", "\r\n" + remark);
        keyword6.put("color", "#173177");
        data.put("remark", keyword6);

        params.put("data", data);

        ObjectMapper om = new ObjectMapper();
        Boolean bool = false;
        try {
            bool = sendTmpl(getTemplSendUrl(storeId), om.writeValueAsString(params));
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        finally {
            return bool;
        }
    }


    public boolean sendTmpl(String url, String params){
        HttpPost hp = new HttpPost(url);
        StringEntity entity = new StringEntity(params, ContentType.APPLICATION_JSON);
        hp.setEntity(entity);
        Optional<String> res = LocalHttpClient.handle(hp);
        logger.info("weixin template msg send result : " + res);
        return true;
    }

    private String getTemplSendUrl(String storeId) {
        String accessToken = redisManage.hget(SysConsts.Redis.WX_PLATFORM_AUTHORIZER_STORE_ACCESS_TOKEN_HASH_KEY, storeId);
        return "https://api.weixin.qq.com/cgi-bin/message/template/send?access_token=" + accessToken;
    }
}

