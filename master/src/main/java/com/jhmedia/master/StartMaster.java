package com.jhmedia.master;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.util.resource.Resource;
import org.eclipse.jetty.webapp.WebAppContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import ch.qos.logback.classic.LoggerContext;
import ch.qos.logback.classic.joran.JoranConfigurator;
import ch.qos.logback.core.joran.spi.JoranException;
import ch.qos.logback.core.util.StatusPrinter;

/**
 * 启动服务（jetty）
 * @author seki 2016/07/25 广州-番禺-大石-植村-南大街5号
 *
 */
public class StartMaster {

    static final Logger logger = LoggerFactory.getLogger(StartMaster.class);

    public static void main(String[] args) throws Exception {
        loadLog();
        int port = Integer.getInteger("port", 8087);
        logger.info("Startting server at port {}", port);

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

    /**
     * 加载日志配置
     */
    private static void loadLog() {
        LoggerContext lc = (LoggerContext) LoggerFactory.getILoggerFactory();
        JoranConfigurator configurator = new JoranConfigurator();
        configurator.setContext(lc);
        lc.reset();
        try {
            configurator.doConfigure("master_config/logback.xml");
        } catch (JoranException e) {
            e.printStackTrace();
            System.out.println("error:load log error !");
        }
        StatusPrinter.printInCaseOfErrorsOrWarnings(lc);
    }
}
