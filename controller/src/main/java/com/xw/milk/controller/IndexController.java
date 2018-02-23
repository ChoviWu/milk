package com.xw.milk.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.xw.milk.common.Paginator;
import com.xw.milk.model.BasProduct;
import com.xw.milk.service.BasProductService;
import com.xw.milk.service.BasUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
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
    private BasProductService productService;
    @Reference
    private BasUserService userService;

    @RequestMapping("")
    public Object index( Model model,HttpServletRequest request){


        List<BasProduct> list = productService.getList();
        model.addAttribute("productList",list);
        Object obj = request.getSession().getAttribute("user");
        if(StringUtils.isEmpty(obj))
            return "redirect:/login";
        return "main/index";
    }
}
