package com.xw.milk.service;

import com.xw.milk.common.PageList;
import com.xw.milk.common.Paginator;
import com.xw.milk.model.BasUser;
import com.xw.milk.model.BasWx;

import java.util.Map;

/**
 * Created by ChoviWu on 2018/02/22
 * Description:
 */
public interface BasUserService extends BaseService<BasUser> {

    PageList getList(Paginator p, Map map);

    Object updateUserType(Map map);
    //用户注册
    Object doRegister(String openId, BasWx basWx);


}
