package com.xw.milk.controller.user;

import com.alibaba.dubbo.config.annotation.Reference;
import com.xw.milk.base.Message;
import com.xw.milk.model.BasUser;
import com.xw.milk.service.BasUserService;
import com.xw.milk.service.BasWxService;
import com.xw.milk.service.ConfigService;
import com.xw.milk.util.AssertUtil;
import com.xw.milk.util.WxUtils;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by ChoviWu on 2018/02/23
 * Description:
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @Reference
    BasUserService userService;
    @Reference
    BasWxService wxService;
    @Reference
    ConfigService configService;

    /**
     * 登录
     * @param openId
     * @param request
     * @return
     */
    @RequestMapping(value = "/login",method = RequestMethod.POST)
    public Object login(String openId, HttpServletRequest request){
        BasUser user = userService.getOneByOpenId(openId);
        if(StringUtils.isEmpty(user))
            return "login";
        request.getSession().setAttribute("user",user);
        return user;
    }

    /**
     * 注册
     * @return
     */
    @RequestMapping(value = "/register",method = RequestMethod.POST)
    public Object register(HttpServletRequest request){
        String openId = (String) request.getSession().getAttribute("openId");
        Integer userId = userService.doRegister(openId, WxUtils.getAccessToken(
                configService.getValueByParam("app_id"),configService.getValueByParam("app_secret")));
        BasUser user = userService.selectByKey(userId);
        request.getSession().setAttribute("user",user);
        return user;
    }

    /**
     * 绑定用户手机号
     * @param mobile
     * @param request
     * @return
     */
    @RequestMapping(value = "/bindMobile",method = RequestMethod.POST)
    public Object modifyMobile(String mobile,HttpServletRequest request){
        Object obj  = request.getSession().getAttribute("user");
        AssertUtil.isNullOrEmpty(obj,"please_login_first");
        BasUser user = (BasUser)obj;
        return userService.bindMobile(mobile,user.getId());
    }

    /**
     * 退出
     * @param request
     * @return
     */
    @RequestMapping(value = "/logout")
    public Object logout(HttpServletRequest request){
        request.getSession().removeAttribute("user");
        return Message.SUCCESS;
    }


}
