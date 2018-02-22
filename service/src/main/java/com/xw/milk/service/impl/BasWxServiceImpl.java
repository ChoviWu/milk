package com.xw.milk.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.xw.milk.mapper.BasWxMapper;
import com.xw.milk.model.BasWx;
import com.xw.milk.service.BasWxService;
import com.xw.milk.service.BaseServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by ChoviWu on 2018/02/22
 * Description:
 */
@Service(version = "1.0.0")
public class BasWxServiceImpl  extends BaseServiceImpl<BasWx> implements BasWxService {

    @Autowired
    private BasWxMapper wxMapper;

    /**
     * 查询用户
     * @param openId
     * @return
     */
    @Override
    public BasWx getOneByOpenId(String openId){
        return wxMapper.getOneByOpenId(openId);
    }


}
