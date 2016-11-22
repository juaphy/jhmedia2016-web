/* =============================================================
 * 工程名称：信息管理系统
 * 对象名称：IndexCtr.java
 * 创建时间：2016年8月13日 下午11:55:28
 * (R) Copyright 贵州小小马驹科技有限公司 (广州市番禺区大石镇植村村东南大街5号)
 * =============================================================
 */
package com.jhmedia.front.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.jhmedia.front.web.base.BaseController;

/**
 * TODO
 * <pre>
 * 概要: TODO
 * 更新: 2016年8月13日 下午11:55:28
 * 作者: seki
 * 版本: $Rev$
 * ID  ：$Id$
 * </pre>
 */
@Controller
public class IndexCtrl extends BaseController {

    private Logger logger = LoggerFactory.getLogger(IndexCtrl.class);

    @RequestMapping("/index")
    public ModelAndView index() throws Exception {
        logger.info("IndexCtrl index...");
        ModelAndView mv = new ModelAndView();
        mv.setViewName("/index.html");
        return mv;
    }
}
