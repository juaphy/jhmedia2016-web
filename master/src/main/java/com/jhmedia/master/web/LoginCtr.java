package com.jhmedia.master.web;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jhmedia.master.entity.UserManage;
import com.jhmedia.master.service.common.UserManageService;
import com.jhmedia.master.state.ZhglState;
import com.jhmedia.master.util.Const;
import com.jhmedia.master.util.MD5;
import com.jhmedia.master.util.PageData;
import com.jhmedia.master.util.StringUtil;
import com.jhmedia.master.web.base.BaseController;

@Controller
public class LoginCtr extends BaseController{

    Logger logger = LoggerFactory.getLogger(LoginCtr.class);

    @Resource(name = "UserManageServiceImpl")
    private UserManageService userManageService;

    @RequestMapping("/login")
    public String login() throws Exception {
        logger.info("LoginCtr login...");
        return "/login.html";
    }

    /**
     * 退出
     * @return
     * @throws Exception
     */
    @RequestMapping("/loginOut")
    public String loginOut() throws Exception {
        getRequest().getSession().removeAttribute(Const.SESSION_USER);
        getRequest().getSession().removeAttribute(Const.SESSION_USERNAME);
        return "/login.html";
    }

    /**
     * 登录
     * @return
     */
    @RequestMapping("/toLogin")
    @ResponseBody
    public Map<String, String> toLogin() {
        logger.info("LoginCtr toLogin...");
        Map<String, String> rtmap = new HashMap<String, String>();

        PageData pd = this.getPageData();

        String username = pd.getString("yhm");
        String password = pd.getString("mm");
        String code = pd.getString("scode");
        String sessionCode = (String) getRequest().getSession().getAttribute(
                Const.SESSION_SECURITY_CODE);
        if (StringUtil.isEmpty(sessionCode)
                || !sessionCode.toUpperCase().equals(code.toUpperCase())) {
            rtmap.put("message", "验证码输入错误");
            return rtmap;
        }

        // 验证用户
        try {
            PageData upd = userManageService.findYhByYhm(pd);
            if (upd == null) {
                rtmap.put("message", "用户名不存在");
                return rtmap;
            } else {
                if (ZhglState.YSC.getType_code().equals(StringUtil.toString(upd.get("zhzt")))) {
                    rtmap.put("message", "用户不存在");
                    return rtmap;
                }
                if (!upd.getString("mm").equals(
                        MD5.md5(password == null ? "" : password))) {
                    rtmap.put("message", "密码错误");
                    return rtmap;
                }
                if(!ZhglState.YJH.getType_code().equals(StringUtil.toString(upd.get("zhzt")))) {
                    rtmap.put("message", "用户未激活");
                    return rtmap;
                }
            } 
            getRequest().getSession().setAttribute(Const.SESSION_USER,
                    upd.converntToBean(UserManage.class));
            if (!StringUtil.isEmpty(upd.getString("nickname"))) {
                username = upd.getString("nickname");
            }
            getRequest().getSession().setAttribute(Const.SESSION_USERNAME, username);
            rtmap.put("url", "/index");
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("系统异常： " + e.getMessage());
            rtmap.put("message", "系统异常！");
        }
        return rtmap;
    }

}
