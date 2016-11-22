/* =============================================================
 * 工程名称：信息管理系统
 * 对象名称：SysStateSupport.java
 * 创建时间：2016年8月2日 下午6:21:59
 * (R) Copyright 贵州小小马驹科技有限公司 (广州市番禺区大石镇植村村东南大街5号)
 * =============================================================
 */
package com.jhmedia.master.state;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * State基类
 * <pre>
 * 概要: State基类
 * 更新: 2016年8月2日 下午6:21:59
 * 作者: seki
 * 版本: $Rev$
 * ID  ：$Id$
 * </pre>
 */
public class SysStateSupport {

    protected static final Logger logger = LoggerFactory.getLogger(SysStateSupport.class);

    /**
     * 类型code
     */
    protected String type_code;

    /**
     * 类型名称
     */
    protected String short_desc;

    /**
     * 取得类型code
     * @return
     */
    public String getType_code() {
        return type_code;
    }

    /**
     * 取得类型名称
     * @return
     */
    public String getShort_desc() {
        return short_desc;
    }

    /**
     * 将类型值转换成数组
     * @param stateMap
     * @return
     */
    protected static List<String[]> makeStateList(Map<String, SysStateSupport> stateMap) {
        Iterator<String> iterator = stateMap.keySet().iterator();
        List<String[]> lst = new ArrayList<String[]>();
        while(iterator.hasNext()) {
            String type_code = (String) iterator.next();
            logger.debug("type_code:" + type_code);
            SysStateSupport stateSupport = stateMap.get(type_code);
            String ss[] = new String[2];
            ss[0] = stateSupport.getType_code();
            ss[1] = stateSupport.getShort_desc();

            lst.add(ss);
        }
        return lst;
    }

    /**
     * 根据类型code取得类型名称
     * @param stateMap
     * @param type_code
     * @return
     */
    protected static String getDescOfCode(Map<String, SysStateSupport> stateMap,
        String type_code) {
        SysStateSupport state = stateMap.get(type_code);
        return state == null ? "" : state.getShort_desc();
    }

}
