/* =============================================================
 * 工程名称：信息管理系统
 * 对象名称：ZhglState.java
 * 创建时间：2016年8月2日 下午4:50:27
 * (R) Copyright 贵州小小马驹科技有限公司 (广州市番禺区大石镇植村村东南大街5号)
 * =============================================================
 */
package com.jhmedia.master.state;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 账号管理 状态类型
 * <pre>
 * 概要: 定义有关账号管理的各种状态类型值常量
 * 更新: 2016年8月2日 下午4:50:27
 * 作者: seki
 * 版本: $Rev$
 * ID  ：$Id$
 * </pre>
 */
public class ZhglState extends SysStateSupport {
    private static Map<String, SysStateSupport> stateMapAll = new HashMap<String, SysStateSupport>();
    private static Map<String, SysStateSupport> zhlxMap = new HashMap<String, SysStateSupport>();

    public ZhglState(String type_code, String short_desc) {
        this.type_code = type_code;
        this.short_desc = short_desc;
    }

    public static final ZhglState WJH = new ZhglState("0", "未激活");
    public static final ZhglState YJH = new ZhglState("1", "已激活");
    public static final ZhglState YSC = new ZhglState("2", "已删除");
    public static final ZhglState YDJ = new ZhglState("3", "已冻结");

    public static final ZhglState GLY = new ZhglState("1", "管理员");
    public static final ZhglState YH = new ZhglState("2", "用户");
    public static final ZhglState CS = new ZhglState("3", "测试员");

    static {
        stateMapAll.put(WJH.getType_code(), WJH);
        stateMapAll.put(YJH.getType_code(), YJH);
        stateMapAll.put(YSC.getType_code(), YSC);
        stateMapAll.put(YDJ.getType_code(), YDJ);

        zhlxMap.put(GLY.getType_code(), GLY);
        zhlxMap.put(YH.getType_code(), YH);
        zhlxMap.put(CS.getType_code(), CS);
    }

    /**
     * 根据类型code取得state对象
     * @param type_code
     * @return
     */
    public static ZhglState codeToState(String type_code) {
        return (ZhglState) stateMapAll.get(type_code);
    }

    /**
     * 根据账号状态code取得账号状态名称
     * @param type_code
     * @return
     */
    public static String codeToDescByZhzt(String type_code) {
        return getDescOfCode(stateMapAll, type_code);
    }

    /**
     * 根据账号类型code取得账号类型名称
     * @param type_code
     * @return
     */
    public static String codeToDescByZhlx(String type_code) {
        return getDescOfCode(zhlxMap, type_code);
    }

    /**
     * 获取账号状态列表
     * @return
     */
    public static List<String[]> findZhzt() {
        return makeStateList(stateMapAll);
    }

    /**
     * 获取账号类型列表
     */
    public static List<String[]> findZhlx() {
        return makeStateList(zhlxMap);
    }

}
