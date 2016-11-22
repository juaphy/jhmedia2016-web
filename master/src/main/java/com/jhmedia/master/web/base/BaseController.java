package com.jhmedia.master.web.base;


import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.jhmedia.master.entity.UserManage;
import com.jhmedia.master.util.Const;
import com.jhmedia.master.util.PageData;


public class BaseController {
    public static final Logger logger = LoggerFactory.getLogger(BaseController.class);

    /**
     * 得到PageData
     */
    public PageData getPageData() {
        return new PageData(this.getRequest());
    }

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
	/*//异常处理
	@ExceptionHandler  
	public String exp(HttpServletRequest request, Exception ex) {  
		if(ex instanceof CultureControllerException
				|| ex instanceof CultureControllerException){
			request.setAttribute(Const.EXCEPTION_CODE, ex.getMessage());  
		}else{
			request.setAttribute(Const.EXCEPTION_CODE, "访问出现异常，稍后重试！");
			request.setAttribute("error_info",ex.toString());
		}
		request.setAttribute("redirect_url", request.getRequestURI());
		logger.error(request.getRequestURI());
		logger.error(ex.toString(),ex);
		return "/error.html";
	}
	*//**
	 * 得到当前会话的账号
	 * @return
	 *//*
	public Account getAccount(){
		return (Account)getRequest().getSession().getAttribute(Const.SESSION_USER);
	}*/
	public UserManage getUser() {
	    return (UserManage) getRequest().getSession().getAttribute(Const.SESSION_USER);
	}

}
