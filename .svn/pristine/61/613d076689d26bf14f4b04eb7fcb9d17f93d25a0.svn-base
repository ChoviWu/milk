package com.xw.milk.config;//package com.example.config;
//
//import com.MyCredentialsMatcher;
//import com.ShiroRealm;
//import org.apache.shiro.authc.credential.CredentialsMatcher;
//import org.apache.shiro.mgt.SecurityManager;
//import org.apache.shiro.spring.LifecycleBeanPostProcessor;
//import org.apache.shiro.spring.security.interceptor.AuthorizationAttributeSourceAdvisor;
//import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
//import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.aop.framework.autoproxy.DefaultAdvisorAutoProxyCreator;
//import org.springframework.beans.factory.annotation.Qualifier;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//
//import java.util.LinkedHashMap;
//
///**
// * Created by ChoviWu on 2018/02/05
// * Description:
// */
//@Configuration
//public class ShiroConfig {
//
//    Logger LOG = LoggerFactory.getLogger("ShiroConfig");
//    @Bean(name="shiroFilter")
//    public ShiroFilterFactoryBean shiroFilter(@Qualifier("securityManager") SecurityManager manager) {
//        ShiroFilterFactoryBean bean=new ShiroFilterFactoryBean();
//        bean.setSecurityManager(manager);
//        //配置登录的url和登录成功的url
//        bean.setLoginUrl("/login");
//        bean.setSuccessUrl("/home");
//        LOG.info("==============进入Shiro=================");
//        //配置访问权限
//        LinkedHashMap<String, String> filterChainDefinitionMap=new LinkedHashMap<>();
//        filterChainDefinitionMap.put("/jsp/login.jsp*", "anon"); //表示可以匿名访问
//        filterChainDefinitionMap.put("/logout*","anon");
//        filterChainDefinitionMap.put("/jsp/login.jsp","anon");
//        filterChainDefinitionMap.put("/login*","anon");
//        filterChainDefinitionMap.put("/jsp/error.jsp*","anon");
//        filterChainDefinitionMap.put("/jsp/index.jsp*","authc");
//        filterChainDefinitionMap.put("/**", "authc");//表示需要认证才可以访问
//        filterChainDefinitionMap.put("/*.*", "authc");
//        bean.setFilterChainDefinitionMap(filterChainDefinitionMap);
//        return bean;
//    }
//    //配置核心安全事务管理器
//    @Bean(name="securityManager")
//    public SecurityManager securityManager(@Qualifier("authRealm") ShiroRealm authRealm) {
//        LOG.info("--------------shiro已经加载----------------");
//        DefaultWebSecurityManager manager=new DefaultWebSecurityManager();
//        manager.setRealm(authRealm);
//        return manager;
//    }
//    //配置自定义的权限登录器
//    @Bean(name="authRealm")
//    public ShiroRealm authRealm(@Qualifier("credentialsMatcher") CredentialsMatcher matcher) {
//        ShiroRealm authRealm=new ShiroRealm();
//        authRealm.setCredentialsMatcher(matcher);
//        return authRealm;
//    }
//    //配置自定义的密码比较器
//    @Bean(name="credentialsMatcher")
//    public CredentialsMatcher credentialsMatcher() {
//        return new MyCredentialsMatcher();
//    }
//    @Bean
//    public LifecycleBeanPostProcessor lifecycleBeanPostProcessor(){
//        return new LifecycleBeanPostProcessor();
//    }
//    @Bean
//    public DefaultAdvisorAutoProxyCreator defaultAdvisorAutoProxyCreator(){
//        DefaultAdvisorAutoProxyCreator creator=new DefaultAdvisorAutoProxyCreator();
//        creator.setProxyTargetClass(true);
//        return creator;
//    }
//    @Bean
//    public AuthorizationAttributeSourceAdvisor authorizationAttributeSourceAdvisor(@Qualifier("securityManager") SecurityManager manager) {
//        AuthorizationAttributeSourceAdvisor advisor=new AuthorizationAttributeSourceAdvisor();
//        advisor.setSecurityManager(manager);
//        return advisor;
//    }
//
//
//}
