/* =============================================================
 * 工程名称：信息管理系统
 * 对象名称：StringUtil.java
 * 创建时间：2016年8月13日 下午3:58:27
 * (R) Copyright jhmedia 婧涵影视
 * (作于：广州市番禺区大石镇植村村东南大街5号)
 * =============================================================
 */
package com.jhmedia.front.util;

/**
 * TODO
 * <pre>
 * 概要: TODO
 * 更新: 2016年8月13日 下午3:58:27
 * 作者: seki
 * </pre>
 */
public class StringUtil {

    public static final String EMPTY = "";
    public static final String NULL = "null";

    /**
     * 判断字符串是否为空串（null, "", "null"）
     * @param value
     * @return 为空，返回true;反之，返回false
     */
    public static boolean isEmpty(String value) {
        return value == null || EMPTY.equals(value) || NULL.equals(value);
    }

}
