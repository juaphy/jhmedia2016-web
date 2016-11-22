/* =============================================================
 * 工程名称：信息管理系统
 * 对象名称：SecurityCodeCtr.java
 * 创建时间：2016年7月31日 下午6:22:40
 * (R) Copyright 贵州小小马驹科技有限公司 (广州市番禺区大石镇植村村东南大街5号)
 * =============================================================
 */
package com.jhmedia.master.web;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.font.FontRenderContext;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.jhmedia.master.util.Const;
import com.jhmedia.master.web.base.BaseController;

/**
 * 验证码
 * <pre>
 * 概要: 验证码控制器
 * 更新: 2016年7月31日 下午6:22:40
 * 作者: seki
 * 版本: $Rev$
 * ID  ：$Id$
 * </pre>
 */
@Controller
public class SecurityCodeCtr extends BaseController {

    private Logger logger = LoggerFactory.getLogger(SecurityCodeCtr.class);

    /**
     * 生产验证码（jpg）
     * @param request
     */
    @RequestMapping("/code")
    public void code(HttpServletResponse response) {
        logger.info("SecurityCodeCtr code...");
        ByteArrayOutputStream output = new ByteArrayOutputStream();

        // 验证码
        String code = drawImg(output);
        getRequest().getSession().setAttribute(Const.SESSION_SECURITY_CODE, code);
        try {
            ServletOutputStream out = response.getOutputStream();
            output.writeTo(out);
        } catch (IOException e) {
            logger.error("ServletOutputStream writeTo response of outputstream error :" + e.getMessage());
            e.printStackTrace();
        }
    }

    /**
     * 生产四位随机字符，并生成image
     * @param output
     * @return
     */
    private String drawImg(ByteArrayOutputStream output) {
        String code = Const.EMPTY;

        // 获取四位随字符
        for (int i = 0; i < 4; i++) {
            code += randomChar();
        }

        // 图片宽度
        int width = 70;

        // 图片高度
        int height = 25;

        // 实例化一个image缓存对象
        BufferedImage bi = new BufferedImage(width, height,
                BufferedImage.TYPE_USHORT_555_RGB);

        // 画笔工具
        Graphics2D g = bi.createGraphics();

        // 字体
        Font font = new Font("Times New Roman", Font.PLAIN, 20);
        g.setFont(font);

        // 字体颜色
        Color color = new Color(62, 2, 82);
        g.setColor(color);

        // 背景
        g.setBackground(new Color(226, 226, 240));

        // 删除线
        g.clearRect(0, 0, width, height);

        FontRenderContext context = g.getFontRenderContext();
        Rectangle2D bounds = font.getStringBounds(code, context);
        double x = (width - bounds.getWidth()) / 2;
        double y = (height - bounds.getHeight()) / 2;
        double ascent = bounds.getY();
        double baseY = y - ascent;

        g.drawString(code, (int) x, (int) baseY);
        g.dispose();

        try {
            ImageIO.write(bi, Const.CODE_FILEFORMAT, output);
        } catch (IOException e) {
            e.printStackTrace();
            logger.error("生成验证码文件时发生异常...\n" + e.getMessage());
        }
        return code;
    }

    /**
     * 生产随机字符
     * @return 根据自定义的样式，生产随机字符
     */
    private char randomChar() {
        Random r = new Random();
        String str = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
        return str.charAt(r.nextInt(str.length()));
    }

}
