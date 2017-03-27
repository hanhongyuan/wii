package com.platform.web.controller;

import com.platform.common.router.Url;
import com.platform.web.dto.KeywordDto;
import com.platform.web.dto.ResultDto;
import com.platform.web.dto.TextReplyDto;
import com.platform.web.dto.UpdateStateDto;
import com.platform.web.service.WxReplyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * Created by tanghong on 2017/3/20.
 */
@RestController
public class WxReplyController {

    @Autowired
    private WxReplyService wxReplyService;

    @RequestMapping(value = Url.WxModule.SHOW_TEXT_REPLY, method = RequestMethod.GET)
    public ResultDto showTextReplyInfo(@PathVariable int storeId){
        return wxReplyService.getTextReply(storeId);
    }

    @RequestMapping(value = Url.WxModule.RENEW_TEXT_REPLY, method = RequestMethod.POST)
    public ResultDto renewTextReplyInfo(@PathVariable int storeId, @RequestBody TextReplyDto json){
        return wxReplyService.renewTextReply(storeId, json);
    }

    @RequestMapping(value = Url.WxModule.SHOW_KEYWORD_REPLAY, method = RequestMethod.GET)
    public ResultDto showKeywordReplyInfo(@PathVariable int storeId){
        return wxReplyService.getKeywordReply(storeId);
    }

    @RequestMapping(value = Url.WxModule.RENEW_KEYWORD_REPLAY, method = RequestMethod.POST)
    public ResultDto renewKeywordReplyInfo(@PathVariable int storeId, @RequestBody KeywordDto json){
        return wxReplyService.renewKeywordReply(json);
    }

    @RequestMapping(value = Url.WxModule.REMOVE_KEYWORD_REPLY, method = RequestMethod.POST)
    public ResultDto removeKeywordReplyInfo(@PathVariable int storeId, @RequestBody UpdateStateDto json){
        return wxReplyService.removeKeywordReply(json.getId(), json.getState());
    }


}
