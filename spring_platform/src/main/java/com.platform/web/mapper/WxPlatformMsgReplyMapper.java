package com.platform.web.mapper;

import com.platform.web.dto.CouponInfoDto;
import com.platform.web.dto.MemberBaseDto;
import com.platform.web.entity.StoreSetting;
import com.platform.web.entity.*;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.Map;

/**
 * Created by tanghong on 2017/3/19.
 */
@Repository
public interface WxPlatformMsgReplyMapper {
    MemberBaseDto selectMemberBaseInfo(int memberId);

    StoreSetting selectStoreSettingById(int storeId);

    CouponInfoDto selectCouponInfoById(int couponId);

    MemberSubAccount selectMemberTopBalanceByAccountId(int accountId);

    StoreApplyAgent selectApplyAgentById(int storeId);

    StoreApplySalesman selectApplySalesmanById(int storeId);

    int updateCouponCountById(int couponId);

    int updateIncreaseGiftAmount(@Param("subAccountId") int subAccountId, @Param("giftAmount") BigDecimal giftAmount, @Param("updateTime") String updateTime, @Param("lastOperatorId") Integer lastOperatorId);

    int updateGiftMoney(Map<String, Object> map);

    int insertMemberCoupon(MemberCoupon mc);

    int insertGiftMoneyDetail(GiftmoneyDetail record);

    int insertGiftMoneyFlow(GiftmoneyFlow record);

    int insertApplyAgent(StoreApplyAgent saa);

    int insertApplySalesman(StoreApplySalesman sas);
}
