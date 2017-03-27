package com.platform.web.dto;

/**
 * Created by tanghong on 2017/3/14.
 */
public class ProjectAppointDto {
   private int projectId;
   private String projectName;
   private String projectImage;
   private String projectDesc;
   private double projectPrice;
   private double appointmentPrice;
   private int salesCount;
   private int salesPeople;
   private String affiliatedImage;

    public String getAffiliatedImage() {
        return affiliatedImage;
    }

    public void setAffiliatedImage(String affiliatedImage) {
        this.affiliatedImage = affiliatedImage;
    }

    public double getAppointmentPrice() {
        return appointmentPrice;
    }

    public void setAppointmentPrice(double appointmentPrice) {
        this.appointmentPrice = appointmentPrice;
    }

    public String getProjectDesc() {
        return projectDesc;
    }

    public void setProjectDesc(String projectDesc) {
        this.projectDesc = projectDesc;
    }

    public int getProjectId() {
        return projectId;
    }

    public void setProjectId(int projectId) {
        this.projectId = projectId;
    }

    public String getProjectImage() {
        return projectImage;
    }

    public void setProjectImage(String projectImage) {
        this.projectImage = projectImage;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public double getProjectPrice() {
        return projectPrice;
    }

    public void setProjectPrice(double projectPrice) {
        this.projectPrice = projectPrice;
    }

    public int getSalesCount() {
        return salesCount;
    }

    public void setSalesCount(int salesCount) {
        this.salesCount = salesCount;
    }

    public int getSalesPeople() {
        return salesPeople;
    }

    public void setSalesPeople(int salesPeople) {
        this.salesPeople = salesPeople;
    }
}
