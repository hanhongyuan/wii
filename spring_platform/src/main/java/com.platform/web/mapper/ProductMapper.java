package com.platform.web.mapper;

import com.platform.web.dto.*;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * Created by tanghong on 2017/3/14.
 */
@Repository
public interface ProductMapper {
    List<ProductOptionDto> selectProductByStore(int storeId);

    List<VoucherOptionDto> selectVoucher(Map<String, Object> map);

    ProjectAppointDto selectProjectAppointByProjectId(int projectId);

    GoodsAppointDto selectGoodsAppointByGoodsId(int goodsId);

    List<VoucherOptionDto> selectVoucherByIds(List<Integer> list);

    VoucherOptionDto selectVoucherById(int id);

    List<VoucherOptionDto> selectVoucherByProduct(Map<String, Object> map);

    List<CouponInfoDto> selectCouponByIds(List<Integer> list);

    WxAppInfoDto selectWxAppQrcode(int storeId);

    List<MemberCouponDto> selectCouponByOpenId(@Param("openid") String openid);

    int updateMemberCouponInfo(Map<String, Integer> map);

    int updateCouponExchangeCountByIds(List<Integer> list);
}
