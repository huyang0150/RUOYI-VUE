package com.ruoyi.project.survey.controller;
;
import com.alibaba.fastjson.JSON;
import com.google.common.collect.Lists;
import com.ruoyi.common.constant.HttpStatus;
import com.ruoyi.common.utils.CheckUtils;
import com.ruoyi.common.utils.file.FileDownloadUtil;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.framework.aspectj.lang.annotation.Log;
import com.ruoyi.framework.aspectj.lang.enums.BusinessType;
import com.ruoyi.framework.config.RuoYiConfig;
import com.ruoyi.framework.web.controller.BaseController;
import com.ruoyi.framework.web.domain.AjaxResult;
import com.ruoyi.framework.web.page.TableDataInfo;
import com.ruoyi.project.survey.domain.SurveyDetail;
import com.ruoyi.project.survey.domain.SurveyQueryVO;
import com.ruoyi.project.survey.domain.SurveyUser;
import com.ruoyi.project.survey.domain.SurveyVO;
import com.ruoyi.project.survey.service.ISurveyDetailService;
import com.ruoyi.project.survey.service.ISurveyService;
import com.ruoyi.project.survey.service.ISurveyUserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.util.List;

/**
 * 【请填写功能名称】Controller
 * 
 * @author ruoyi
 * @date 2019-12-11
 */
@RestController
@RequestMapping("/survey")
public class SurveyController extends BaseController
{
    private static final Logger log = LoggerFactory.getLogger(SurveyController.class);
    @Autowired
    private ISurveyService surveyService;

    @Autowired
    private ISurveyDetailService surveyDetailService;


    /**
     * 查询【请填写功能名称】列表
     */
    @PostMapping
    public AjaxResult survey(@RequestBody SurveyVO surveyVO)
    {
        if(!CheckUtils.checkMobile(surveyVO.getMobile())){
            return AjaxResult.error(HttpStatus.UNSUPPORTED_TYPE,"手机号格式错误");
        }
        //List<SurveyUser> list = surveyUserService.selectSurveyUserList(surveyVO);
        return surveyService.survey(surveyVO, surveyVO.getChannelId());
    }

    /**
     * 导出详情到excel
     * 第一列：电话；
     * 第二列：运营商是否满意
     * 第三列：是否会携号转网
     * 第四列：选择运营商因素
     * @param surveyQueryVO
     * @return
     */
    @PostMapping("/export")
    public AjaxResult expert(@RequestBody SurveyQueryVO surveyQueryVO)
    {
        return surveyService.export(surveyQueryVO);
    }

    /**
     *
     * @param request
     * @param response
     */
    @GetMapping("/download")
    public void downloadFile(HttpServletRequest request, HttpServletResponse response,
                             @RequestParam(value = "startDate",required=false) String startDate,
                             @RequestParam(value = "endDate",required=false) String endDate,
                             @RequestParam(value = "source",required=false) String source) {
        //File file = new File("D:\\ruoyi\\uploadPath\\download\\aaa_调查统计.xlsx");
        log.info("下载参数：startDate:{}，endDate:{}，source:{}",startDate,endDate,source);
        SurveyQueryVO surveyQueryVO = new SurveyQueryVO();
        surveyQueryVO.setStartDate(startDate);
        surveyQueryVO.setEndDate(endDate);
        surveyQueryVO.setSource(source);
        AjaxResult ajaxResult = surveyService.export(surveyQueryVO);
        if(!ajaxResult.isSuccess()){
            return ;
        }
        String profile = RuoYiConfig.getProfile();
        //String filePath = profile + "\\download\\"+ajaxResult.get(AjaxResult.MSG_TAG);
        String filePath = profile + "/download/" + ajaxResult.get(AjaxResult.MSG_TAG);
        File file = new File(filePath);
        String fileName = "问卷调查结果统计.xlsx";
        log.info("filePath:{}",filePath);
        //log.info("filePath2:{}",filePath2);
        FileDownloadUtil.downloadFile(fileName,file,response,request);
    }

    @GetMapping("/list")
    public AjaxResult list(@RequestParam(value = "channelId",required = false) String source){
        return AjaxResult.success(surveyService.list(source));
    }
}
