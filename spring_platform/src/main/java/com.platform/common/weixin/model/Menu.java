package com.platform.common.weixin.model;

import com.platform.common.configs.CommonConfig;
import com.platform.common.utils.JsonUtils;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by tanghong on 2017/3/20.
 */
public class Menu {

    public static String getDefaultMenu(int storeId)
    throws Exception{
        String location = "http://"+ CommonConfig.WxConfig.domain+"/static/member/#/";
        String introduce = location + "shop?storeId=" + storeId;
        String preengage = location + "tab/appointment?storeId=" + storeId;
        String member = location + "tab/home?storeId="+ storeId;
        String mall = location + "tab/mall/1?storeId=" + storeId;
        String discount = location + "game?storeId=" + storeId;
        String community = location + "tab/community?storeId=" + storeId;
        Map<String, Object> map = new HashMap<>();
        List<SubButton> list = Arrays.asList(
            new SubButton(
                "门店服务",
                Arrays.asList(
                   new ViewButton("最新优惠", discount),
                   new ViewButton("门店介绍", introduce),
                   new ViewButton("一键上网", "http://wifi.weixin.qq.com/mbl/connect.xhtml?type=1")
                )
            ),
            new SubButton(
                "会员专享",
                 Arrays.asList(
                     new ViewButton("实时预约", preengage),
                     new ViewButton("会员中心", member)
                 )
            ),
            new SubButton(
                "自助服务",
                Arrays.asList(
                    new ViewButton("购物中心", mall),
                    new ViewButton("社区频道", community)
                )
            )
        );
        map.put("button", list);
        return JsonUtils.writeObjAsStr(map);
    }
}
