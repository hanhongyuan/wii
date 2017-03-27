package com.platform.common.weixin.dto;

/**
 * Created by tanghong on 2017/3/19.
 */
public class IndustryInfoDto {
    private PrimaryIndustryDto primary_industry;
    private SecondaryIndustryDto secondary_industry;

    public PrimaryIndustryDto getPrimary_industry() {
        return primary_industry;
    }

    public void setPrimary_industry(PrimaryIndustryDto primary_industry) {
        this.primary_industry = primary_industry;
    }

    public SecondaryIndustryDto getSecondary_industry() {
        return secondary_industry;
    }

    public void setSecondary_industry(SecondaryIndustryDto secondary_industry) {
        this.secondary_industry = secondary_industry;
    }
}
