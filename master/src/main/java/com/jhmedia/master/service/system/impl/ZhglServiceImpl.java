/* =============================================================
 * 工程名称：信息管理系统
 * 对象名称：ZhglServiceImpl.java
 * 创建时间：2016年8月2日 下午7:36:31
 * (R) Copyright 贵州小小马驹科技有限公司 (广州市番禺区大石镇植村村东南大街5号)
 * =============================================================
 */
package com.jhmedia.master.service.system.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.jhmedia.master.service.common.BaseServiceImpl;
import com.jhmedia.master.service.system.ZhglService;
import com.jhmedia.master.util.MD5;
import com.jhmedia.master.util.Page;
import com.jhmedia.master.util.PageData;
import com.jhmedia.master.util.StringUtil;

/**
 * TODO
 * <pre>
 * 概要: TODO
 * 更新: 2016年8月2日 下午7:36:31
 * 作者: seki
 * 版本: $Rev$
 * ID  ：$Id$
 * </pre>
 */
@Service("ZhglServiceImpl")
public class ZhglServiceImpl extends BaseServiceImpl implements ZhglService {

    private Logger logger = LoggerFactory.getLogger(ZhglServiceImpl.class);

    @SuppressWarnings({ "unchecked", "rawtypes" })
    public List<PageData> findZhListPage(Page page) throws Exception {
        return (List<PageData>) this.daoSupport.findForList("ZhglMapper.zhlistPage", page);
    }

    public void updateZhzt(PageData pd) throws Exception {
        logger.info("ZhglServiceImpl updateZhzt...");
        if (StringUtil.isEmpty(pd.getString("yhid"))
                || StringUtil.isEmpty(String.valueOf(pd.get("zhzt")))) {
            throw new Exception("用户id或更新状态错误!");
        }
        this.daoSupport.update("ZhglMapper.updateZhzt", pd);
    }

    public void updateZhmm(PageData pd) throws Exception {
        logger.info("ZhglServiceImpl updateZhmm...");
        if (StringUtil.isEmpty(pd.getString("yhid"))) {
            throw new Exception("用户id不能为空");
        }
        pd.put("mm", MD5.md5(pd.getString("xmm")));
        this.daoSupport.update("ZhglMapper.updateZhmm", pd);
    }
}
