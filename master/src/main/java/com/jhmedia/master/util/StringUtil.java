/* =============================================================
 * 工程名称：信息管理系统
 * 对象名称：StringUtil.java
 * 创建时间：2016年7月31日 下午7:09:42
 * (R) Copyright 贵州小小马驹科技有限公司 (广州市番禺区大石镇植村村东南大街5号)
 * =============================================================
 */
package com.jhmedia.master.util;

/**
 * String工具类
 * <pre>
 * 概要: 有关String常用的共通方法
 * 更新: 2016年7月31日 下午7:09:42
 * 作者: seki
 * 版本: $Rev$
 * ID  ：$Id$
 * </pre>
 */
public class StringUtil {

    /**
     * 判断字符串是否为空
     * @param value
     * @return null、空串、"null"都表示为空
     */
    public static boolean isEmpty(String value) {
        return value == null || Const.EMPTY.equals(value) || Const.NULL.equals(value);
    }

    /**
     * toString
     * @return
     */
    public static String toString(Object value) {
        return value == null ? "" : value.toString();
    }

}
