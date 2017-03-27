package com.platform.web.mapper;

import com.platform.web.entity.WechatGroupInfo;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * Created by zhh on 2017/2/21.
 */
@Repository
public interface WechatGroupInfoMapper {
    /**
     * 查询某个类型下的分组信息
     *
     * @param groupType 分组类型(1:会员，2:员工，3:老板，4:无身份)
     * @return 分组信息
     */
    List<WechatGroupInfo> selectAllByGroupType(int groupType);

    /**
     * 根据门店标识、分组类型查询微信分组ID
     *
     * @param map 门店标识、分组类型
     * @return 微信分组ID
     */
    List<WechatGroupInfo> selectGroupIdByStoreIdAndGroupType(Map<String, Integer> map);

    /**
     * 根据分组标识删除分组信息
     *
     * @param id 分组标识
     * @return 0:失败，1:成功
     */
    int deleteByPrimaryKey(int id);

    /**
     * 新增分组信息
     *
     * @param record 分组信息
     * @return 0:失败，1:成功
     */
    int insert(WechatGroupInfo record);

    /**
     * 根据分组标识查询分组信息
     *
     * @param id 分组标识
     * @return 分组信息
     */
    WechatGroupInfo selectByPrimaryKey(int id);

    /**
     * 修改分组信息
     *
     * @param record 分组信息
     * @return 0:失败，1:成功
     */
    int updateByPrimaryKey(WechatGroupInfo record);

    List<WechatGroupInfo> selectGroupInfo(int storeId);
}
