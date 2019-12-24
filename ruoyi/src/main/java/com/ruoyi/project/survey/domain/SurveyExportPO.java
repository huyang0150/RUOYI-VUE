package com.ruoyi.project.survey.domain;

/**
 * 【请填写功能名称】对象 survey_user
 * 
 * @author ruoyi
 * @date 2019-12-11
 */
public class SurveyExportPO
{
    private static final long serialVersionUID = 1L;

    private String mobile;

    private Integer satisfication;

    private Boolean transfer;

    private Integer considerationOne;

    private Integer considerationTwo;

    public Integer getSatisfication() {
        return satisfication;
    }

    public void setSatisfication(Integer satisfication) {
        this.satisfication = satisfication;
    }

    public Boolean getTransfer() {
        return transfer;
    }

    public void setTransfer(Boolean transfer) {
        this.transfer = transfer;
    }

    public Integer getConsiderationOne() {
        return considerationOne;
    }

    public void setConsiderationOne(Integer considerationOne) {
        this.considerationOne = considerationOne;
    }

    public Integer getConsiderationTwo() {
        return considerationTwo;
    }

    public void setConsiderationTwo(Integer considerationTwo) {
        this.considerationTwo = considerationTwo;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

}
