package com.xw.milk.config;

import com.xw.milk.web.ServletInitListener;
import org.springframework.boot.context.embedded.ServletListenerRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by ChoviWu on 2018/02/05
 * Description:
 */
@Configuration
public class ServletContextListener {


    @Bean
    public ServletListenerRegistrationBean servletListenerRegistrationBean(){
        ServletListenerRegistrationBean servletListenerRegistrationBean = new ServletListenerRegistrationBean();
        servletListenerRegistrationBean.setListener(new ServletInitListener());
        return servletListenerRegistrationBean;
    }

}
