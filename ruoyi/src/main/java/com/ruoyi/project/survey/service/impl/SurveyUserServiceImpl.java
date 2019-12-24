package com.ruoyi.project.survey.service.impl;

import java.util.List;

import com.ruoyi.project.survey.domain.SurveyUser;
import com.ruoyi.project.survey.mapper.SurveyUserMapper;
import com.ruoyi.project.survey.service.ISurveyUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 【请填写功能名称】Service业务层处理
 * 
 * @author ruoyi
 * @date 2019-12-11
 */
@Service
public class SurveyUserServiceImpl implements ISurveyUserService
{
    @Autowired
    private SurveyUserMapper surveyUserMapper;

    /**
     * 查询【请填写功能名称】
     * 
     * @param id 【请填写功能名称】ID
     * @return 【请填写功能名称】
     */
    @Override
    public SurveyUser selectSurveyUserById(Long id)
    {
        return surveyUserMapper.selectSurveyUserById(id);
    }

    /**
     * 查询【请填写功能名称】列表
     * 
     * @param surveyUser 【请填写功能名称】
     * @return 【请填写功能名称】
     */
    @Override
    public List<SurveyUser> selectSurveyUserList(SurveyUser surveyUser)
    {
        return surveyUserMapper.selectSurveyUserList(surveyUser);
    }

    /**
     * 新增【请填写功能名称】
     * 
     * @param surveyUser 【请填写功能名称】
     * @return 结果
     */
    @Override
    public int insertSurveyUser(SurveyUser surveyUser)
    {
        return surveyUserMapper.insertSurveyUser(surveyUser);
    }

    /**
     * 修改【请填写功能名称】
     * 
     * @param surveyUser 【请填写功能名称】
     * @return 结果
     */
    @Override
    public int updateSurveyUser(SurveyUser surveyUser)
    {
        return surveyUserMapper.updateSurveyUser(surveyUser);
    }

    /**
     * 批量删除【请填写功能名称】
     * 
     * @param ids 需要删除的【请填写功能名称】ID
     * @return 结果
     */
    @Override
    public int deleteSurveyUserByIds(Long[] ids)
    {
        return surveyUserMapper.deleteSurveyUserByIds(ids);
    }

    /**
     * 删除【请填写功能名称】信息
     * 
     * @param id 【请填写功能名称】ID
     * @return 结果
     */
    @Override
    public int deleteSurveyUserById(Long id)
    {
        return surveyUserMapper.deleteSurveyUserById(id);
    }

    @Override
    public SurveyUser selectSurveyUserByMobile(String mobile)
    {
        return surveyUserMapper.selectSurveyUserByMobile(mobile);
    }

    @Override
    public List<SurveyUser> selectTwentyList(String source)
    {
        return surveyUserMapper.selectTwentyList(source);
    }
}
