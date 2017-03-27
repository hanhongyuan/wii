package com.platform.common.consts;

/**
 * Created by zhh on 2017/2/21.
 */
public interface Consts {

    /**
     * 活动类型
     */
    enum PromotionTypeEnum{
       NON_PROMOTION(1, "非活动类型"),

       SHOPPING_ID(7, "双11活动类型"),

       FESTIVAL_ID(8, "节日促销");

       private int id;
       private String name;
       PromotionTypeEnum(int id, String name) {
           this.id = id;
           this.name = name;
       }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }

    /**
     * 活动规则类型
     */
    enum PromotionRuleTypeEnum{
        FESTIVAL_RULE(1, "礼包"),

        GAME_RULE(2, "游戏"),

        RED_PACKETS_RULE(3, "发红包"),

        ROULETTE_LOTTERY_RULE(4, "轮盘抽奖游戏");


        private int typeId;
        private String text;
        PromotionRuleTypeEnum(int typeId, String text) {
            this.typeId = typeId;
            this.text = text;
        }

        public int getTypeId() {
            return typeId;
        }

        public void setTypeId(int typeId) {
            this.typeId = typeId;
        }

        public String getText() {
            return text;
        }

        public void setText(String text) {
            this.text = text;
        }
    }

    /**
     * 产品类型
     */
    enum ProductTypeEnum{
        COMMON(0, "通用"),

        PROJECT(1, "项目"),

        GOODS(2, "商品"),

        COMBO(3, "疗程"),

        PROJECT_SERIES(4, "项目系列"),

        GOODS_SERIES(5, "商品系列");

        private int typeId;
        private String text;
        ProductTypeEnum(int typeId, String text) {
            this.typeId = typeId;
            this.text = text;
        }

        public int getTypeId() {
            return typeId;
        }

        public void setTypeId(int typeId) {
            this.typeId = typeId;
        }

        public String getText() {
            return text;
        }

        public void setText(String text) {
            this.text = text;
        }

    }

    /**
     * 游戏素材类型
     */
    enum MaterialGameTypeEnum{
        FESTIVAL(0, "节日游戏"),

        OTHERS(1, "其他");

        private int typeId;
        private String text;
        MaterialGameTypeEnum(int typeId, String text) {
            this.typeId = typeId;
            this.text = text;
        }
        public int getTypeId() {
            return typeId;
        }

        public void setTypeId(int typeId) {
            this.typeId = typeId;
        }

        public String getText() {
            return text;
        }

        public void setText(String text) {
            this.text = text;
        }
    }

    /**
     * 状态变量
     */
    class StatusCons {
        public static final int enable = 0; // 停用
        public static final int stop = 1; // 启用
        public static final int remove = 2; // 删除
        public static final int release = 3; // 发布
    }

    /**
     * 图文变量
     */
    class TeletextActionCons {
        public static final int download = 1; // 下载
        public static final int praise = 2; // 删除
    }

    /**
     * 图文类型变量
     */
    class TeletextCategoryCons {
        public static final int zefun = 1;
        public static final int promotion = 2;
    }

    /**
     * 支付类型变量
     */
    class PaymentTypeCons {
        public static final int card = 1;
        public static final int weixin = 2;
        public static final int cardOrWeixin = 3;
    }


    class WxAutoReplyCons{
        public final static int subscribeReply = 1;
        public final static int msgReply = 2;
        public final static int keywordReply = 3;
    }

}
