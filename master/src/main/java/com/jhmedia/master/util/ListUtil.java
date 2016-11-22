/* =============================================================
 * 工程名称：信息管理系统
 * 对象名称：ListUtil.java
 * 创建时间：2016年8月2日 下午8:38:53
 * (R) Copyright 贵州小小马驹科技有限公司 (广州市番禺区大石镇植村村东南大街5号)
 * =============================================================
 */
package com.jhmedia.master.util;

import java.util.List;

import org.apache.poi.ss.formula.functions.T;

/**
 * TODO
 * <pre>
 * 概要: TODO
 * 更新: 2016年8月2日 下午8:38:53
 * 作者: seki
 * 版本: $Rev$
 * ID  ：$Id$
 * </pre>
 */
public class ListUtil {

    /**
     * 判断List是否为空
     * @param list
     * @return null或没有元素，返回true
     */
    @SuppressWarnings("hiding")
    public static <T> boolean isBlank(List<T> list) {
        return (list == null || list.isEmpty());
    }

    /**
     * 判断List是否不为空
     * @param list
     * @return 调用isBlank，然后取非
     */
    @SuppressWarnings("hiding")
    public static <T> boolean isNotBlank(List<T> list) {
        return !isBlank(list);
    }
}
