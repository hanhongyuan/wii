package com.platform.common.exception;

import com.platform.web.dto.ResultDto;

/**
 * Created by tanghong on 2017/2/27.
 */
public interface SysExcCode {

    /***
     * 定义异常码
     */
    class SysExcCodeModule{
        public final static int SYS_OK = 200;

        public final static int SYS_ERROR = 601;

    }

    /**
     * 定义异常结果对象
     */
    class SysExcDtoModule{
        public final static ResultDto SYS_OK = new ResultDto(SysExcCodeModule.SYS_OK, "OK");

        public final static ResultDto SYS_ERROR = new ResultDto(SysExcCodeModule.SYS_ERROR, "sys failure");

        public final static ResultDto NOT_DATA = new ResultDto(1001, "没有数据!");

    }

    class NewsExcDtoModule{
        public final static ResultDto SEND_MSG_PROCESS = new ResultDto(1030, "正在发送中, 稍后请查看手机");
        public final static ResultDto YET_DOWNLOADS = new ResultDto(1532, "已经下载");
    }

    class PromotionExcDtoModule{
        public final static ResultDto NOT_RULE_TYPE = new ResultDto(1002, "找不到这个活动方式类型");
        public final static ResultDto TIP_ENABLE_PROMOTION = new ResultDto(1536, "请先启用您的活动!");

        public final static ResultDto YET_GRANT_VOUCHER = new ResultDto(3003, "已经领取代金券!");
        public final static ResultDto NO_GRANT_VOUCHER = new ResultDto(3004, "未领取代金券!");

        public final static ResultDto LOTTERY_FAILURE = new ResultDto(3020, "抽奖失败, 请继续加油!");
        public final static ResultDto YET_GET_VOUCHER = new ResultDto(3021, "已经领取代金券");
        public final static ResultDto NOT_LOTTERY = new ResultDto(3033, "今天抽奖次数已经用完, 明天再接再厉!");
    }

}
