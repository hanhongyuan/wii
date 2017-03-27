package com.platform.web.mapper;

import com.platform.web.entity.WxKeywordReply;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * Created by tanghong on 2017/3/19.
 */
@Repository
public interface WxKeywordReplyMapper {
    int insertDynamic(WxKeywordReply was);

    int updateDynamic(WxKeywordReply was);

    int deleteById(Map<String, Integer> map);

    WxKeywordReply selectById(int id);

    List<WxKeywordReply> selectByStoreId(int storeId);

    WxKeywordReply selectByKeyword(Map<String, String> map);
}
