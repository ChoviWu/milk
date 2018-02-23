package com.xw.milk.controller.user;

import com.alibaba.dubbo.config.annotation.Reference;
import com.xw.milk.service.BasUserService;
import com.xw.milk.service.BasWxService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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


}
