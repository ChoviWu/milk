package com.xw.milk.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.xw.milk.mapper.SysConfigMapper;
import com.xw.milk.model.SysConfig;
import com.xw.milk.service.BaseServiceImpl;
import com.xw.milk.service.ConfigService;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by ChoviWu on 2018/02/23
 * Description:
 */
@Service
public class ConfigServiceImpl extends BaseServiceImpl<SysConfig> implements ConfigService {


    @Autowired
    private SysConfigMapper configMapper;

    @Override
    public String getValueByParam(String param) {
        return configMapper.getValueByParam(param);
    }
}
