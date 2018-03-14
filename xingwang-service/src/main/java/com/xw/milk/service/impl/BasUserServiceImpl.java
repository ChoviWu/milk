package com.xw.milk.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.github.pagehelper.PageHelper;
import com.xw.milk.Enums.SubCode;
import com.xw.milk.Exception.CrowdException;
import com.xw.milk.common.Message;
import com.xw.milk.common.PageList;
import com.xw.milk.common.Paginator;
import com.xw.milk.mapper.BasUserMapper;
import com.xw.milk.mapper.BasWxMapper;
import com.xw.milk.mapper.SysConfigMapper;
import com.xw.milk.model.BasUser;
import com.xw.milk.model.BasWx;
import com.xw.milk.model.VO.BasUserVO;
import com.xw.milk.model.resp.BasWechat;
import com.xw.milk.service.BasUserService;
import com.xw.milk.service.BaseServiceImpl;
import com.xw.milk.tools.HttpUtils;
import com.xw.milk.util.*;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.UnsupportedEncodingException;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by ChoviWu on 2018/02/22
 * Description:
 */
@Service
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

    /**
     * 登陆
     * @param openId
     * @param mobile
     * @param password
     * @return
     */
    @Override
    public BasUser getOneByUser(String openId,String mobile,String password) {
        BasUser user = null;
        if(StringUtils.isNotEmpty(openId)) {
            Map map = new HashMap();
            map.put("openId",openId);
            user = userMapper.getUserByOpenId(map);
        }
        if(StringUtils.isEmpty(user)) {
            user = userMapper.getUserByPhone(mobile);
            AssertUtil.isNullOrEmpty(user, "please_login_first");
            try {
                password = MD5.toMD5(password + user.getSalt());
                if (!password.equals(user.getPassword()))
                    throw new CrowdException("user.login.password.password_not_correct");
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
        }
        return user;
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

    /**
     * 注册
     * @param openId
     * @param accessToken
     * @param ip
     * @return
     */
    @Override
    public Integer doRegister(String openId,String accessToken,String ip) {
        BasWx wx = wxMapper.getOneByOpenId(openId);
        AssertUtil.isTrue(wx==null, SubCode.U00001.getMessage());
        //拉去用户资料
        BasWechat wxInfo = JsonUtils.json2Object(HttpUtils.URLGet("https://api.weixin.qq.com/sns/userinfo?access_token="
                +accessToken+"&openid="+openId+"&lang=zh_CN",null,"UTF-8"),BasWechat.class);
        //同步插入微信表
        this.insertWx(wxInfo);
        //TODO 注册
        Map map = new HashMap();
        map.put("openId",openId);
        map.put("type",0);
        map.put("time",new Date());
        map.put("ip", IpUtils.get());
        Integer userId = userMapper.registerUser(map);

        //更新用户名
        AssertUtil.isTrue(userMapper.updateUserName("xingwang-"+userId,userId)>0,"insert_error");

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
        AssertUtil.isTrue(userMapper.bindPhone(map)>0,"update_error");//TODO
        return Message.SUCCESS;
    }


    //同步插入wx表
    private void insertWx(BasWechat wechat){
        BasWx wx = new BasWx();
        wx.setCity(wechat.getCity());
        wx.setProvince(wechat.getProvince());
        wx.setCountry(wechat.getCountry());
        wx.setGroupid(wechat.getGroupid());
        wx.setHeadImgUrl(wechat.getHeadimgurl());
        wx.setNickName(wechat.getNickname());
        wx.setRemark(wechat.getRemark());
        wx.setOpenId(wechat.getOpenid());
        wx.setSex(wechat.getSex());
        wx.setTagidList(JsonUtils.toJson(wechat.getTagid_list()));
        AssertUtil.isTrue(wxMapper.insertSelective(wx)>0,"insert_error");
    }


}
