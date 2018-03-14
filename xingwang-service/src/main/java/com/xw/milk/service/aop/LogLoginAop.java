//package com.xw.milk.service.aop;
//
//import com.xw.milk.annotation.LogLoginAnnotation;
//import com.xw.milk.util.AssertUtil;
//import com.xw.milk.util.JsonUtils;
//import org.aspectj.lang.ProceedingJoinPoint;
//import org.aspectj.lang.annotation.Around;
//import org.aspectj.lang.annotation.Aspect;
//import org.aspectj.lang.annotation.Pointcut;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.ComponentScan;
//import org.springframework.stereotype.Component;
//import org.springframework.stereotype.Service;
//
//import java.util.Date;
//
///**
// * Created by ChoviWu on 2018/02/23
// * Description:自定义切面记录日志类
// */
//@Aspect //切面
//@Component
//public class LogLoginAop {
//
//    @Autowired
//    SysLogpper logMapper;
//
//    @Pointcut(value = "@annotation(com.xw.milk.annotation.LogLoginAnnotation)")//切点
//    public void pointCut(){}
//
//    //通知
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
//        AssertUtil.isTrue(logMapper.insertSelective(log)==1,"insert_error");
//
//       return pjp.proceed();
//    }
//
//}
