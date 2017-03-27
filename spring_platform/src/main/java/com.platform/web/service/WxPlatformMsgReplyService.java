package com.platform.web.service;

import com.platform.common.consts.SysConsts;
import com.platform.common.manage.RedisManage;
import com.platform.common.manage.WxCacheManage;
import com.platform.common.router.Url;
import com.platform.common.utils.JodaUtils;
import com.platform.common.utils.JsonUtils;
import com.platform.web.dto.MemberBaseDto;
import com.platform.web.entity.*;
import com.platform.web.mapper.WechatStoreMapper;
import com.platform.web.mapper.WechatSubscribeMapper;
import com.platform.web.mapper.WxPlatformMsgReplyMapper;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.stream.IntStream;

/**
 * Created by tanghong on 2017/3/19.
 */
@Service
public class WxPlatformMsgReplyService {

    @Autowired
    private WxPlatformMsgReplyMapper wxPlatformMsgReplyMapper;

    @Autowired
    private WechatStoreMapper wechatStoreMapper;

    @Autowired
    private WechatSubscribeMapper wechatSubscribeMapper;

    @Autowired
    private RedisManage redisManage;

    private Logger logger = LoggerFactory.getLogger(WxPlatformMsgReplyService.class);

    /**
     * 根据会员标识查询会员基本信息
     * @author 张进军
     * @param memberId   会员标识
     * @param hasConsume	是否包含消费信息
     * @return           会员基本信息
     */
    public Optional<MemberBaseDto> getMemberBaseInfo(int memberId, boolean hasConsume){
        String obj = redisManage.hget(SysConsts.Redis.MEMBER_BASE_INFO_KEY_HASH, memberId);
        try {
            if (obj == null && !obj.equals("")){
                MemberBaseDto dto = JsonUtils.readObj(obj, MemberBaseDto.class);
                return Optional.ofNullable(dto);
            }
            else {
                MemberBaseDto dto = wxPlatformMsgReplyMapper.selectMemberBaseInfo(memberId);
                if (dto != null){
                    redisManage.hset(
                        SysConsts.Redis.MEMBER_BASE_INFO_KEY_HASH,
                        memberId,
                        JsonUtils.writeObjAsStr(dto)
                    );
                    return Optional.ofNullable(dto);
                }
            }
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return Optional.empty();
    }

    /**
     * 赠送优惠券给会员
     * @author 张进军
     * @param memberId	会员标识
     * @param couponId	优惠券标识
     */
    public void presentCouponToMember(int memberId, int couponId){
        MemberCoupon memberCoupon = new MemberCoupon();
        memberCoupon.setMemberInfoId(memberId);
        memberCoupon.setCouponId(couponId);
        memberCoupon.setIsUsed(0);
        memberCoupon.setGrantTime(JodaUtils.getDateTime());
        wxPlatformMsgReplyMapper.insertMemberCoupon(memberCoupon);
    }

    /**
     * 用户渠道绑定
     * @author 张进军
     * @param openId    微信操作用户
     * @param sceneStr  场景值ID
     */
    public void channelBind(String openId, String sceneStr){
        if (sceneStr != null && !sceneStr.isEmpty()){
            WechatStore wechatStore = wechatStoreMapper.selectByPrimaryKey(openId);
            if (wechatStore != null) {
                String scene = redisManage.hget(SysConsts.Redis.WECHAT_AGENT_RECOMMEND_HASH, openId);
                if (scene != null && !scene.isEmpty()) {
                    String[] str = scene.split("_");
                    int recommendId = Integer.valueOf(str[str.length]);
                    int storeId = wechatStore.getStoreId();
                    if (sceneStr.startsWith(SysConsts.System.QRCODE_SALESMAN_PREFIX)) {
                        // 检查是否有推荐者
                        if (!Optional.ofNullable(wxPlatformMsgReplyMapper.selectApplySalesmanById(storeId)).isPresent()){
                            wxPlatformMsgReplyMapper.insertApplySalesman(new StoreApplySalesman(storeId, recommendId));
                        }
                    }
                    else {
                        // 不是业务员就是渠道商
                        // 检查是否有推荐者
                        if (!Optional.ofNullable(wxPlatformMsgReplyMapper.selectApplyAgentById(storeId)).isPresent()){
                            wxPlatformMsgReplyMapper.insertApplyAgent(new StoreApplyAgent(storeId, recommendId));
                        }
                    }
                    redisManage.hdel(SysConsts.Redis.WECHAT_AGENT_RECOMMEND_HASH, openId);
                }

            }
            else {
                // 如果该用户还未注册门店
                redisManage.hset(SysConsts.Redis.WECHAT_AGENT_RECOMMEND_HASH, openId, sceneStr);
            }
        }
    }

    /**
     * 赠送礼金给会员
     * @author 张进军
     * @date Jan 5, 2016 8:22:49 PM
     * @param memberId	会员标识
     * @param money	赠送金额
     * @param desc	赠送说明
     */
    public void presentGiftMoneyToMember(int memberId, Integer sAccountId, BigDecimal money, String desc){
        if (money.intValue() >= 1) {
            // 如果子账户为空,默认送至钱最多的子账户
            int accountId = sAccountId;
            if (sAccountId == null) {
                accountId = wxPlatformMsgReplyMapper.selectMemberTopBalanceByAccountId(memberId).getSubAccountId();
            }
            //增加礼金余额
            Map<String, Object> giftParams = new HashMap<String, Object>(5);
            giftParams.put("accountId", memberId);
            giftParams.put("totalGiftmoneyAmount", money);
            giftParams.put("balanceGiftmoneyAmount", money);
            wxPlatformMsgReplyMapper.updateGiftMoney(giftParams);
            wxPlatformMsgReplyMapper.updateIncreaseGiftAmount(accountId, money, JodaUtils.getDateTime(), null);

            //增加礼金明细
            GiftmoneyDetail giftmoneyDetail = new GiftmoneyDetail();
            giftmoneyDetail.setAccountId(accountId);
            giftmoneyDetail.setTotalAmount(money);
            giftmoneyDetail.setNowMoney(money);
            giftmoneyDetail.setResidueNowMoney(money);
            giftmoneyDetail.setPartNumber(0);
            giftmoneyDetail.setPartType(1);
            giftmoneyDetail.setIsPresent(1);
            giftmoneyDetail.setStartDate(JodaUtils.getDate());
            giftmoneyDetail.setEndDate("永久");
            giftmoneyDetail.setCreateTime(JodaUtils.getDateTime());
            giftmoneyDetail.setIsDeleted(0);
            wxPlatformMsgReplyMapper.insertGiftMoneyDetail(giftmoneyDetail);

            //增加礼金流水
            GiftmoneyFlow giftmoneyFlow = new GiftmoneyFlow();
            giftmoneyFlow.setAccountId(memberId);
            giftmoneyFlow.setSubAccountId(accountId);
            giftmoneyFlow.setFlowType(2);
            giftmoneyFlow.setFlowAmount(money);
            giftmoneyFlow.setFlowTime(JodaUtils.getDateTime());
            giftmoneyFlow.setBusinessType(desc);
            giftmoneyFlow.setBusinessDesc(desc);
            giftmoneyFlow.setIsDeleted(0);
            wxPlatformMsgReplyMapper.insertGiftMoneyFlow(giftmoneyFlow);
            wipeCache(memberId);
        }
    }

    public void wipeCache(int memberId){
        //更新会员缓存信息
        redisManage.hdel(SysConsts.Redis.MEMBER_BASE_INFO_KEY_HASH, memberId);
    }


    /**
     * 关注赠送
     * @param fromUserName
     * @param eventKey
     */
    public void attentionGift(String fromUserName, String eventKey){
        //如果用户是首次关注，需要查询门店是否有赠送内容
        WechatSubscribe ws = new WechatSubscribe(fromUserName, 1);
        if (!Optional.ofNullable(wechatSubscribeMapper.selectByPrimaryKey(fromUserName)).isPresent()){
            //首次关注
            ws.setCreateTime(JodaUtils.getDateTime());
            wechatSubscribeMapper.insert(ws);
            String userId = redisManage.hget(SysConsts.Redis.WECHAT_OPENID_TO_USERID_KEY_HASH, fromUserName);
            if (userId != null) {
                int memberId = Integer.valueOf(userId);
                Optional<MemberBaseDto> baseOpt = getMemberBaseInfo(memberId, false);
                if (baseOpt.isPresent()) {
                    MemberBaseDto memberInfo = baseOpt.get();
                    StoreSetting storeSetting = wxPlatformMsgReplyMapper.selectStoreSettingById(memberInfo.getStoreId());
                    //查看是否有优惠券奖励
                    String coupon = storeSetting.getFirstFollowCoupon();
                    if (!coupon.isEmpty()) {
                        Arrays.asList(coupon.split(",")).stream().forEach( c -> {
                            String[] list = c.split(":");
                            int couponId = Integer.valueOf(list[0]);
                            if (list.length > 1) {
                                IntStream.range(0, Integer.valueOf(list[1])).forEach(f -> {
                                    presentCouponToMember(memberId, couponId);
                                });
                            }
                            else presentCouponToMember(memberId, couponId);
                        });
                    }
                    //查看是否有礼金奖励
                    int gift = storeSetting.getFirstFollowGift();
                    if (gift > 0) {
                        presentGiftMoneyToMember(memberId, null, new BigDecimal(gift), "首次关注赠送");
                        wipeCache(memberId);
                    }
                }
            }
            else {
                redisManage.sadd(SysConsts.Redis.WECHAT_OPENID_TO_SUBSCRIBE_AWARD_SET, fromUserName);
            }
        }
        redisManage.hset(SysConsts.Redis.WECHAT_SUBSCRIBE_KEY_HASH, fromUserName, "1");

        // 检查事件值
        if (StringUtils.isNotBlank(eventKey)) {
            channelBind(fromUserName, eventKey);
        }
    }


    public void cancelAttention(String openid){
        WechatSubscribe ws = new WechatSubscribe(openid, 0);
        wechatSubscribeMapper.updateByPrimaryKey(ws);
        redisManage.hset(SysConsts.Redis.WECHAT_SUBSCRIBE_KEY_HASH, openid, "0");
    }
}
