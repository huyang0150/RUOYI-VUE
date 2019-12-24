package com.ruoyi.project.survey.service;

import com.ruoyi.framework.web.domain.AjaxResult;
import com.ruoyi.project.survey.domain.SurveyQueryVO;
import com.ruoyi.project.survey.domain.SurveyUser;
import com.ruoyi.project.survey.domain.SurveyVO;

import java.util.List;

/**
 * 【请填写功能名称】Service接口
 * 
 * @author ruoyi
 * @date 2019-12-11
 */
public interface ISurveyService
{
    /**
 * 查询【请填写功能名称】
 *
 * @param id 【请填写功能名称】ID
 * @return 【请填写功能名称】
 */
    public AjaxResult survey(SurveyVO surveyVO,String from);

    public AjaxResult export(SurveyQueryVO surveyQueryVO);

    public List<String> list(String source);

}
