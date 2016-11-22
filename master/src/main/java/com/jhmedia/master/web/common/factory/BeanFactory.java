package com.jhmedia.master.web.common.factory;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

public class BeanFactory implements ApplicationContextAware {

         // Spring应用上下文环境  
        private static ApplicationContext applicationContext;  
        
        public static <T> T getInstance(Class<T> clazz) {
            ApplicationContext webContext = getApplicationContext();
            T t = (T) webContext.getBean(clazz);
            return t;
        }

        public static <T> T getInstance(String name, Class<T> clazz) {
            ApplicationContext webContext = getApplicationContext();
            T t = (T) webContext.getBean(name, clazz);
            return t;
        }

        public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
            BeanFactory.applicationContext = applicationContext; 
        }
        
        public static ApplicationContext getApplicationContext() {  
            return applicationContext;  
        }  


}
