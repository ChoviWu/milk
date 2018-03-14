package com.xw.milk.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.WebApplicationContext;

import javax.servlet.ServletContextEvent;
import javax.servlet.http.HttpServletRequest;

/**
 * Created by ChoviWu on 2018/02/05
 * Description:
 */
public class WebContextLoaderListener extends ContextLoaderListener {


    @Autowired
    HttpServletRequest request;


    public WebContextLoaderListener(WebApplicationContext context) {

       // super(context);
    }

    @Override
    public void contextInitialized(ServletContextEvent event) {
        super.contextInitialized(event);
    }

    @Override
    public void contextDestroyed(ServletContextEvent event) {
        super.contextDestroyed(event);
    }
}
