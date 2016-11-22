package com.jhmedia.master.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.jhmedia.master.web.base.BaseController;

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
