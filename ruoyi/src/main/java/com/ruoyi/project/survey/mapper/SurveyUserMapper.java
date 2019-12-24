package com.ruoyi.project.survey.mapper;

import com.ruoyi.project.survey.domain.SurveyUser;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 【请填写功能名称】Mapper接口
 * 
 * @author ruoyi
 * @date 2019-12-11
 */
public interface SurveyUserMapper 
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
     * 删除【请填写功能名称】
     * 
     * @param id 【请填写功能名称】ID
     * @return 结果
     */
    public int deleteSurveyUserById(Long id);

    /**
     * 批量删除【请填写功能名称】
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteSurveyUserByIds(Long[] ids);

    /**
     * 查询【请填写功能名称】
     *
     * @param mobile 【请填写功能名称】ID
     * @return 【请填写功能名称】
     */
    public SurveyUser selectSurveyUserByMobile(String mobile);

    public List<SurveyUser> selectTwentyList(@Param(value = "source") String source);
}
