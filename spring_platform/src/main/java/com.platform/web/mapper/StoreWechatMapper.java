package com.platform.web.mapper;

import com.platform.web.entity.StoreWechat;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by zhh on 2017/2/21.
 */
@Repository
public interface StoreWechatMapper {
    /**
     * 新增
     * @param record 实体
     * @return 影响行数
     */
    int insert(StoreWechat record);

    /**
     * 查询
     * @param storeId 主键
     * @return 返回实体
     */
    StoreWechat selectByPrimaryKey(int storeId);

    /**
     * 更新
     * @param record 实体
     * @return 影响行数
     */
    int updateByPrimaryKey(StoreWechat record);

    /**
     * 根据微信的唯一id进行查询
     * @param toUserName wechatID
     * @return 返回实体
     */
    StoreWechat selectByWechatId(String toUserName);

    /**
     * 查询所有门店的微信设置信息
     * @return   所有门店的微信设置信息
     */
    List<StoreWechat> selectAll();
}
