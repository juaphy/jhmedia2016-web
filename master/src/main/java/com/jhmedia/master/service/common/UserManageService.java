/* =============================================================
 * 工程名称：信息管理系统
 * 对象名称：UserManageService.java
 * 创建时间：2016年7月31日 下午10:32:54
 * (R) Copyright 贵州小小马驹科技有限公司 (广州市番禺区大石镇植村村东南大街5号)
 * =============================================================
 */
package com.jhmedia.master.service.common;

import com.jhmedia.master.util.PageData;

/**
 * 用户管理
 * <pre>
 * 概要: 用户管理用到的DB操作方法
 * 更新: 2016年7月31日 下午10:32:54
 * 作者: seki
 * 版本: $Rev$
 * ID  ：$Id$
 * </pre>
 */
public interface UserManageService {

    /**
     * 根据用户名查询用户
     * @param pd
     * @return
     * @throws Exception
     */
    public PageData findYhByYhm(PageData pd) throws Exception;

}
