/* =============================================================
 * 工程名称：信息管理系统
 * 对象名称：PropertiesUtil.java
 * 创建时间：2016年8月13日 下午3:58:53
 * (R) Copyright jhmedia 婧涵影视
 * (作于：广州市番禺区大石镇植村村东南大街5号)
 * =============================================================
 */
package com.jhmedia.front.util;

import java.io.FileInputStream;
import java.util.Properties;

/**
 * 加载配置文件
 * 
 * <pre>
 * 概要: 加载配置文件的参数，并赋值给对应的全局变量
 * 更新: 2016年8月13日 下午3:58:53
 * 作者: seki
 * </pre>
 */
public class PropertiesUtil {

    // 配置文件的路径
    private static final String FRONT_CONFIG = "front_config/front_config.properties";

    public static void loadProperties() throws Exception {
        Properties properties = new Properties();
        properties.load(new FileInputStream(FRONT_CONFIG));

        // 获取服务器端口
        if (!StringUtil.isEmpty(properties.getProperty("port"))) {
            if (Tools.isNumber(properties.getProperty("port"))) {
                Const.PORT = Integer.valueOf(properties.getProperty("port"));
            } else {
                throw new Exception("port值不正确！");
            }
        } else {
            throw new Exception("front_config.properties文件中缺少port配置！");
        }
    }

}
