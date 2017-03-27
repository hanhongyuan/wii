package com.platform.web.mapper;

import com.platform.web.entity.WxTextReply;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * Created by tanghong on 2017/3/19.
 */
@Repository
public interface WxTextReplyMapper {
    int insertDynamic(WxTextReply was);

    int updateDynamic(WxTextReply was);

    int deleteById(Map<String, Integer> map);

    WxTextReply selectById(int id);

    WxTextReply selectByCategory(Map<String, Integer> map);

    List<WxTextReply> selectByStoreId(int storeId);
}
