/* =============================================================
 * 工程名称：信息管理系统
 * 对象名称：UuIdUtil.java
 * 创建时间：2016年7月31日 下午10:58:39
 * (R) Copyright 贵州小小马驹科技有限公司 (广州市番禺区大石镇植村村东南大街5号)
 * =============================================================
 */
package com.jhmedia.master.util;

import java.util.UUID;

/**
 * UUID
 * <pre>
 * 概要: 使用java自带的UUID生成32位的字符串，用以设定DB各表用到的id值
 * 更新: 2016年7月31日 下午10:58:39
 * 作者: seki
 * 版本: $Rev$
 * ID  ：$Id$
 * </pre>
 */
public class UuIdUtil {

    /**
     * 获取32位的随机字符串
     * @return 去掉"-"符号的32位字符串
     */
    public static String get32Uuid() {
        String uuid = UUID.randomUUID().toString().replace("-", "");
        return uuid;
    }

}
