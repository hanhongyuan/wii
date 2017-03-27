package com.platform.web.mapper;

import com.platform.web.entity.StoreInfo;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * Created by tanghong on 2017/2/21.
 */
@Repository
public interface StoreInfoMapper {
    /**
     * 删除
     *
     * @param storeId 门店id
     * @return int
     */
     int deleteByPrimaryKey(int storeId);


    /**
     * 插入
     *
     * @param storeInfo 门店信息
     * @return int
     */
     int insert(StoreInfo storeInfo);

    /**
     * 查询
     *
     * @param storeId 门店id
     * @return StoreInfo
     */
     StoreInfo selectByPrimaryKey(@Param(value = "storeId") int storeId);

    /**
     * 更新
     *
     * @param storeInfo 门店信息
     * @return int
     */
     int updateByPrimaryKey(StoreInfo storeInfo);

    /**
     * 根据门店标识查询门店基础信息
     *
     * @param storeId 门店标识
     * @return 门店基础信息
     */
     StoreInfo selectBaseInfoByStoreId(int storeId);

    /**
     * 根据门店查询门店介绍
     *
     * @param storeId 门店标识
     * @return 门店介绍
     */
     StoreInfo selectDescByStoreId(int storeId);

    /**
     * 根据门店查询技术展示
     *
     * @param storeId 技术展示
     * @return 技术展示
     */
     String selectTechnicalByStoreId(int storeId);

    /**
     * 根据门店查询特色服务
     *
     * @param storeId 特色服务
     * @return 特色服务
     */
     String selectCharacteristicByStoreId(int storeId);

    /**
     * 根据总店标识查询所有分店信息，不包括自己
     *
     * @param mainStoreId 总店标识
     * @return 分店列表
     */
     List<StoreInfo> selectBaseInfoByMainId(int storeId);

    /**
     * 根据总店id查询旗下的分店数量
     *
     * @param hqStoreId 总店id
     * @return 分店数量
     */
     int countByHQStoreId(int hqStoreId);


    /**
     * 根据总店id查询旗下所有分店
     *
     * @param hqStoreId 总店id
     * @return 总店id查询旗下所有分店
     */
     List<StoreInfo> selectChainsByHQStoreId(int hqStoreId);

    /**
     * 根据多个门店id查询门店账号
     *
     * @param storeIds 多个门店id
     * @return 多个门店账号
     */
     List<StoreInfo>  selectByStoreIds(List<Integer> storeIds);

    /**
     * 根据门店标识查询总店，当店/总店返回自身
     *
     * @param storeId 门店标识
     * @return 总店标识
     */
     int selectMainIdByStoreId(int storeId);

    /**
     * 查询所有门店标识
     *
     * @return List<Integer>
     */
     List<Integer> selectStoreIdAll();


    /**
     * 根据门店id和门店名称查询门店
     *
     * @param prams 参数
     * @return 门店集合, 根据传入的门店id排序
     */
     List<StoreInfo> selectOrderedStore(Map<String, Object> prams);

    /**
     * 根据门店id查询门店的微信会员数
     *
     * @param storeIds 门店id
     * @return 会员数
     */
     int countWechatByIds(List<Integer> storeIds);

    /**
     * 查询一个省份下已开的门店
     *
     * @param province 省份名称
     * @return 一个省份下已开的门店
     */
     List<StoreInfo> selectOpenedByProvince(String province);
    
}
