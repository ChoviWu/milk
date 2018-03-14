package com.xw.milk.web;

import com.xw.milk.util.IpUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Created by ChoviWu on 2018/02/23
 * Description:登录过滤器
 */

public class SessionFilter implements Filter {

    Logger LOG = LoggerFactory.getLogger(this.getClass());
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest)req;
        HttpServletResponse response = (HttpServletResponse)res;
        HttpSession session = request.getSession();

        Object userIdObj = session.getAttribute("userId");
        String path = request.getServletPath();

        String[] noNeedLoginPaths = {"/login","/logout"};

        String[] needLoginPaths = {"/user","/order","/log"};

        boolean noNeedLogin = isMatch(path, noNeedLoginPaths);

        if(noNeedLogin){
            chain.doFilter(req, res);
        }else{
            boolean needLogin = isMatch(path, needLoginPaths);
            if(needLogin && userIdObj == null){
                response.sendRedirect("/login");
            }else{
                chain.doFilter(req, res);
            }
        }

    }

    private boolean isMatch(String path, String[] paths){
        boolean isMatch = false;
        for(String p:paths){
            if(path.startsWith(p)){
                isMatch = true;
                break;
            }
        }
        return isMatch;
    }


    @Override
    public void destroy() {

    }
}
