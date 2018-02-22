package com.xw.milk.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.xw.milk.model.BusOrder;
import com.xw.milk.service.BaseServiceImpl;
import com.xw.milk.service.BusOrderService;

/**
 * Created by ChoviWu on 2018/02/22
 * Description:
 */
@Service(version = "1.0.0")
public class BusOrderServiceImpl  extends BaseServiceImpl<BusOrder> implements BusOrderService {
}
