package org.mrhu.smartlab.util;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

public class SpringContextUtil implements ApplicationContextAware{

    private static ApplicationContext application;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        application = applicationContext;
    }

    public static ApplicationContext getApplication() {
        return application;
    }

    public static Object getBean(String name) {
        return application.getBean(name);
    }

    public static<T> T getBean(String name, Class<T> requiredClass) {
        return application.getBean(name, requiredClass);
    }
}
