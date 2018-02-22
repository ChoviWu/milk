package com.xw.milk.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.xw.milk.model.BasWx;
import com.xw.milk.service.BasWxService;
import com.xw.milk.service.BaseServiceImpl;

/**
 * Created by ChoviWu on 2018/02/22
 * Description:
 */
@Service(version = "1.0.0")
public class BasWxServiceImpl  extends BaseServiceImpl<BasWx> implements BasWxService {
}
