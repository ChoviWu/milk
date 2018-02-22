package com.xw.milk.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.xw.milk.model.BusOrderLog;
import com.xw.milk.service.BaseServiceImpl;
import com.xw.milk.service.BusOrderLogService;

/**
 * Created by ChoviWu on 2018/02/22
 * Description:
 */
@Service(version = "1.0.0")
public class BusOrderLogServiceImpl  extends BaseServiceImpl<BusOrderLog> implements BusOrderLogService {
}
