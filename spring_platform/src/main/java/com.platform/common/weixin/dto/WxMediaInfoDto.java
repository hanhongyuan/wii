package com.platform.common.weixin.dto;

import java.util.Optional;

/**
 * Created by tanghong on 2017/3/7.
 */
public class WxMediaInfoDto {

    private String media_id;
    private Optional<String> url;

    public String getMedia_id() {
        return media_id;
    }

    public void setMedia_id(String media_id) {
        this.media_id = media_id;
    }

    public Optional<String> getUrl() {
        return url;
    }

    public void setUrl(Optional<String> url) {
        this.url = url;
    }
}
