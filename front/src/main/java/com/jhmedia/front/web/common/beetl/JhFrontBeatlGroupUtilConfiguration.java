/* =============================================================
 * 工程名称：信息管理系统
 * 对象名称：JhFrontBeatlGroupUtilConfiguration.java
 * 创建时间：2016年8月13日 下午11:29:37
 * (R) Copyright 贵州小小马驹科技有限公司 (广州市番禺区大石镇植村村东南大街5号)
 * =============================================================
 */
package com.jhmedia.front.web.common.beetl;

import org.beetl.core.Configuration;
import org.beetl.core.GroupTemplate;
import org.beetl.core.resource.ClasspathResourceLoader;
import org.beetl.ext.spring.BeetlGroupUtilConfiguration;

/**
 * 自定义BeetlGroupUtilConfiguration
 * <pre>
 * 概要: 继承自BeetlGroupUtilConfiguration
 * 更新: 2016年8月13日 下午11:29:37
 * 作者: seki
 * 版本: $Rev$
 * ID  ：$Id$
 * </pre>
 */
public class JhFrontBeatlGroupUtilConfiguration extends BeetlGroupUtilConfiguration {

    @Override
    public void init() {
        try {
            initGroupTemplate();
            config(groupTemplate);
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("加载GroupTemplate失败", e);
        }
    }

    private void initGroupTemplate() throws Exception {

        // 配置数据加载
        Configuration configuration = Configuration.defaultConfiguration();

        ClasspathResourceLoader resourceLoader = new ClasspathResourceLoader("/webapp/templates"){
            @Override
            public void init(GroupTemplate gt) {
                this.setAutoCheck(true);
                this.setCharset("UTF-8");
            }
        };

        groupTemplate = new GroupTemplate(resourceLoader, configuration);

        if (errorHandler != null) {
            groupTemplate.setErrorHandler(errorHandler);
        }

        // 设置共享变量
        if (sharedVars != null) {
            groupTemplate.setSharedVars(sharedVars);
        }
    }

}
