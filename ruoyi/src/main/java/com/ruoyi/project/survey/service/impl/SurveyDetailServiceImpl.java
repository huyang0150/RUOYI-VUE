package com.ruoyi.project.survey.service.impl;

import java.util.Date;
import java.util.List;

import com.alibaba.fastjson.JSON;
import com.ruoyi.project.survey.domain.SurveyDetail;
import com.ruoyi.project.survey.domain.SurveyExportPO;
import com.ruoyi.project.survey.mapper.SurveyDetailMapper;
import com.ruoyi.project.survey.service.ISurveyDetailService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 【请填写功能名称】Service业务层处理
 * 
 * @author ruoyi
 * @date 2019-12-11
 */
@Service
public class SurveyDetailServiceImpl implements ISurveyDetailService
{
    private static final Logger log = LoggerFactory.getLogger(SurveyDetailServiceImpl.class);
    @Autowired
    private SurveyDetailMapper surveyDetailMapper;



    /**
     * 查询【请填写功能名称】
     * 
     * @param id 【请填写功能名称】ID
     * @return 【请填写功能名称】
     */
    @Override
    public SurveyDetail selectSurveyDetailById(Long id)
    {
        return surveyDetailMapper.selectSurveyDetailById(id);
    }

    /**
     * 查询【请填写功能名称】列表
     * 
     * @param surveyDetail 【请填写功能名称】
     * @return 【请填写功能名称】
     */
    @Override
    public List<SurveyDetail> selectSurveyDetailList(SurveyDetail surveyDetail)
    {
        return surveyDetailMapper.selectSurveyDetailList(surveyDetail);
    }

    /**
     * 新增【请填写功能名称】
     * 
     * @param surveyDetail 【请填写功能名称】
     * @return 结果
     */
    @Override
    public int insertSurveyDetail(SurveyDetail surveyDetail)
    {
        return surveyDetailMapper.insertSurveyDetail(surveyDetail);
    }

    /**
     * 修改【请填写功能名称】
     * 
     * @param surveyDetail 【请填写功能名称】
     * @return 结果
     */
    @Override
    public int updateSurveyDetail(SurveyDetail surveyDetail)
    {
        return surveyDetailMapper.updateSurveyDetail(surveyDetail);
    }

    /**
     * 批量删除【请填写功能名称】
     * 
     * @param ids 需要删除的【请填写功能名称】ID
     * @return 结果
     */
    @Override
    public int deleteSurveyDetailByIds(Long[] ids)
    {
        return surveyDetailMapper.deleteSurveyDetailByIds(ids);
    }

    /**
     * 删除【请填写功能名称】信息
     * 
     * @param id 【请填写功能名称】ID
     * @return 结果
     */
    @Override
    public int deleteSurveyDetailById(Long id)
    {
        return surveyDetailMapper.deleteSurveyDetailById(id);
    }

    @Override
    public SurveyDetail selectSurveyDetailByUserId(Long userId)
    {
        return surveyDetailMapper.selectSurveyDetailByUserId(userId);
    }

    @Override
    public List<SurveyExportPO> getSurveyDetail(Date start, Date end, Integer type,String source){
        return surveyDetailMapper.selectSurveyExportDetailList(start,end,type,source);
    }
}
