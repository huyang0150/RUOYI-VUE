package com.ruoyi.project.survey.domain;

import com.ruoyi.framework.aspectj.lang.annotation.Excel;

/**
 * 【请填写功能名称】对象 survey_user
 * 
 * @author ruoyi
 * @date 2019-12-11
 */
public class SurveyExportBO
{
    private static final long serialVersionUID = 1L;

    @Excel(name = "手机号", cellType = Excel.ColumnType.STRING)
    private String mobile;

    @Excel(name = "您对现在的移动号码的运营商是否满意", cellType = Excel.ColumnType.STRING)
    private String satisficationDesc;

    @Excel(name = "您是否会携号转网", cellType = Excel.ColumnType.STRING)
    private String transferDesc;

    @Excel(name = "您现在选择运营商主要考虑的因素有哪些(1)", cellType = Excel.ColumnType.STRING)
    private String considerationOneDesc;

    @Excel(name = "您现在选择运营商主要考虑的因素有哪些(2)", cellType = Excel.ColumnType.STRING)
    private String considerationTwoDesc;

    @Excel(name = "渠道", cellType = Excel.ColumnType.STRING)
    private String source;

    public String getSatisficationDesc() {
        return satisficationDesc;
    }

    public void setSatisficationDesc(String satisficationDesc) {
        this.satisficationDesc = satisficationDesc;
    }

    public String getTransferDesc() {
        return transferDesc;
    }

    public void setTransferDesc(String transferDesc) {
        this.transferDesc = transferDesc;
    }

    public String getConsiderationOneDesc() {
        return considerationOneDesc;
    }

    public void setConsiderationOneDesc(String considerationOneDesc) {
        this.considerationOneDesc = considerationOneDesc;
    }

    public String getConsiderationTwoDesc() {
        return considerationTwoDesc;
    }

    public void setConsiderationTwoDesc(String considerationTwoDesc) {
        this.considerationTwoDesc = considerationTwoDesc;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

}
