/* =============================================================
 * 工程名称：信息管理系统
 * 对象名称：ZhglService.java
 * 创建时间：2016年8月2日 下午7:35:01
 * (R) Copyright 贵州小小马驹科技有限公司 (广州市番禺区大石镇植村村东南大街5号)
 * =============================================================
 */
package com.jhmedia.master.service.system;

import java.util.List;

import com.jhmedia.master.util.Page;
import com.jhmedia.master.util.PageData;

/**
 * 账号管理Service
 * <pre>
 * 概要: 账号管理
 * 更新: 2016年8月2日 下午7:35:01
 * 作者: seki
 * 版本: $Rev$
 * ID  ：$Id$
 * </pre>
 */
public interface ZhglService {

    /**
     * 查询账号分页列表
     * @param pd
     * @return
     * @throws Exception
     */
    @SuppressWarnings("rawtypes")
    public List<PageData> findZhListPage(Page page) throws Exception;

    /**
     * 更新账号状态
     * @param pd
     * @throws Exception
     */
    public void updateZhzt(PageData pd) throws Exception;

    /**
     * 修改密码
     * @param pd
     * @throws Exception
     */
    public void updateZhmm(PageData pd) throws Exception;

}
