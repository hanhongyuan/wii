package com.platform.web.service;

import com.platform.common.exception.WxException;
import com.platform.common.manage.WxCacheManage;
import com.platform.common.weixin.dto.TemplateNumberDto;
import com.platform.web.entity.WxAuthStore;
import com.platform.web.entity.WxTemplateInfo;
import com.platform.web.mapper.WxAuthStoreMapper;
import com.platform.web.mapper.WxTemplateInfoMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.function.Function;

import static com.platform.common.weixin.api.TemplateMsgApi.getTemplateID;

/**
 * Created by tanghong on 2017/3/19.
 */
@Service
public class WxTemplateService {
    @Autowired
    private WxTemplateInfoMapper wxTemplateInfoMapper;

    @Autowired
    private WxAuthStoreMapper wxAuthStoreMapper;

    @Autowired
    private WxCacheManage wxCacheManage;

    private Logger logger = LoggerFactory.getLogger(WxTemplateInfoMapper.class);

    public String getTemplateNo(String storeNo, String tmCode){
        int storeId = Integer.valueOf(storeNo);
        Optional<String> opt = Optional.ofNullable(wxTemplateInfoMapper.selectTemplateNo(storeId, tmCode))
        .map(WxTemplateInfo::getTmNo);
        if (opt.isPresent()) return opt.get();
        else {
            WxAuthStore auth = wxAuthStoreMapper.selectByEnableStoreId(storeId);
            Optional<String> tokenOpt = wxCacheManage.getAuthAccessToken(storeId);
            if (auth != null && tokenOpt.isPresent()) {
                Function<String, String> getTemplateObj = tmNo -> {
                    WxTemplateInfo wxTem = new WxTemplateInfo(auth.getAuthId(), storeId, tmCode, auth.getAppId());
                    wxTem.setTmNo(tmNo);
                    wxTemplateInfoMapper.insertDynamic(wxTem);
                    return wxTem.getTmNo();
                };

                try {
                    Optional<TemplateNumberDto> dto = getTemplateID(tokenOpt.get(), tmCode);
                    if (dto.isPresent()) {
                        return dto.map(m -> getTemplateObj.apply(m.getTemplate_id()))
                        .orElse("");
                    }
                    return null;
                }
                catch (WxException e) {
                    TemplateNumberDto tn = e.toObj(TemplateNumberDto.class);
                    return getTemplateObj.apply(tn.getTemplate_id());
                }
                catch (Exception e) {
                    e.printStackTrace();
                }
                return null;
            }
            return null;
        }
    }

}
