package com.platform.web.service;

import com.platform.common.consts.Consts;
import com.platform.web.dto.ProductVoucherDto;
import com.platform.web.dto.ResultDto;
import com.platform.web.mapper.ProductMapper;
import org.joda.time.LocalDate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import scala.collection.immutable.Stream;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Created by tanghong on 2017/3/14.
 */
@Service
public class CouponService {

    @Autowired
    private ProductMapper productMapper;

    public List<Map<String, Object>> getVoucher(List<Integer> ids){
        if (!ids.isEmpty()) {
            return productMapper.selectVoucherByIds(ids).stream().map(m -> {
                Optional<String> couponTypeName = Arrays.asList(Consts.ProductTypeEnum.values()).stream().filter(f ->
                    f.getTypeId() == m.getCouponTypeId()
                ).findFirst().map(Consts.ProductTypeEnum::getText);
                Map<String, Object> map =  new HashMap<String, Object>();
                map.put("couponTypeId", m.getCouponTypeId());
                map.put("couponId", m.getId());
                map.put("couponTypeName", couponTypeName);
                map.put("startTime", m.getStartTime());
                map.put("name", m.getName());
                map.put("price", m.getPrice());
                map.put("stopTime", m.getCouponStopTime());
                return map;
            }).collect(Collectors.toList());
        }
        else return null;
    }

    // 获取代金券详情
    public ResultDto queryVoucherDetail(List<Integer> ids){
        return new ResultDto(0, getVoucher(ids));
    }

    // 获取产品代金券
    public ResultDto getProductVoucher(ProductVoucherDto rv){
        Map<String, Object> map = new HashMap<>();
        map.put("storeId", rv.getStoreId());
        map.put("productTypeId", rv.getProductTypeId());
        map.put("time", LocalDate.now().toString());
        List<Map<String, Object>> list = productMapper.selectVoucher(map).stream().map(vou -> {
            Optional<String> cons = Arrays.asList(Consts.ProductTypeEnum.values())
            .stream()
            .filter(f -> f.getTypeId() == vou.getCouponTypeId())
            .findFirst().map(Consts.ProductTypeEnum::getText);
            Map<String, Object> vmap = new HashMap<>();
            vmap.put("couponStopTime", vou.getCouponStopTime());
            vmap.put("couponTypeId",  vou.getCouponTypeId());
            vmap.put("effectiveDays", vou.getEffectiveDays());
            vmap.put("hasExchangeCount", vou.getHasExchangeCount());
            vmap.put("hasUseCount", vou.getHasUseCount());
            vmap.put("id", vou.getId());
            vmap.put("name", vou.getName());
            vmap.put("price", vou.getPrice());
            vmap.put("releaseTime", vou.getReleaseTime());
            vmap.put("startTime", vou.getStartTime());
            vmap.put("storeId", vou.getStoreId());
            vmap.put("voucherType", cons);
            return vmap;
        }).collect(Collectors.toList());
        return new ResultDto(0, list);
    }
}
