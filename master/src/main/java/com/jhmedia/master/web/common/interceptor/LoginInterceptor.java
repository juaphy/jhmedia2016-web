package com.jhmedia.master.web.common.interceptor;

import org.springframework.stereotype.Repository;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.jhmedia.master.util.Const;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author phu
 */
@Repository
public class LoginInterceptor extends HandlerInterceptorAdapter {
    private static final String[] NO_FILTERS = new String[] {
      "/login",
      "/toLogin",
      "/js",
      "/images",
      "/css",
      "/font",
      "/skins",
      "/easyui",
      "/code",
      "/addZh"
      };

    @Override
    public boolean preHandle(HttpServletRequest request, 
            HttpServletResponse response, Object handler) throws Exception {

        String uri = request.getRequestURI();

        // 拦截“不拦截名单”以外的uri
        for (String noFilter : NO_FILTERS) {
            if (uri.startsWith(noFilter)) {
                return true;
            }
        }

        if (request.getSession().getAttribute(Const.SESSION_USER) == null) {
            response.sendRedirect("/login");
            return false;
        } else if ("/".equals(uri) && request.getSession().getAttribute(Const.SESSION_USER) == null) {
            response.sendRedirect("/login");
            return false;
        } else if ("/".equals(uri)) {
            response.sendRedirect("/index");
            return false;
        }

        return true;
    }

}
