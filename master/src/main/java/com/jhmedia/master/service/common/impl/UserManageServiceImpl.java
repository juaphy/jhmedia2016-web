/* =============================================================
 * 工程名称：信息管理系统
 * 对象名称：UserManageServiceImpl.java
 * 创建时间：2016年7月31日 下午10:33:59
 * (R) Copyright 贵州小小马驹科技有限公司 (广州市番禺区大石镇植村村东南大街5号)
 * =============================================================
 */
package com.jhmedia.master.service.common.impl;

import org.springframework.stereotype.Service;

import com.jhmedia.master.service.common.BaseServiceImpl;
import com.jhmedia.master.service.common.UserManageService;
import com.jhmedia.master.util.PageData;

/**
 * TODO
 * <pre>
 * 概要: TODO
 * 更新: 2016年7月31日 下午10:33:59
 * 作者: seki
 * 版本: $Rev$
 * ID  ：$Id$
 * </pre>
 */
@Service("UserManageServiceImpl")
public class UserManageServiceImpl extends BaseServiceImpl implements UserManageService {

    public PageData findYhByYhm(PageData pd) throws Exception {
        return (PageData) daoSupport.findForObject("UserManageMapper.findYhByYhm", pd);
    }


}
