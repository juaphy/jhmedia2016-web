/* =============================================================
 * 工程名称：信息管理系统
 * 对象名称：SystemManageCtr.java
 * 创建时间：2016年8月2日 下午12:00:52
 * (R) Copyright 贵州小小马驹科技有限公司 (广州市番禺区大石镇植村村东南大街5号)
 * =============================================================
 */
package com.jhmedia.master.web.system;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.jhmedia.master.service.system.ZhglService;
import com.jhmedia.master.state.ZhglState;
import com.jhmedia.master.util.MD5;
import com.jhmedia.master.util.Page;
import com.jhmedia.master.util.PageData;
import com.jhmedia.master.util.StringUtil;
import com.jhmedia.master.web.base.BaseController;

/**
 * 系统管理
 * 
 * <pre>
 * 概要: 系统管理Ctr
 * 更新: 2016年8月2日 下午12:00:52
 * 作者: seki
 * 版本: $Rev$
 * ID  ：$Id$
 * </pre>
 */
@Controller
@RequestMapping("/system_manage/zhgl")
public class SystemManageCtr extends BaseController {

    @Resource(name = "ZhglServiceImpl")
    private ZhglService zhglService;

    @RequestMapping("/")
    public ModelAndView index(Page page) throws Exception {
        ModelAndView mv = new ModelAndView();
        page.setPageSize(5);
        List<PageData> list = zhglService.findZhListPage(page);
        for (PageData pd : list) {

            // 操作
            pd.put("cz", String.valueOf(pd.get("zhzt")));

            // 账号类型
            pd.put("zhlx", ZhglState.codeToDescByZhlx(String.valueOf(pd.get("zhlx"))));

            // 账号状态
            pd.put("zhzt", ZhglState.codeToDescByZhzt(String.valueOf(pd.get("zhzt"))));

        }
        mv.setViewName("/system/zhgl/index.html");
        mv.addObject("list", list);
        return mv;
    }

    @RequestMapping("/toUpdateZt")
    @ResponseBody
    public PageData toUpdateZt() {
        PageData pd = this.getPageData();
        try {
            zhglService.updateZhzt(pd);
        } catch (Exception e) {
            e.printStackTrace();
            pd.put("errormessage", "更新账号状态时发生异常");
        }
        return pd;
    }

    /**
     * 跳转到修改密码页面
     * @return
     */
    @RequestMapping("/toXgmm")
    public ModelAndView toXgmm() {
        logger.info("SystemManage toXgmm...");
        ModelAndView mv = this.getModelAndView();
        mv.setViewName("/system/zhgl/xgmm.html");
        PageData zhxx = new PageData();
        zhxx.put("yhm", getUser().getYhm());
        zhxx.put("yhid", getUser().getYhid());
        mv.addObject("zhxx", zhxx);
        return mv;
    }

    /**
     * 修改密码
     * @return
     * @throws Exception 
     */
    @RequestMapping("/doXgmm")
    @ResponseBody
    public PageData doXgmm() {
        logger.info("SystemManage doXgmm...");
        PageData pd = this.getPageData();
        PageData rtnpd = new PageData();

        // check
        // 用户账号信息
        if (StringUtil.isEmpty(pd.getString("yhm"))
                || StringUtil.isEmpty(pd.getString("yhid"))
                || !getUser().getYhm().equals(pd.getString("yhm"))
                || !getUser().getYhid().equals(pd.getString("yhid"))) {
            rtnpd.put("errormessage", "账号异常，请稍后再试！");
            return rtnpd;
        }
        // 旧密码
        if (StringUtil.isEmpty(pd.getString("jmm"))) {
            rtnpd.put("errormessage", "旧密码不能为空！");
            return rtnpd;
        }

        // 新密码
        if (StringUtil.isEmpty(pd.getString("xmm"))) {
            rtnpd.put("errormessage", "新密码不能为空！");
            return rtnpd;
        }

        // check旧密码是否与当前会话用户的密码一致，若一致，则check通过
        if (!getUser().getMm().equals(MD5.md5(pd.getString("jmm")))) {
            rtnpd.put("errormessage", "旧密码不正确！");
            return rtnpd;
        }

        // check新密码是否与当前会话用户的密码一致，若一致则check不通过
        if (getUser().getMm().equals(MD5.md5(pd.getString("xmm")))) {
            rtnpd.put("errormessage", "新密码不能与旧密码相同！");
            return rtnpd;
        }
        if (50 < pd.getString("xmm").length()) {
            rtnpd.put("errormessage", "密码过长！");
            return rtnpd;
        }

        try {
            zhglService.updateZhmm(pd);
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("修改密码是发生异常：" + e.getMessage());
            rtnpd.put("errormessage", "修改密码是发生异常");
        }
        return rtnpd;
    }

}
