package com.xw.milk.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.github.pagehelper.PageHelper;
import com.xw.milk.common.PageList;
import com.xw.milk.common.Paginator;
import com.xw.milk.mapper.BasUserMapper;
import com.xw.milk.mapper.BasWxMapper;
import com.xw.milk.model.BasUser;
import com.xw.milk.model.BasWx;
import com.xw.milk.service.BasUserService;
import com.xw.milk.service.BaseServiceImpl;
import com.xw.milk.util.AssertUtil;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by ChoviWu on 2018/02/22
 * Description:
 */
@Service(version = "1.0.0")
public class BasUserServiceImpl extends BaseServiceImpl<BasUser> implements BasUserService {

    @Autowired
    private BasUserMapper userMapper;
    @Autowired
    private BasWxMapper wxMapper;

    @Override
    public PageList getList(Paginator p, Map map) {
        PageHelper.startPage(p.getPageNum(),p.getPageSize());
        List list = userMapper.getList(map);
        return new PageList(list);
    }

    /**
     * 修改用户类型
     * @param map
     * @return
     */
    @Override
    public Object updateUserType(Map map) {
        return userMapper.modifyUserType(map);
    }

    @Override
    public Object doRegister(String openId, BasWx basWx) {
        BasWx wx = wxMapper.getOneByOpenId(openId);
        AssertUtil.isTrue(wx==null,"");
        //TODO 注册
        Map map = new HashMap();
        map.put("openId",openId);
        map.put("type",0);
        map.put("time",new Date());
        map.put("ip","");
        Integer userId = userMapper.registerUser(map);

        //更新用户名
        AssertUtil.isTrue(userMapper.updateUserName("Xwry"+userId,userId)==1,"insert_error");




        return userId;

    }

    //同步插入wx表

    private void insertWx(BasWx wx){
        AssertUtil.isTrue(wxMapper.insertSelective(wx)==1,"insert_error");
    }


}
