package com.xw.milk.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.xw.milk.common.Paginator;
import com.xw.milk.service.BasProductService;
import com.xw.milk.service.BasUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * Created by ChoviWu on 2018/02/02
 * Description:
 */
@Controller
@RequestMapping("/index")
public class IndexController {

    @Reference
    BasProductService productService;

    @RequestMapping("")
    public Object index(HttpServletRequest request){

        List list = productService.getList();
        request.getSession().setAttribute("productList",list);

        return "main/index";
    }
}
