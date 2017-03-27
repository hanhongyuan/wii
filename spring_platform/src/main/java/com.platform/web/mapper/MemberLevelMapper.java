package com.platform.web.mapper;

import com.platform.web.entity.MemberLevel;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by tanghong on 2017/3/13.
 */
@Repository
public interface MemberLevelMapper {
    List<MemberLevel> selectByStoreId(int storeId);
}
