package com.platform.web.dto;

/**
 * Created by tanghong on 2017/3/13.
 */
public class MemberInfoDto {
    private int memberId;
    private String phone;

    public int getMemberId() {
        return memberId;
    }

    public void setMemberId(int memberId) {
        this.memberId = memberId;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
