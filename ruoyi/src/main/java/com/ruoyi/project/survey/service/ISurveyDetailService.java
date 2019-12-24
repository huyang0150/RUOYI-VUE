package com.ruoyi.project.survey.service;

import com.ruoyi.project.survey.domain.SurveyDetail;
import com.ruoyi.project.survey.domain.SurveyExportPO;

import java.util.Date;
import java.util.List;

/**
 * 【请填写功能名称】Service接口
 * 
 * @author ruoyi
 * @date 2019-12-11
 */
public interface ISurveyDetailService 
{
    /**
     * 查询【请填写功能名称】
     * 
     * @param id 【请填写功能名称】ID
     * @return 【请填写功能名称】
     */
    public SurveyDetail selectSurveyDetailById(Long id);

    /**
     * 查询【请填写功能名称】列表
     * 
     * @param surveyDetail 【请填写功能名称】
     * @return 【请填写功能名称】集合
     */
    public List<SurveyDetail> selectSurveyDetailList(SurveyDetail surveyDetail);

    /**
     * 新增【请填写功能名称】
     * 
     * @param surveyDetail 【请填写功能名称】
     * @return 结果
     */
    public int insertSurveyDetail(SurveyDetail surveyDetail);

    /**
     * 修改【请填写功能名称】
     * 
     * @param surveyDetail 【请填写功能名称】
     * @return 结果
     */
    public int updateSurveyDetail(SurveyDetail surveyDetail);

    /**
     * 批量删除【请填写功能名称】
     * 
     * @param ids 需要删除的【请填写功能名称】ID
     * @return 结果
     */
    public int deleteSurveyDetailByIds(Long[] ids);

    /**
     * 删除【请填写功能名称】信息
     * 
     * @param id 【请填写功能名称】ID
     * @return 结果
     */
    public int deleteSurveyDetailById(Long id);

    public SurveyDetail selectSurveyDetailByUserId(Long userId);

    public List<SurveyExportPO> getSurveyDetail(Date start, Date end, Integer type, String source);
}
