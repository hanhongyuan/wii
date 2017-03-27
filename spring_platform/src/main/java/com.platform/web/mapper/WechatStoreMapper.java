package com.platform.web.mapper;

import com.platform.web.entity.WechatStore;
import org.springframework.stereotype.Repository;

import java.util.Map;

/**
 * Created by zhh on 2017/2/21.
 */
@Repository
public interface WechatStoreMapper {
    /**
     * 新增微信门店映射信息
     *
     * @param record 微信门店映射信息
     * @return 0:失败，1:成功
     */
    int insert(WechatStore record);

    /**
     * 根据微信标识查询微信门店映射信息
     *
     * @param openId 微信标识
     * @return 微信门店映射信息
     */
    WechatStore selectByPrimaryKey(String openId);

    /**
     * 根据门店标识查询微信门店映射信息
     *
     * @param storeId 门店标识
     * @return 微信门店映射信息
     */
    WechatStore selectByStoreId(int storeId);

    /**
     * 统计微信关注数
     *
     * @param params 参数
     * @return 微信关注数
     */
    int countFollowByStoreIds(Map<String, Object> params);

    /**
     * 根据主键删除关联记录
     *
     * @param openId 微信标识
     * @return 0:失败，1:成功
     */
    int deleteByPrimaryKey(String openId);
}
