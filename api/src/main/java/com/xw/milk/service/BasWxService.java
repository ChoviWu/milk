package com.xw.milk.service;

import com.xw.milk.model.BasWx;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by ChoviWu on 2018/02/22
 * Description:
 */
public interface BasWxService extends BaseService<BasWx> {

    BasWx getOneByOpenId(String openId);

}
