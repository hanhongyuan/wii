package com.platform.web.mapper;

import com.platform.web.dto.MemberInfoDto;
import com.platform.web.dto.ScreeningDto;
import com.platform.web.entity.MemberScreening;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import java.util.List;

/**
 * Created by tanghong on 2017/3/13.
 */
@Repository
public interface MemberScreeningMapper {
    //通过门店筛选会员信息
    List<MemberScreening> selectByStoreId(int storeId);

    List<ScreeningDto> selectByDtos(List<String> list);

    List<Integer> selectMemberIdsByDtos2(ScreeningDto sd);

    List<MemberInfoDto> selectMemberIdListByGroupParam(ScreeningDto sd);

    List<Integer> selectMemberIdsByLevelIds(@Param("storeId") int storeId, @Param("list") List<String> list);

    List<MemberInfoDto> selectMemberInfoInIds(List<Integer> list);
}
