package com.platform.web.mapper;

import com.platform.web.entity.WechatAgent;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

/**
 * Created by zhh on 2017/2/21.
 */
@Repository
public interface WechatAgentMapper {

    /**
     * 新增微信与代理的映射
     * @param record 映射信息
     * @return   0:失败，1:成功
     */
    int insert(WechatAgent record);


    /**
     * 根据微信标识查询映射信息
     * @param openId 微信标识
     * @return   映射信息
     */
    WechatAgent selectByPrimaryKey(String openId);
}
