/* =============================================================
 * 工程名称：信息管理系统
 * 对象名称：BaseController.java
 * 创建时间：2016年8月13日 下午11:57:48
 * (R) Copyright 贵州小小马驹科技有限公司 (广州市番禺区大石镇植村村东南大街5号)
 * =============================================================
 */
package com.jhmedia.front.web.base;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.servlet.ModelAndView;

/**
 * TODO
 * <pre>
 * 概要: TODO
 * 更新: 2016年8月13日 下午11:57:48
 * 作者: seki
 * 版本: $Rev$
 * ID  ：$Id$
 * </pre>
 */
public class BaseController {
    public static final Logger logger = LoggerFactory.getLogger(BaseController.class);

    /**
     * 得到PageData
     */
    /*public PageData getPageData() {
        return new PageData(this.getRequest());
    }*/

    /**
     * 得到ModelAndView
     */
    public ModelAndView getModelAndView(){
        return new ModelAndView();
    }
    
    /**
     * 得到request对象
     */
    public HttpServletRequest getRequest() {
        HttpServletRequest request = ((ServletRequestAttributes)RequestContextHolder.getRequestAttributes()).getRequest();
        return request;
    }

    
    public static void logBefore(Logger logger, String interfaceName){
        logger.info("");
        logger.info("start");
        logger.info(interfaceName);
    }
    
    public static void logAfter(Logger logger){
        logger.info("end");
        logger.info("");
    }

}
