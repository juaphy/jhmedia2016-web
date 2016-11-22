/* =============================================================
 * 工程名称：信息管理系统
 * 对象名称：BaseServiceImpl.java
 * 创建时间：2016年7月31日 下午10:37:18
 * (R) Copyright 贵州小小马驹科技有限公司 (广州市番禺区大石镇植村村东南大街5号)
 * =============================================================
 */
package com.jhmedia.master.service.common;

import java.util.Iterator;
import java.util.Map;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.jhmedia.master.dao.DaoSupport;
import com.jhmedia.master.util.UuIdUtil;

/**
 * DB服务基类实现
 * <pre>
 * 概要: DB服务基类实现类
 * 更新: 2016年7月31日 下午10:37:18
 * 作者: seki
 * 版本: $Rev$
 * ID  ：$Id$
 * </pre>
 */
public class BaseServiceImpl implements BaseService {
    public Logger logger = LoggerFactory.getLogger(BaseServiceImpl.class);

    @Resource(name = "daoSupport")
    protected DaoSupport daoSupport;

    public Object save(String str, Object obj) throws Exception {
        return this.daoSupport.save(str, obj);
    }

    public Object update(String str, Object obj) throws Exception {
        return this.daoSupport.update(str, obj);
    }

    public Object delete(String str, Object obj) throws Exception {
        return this.daoSupport.delete(str, obj);
    }

    public Object findForObject(String str, Object obj) throws Exception {
        return this.daoSupport.findForObject(str, obj);
    }

    public Object findForList(String str, Object obj) throws Exception {
        return this.daoSupport.findForList(str, obj);
    }

    public Object findForMap(String str, Object obj, String key, String value) throws Exception {
        return this.daoSupport.findForMap(str, obj, key, value);
    }

    public Object findForList(String str) throws Exception {
        return this.daoSupport.findForList(str);
    }

    /**
     * 取得32位的uuid作为表id
     * @return
     */
    public static String get32Uuid() {
        return UuIdUtil.get32Uuid();
    }

    /**
     * 比较两个对象，将新值赋给旧的对象
     * @param newMap 新对象
     * @param oldMap 旧对象
     */
    @SuppressWarnings({ "rawtypes", "unchecked" })
    public void newCopyForOld(Map newMap, Map oldMap) {

        // 把新值赋给旧对象
        if (newMap == null || oldMap == null) {
            oldMap = newMap;
            return;
        }
        Iterator it = newMap.keySet().iterator();
        while(it.hasNext()) {
            Object obj = it.next();
            oldMap.put(obj, newMap.get(obj));
        }
    }

}
