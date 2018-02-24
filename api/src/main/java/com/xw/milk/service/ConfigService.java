package com.xw.milk.service;

import com.xw.milk.model.SysConfig;

/**
 * Created by ChoviWu on 2018/02/23
 * Description:
 */
public interface ConfigService extends BaseService<SysConfig>{

    String getValueByParam(String param);
}
