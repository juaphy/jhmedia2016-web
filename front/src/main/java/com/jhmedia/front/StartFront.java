/* =============================================================
 * 工程名称：信息管理系统
 * 对象名称：StartFront.java
 * 创建时间：2016年8月9日 上午9:37:32
 * (R) Copyright jhmedia 婧涵影视
 * (作于：广州市番禺区大石镇植村村东南大街5号)
 * =============================================================
 */
package com.jhmedia.front;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.util.resource.Resource;
import org.eclipse.jetty.webapp.WebAppContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.jhmedia.front.util.Const;
import com.jhmedia.front.util.PropertiesUtil;

import ch.qos.logback.classic.LoggerContext;
import ch.qos.logback.classic.joran.JoranConfigurator;
import ch.qos.logback.core.joran.spi.JoranException;
import ch.qos.logback.core.util.StatusPrinter;

/**
 * 启动Front
 * <pre>
 * 概要: 通过jetty启动Front服务
 * 更新: 2016年8月9日 上午9:37:32
 * 作者: seki
 * </pre>
 */
public class StartFront {

    static final Logger logger = LoggerFactory.getLogger(StartFront.class);

    public static void main(String[] args) throws Exception {

        // 加载日志配置文件
        LoggerContext lc = (LoggerContext) LoggerFactory.getILoggerFactory();
        JoranConfigurator joranconfig = new JoranConfigurator();
        joranconfig.setContext(lc);
        lc.reset();
        try {
            joranconfig.doConfigure("front_config/logback.xml");
        } catch (JoranException e) {
            e.printStackTrace();
        }
        StatusPrinter.printInCaseOfErrorsOrWarnings(lc);

        // 加载配置文件
        PropertiesUtil.loadProperties();
        int port = Const.PORT;

        // 启动jetty服务
        logger.info("Starting server at port {}", port);
        Server server = new Server(port);

        WebAppContext handler = new WebAppContext();
        handler.setContextPath("/");
        handler.setBaseResource(Resource.newClassPathResource("/webapp"));
        handler.setMaxFormContentSize(Integer.MAX_VALUE);
        handler.setDefaultsDescriptor("/webdefault.xml");

        server.setHandler(handler);
        server.start();
        logger.info("Server started at port {}", port);
        server.join();
    }

}
