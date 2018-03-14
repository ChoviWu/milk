package com.xw.milk.base;

import com.ctc.wstx.util.StringUtil;
import com.xw.milk.model.BasUser;
import com.xw.milk.util.IpUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * Created by ChoviWu on 2017/12/28
 */
@Controller
public class BaseController {

    protected String USER = "user";
    protected String OPEN_ID = "openId";
    protected String  USER_ID = "userId";

    @Autowired
    HttpServletRequest request;


    public Object getObject(String obj){
        return request.getSession().getAttribute(obj);
    }

    public HttpSession getSession(){
        return request.getSession();
    }

    public void setAttribute(String key,Object value){
        request.getSession().setAttribute(key,value);
    }
    public String getStringAttribute(String str){
        if(StringUtils.isEmpty(str)){
            return null;
        }
        return String.valueOf(getSession().getAttribute(str));
    }

    public BasUser getSessionUser(){
        return (BasUser) getSession().getAttribute(USER);
    }

    public void removeAttribute(String str){
        request.getSession().removeAttribute(str);
    }


//
//    public HttpServletRequest getRequest(){
//        return ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
//    }

    public String getIP(){
        return IpUtils.getRemoteIp(request);
    }

}
