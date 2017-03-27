package com.platform.web.mapper;

import com.platform.web.entity.MemberCoupon;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by tanghong on 2017/3/17.
 */
@Repository
public interface MemberCouponMapper {
    int insertByList(List<MemberCoupon> list);

    int dynamicInsert(MemberCoupon coupon);
}
