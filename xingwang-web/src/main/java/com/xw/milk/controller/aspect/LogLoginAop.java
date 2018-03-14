//package com.xw.milk.controller.aspect;
//
//import com.alibaba.dubbo.config.annotation.Reference;
//import com.xw.milk.annatation.LogLoginAnnotation;
//import com.xw.milk.model.SysLog;
//import com.xw.milk.service.SysLogService;
//import com.xw.milk.util.AssertUtil;
//import com.xw.milk.util.JsonUtils;
//import org.aspectj.lang.ProceedingJoinPoint;
//import org.aspectj.lang.annotation.Around;
//import org.aspectj.lang.annotation.Aspect;
//import org.aspectj.lang.annotation.Pointcut;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Component;
//
//import java.util.Date;
//
///**
// * Created by ChoviWu on 2018/02/23
// * Description:自定义切面记录日志类
// */
//@Aspect
//@Component
//public class LogLoginAop {
//
//    @Reference(version = "1.0.0")
//    SysLogService logService;
//
//    @Pointcut(value = "@annotation(com.xw.milk.annatation.LogLoginAnnotation)")
//    public void pointCut(){}
//
//
//    @Around(value = "pointCut()&&@annotation(loginAnnotation))")
//    public Object aroundAdvice(ProceedingJoinPoint pjp,LogLoginAnnotation loginAnnotation) throws Throwable{
//
//        String method = loginAnnotation.methodName();//方法
//        String moduleName = loginAnnotation.moduleName();//模型
//        String args = JsonUtils.toJson(pjp.getArgs());//参数
//        Date time = new Date();
//        SysLog log = new SysLog();
//        log.setArgs(args);
//        log.setMethod(method);
//        log.setModule(moduleName);
//        log.setAddtime(time);
//        AssertUtil.isTrue(logService.save(log)==1,"insert_error");
//
//       return pjp.proceed();
//    }
//
//}
