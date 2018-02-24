package com.xw.milk.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.xw.milk.model.SysLog;
import com.xw.milk.service.BaseServiceImpl;
import com.xw.milk.service.SysLogService;

/**
 * Created by ChoviWu on 2018/02/24
 * Description:
 */
@Service(version = "1.0.0")
public class SysLogServiceImpl  extends BaseServiceImpl<SysLog> implements SysLogService{
}
