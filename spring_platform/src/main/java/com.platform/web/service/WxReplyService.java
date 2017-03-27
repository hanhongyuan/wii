package com.platform.web.service;

import com.platform.common.consts.WxConsts;
import com.platform.common.utils.Helpers;
import com.platform.common.utils.JsonUtils;
import com.platform.common.weixin.model.Article;
import com.platform.common.weixin.model.BaseMsgOut;
import com.platform.common.weixin.model.OutNewsMsg;
import com.platform.common.weixin.model.OutTextMsg;
import com.platform.web.dto.KeywordDto;
import com.platform.web.dto.ResultDto;
import com.platform.web.dto.TextReplyDto;
import com.platform.web.entity.WxKeywordReply;
import com.platform.web.entity.WxTextReply;
import com.platform.web.mapper.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

import static com.platform.common.exception.SysExcCode.SysExcDtoModule.NOT_DATA;

/**
 * Created by tanghong on 2017/3/19.
 */
@Service
public class WxReplyService {

    @Autowired
    private WxKeywordReplyMapper wxKeywordReplyMapper;

    @Autowired
    private WxAuthStoreMapper wxAuthMapper;

    @Autowired
    private WxTeletextMapper wxTeletextMapper;

    @Autowired
    private WxTextReplyMapper wxTextReplyMapper;

    @Autowired
    private StoreInfoMapper storeInfoMapper;


    public Optional<BaseMsgOut> provideQueryKeyword(
    String toUser,
    String fromUser,
    String word,
    int storeId){
        Map<String, String> map = new HashMap<>();
        map.put("word", word);
        map.put("storeId", String.valueOf(storeId));
        return Optional.ofNullable(wxKeywordReplyMapper.selectByKeyword(map)).map(m -> {
            int rt = m.getReplyType();
            if (rt == 1) {
                return new OutTextMsg(toUser, fromUser, m.getContent());
            }
            else if (rt == 2){
                try {
                    List<Integer> teletextIds = JsonUtils.readList(m.getTeletexts(), Integer.class);
                    List<Article> list = wxTeletextMapper.selectByList(teletextIds).stream().map(t -> {
                        return new Article(
                            t.getTitle(),
                            t.getDigest(),
                            WxConsts.QiniuCons.QINIU_CDN + t.getImgUrl(),
                            t.getContentSourceUrl()
                        );
                    }).collect(Collectors.toList());
                    return new OutNewsMsg(toUser, fromUser, list);
                } catch (Exception e) {
                    e.printStackTrace();
                    return null;
                }
            }
            else return null;
        });
    }

    public Optional<BaseMsgOut> provideAppQueryKeyword(
    String toUser,
    String fromUser,
    String word,
    String appId){
        return Optional.ofNullable(wxAuthMapper.selectByAppId(appId)).flatMap(wx ->
            provideQueryKeyword(toUser, fromUser, word, wx.getStoreId())
        );
    }

    public Optional<Integer> provideRenewTextInfo(
    int storeId,
    int replyType,
    String content){
        WxTextReply wxText = new WxTextReply(replyType, storeId, content);
        Map<String, Integer> map = new HashMap<>();
        map.put("storeId", storeId);
        map.put("category", replyType);
        Optional<Integer> resOpt = Optional
        .ofNullable(wxTextReplyMapper.selectByCategory(map))
        .map(m -> {
            wxText.setId(m.getId());
            wxTextReplyMapper.updateDynamic(wxText);
            return m.getId();
        });

        if (resOpt.isPresent()) {
            return resOpt;
        }
        else {
            wxTextReplyMapper.insertDynamic(wxText);
            return Optional.ofNullable(wxText.getId());
        }
    }


