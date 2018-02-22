package com.xw.milk.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.xw.milk.model.BasProduct;
import com.xw.milk.service.BasProductService;
import com.xw.milk.service.BaseServiceImpl;

/**
 * Created by ChoviWu on 2018/02/22
 * Description:
 */

@Service(version = "1.0.0")
public class BasProductServiceImpl extends BaseServiceImpl<BasProduct> implements BasProductService {
}
