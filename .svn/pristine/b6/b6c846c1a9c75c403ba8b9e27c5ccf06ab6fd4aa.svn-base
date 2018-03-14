package com.xw.milk.web;

import com.xw.milk.base.Global;
import com.xw.milk.mapper.SysConfigMapper;
import com.xw.milk.model.SysConfig;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import java.util.List;

/**
 * Created by ChoviWu on 2018/02/05
 * Description:
 */
public class ServletInitListener implements ServletContextListener {

    Logger logger = LoggerFactory.getLogger("WebServletListener");

    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {
        logger.info("LOGGING...");
        ServletContext servletContext = servletContextEvent.getServletContext();
        ApplicationContext applicationContext = WebApplicationContextUtils.getWebApplicationContext(servletContext);
        SysConfigMapper configMapper = (SysConfigMapper) applicationContext.getBean("configMapper");
        List<SysConfig> configList = configMapper.selectAll();
        for (SysConfig config : configList){
            Global.FIELD.put(config.getParam(),config.getValue());
        }
        logger.info("Init OK ...");
    }

    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {
    }
}
