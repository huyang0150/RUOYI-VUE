package com.ruoyi.project.survey.service.impl;

import com.alibaba.fastjson.JSON;
import com.google.common.collect.Lists;
import com.ruoyi.common.constant.HttpStatus;
import com.ruoyi.common.enums.SatisfactionEnum;
import com.ruoyi.common.enums.TransferOperatorConsiderationsEnum;
import com.ruoyi.common.utils.CheckUtils;
import com.ruoyi.common.utils.DateUtils;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.framework.web.domain.AjaxResult;
import com.ruoyi.project.survey.domain.*;
import com.ruoyi.project.survey.service.*;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

/**
 *
 * 
 * @author ruoyi
 * @date 2019-12-11
 */
@Service
public class SurveyServiceImpl implements ISurveyService
{
    private static final Logger log = LoggerFactory.getLogger(SurveyServiceImpl.class);

    @Autowired
    private ISurveyUserService surveyUserService;

    @Autowired
    private ISurveyDetailService surveyDetailService;

    @Autowired
    private ISurveyCouponService surveyCouponService;

    @Autowired
    private ISMSService smsService;

    @Override
    @Transactional(rollbackFor = Exception.class)
    public AjaxResult survey(SurveyVO surveyVO,String source){
        log.info("调查问卷入参：{}",JSON.toJSONString(surveyVO));
        SurveyUser existSurveyUserFirstly = surveyUserService.selectSurveyUserByMobile(surveyVO.getMobile());
        if(existSurveyUserFirstly != null){
            log.info("该手机用户已填写过调查问卷");
            return AjaxResult.error(HttpStatus.CONFLICT,"您已填写过调查问卷");
        }
        fillBasicDeatil(surveyVO, source);
        SurveyUser existSurveyUserSecondly = surveyUserService.selectSurveyUserByMobile(surveyVO.getMobile());
        if(existSurveyUserSecondly == null){
            return AjaxResult.error("系统繁忙，请重试");
        }
        //如果优惠券类型不传，默认是1
        Integer type = surveyVO.getType() == null ? 1:surveyVO.getType();
        boolean existCouponFlag = surveyCouponService.occupyCoupon(type);
        if(!existCouponFlag){
            return AjaxResult.error("优惠券已用尽，请关注其他活动");
        }

        SurveyCoupon surveyCoupon = surveyCouponService.getSurveyCouponByType(type);
        //r如果发送短信失败，则保留已经占用的优惠券（因为不确定发短信那边失败是否会重新发送）
        boolean toSMS = smsService.sendSMS(existSurveyUserSecondly.getMobile(),surveyCoupon.getCoupon());
        if(toSMS){
            existSurveyUserSecondly.setCouponId(surveyCoupon.getId());
            existSurveyUserSecondly.setIsSend(true);
            surveyUserService.updateSurveyUser(existSurveyUserSecondly);
        }else{
            surveyCouponService.releaseCoupon(type);
        }
        return AjaxResult.success("优惠券已发放至您手机，请注意查收");

    }

    @Override
    public AjaxResult export(SurveyQueryVO surveyQueryVO){
        Date start = null;
        if(surveyQueryVO.getStartDate() != null ){
            start = DateUtils.dateTime("yyyy-MM-dd",surveyQueryVO.getStartDate());
        }
        Date end = null;
        if(surveyQueryVO.getEndDate() != null ){
            end = DateUtils.dateTime("yyyy-MM-dd",surveyQueryVO.getEndDate());
        }
        Integer type = 1;
        if(surveyQueryVO.getType() != null){
            type = surveyQueryVO.getType();
        }

        List<SurveyExportBO> listDb = getServeyDetail(start, end, type, surveyQueryVO.getSource());

        ExcelUtil excelUtil = new ExcelUtil<SurveyExportBO>(SurveyExportBO.class);
        /*
        List<SurveyExportBO> list = Lists.newArrayList();
        SurveyExportBO surveyExportBO = new SurveyExportBO();
        surveyExportBO.setMobile("12112321222");
        surveyExportBO.setSatisficationDesc("满意");
        surveyExportBO.setTransferDesc("是");
        surveyExportBO.setConsiderationOneDesc("haoba");
        surveyExportBO.setConsiderationTwoDesc("aaa");
        list.add(surveyExportBO);
         */

        return excelUtil.exportExcel(listDb, "调查统计");
    }

