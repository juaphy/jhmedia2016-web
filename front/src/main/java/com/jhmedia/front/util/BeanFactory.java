/* =============================================================
 * 工程名称：信息管理系统
 * 对象名称：BeanFactory.java
 * 创建时间：2016年8月13日 下午11:17:24
 * (R) Copyright 贵州小小马驹科技有限公司 (广州市番禺区大石镇植村村东南大街5号)
 * =============================================================
 */
package com.jhmedia.front.util;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

/**
 * TODO
 * <pre>
 * 概要: TODO
 * 更新: 2016年8月13日 下午11:17:24
 * 作者: seki
 * 版本: $Rev$
 * ID  ：$Id$
 * </pre>
 */
public class BeanFactory implements ApplicationContextAware {

    // spring应用上下文环境
    private static ApplicationContext applicationContext;

    public static <T> T getInstance(Class<T> clazz) {
        ApplicationContext webContext = getApplicationContext();
        T t = (T) webContext.getBean(clazz);
        return t;
    }

    public static <T> T getInstance(String name, Class<T> clazz) {
        ApplicationContext webContext = getApplicationContext();
        T t = (T) webContext.getBean(name, clazz);
        return t;
    }

    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        BeanFactory.applicationContext = applicationContext;
    }

    public static ApplicationContext getApplicationContext() {
        return applicationContext;
    }
}
