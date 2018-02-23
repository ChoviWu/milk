package com.xw.milk.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.github.pagehelper.PageHelper;
import com.xw.milk.common.Message;
import com.xw.milk.common.PageList;
import com.xw.milk.common.Paginator;
import com.xw.milk.mapper.BasUserMapper;
import com.xw.milk.mapper.BasWxMapper;
import com.xw.milk.mapper.SysConfigMapper;
import com.xw.milk.model.BasUser;
import com.xw.milk.model.BasWx;
import com.xw.milk.model.VO.BasUserVO;
import com.xw.milk.service.BasUserService;
import com.xw.milk.service.BasWxService;
import com.xw.milk.service.BaseServiceImpl;
import com.xw.milk.tools.HttpUtils;
import com.xw.milk.util.AssertUtil;
import com.xw.milk.util.JsonUtils;
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
    @Autowired
    private SysConfigMapper configMapper;

    public PageList getList(Paginator p, Map map) {
        PageHelper.startPage(p.getPageNum(),p.getPageSize());
        List list = userMapper.getList(map);
        return new PageList(list);
    }

    @Override
    public BasUser getOneByOpenId(String openId) {
        BasUser user = new BasUser();
        user.setOpenId(openId);
        return userMapper.selectOne(user);
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
    public Integer doRegister(String openId,String accessToken) {
        BasWx wx = wxMapper.getOneByOpenId(openId);
        AssertUtil.isTrue(wx==null,"");
        //拉去用户资料
        Object wxInfo = JsonUtils.json2Object(HttpUtils.URLGet("https://api.weixin.qq.com/sns/userinfo?access_token="
                +accessToken+"&openid="+openId+"&lang=zh_CN",null,"UTF-8"),BasWx.class);
        //同步插入微信表
//        this.insertWx(wxInfo);
        //TODO 注册
        Map map = new HashMap();
        map.put("openId",openId);
        map.put("type",0);
        map.put("time",new Date());
        map.put("ip","");
        Integer userId = userMapper.registerUser(map);

        //更新用户名
        AssertUtil.isTrue(userMapper.updateUserName("xingwang-"+userId,userId)==1,"insert_error");

        return userId;

    }

    @Override
    public BasUserVO getUserByOpenId(String openId) {
       Map map = new HashMap();
       map.put("openId",openId);
       return userMapper.getUserByOpenId(map);
    }

    /**
     * 绑定手机号
     * @param mobile
     * @param userId
     * @return
     */
    @Override
    public Object bindMobile(String mobile,Integer userId) {
        Map map = new HashMap();
        map.put("userId",userId);
        map.put("mobile",mobile);
        AssertUtil.isTrue(userMapper.bindMobile(map)==1,"update_error");//TODO
        return Message.SUCCESS;
    }


    //同步插入wx表

    private void insertWx(BasWx wx){
        AssertUtil.isTrue(wxMapper.insertSelective(wx)==1,"insert_error");
    }


}
