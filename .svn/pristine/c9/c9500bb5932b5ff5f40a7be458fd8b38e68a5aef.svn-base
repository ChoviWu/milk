package com.xw.milk.web;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.xw.milk.Exception.CrowdException;
import com.xw.milk.Exception.ExceptionMessage;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;
import java.util.HashMap;

/**
 * Created by ChoviWu on 2018/02/02
 * Description:
 */
public class ExceptionInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o) throws Exception {
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse response, Object o, Exception ex) throws Exception {
        HashMap<String,String> msg=new HashMap<String, String>();
        if (ex != null) {
            if(ex instanceof CrowdException){
                msg.put("result","fail");
                CrowdException exception = (CrowdException) ex;
                String code=exception.getCode();
                String message ;

                if (exception.getMessage()!=null)
                    message = exception.getMessage();
                else
                    message = ExceptionMessage.exceptionMessage.get(code);
                if(message==null || message=="")message= "系统繁忙";
                msg.put("messageCode",code);
                msg.put("messageText",message);
            }  else {
                msg.put("result", "fail");
                msg.put("messageCode", "sys.error");
                msg.put("messageText", "系统错误");
            }
            ObjectMapper mapper=new ObjectMapper();
            String json=mapper.writeValueAsString(msg);
            response.setContentType("application/json;charset=UTF-8");
            response.setHeader("Pragma", "No-cache");
            response.setHeader("Cache-Control", "no-cache");
            response.setDateHeader("Expires", 0);
            PrintWriter out =response.getWriter();
            out.print(json);
            out.flush();
            out.close();
        }
    }
}
