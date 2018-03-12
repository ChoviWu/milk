package com.xw.milk.tools;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

import java.util.Map;

/**
 * Created by ChoviWu on 2018/03/12
 * Description:
 */
@Component
public class ApplicationContextUtils implements ApplicationContextAware {

     private Logger log = LoggerFactory.getLogger(ApplicationContextUtils.class);


     private static ApplicationContext applicationContext = null;

        @Override
        public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
            if(ApplicationContextUtils.applicationContext == null){
                ApplicationContextUtils.applicationContext  = applicationContext;
            }
            log.info("ApplicationContext注入成功");
        }

        /**获取applicationContext*/
        public static ApplicationContext getApplicationContext() {
            return applicationContext;
        }

        /**通过name获取 Bean*/
        public static Object getBean(String name){
            return getApplicationContext().getBean(name);

        }

        /**通过class获取Bean*/
        public static <T> T getBean(Class<T> clazz){
            return getApplicationContext().getBean(clazz);
        }

        /**通过name,以及Clazz返回指定的Bean*/
        public static <T> T getBean(String name,Class<T> clazz){
            return getApplicationContext().getBean(name, clazz);
        }

        /**
         * 根据接口返回beanMap
         * @param clazz
         * @param <T>
         * @return
         */
        public static <T> Map<String,T> getBeans(Class<T> clazz){
            return getApplicationContext().getBeansOfType(clazz);
        }

}
