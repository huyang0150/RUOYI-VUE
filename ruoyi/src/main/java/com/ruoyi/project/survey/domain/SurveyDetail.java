package com.ruoyi.project.survey.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.framework.aspectj.lang.annotation.Excel;
import com.ruoyi.framework.web.domain.BaseEntity;

import java.util.Date;

/**
 * 【请填写功能名称】对象 survey_detail
 * 
 * @author ruoyi
 * @date 2019-12-11
 */
public class SurveyDetail extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** $column.columnComment */
    private Long id;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private Long surveyUserId;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private Integer satisfication;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private Boolean transfer;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private Integer considerationOne;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private Integer considerationTwo;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private Integer status;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private String context;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private Boolean isDeleted;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private Date gmtCreated;

    private String source;

    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }
    public void setSurveyUserId(Long surveyUserId) 
    {
        this.surveyUserId = surveyUserId;
    }

    public Long getSurveyUserId() 
    {
        return surveyUserId;
    }
    public void setSatisfication(Integer satisfication) 
    {
        this.satisfication = satisfication;
    }

    public Integer getSatisfication()
    {
        return satisfication;
    }
    public void setTransfer(Boolean transfer)
    {
        this.transfer = transfer;
    }

    public Boolean getTransfer()
    {
        return transfer;
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
    public void setStatus(Integer status) 
    {
        this.status = status;
    }

    public Integer getStatus() 
    {
        return status;
    }
    public void setContext(String context) 
    {
        this.context = context;
    }

    public String getContext() 
    {
        return context;
    }
    public void setIsDeleted(Boolean isDeleted)
    {
        this.isDeleted = isDeleted;
    }

    public Boolean getIsDeleted()
    {
        return isDeleted;
    }

    public Date getGmtCreated() {
        return gmtCreated;
    }

    public void setGmtCreated(Date gmtCreated) {
        this.gmtCreated = gmtCreated;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
                .append("id", getId())
                .append("surveyUserId", getSurveyUserId())
                .append("satisfication", getSatisfication())
                .append("transfer", getTransfer())
                .append("considerationOne", getConsiderationOne())
                .append("status", getStatus())
                .append("context", getContext())
                .append("isDeleted", getIsDeleted())
                .append("considerationTwo", getConsiderationTwo())
                .append("gmtCreated", getGmtCreated())
                .toString();
    }
}
