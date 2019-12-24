package com.ruoyi.project.survey.domain;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.List;

/**
 * 【请填写功能名称】对象 survey_user
 * 
 * @author ruoyi
 * @date 2019-12-11
 */
public class SurveyVO
{
    private static final long serialVersionUID = 1L;
    /** 手机号 */
    @NotNull
    private String mobile;

    /** 满意度
     EXTREMELY(1, "非常满意"),
     GENERAL(2, "一般满意"),
     NOT(3, "不满意");
     */
    @NotNull
    private Integer satisfication;

    /** 是否携号转网
     是：true
     否：false
     */
    @NotNull
    private Boolean transfer;

    /** 选择运营商主要考虑的因素
     NETWORK_QUALITY(1, "网络质量"),
     TARIF(2, "资费"),
     SERVICE(3, "服务"),
     EVALUATION(4, "口碑"),
     VIRTUAL_NETWORK(5, "虚拟网"),
     OTHER(6, "其他");
     */
    List<Integer> considerations;

    /** $column.columnComment */
    private String context;

    /**
     * 优惠券类型
     */
    private Integer type;

    private String channelId;

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public Integer getSatisfication() {
        return satisfication;
    }

    public void setSatisfication(Integer satisfication) {
        this.satisfication = satisfication;
    }

    public Boolean getTransfer() {
        return transfer;
    }

    public void setTransfer(Boolean transfer) {
        this.transfer = transfer;
    }

    public List<Integer> getConsiderations() {
        return considerations;
    }

    public void setConsiderations(List<Integer> considerations) {
        this.considerations = considerations;
    }

    public String getContext() {
        return context;
    }

    public void setContext(String context) {
        this.context = context;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getChannelId() {
        return channelId;
    }

    public void setChannelId(String channelId) {
        this.channelId = channelId;
    }
}
