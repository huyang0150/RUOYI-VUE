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
public enum MobileOperatorEnum {
    LIANTONG(1, "联通"),
    YIDONG(2, "移动"),
    DIANXIN(3, "电信"),
    VIRTUAL(4, "虚拟运营商"),
    OTHER(5, "未识别");


    private Integer code;

    private String name;

    /**
     * 存放所有的code和enum的转换.
     */
    private static final Map<Integer, MobileOperatorEnum> MOBILE_OPERATOR_ENUM_MAP = new ConcurrentHashMap<Integer, MobileOperatorEnum>(
        MobileOperatorEnum.values().length);

    MobileOperatorEnum(Integer code, String name) {
        this.code = code;
        this.name = name;
    }

    static {
        /**
         * 将所有的实体类放入到map中,提供查询.
         */
        for (MobileOperatorEnum cardType : EnumSet.allOf(MobileOperatorEnum.class)) {
            MOBILE_OPERATOR_ENUM_MAP.put(cardType.code, cardType);
        }
    }

    public Integer getCode() {
        return code;
    }

    public String getName() {
        return name;
    }

    //根据类型获取枚举
    public static MobileOperatorEnum getByCode(Integer code) {
        return MOBILE_OPERATOR_ENUM_MAP.get(code);
    }


}
