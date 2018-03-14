package com.xw.milk.controller.user;

import com.alibaba.dubbo.config.annotation.Reference;
import com.xw.milk.base.Message;
import com.xw.milk.controller.base.BaseController;
import com.xw.milk.model.BasUser;
import com.xw.milk.service.BasUserService;
import com.xw.milk.service.ConfigService;
import com.xw.milk.util.AssertUtil;
import com.xw.milk.util.WxUtils;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by ChoviWu on 2018/02/23
 * Description:
 */
@RestController
@RequestMapping("/user")
public class UserController extends BaseController {

    @Reference
    BasUserService userService;
    @Reference
    ConfigService configService;

    /**
     * 登录
     * @param openId
     * @return
     */
    @RequestMapping(value = "/login",method = RequestMethod.POST)
    public Object login(String openId,String mobile,String password){
        BasUser user = userService.getOneByUser(openId,mobile,password);
        if(StringUtils.isEmpty(user))
            return "login";
        setAttribute(USER,user);
        return user;
    }

    /**
     * 注册
     * @return
     */
    @RequestMapping(value = "/register",method = RequestMethod.POST)
    public Object register(){
        String ip = getIP();
        String openId = getStringAttribute(OPEN_ID);
        Integer userId = userService.doRegister(openId, WxUtils.getAccessToken(
                configService.getValueByParam("app_id"),configService.getValueByParam("app_secret")),ip);
        BasUser user = userService.selectByKey(userId);
        setAttribute(USER,user);
        return user;
    }

    /**
     * 绑定用户手机号
     * @param mobile
     * @return
     */
    @RequestMapping(value = "/bindMobile",method = RequestMethod.POST)
    public Object modifyMobile(String mobile){
        BasUser user = getSessionUser();
        AssertUtil.isNullOrEmpty(user,"please_login_first");
        return userService.bindMobile(mobile,user.getId());
    }

    /**
     * 退出
     * @return
     */
    @RequestMapping(value = "/logout")
    public Object logout(){
      removeAttribute(USER);
      return Message.SUCCESS;
    }


}
