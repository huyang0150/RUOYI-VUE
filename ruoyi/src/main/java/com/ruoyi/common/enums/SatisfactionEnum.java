/*
 * Copyright (c) 2001-2017 GuaHao.com Corporation Limited. All rights reserved. 
 * This software is the confidential and proprietary information of GuaHao Company. 
 * ("Confidential Information"). 
 * You shall not disclose such Confidential Information and shall use it only 
 * in accordance with the terms of the license agreement you entered into with GuaHao.com.
 */
package com.ruoyi.common.enums;

import java.util.EnumSet;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * 满意度枚举
 */
public enum SatisfactionEnum {
    EXTREMELY(1, "非常满意"),
    GENERAL(2, "一般满意"),
    NOT(3, "不满意");


    private Integer code;

    private String name;

    /**
     * 存放所有的code和enum的转换.
     */
    private static final Map<Integer, SatisfactionEnum> SATISFACTION_ENUM_MAP = new ConcurrentHashMap<Integer, SatisfactionEnum>(
        SatisfactionEnum.values().length);

    SatisfactionEnum(Integer code, String name) {
        this.code = code;
        this.name = name;
    }

    static {
        /**
         * 将所有的实体类放入到map中,提供查询.
         */
        for (SatisfactionEnum cardType : EnumSet.allOf(SatisfactionEnum.class)) {
            SATISFACTION_ENUM_MAP.put(cardType.code, cardType);
        }
    }

    public Integer getCode() {
        return code;
    }

    public String getName() {
        return name;
    }

    //根据类型获取枚举
    public static SatisfactionEnum getByCode(Integer code) {
        return SATISFACTION_ENUM_MAP.get(code);
    }


}
