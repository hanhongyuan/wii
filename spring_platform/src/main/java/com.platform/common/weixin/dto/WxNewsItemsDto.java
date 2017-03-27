package com.platform.common.weixin.dto;

import java.util.List;

/**
 * Created by tanghong on 2017/3/7.
 */
public class WxNewsItemsDto {
    private List<WxNewsDto> news_item;

    public List<WxNewsDto> getNews_item() {
        return news_item;
    }

    public void setNews_item(List<WxNewsDto> news_item) {
        this.news_item = news_item;
    }
}
