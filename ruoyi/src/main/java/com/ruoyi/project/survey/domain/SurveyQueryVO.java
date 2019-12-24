package com.ruoyi.project.survey.domain;

import javax.validation.constraints.NotNull;
import java.util.List;

/**
 * 【请填写功能名称】对象 survey_user
 * 
 * @author ruoyi
 * @date 2019-12-11
 */
public class SurveyQueryVO
{
    private static final long serialVersionUID = 1L;
    /** 格式 YYYY-MM-DD */
    private String startDate;
    /** 格式 YYYY-MM-DD */
    private String endDate;
    /** 类型，与SurveyVO中type一致，默认1*/
    private Integer type;

    /**
     * 就是channel
     */
    private String source;

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }
}
