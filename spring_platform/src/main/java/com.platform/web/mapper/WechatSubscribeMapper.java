package com.platform.web.mapper;

import com.platform.web.entity.WechatSubscribe;
import org.springframework.stereotype.Repository;

/**
 * Created by zhh on 2017/2/21.
 */
@Repository
public interface WechatSubscribeMapper {
    /**
     * 新增微信关注者
     *
     * @param record 关注信息
     * @return 0:失败，1:成功
     */
    int insert(WechatSubscribe record);

    /**
     * 根据微信标识查询关注信息
     *
     * @param openId 微信标识
     * @return 关注信息
     */
    WechatSubscribe selectByPrimaryKey(String openId);


    /**
     * 取消关注/再次关注
     *
     * @param record 关注信息
     * @return 0:失败，1:成功
     */
    int updateByPrimaryKey(WechatSubscribe record);
}
