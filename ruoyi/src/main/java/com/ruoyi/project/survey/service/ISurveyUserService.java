package com.ruoyi.project.survey.service;

import com.ruoyi.project.survey.domain.SurveyUser;

import java.util.List;

/**
 * 【请填写功能名称】Service接口
 * 
 * @author ruoyi
 * @date 2019-12-11
 */
public interface ISurveyUserService 
{
    /**
     * 查询【请填写功能名称】
     * 
     * @param id 【请填写功能名称】ID
     * @return 【请填写功能名称】
     */
    public SurveyUser selectSurveyUserById(Long id);

    /**
     * 查询【请填写功能名称】列表
     * 
     * @param surveyUser 【请填写功能名称】
     * @return 【请填写功能名称】集合
     */
    public List<SurveyUser> selectSurveyUserList(SurveyUser surveyUser);

    /**
     * 新增【请填写功能名称】
     * 
     * @param surveyUser 【请填写功能名称】
     * @return 结果
     */
    public int insertSurveyUser(SurveyUser surveyUser);

    /**
     * 修改【请填写功能名称】
     * 
     * @param surveyUser 【请填写功能名称】
     * @return 结果
     */
    public int updateSurveyUser(SurveyUser surveyUser);

    /**
     * 批量删除【请填写功能名称】
     * 
     * @param ids 需要删除的【请填写功能名称】ID
     * @return 结果
     */
    public int deleteSurveyUserByIds(Long[] ids);

    /**
     * 删除【请填写功能名称】信息
     * 
     * @param id 【请填写功能名称】ID
     * @return 结果
     */
    public int deleteSurveyUserById(Long id);

    public SurveyUser selectSurveyUserByMobile(String mobile);

    public List<SurveyUser> selectTwentyList(String source);
}
