package com.ruoyi.project.survey.service;

import com.ruoyi.project.survey.domain.SurveyCoupon;
import java.util.List;

/**
 * 【请填写功能名称】Service接口
 * 
 * @author ruoyi
 * @date 2019-12-11
 */
public interface ISurveyCouponService 
{
    public Boolean occupyCoupon(Integer type);

    public void releaseCoupon(Integer type);

    public SurveyCoupon getSurveyCouponByType(Integer type);
}
