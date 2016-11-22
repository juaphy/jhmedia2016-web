/* =============================================================
 * 工程名称：信息管理系统
 * 对象名称：DAO.java
 * 创建时间：2016年7月31日 下午10:38:51
 * (R) Copyright 贵州小小马驹科技有限公司 (广州市番禺区大石镇植村村东南大街5号)
 * =============================================================
 */
package com.jhmedia.master.dao;

/**
 * DAO
 * <pre>
 * 概要: DAO
 * 更新: 2016年7月31日 下午10:38:51
 * 作者: seki
 * 版本: $Rev$
 * ID  ：$Id$
 * </pre>
 */
public interface DAO {

    /**
     * 保存对象
     * @param str sql文件名
     * @param obj 参数
     * @return
     * @throws Exception
     */
    public Object save(String str, Object obj) throws Exception;

    /**
     * 修改对象
     * @param str sql文件名
     * @param obj 参数
     * @return
     * @throws Exception
     */
    public Object update(String str, Object obj) throws Exception;

    /**
     * 删除对象 
     * @param str sql文件名
     * @param obj 参数
     * @return
     * @throws Exception
     */
    public Object delete(String str, Object obj) throws Exception;

    /**
     * 根据ID查找对象
     * @param str sql文件名
     * @param obj 参数
     * @return
     * @throws Exception
     */
    public Object findForObject(String str, Object obj) throws Exception;

    /**
     * 查询对象列表
     * @param str sql文件名
     * @return
     * @throws Exception
     * */
    public Object findForList(String str) throws Exception ;

    /**
     * 查找对象列表
     * @param str sql文件名
     * @param obj 参数
     * @return
     * @throws Exception
     */
    public Object findForList(String str, Object obj) throws Exception;

    /**
     * 查找对象封装成Map
     * @param s sql文件名
     * @param obj 参数
     * @return
     * @throws Exception
     */
    public Object findForMap(String str, Object obj, String key , String value) throws Exception;

}
