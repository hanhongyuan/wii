package com.platform.web.mapper;

import com.platform.web.entity.WechatEmployee;
import org.springframework.stereotype.Repository;

/**
 * Created by zhh on 2017/2/21.
 */
@Repository
public interface WechatEmployeeMapper {
    /**
     * 根据微信id删除关联记录
     *
     * @param openId 微信id
     * @return 0:失败，1:成功
     */
    int deleteByPrimaryKey(String openId);

    /**
     * 插入微信id与员工关联记录
     * @param record 关联记录
     * @return 0:失败，1:成功
     */
    int insert(WechatEmployee record);

    /**
     * 根据微信id查询关联记录
     *
     * @param openId 微信id
     * @return 关联记录
     */
    WechatEmployee selectByPrimaryKey(String openId);

    /**
     * 根据员工编号查询关联记录
     * @param employeeId
     * @return
     */
    WechatEmployee selectByEmployeeId(int employeeId);

    /**
     * 根据微信id修改关联记录
     *
     * @param record 关联记录
     * @return 0:失败，1:成功
     */
   int updateByPrimaryKey(WechatEmployee record);

    int selectOpenIdByUserName(String name);
}
