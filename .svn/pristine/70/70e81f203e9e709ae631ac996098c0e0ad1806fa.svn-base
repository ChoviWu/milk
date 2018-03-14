package com.xw.milk.controller.auth;

import com.alibaba.dubbo.config.annotation.Reference;
import com.xw.milk.model.BasUser;
import com.xw.milk.service.BasUserService;
import com.xw.milk.service.BasWxService;
import com.xw.milk.service.ConfigService;
import com.xw.milk.util.HttpUtils;
import com.xw.milk.util.IpUtils;
import com.xw.milk.util.JsonUtils;
import com.xw.milk.util.WxUtils;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Logger;

/**
 * Created by ChoviWu on 2018/02/23
 * Description:
 */
@RestController
public class WxAuthController {


    private static Logger logger = java.util.logging.Logger.getLogger("WxAuthController");

    @Reference
    BasWxService wxService;
    @Reference
    BasUserService userService;
    @Reference
    ConfigService configService;


    /**
     * 微信绑定跳转页面
     * @param code
     * @param request
     * @return
     */
    @RequestMapping(value = "/weixin/redirect/{ip}")
    public  Object redirect(String code, @PathVariable String ip, HttpServletRequest request){
        try {
            ip = URLDecoder.decode(ip,"UTF-8");
            logger.info("IP: " + ip);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        logger.info("WxController redirect method code:"+code);
        Map result = wxService.getAnthTokenByCode(code);
        logger.info("WxController redirect method result:"+ JsonUtils.toJson(result));
        if(result != null && result.get("openid") != null){
            logger.info("WxController redirect openId is can setAttribute" );
            request.getSession().setAttribute("openId", result.get("openid"));
            String openId = String.valueOf(result.get("openid"));
            BasUser user = userService.getUserByOpenId(openId);
            Map map = new HashMap();
            if(StringUtils.isEmpty(user)){
                Integer userId = userService.doRegister(openId,String.valueOf(result.get("access_token")),ip);
                map.put("user",userService.getUserByOpenId(openId));
                map.put("userId",userId);
                return map;
            }
            return null;
        }
        return null;
    }

    /**
     * 获取授权
     * @return
     */
    @RequestMapping("/weixin/auth")
    public void getAuth(HttpServletResponse response, HttpServletRequest request){
        String ip = IpUtils.get();
        StringBuffer url = request.getRequestURL();
        String tempContextUrl = url.delete(url.length() - request.getRequestURI().length(), url.length()).append("/").toString();
        String encode = URLEncoder.encode(tempContextUrl+"/weixin/redirect/"+URLEncoder.encode(ip));
        try {
            response.sendRedirect("https://open.weixin.qq.com/connect/oauth2/authorize?" +
                    "appid="+configService.getValueByParam("app_id")+"&redirect_uri=" +
                    encode + "&response_type=code&scope=snsapi_userinfo&connect_redirect=1#wechat_redirect");
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    /**
     * 获取用户资料
     * @param request
     * @return
     */
    @RequestMapping("/weixin/getInfo")
    public Object getInfo(HttpServletRequest request){
        String response = HttpUtils.URLGet("https://api.weixin.qq.com/cgi-bin/user/info?access_token="+ WxUtils.getAccessToken(
                configService.getValueByParam("app_id"),configService.getValueByParam("app_secret"))+"&openid="+String.valueOf(request.getSession().getAttribute("openId"))+"&lang=zh_CN",null,"UTF-8");

        return response;
    }


}
