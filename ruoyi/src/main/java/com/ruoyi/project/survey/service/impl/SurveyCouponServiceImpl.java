package com.ruoyi.project.survey.service.impl;

import java.util.List;

import com.ruoyi.project.survey.domain.SurveyCoupon;
import com.ruoyi.project.survey.mapper.SurveyCouponMapper;
import com.ruoyi.project.survey.service.ISurveyCouponService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Service;

/**
 * 【请填写功能名称】Service业务层处理
 * 
 * @author ruoyi
 * @date 2019-12-11
 */
@Service
public class SurveyCouponServiceImpl implements ISurveyCouponService
{
    private static final Logger log = LoggerFactory.getLogger(SurveyCouponServiceImpl.class);
    @Autowired
    private SurveyCouponMapper surveyCouponMapper;

    @Override
    public Boolean occupyCoupon(Integer type) {
        //获取并更新
        log.info("-------get coupon-----");
        if(type == null){
            return false;
        }
        int count = surveyCouponMapper.occupyCoupon(type);
        if(count > 0){
            return true;
        }else{
            return false;
        }
    }

    @Override
    public void releaseCoupon(Integer type){
        log.info("-------release coupon-----");
        if(type == null){
            return;
        }
        int count = surveyCouponMapper.releaseCoupon(type);
    }

    @Override
    public SurveyCoupon getSurveyCouponByType(Integer type){
        return surveyCouponMapper.getSurveyCouponByType(type);
    }
}
