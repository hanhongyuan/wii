package com.platform.web.mapper;

import com.platform.web.entity.WxTeletext;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * Created by zhh on 2017/2/22.
 */
@Repository
public interface WxTeletextMapper {
    int deleteByPrimaryKey(int id);

    int insertSelective(WxTeletext record);

    WxTeletext selectByPrimaryKey(int id);

    int updateByPrimaryKeySelective(WxTeletext record);

    int batchUpdate(List<WxTeletext> records);

    int insertByList(List<WxTeletext> automaticReplies);

    int updateSourceUrl(Map<String, Object> map);

    List<WxTeletext> selectByStoreId(int storeId);

    //通过活动类型查询图文
    List<WxTeletext> selectByPromotion(@Param("storeId") int storeId, @Param("promotionTypeId") int promotionTypeId);

    List<WxTeletext> selectByList(List<Integer> list);

    int removeById(int id);

    int isExistsDownloads(Map<String, Integer> map);

}