    public Optional<WxTextReply> provideQueryTextInfo(String appId, int replyType){
        return Optional.ofNullable(wxAuthMapper.selectByAppId(appId)).flatMap(m -> {
            Map<String, Integer> map = new HashMap<String, Integer>();
            map.put("storeId", m.getStoreId());
            map.put("category", replyType);
            return Optional.ofNullable(wxTextReplyMapper.selectByCategory(map));
        });
    }

    public ResultDto getTextReply(int storeId){
        int mStoreId = storeInfoMapper.selectMainIdByStoreId(storeId);
        List<Map<String, Object>> list = wxTextReplyMapper.selectByStoreId(mStoreId).stream().map(m -> {
            Map<String, Object> map = new HashMap<String, Object>();
            map.put("id", m.getId());
            map.put("content", m.getContent());
            map.put("storeId", m.getStoreId());
            map.put("category", m.getCategory());
            return map;
        }).collect(Collectors.toList());
        return new ResultDto(0, list);
    }

    public ResultDto renewTextReply(int storeId, TextReplyDto td){
        int mStoreId = storeInfoMapper.selectMainIdByStoreId(storeId);
        return provideRenewTextInfo(mStoreId, td.getCategory(), td.getContent()).map(m ->
            new ResultDto(0, "success")
        ).orElse(NOT_DATA);
    }

    public ResultDto getKeywordReply(int storeId){
        int mStoreId = storeInfoMapper.selectMainIdByStoreId(storeId);
        List<Map<String, Object>> json = wxKeywordReplyMapper.selectByStoreId(mStoreId).stream().map(m -> {
            Map<String, Object> map = new HashMap<String, Object>();
            map.put("content", m.getContent());
            map.put("keyword", m.getKeyword().split(","));
            map.put("rule", m.getRule());
            map.put("storeId", m.getStoreId());
            map.put("replyType", m.getReplyType());
            if (m.getTeletexts() != null && !m.getTeletexts().isEmpty()){
                try {
                    List<Integer> list = JsonUtils.readList(m.getTeletexts(), Integer.class);
                    List<Map<String, Object>> tList = wxTeletextMapper.selectByList(list).stream().map(t -> {
                        Map<String, Object> tmap = new HashMap<String, Object>();
                        tmap.put("teletextId", t.getId());
                        tmap.put("imgUrl", t.getImgUrl());
                        tmap.put("title", t.getTitle());
                        return tmap;
                    }).collect(Collectors.toList());
                    map.put("teletexts", tList);
                }
                catch (Exception e){
                    e.printStackTrace();
                }
            }
            map.put("id", m.getId());
            return map;
        }).collect(Collectors.toList());
        return new ResultDto(0, json);
    }

    public ResultDto renewKeywordReply(KeywordDto kd){
        return Optional.ofNullable(storeInfoMapper.selectMainIdByStoreId(kd.getStoreId()))
        .map(mStoreId -> {
            WxKeywordReply wkr = new WxKeywordReply(
                kd.getStoreId(),
                kd.getRule(),
                Helpers.mkString(new ArrayList<Object>(kd.getKeyword()), ","),
                kd.getContent().orElse(""),
                kd.getReplyType()
            );
            List<Integer> teletexts = kd.getTeletexts();
            if (!teletexts.isEmpty()) {
                try {
                    wkr.setTeletexts(JsonUtils.writeObjAsStr(teletexts));
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

            if (kd.getId() != null && kd.getId().isPresent()) {
                wxKeywordReplyMapper.updateDynamic(wkr);
                return new ResultDto(0, kd.getId().get());
            }
            else {
                wxKeywordReplyMapper.insertDynamic(wkr);
                return new ResultDto(0, wkr.getId());
            }
        }).orElse(NOT_DATA);
    }

    public ResultDto removeKeywordReply(int id, int state){
        Map<String, Integer> map = new HashMap<>();
        map.put("id", id);
        map.put("state", state);
        int res = wxKeywordReplyMapper.deleteById(map);
        if (res > 0) return new ResultDto(0, "success");
        else return new ResultDto(-1, "failure");
    }


}
