package com.xw.milk.controller.base;

import com.alibaba.dubbo.common.json.JSONObject;
import com.fasterxml.jackson.databind.util.JSONPObject;
import com.xw.milk.model.BasUser;
import com.xw.milk.util.IpUtils;
import com.xw.milk.util.ServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

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



    public String  getRequestAttrId(){
        return String.valueOf(((ServletRequestAttributes)
                RequestContextHolder.getRequestAttributes()).getRequest().getAttribute("userId"));
    }

    public String getIP(){
        return IpUtils.getRemoteIp(request);
    }


    public Map success(Object data){
        Map map = new HashMap();
        map.put("result","success");
        map.put("messageCode","0000");
        map.put("messageText",data);
        return map;
    }
    public Object fail(Object data){
        Map map = this.success(data);
        map.put("result","fail");
        return map;
    }
}
