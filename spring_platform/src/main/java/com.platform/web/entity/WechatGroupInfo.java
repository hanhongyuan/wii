package com.platform.web.entity;

/**
 * Created by zhh on 2017/2/21.
 */
public class WechatGroupInfo {
    /** 分组标识 */
    private int id;

    /** 门店标识 */
    private int storeId;

    /** 分组类型(1:会员，2:员工，3:老板，4:无身份) */
    private int groupType;

    /** 微信分组ID */
    private int groupId;

    /** 微信分组名称 */
    private String groupName;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getStoreId() {
        return storeId;
    }

    public void setStoreId(int storeId) {
        this.storeId = storeId;
    }

    public int getGroupType() {
        return groupType;
    }

    public void setGroupType(int groupType) {
        this.groupType = groupType;
    }

    public int getGroupId() {
        return groupId;
    }

    public void setGroupId(int groupId) {
        this.groupId = groupId;
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    public WechatGroupInfo(){}

    public WechatGroupInfo(int storeId, int groupType, int groupId, String groupName){
        this.storeId = storeId;
        this.groupType = groupType;
        this.groupId = groupId;
        this.groupName = groupName;
    }
}