    @Override
    public List<String> list(String source){
        List<SurveyUser> list = surveyUserService.selectTwentyList(source);
        return list.stream().map(x->hidePartMobile(x.getMobile())).collect(Collectors.toList());
    }

    public static void main(String[] args){
        System.out.println(hidePartMobile("03445433456"));;
    }


    public static String hidePartMobile(String mobile){
        if(StringUtils.isEmpty(mobile)){
            return mobile;
        }
        if(CheckUtils.checkMobile(mobile)){
            return mobile.substring(0,3) + "****"+mobile.substring(7,11);
        }
        return mobile;
    }

    private void fillBasicDeatil(SurveyVO surveyVO, String source){
        log.info("------to database-----");
        SurveyUser surveyUser = new SurveyUser();
        surveyUser.setMobile(surveyVO.getMobile());
        surveyUser.setIsSend(false);
        surveyUser.setIsDeleted(false);
        surveyUserService.insertSurveyUser(surveyUser);
        SurveyUser existSurveyUser = surveyUserService.selectSurveyUserByMobile(surveyVO.getMobile());
        if(existSurveyUser == null){
            return;
        }
        SurveyDetail surveyDetail = new SurveyDetail();
        surveyDetail.setSatisfication(surveyVO.getSatisfication());
        if(!CollectionUtils.isEmpty(surveyVO.getConsiderations())){
            surveyDetail.setConsiderationOne(surveyVO.getConsiderations().get(0));
            if(surveyVO.getConsiderations().size() > 1){
                surveyDetail.setConsiderationTwo(surveyVO.getConsiderations().get(1));
            }
        }
        surveyDetail.setTransfer(surveyVO.getTransfer());
        surveyDetail.setContext(surveyVO.getContext());
        surveyDetail.setSurveyUserId(existSurveyUser.getId());
        surveyDetail.setStatus(1);
        surveyDetail.setIsDeleted(false);
        surveyDetail.setGmtCreated(new Date());
        surveyDetail.setSource(source);
        surveyDetailService.insertSurveyDetail(surveyDetail);
    }

    private List<SurveyExportBO> getServeyDetail(Date start, Date end, Integer type, String source){
        List<SurveyExportPO> pos = surveyDetailService.getSurveyDetail(start,end,type,source);
        return transform(pos);
    }

    private List<SurveyExportBO> transform(List<SurveyExportPO> pos){
        if(CollectionUtils.isEmpty(pos)){
            return Collections.emptyList();
        }
        return pos.stream().map(SurveyServiceImpl::transform).collect(Collectors.toList());
    }

    private static SurveyExportBO transform(SurveyExportPO po){
        if(po == null){
            return null;
        }
        SurveyExportBO bo = new SurveyExportBO();
        bo.setMobile(po.getMobile());
        SatisfactionEnum saticfication = SatisfactionEnum.getByCode(po.getSatisfication());
        bo.setSatisficationDesc(saticfication == null ? null: saticfication.getName());
        bo.setTransferDesc(po.getTransfer() == true ? "是" : "否");
        TransferOperatorConsiderationsEnum one = TransferOperatorConsiderationsEnum.getByCode(po.getConsiderationOne());
        bo.setConsiderationOneDesc(one == null ? null : one.getName());
        if(po.getConsiderationTwo() != null){
            TransferOperatorConsiderationsEnum two = TransferOperatorConsiderationsEnum.getByCode(po.getConsiderationTwo());
            bo.setConsiderationTwoDesc( two == null ? null : two.getName());
        }
        return bo;
    }
}
