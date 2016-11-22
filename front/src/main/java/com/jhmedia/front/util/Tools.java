/* =============================================================
 * 工程名称：信息管理系统
 * 对象名称：Tools.java
 * 创建时间：2016年8月13日 下午4:53:01
 * (R) Copyright jhmedia 婧涵影视
 * (作于：广州市番禺区大石镇植村村东南大街5号)
 * =============================================================
 */
package com.jhmedia.front.util;

/**
 * 共通方法
 * <pre>
 * 概要: 常用的共通方法
 * 更新: 2016年8月13日 下午4:53:01
 * 作者: seki
 * </pre>
 */
public class Tools {

    /**
     * 判断是否是数字
     * @param value
     * @return
     */
    public static boolean isNumber(String value) {
        String regex = "^(-?[1-9]\\d*\\.?\\d*)|(-?0\\.\\d*[1-9])|(-?[0])|(-?[0]\\.\\d*)$";
        return value.matches(regex);
    }

}
