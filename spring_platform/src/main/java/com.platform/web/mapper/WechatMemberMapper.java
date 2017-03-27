package com.platform.web.mapper;

import com.platform.web.entity.WechatEmployee;
import com.platform.web.entity.WechatMember;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by zhh on 2017/2/21.
 */
@Repository
public interface WechatMemberMapper {

    /**
     * 根据微信id删除关联记录
     *
     * @param openId 微信id
     * @return 0:失败，1:成功
     */
    int deleteByPrimaryKey(String openId);

    /**
     * 插入微信id与会员关联记录
     *
     * @param record 关联记录
     * @return 0:失败，1:成功
     */
    int insert(WechatMember record);

    /**
     * 根据微信id查询关联记录
     *
     * @param openId 微信id
     * @return 关联记录
     */
    WechatMember selectByPrimaryKey(String openId);


    /**
     * 根据微信id修改关联记录
     *
     * @param record 关联记录
     * @return 0:失败，1:成功
     */
    int updateByPrimaryKey(WechatMember record);

    /**
     * 给一个会员id的list,查询出所有openid
     *
     * @param memberIds 会员id集合
     * @return openId集合
     */
    List<String> selectOpenIdsByMemberIdList(List<Integer> memberIds);

    /**
     * 如果取消了关注,将is_subscribe值改为0
     *
     * @param member 关联实体
     */
    int updateByOpenId(WechatMember member);

    /**
     * 通过openId查询memberId
     * @param fromUserName 微信openId
     * @return memberId
     */
    WechatMember selectMemberIdByOpenId(String fromUserName);

    /**
     * 根据会员标识集合查询对应的openid集合
     *
     * @param meberIdList 会员标识集合
     * @return openid集合
     */
    List<String> selectOpenIdByMemberIdList(List<Integer> meberIdList);


    /**
     * 根据openid列表删除会员微信关联记录
     *
     * @param openIdList openid集合
     * @return 删除数量
     */
    int deleteByOpenIdList(List<String> openIdList);

    /**
     * 根据会员标示查询微信openId
     *
     * @param memberId 会员id
     * @return openId
     */
    String selectOpenIdsByMemberId(int memberId);

}
