package com.xw.milk.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.xw.milk.common.Paginator;
import com.xw.milk.service.BasUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by ChoviWu on 2018/02/02
 * Description:
 */
@RestController
@RequestMapping("/user")
public class IndexController {

    @Reference
    BasUserService userService;

    @RequestMapping("/getList")
    public Object getList(){

        return userService.selectAll();
    }

    @RequestMapping("/list")
    public Object getList(Paginator p){

        return userService.selectAll();
    }


}
