package com.platform.common.weixin.dto;

import java.util.Optional;

/**
 * Created by tanghong on 2017/3/7.
 */
public class WxFuncscopeCategoryDto {
    private WxBaseInfoDto funcscope_category;
    private Optional<WxConfirmInfoDto> confirm_info;

    public WxBaseInfoDto getFuncscope_category() {
        return funcscope_category;
    }

    public void setFuncscope_category(WxBaseInfoDto funcscope_category) {
        this.funcscope_category = funcscope_category;
    }

    public Optional<WxConfirmInfoDto> getConfirm_info() {
        return confirm_info;
    }

    public void setConfirm_info(Optional<WxConfirmInfoDto> confirm_info) {
        this.confirm_info = confirm_info;
    }
}
