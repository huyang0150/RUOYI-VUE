package com.ruoyi.project.survey.service;

import com.ruoyi.project.survey.domain.SurveyVO;

/**
 * 发送短信服务
 * 
 * @author ruoyi
 * @date 2019-12-11
 */
public interface ISMSService
{
    public Boolean sendSMS(String mobile, String coupon);
}
