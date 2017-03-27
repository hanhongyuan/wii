package com.platform.web.service;

import com.platform.web.dto.MemberInfoDto;
import com.platform.web.dto.ResultDto;
import com.platform.web.mapper.MemberLevelMapper;
import com.platform.web.mapper.MemberScreeningMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created by tanghong on 2017/3/13.
 */
@Service
public class MemberService {

    private Logger logger = LoggerFactory.getLogger(MemberService.class);

    @Autowired
    private MemberScreeningMapper memberScreeningMapper;

    @Autowired
    private MemberLevelMapper memberLevelMapper;

    // 获取筛选会员信息
    public ResultDto screenMemberInfo(int storeId){
        Map<String, Object> map = new HashMap<>();
        map.put("levels", memberLevelMapper.selectByStoreId(storeId));
        map.put("screens", memberScreeningMapper.selectByStoreId(storeId));
        return new ResultDto(0, map);
    }

    // 获取分组会员
    public List<MemberInfoDto> getGroupMember(List<String> groups){
        return memberScreeningMapper.selectByDtos(groups).stream().flatMap(sc ->
                memberScreeningMapper.selectMemberIdListByGroupParam(sc).stream()
        ).collect(Collectors.toList());
    }

    // 获取等级会员
    public List<Integer> getLevelsMember(int storeId, List<String> levels){
        return memberScreeningMapper.selectMemberIdsByLevelIds(storeId, levels)
                .stream().distinct().collect(Collectors.toList());
    }

    //获取分组会员编号
    public List<Integer> provideGroupingMemberId(int storeId, List<String> groups, List<String> levels){
        if (!groups.isEmpty() && !levels.isEmpty()) {
            List<Integer> members = getGroupMember(groups).stream()
            .map(MemberInfoDto::getMemberId)
            .collect(Collectors.toList());

            return Stream.of(members, getLevelsMember(storeId, levels))
                    .flatMap(Collection::stream).collect(Collectors.toList());
        }
        else if (!groups.isEmpty() && levels.isEmpty()) {
            return getGroupMember(groups).stream()
            .map(MemberInfoDto::getMemberId)
            .collect(Collectors.toList());
        }
        else if (!levels.isEmpty() && groups.isEmpty()) {
            return getLevelsMember(storeId, levels);
        }
        else return null;
    }

    // 获取会员分组号码
    public List<String> provideGroupingPhone(int storeId, List<String> groups, List<String> levels){
        Function<Void, List<String>> getLevelsPhone = (Void v) -> {
            return memberScreeningMapper.selectMemberInfoInIds(getLevelsMember(storeId, levels))
            .stream().map(MemberInfoDto::getPhone).collect(Collectors.toList());
        };
        if (!groups.isEmpty() && !levels.isEmpty()) {
            return Stream.of(
                getGroupMember(groups).stream().map(MemberInfoDto::getPhone).collect(Collectors.toList()),
                getLevelsPhone.apply(null)
            ).flatMap(Collection::stream)
                    .collect(Collectors.toList());
        }
        else if (!groups.isEmpty() && levels.isEmpty()) {
            return getGroupMember(groups).stream().map(MemberInfoDto::getPhone).collect(Collectors.toList());
        }
        else if (!levels.isEmpty() && groups.isEmpty()) {
            return getLevelsPhone.apply(null);
        }
        else return null;
    }
}
