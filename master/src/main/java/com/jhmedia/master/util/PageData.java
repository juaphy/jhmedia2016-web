/* =============================================================
 * 工程名称：信息管理系统
 * 对象名称：PageData.java
 * 创建时间：2016年7月30日 下午11:58:47
 * (R) Copyright 贵州小小马驹科技有限公司 (广州市番禺区大石镇植村村东南大街5号)
 * =============================================================
 */
package com.jhmedia.master.util;

import java.beans.BeanInfo;
import java.beans.IntrospectionException;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.lang.reflect.InvocationTargetException;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 页面数据
 * <pre>
 * 概要: 处理页面传递到后台的变量，并put到map中
 * 更新: 2016年7月30日 下午11:58:47
 * 作者: seki
 * 版本: $Rev$
 * ID  ：$Id$
 * </pre>
 */
@SuppressWarnings("rawtypes")
public class PageData extends HashMap implements Map {

    private static final long serialVersionUID = -6343402196565651319L;
    Logger logger = LoggerFactory.getLogger(PageData.class);
    Map map = null;
    HttpServletRequest request;

    /**
     * 从request中取得变量
     * @param request
     */
    @SuppressWarnings("unchecked")
    public PageData(HttpServletRequest request) {
        this.request = request;
        Map properties = request.getParameterMap();
        Map rtnMap = new HashMap();
        Iterator entries = properties.entrySet().iterator();
        Map.Entry entry;
        String name = "";
        String value = "";
        while (entries.hasNext()) {
            entry = (Map.Entry) entries.next();
            name = (String) entry.getKey();
            Object valueObj = entry.getValue();
            if (valueObj == null) {
                value = "";
            } else if (valueObj instanceof String[]) {
                String[] values = (String[]) valueObj;
                for (int i = 0; i < values.length; i++) {
                    value= values[i] + ",";
                }
                value = value.substring(0,value.length() - 1);
            } else {
                value = valueObj.toString();
            }
            rtnMap.put(name, value);
        }
        map = rtnMap;
    }

    /**
     * 无参构造方法
     */
    public PageData() {
        map = new HashMap();
    }
    @Override
    public int size() {
        return map.size();
    }

    @Override
    public boolean isEmpty() {
        return map.isEmpty();
    }

    /**
     * 重写的get方法
     */
    @Override
    public Object get(Object key) {
        Object obj = null;
        if (map.get(key) instanceof Object[]) {
            Object[] arr = (Object[]) map.get(key);
            obj = request == null ? arr : 
                (request.getParameter((String) key)) == null ? arr : arr[0];
        } else {
            obj = map.get(key);
        }
        return obj;
    }

    /**
     * 获取字符串型变量的值
     * @param key
     * @return
     */
    public String getString(Object key) {
        return (String) map.get(key);
    }
    @Override
    public boolean containsKey(Object key) {
        return map.containsKey(key);
    }

    @SuppressWarnings("unchecked")
    @Override
    public Object put(Object key, Object value) {
        return map.put(key, value);
    }

    @SuppressWarnings("unchecked")
    @Override
    public void putAll(Map m) {
        map.putAll(m);
    }

    @Override
    public Object remove(Object key) {
        return map.remove(key);
    }

    @Override
    public void clear() {
        map.clear();
    }

    @Override
    public boolean containsValue(Object value) {
        return map.containsValue(value);
    }

    @Override
    public Set keySet() {
        return map.keySet();
    }

    @Override
    public Collection values() {
        return map.values();
    }

    @Override
    public Set entrySet() {
        return map.entrySet();
    }

    /**
     * 将一个Map转换成一个JavaBean对象
     * @param type 要转化成为的类型
     * @param map 包含属性值的Map
     * @return 转化出来的JavaBean对象
     * @throws IntrospectionException 如果分析类属性失败 
     * @throws InstantiationException 如果实例化 JavaBean失败 
     * @throws IllegalAccessException 如果实例化 JavaBean失败 
     * @throws InvocationTargetException InvocationTargetException
     */
    public Object converntToBean(Class type) throws IntrospectionException, InstantiationException,
        IllegalAccessException {

        // 获取类属性
        BeanInfo beanInfo = Introspector.getBeanInfo(type);

        // 创建JavaBean对象
        Object obj = type.newInstance();

        if (map == null) {
            return obj;
        }

        // 给JavaBean对象的属性赋值
        PropertyDescriptor[] propertyDescriptors = beanInfo.getPropertyDescriptors();
        for (int i = 0; i < propertyDescriptors.length; i++) {
            PropertyDescriptor descriptor = propertyDescriptors[i];
            String propertyName = descriptor.getName();
            if (map.containsKey(propertyName)) {
                try {
                    Object value = map.get(propertyName);
                    Object args[] = new Object[1];
                    args[0] = value;
                    descriptor.getWriteMethod().invoke(obj, args);
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                    logger.error(e.toString());
                } catch (IllegalArgumentException e) {
                    e.printStackTrace();
                    logger.error(e.toString());
                } catch (InvocationTargetException e) {
                    e.printStackTrace();
                    logger.error(e.toString());
                }
            }
        }
        return obj;
    }

}
