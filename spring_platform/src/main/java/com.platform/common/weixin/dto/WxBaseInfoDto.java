package com.platform.common.weixin.dto;

import java.util.Optional;

/**
 * Created by tanghong on 2017/3/7.
 */
public class WxBaseInfoDto {
    private int id;

    private Optional<Integer> status;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Optional<Integer> getStatus() {
        return status;
    }

    public void setStatus(Optional<Integer> status) {
        this.status = status;
    }
}
