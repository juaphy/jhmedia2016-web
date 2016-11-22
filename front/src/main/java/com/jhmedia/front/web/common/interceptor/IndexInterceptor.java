/* =============================================================
 * 工程名称：信息管理系统
 * 对象名称：IndexInterceptor.java
 * 创建时间：2016年8月13日 下午11:52:29
 * (R) Copyright 贵州小小马驹科技有限公司 (广州市番禺区大石镇植村村东南大街5号)
 * =============================================================
 */
package com.jhmedia.front.web.common.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Repository;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

/**
 * TODO
 * <pre>
 * 概要: TODO
 * 更新: 2016年8月13日 下午11:52:29
 * 作者: seki
 * 版本: $Rev$
 * ID  ：$Id$
 * </pre>
 */
@Repository
public class IndexInterceptor extends HandlerInterceptorAdapter {
    @SuppressWarnings("unused")
    private static final String[] NO_FILTERS = new String[] {
            "/login",
            "/index",
            "/toLogin",
            "/js",
            "/images",
            "/css",
            "/font",
            "/skins",
            "/easyui",
            "/code"
            };
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
            throws Exception {
        String uri = request.getRequestURI();

        // 拦截“不拦截名单”以外的uri
/*        for (String noFilter : NO_FILTERS) {
            if (uri.startsWith(noFilter)) {
                return true;
            }
        }
*/        if ("/".equals(uri)) {
            response.sendRedirect("/index");
            return false;
        }
        return true;
    }
}
