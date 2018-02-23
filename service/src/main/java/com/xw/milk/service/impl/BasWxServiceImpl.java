package com.xw.milk.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.xw.milk.mapper.BasWxMapper;
import com.xw.milk.mapper.SysConfigMapper;
import com.xw.milk.model.BasUser;
import com.xw.milk.model.BasWx;
import com.xw.milk.service.BasWxService;
import com.xw.milk.service.BaseServiceImpl;
import com.xw.milk.util.HttpUtils;
import com.xw.milk.util.JsonUtils;
import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by ChoviWu on 2018/02/22
 * Description:
 */
@Service(version = "1.0.0")
public class BasWxServiceImpl  extends BaseServiceImpl<BasWx> implements BasWxService {

    @Autowired
    private BasWxMapper wxMapper;

    protected String appid;

    protected String appsecret;


    private final String authUrl = "https://api.weixin.qq.com/sns/oauth2/access_token" +
            "?appid="+appid+"&secret="+appsecret;



    @Autowired
    public BasWxServiceImpl(SysConfigMapper configMapper){
        this.appid =  configMapper.getValueByParam("app_id");
        this.appsecret = configMapper.getValueByParam("app_secret");
    }

    /**
     * 查询用户
     * @param openId
     * @return
     */
    @Override
    public BasWx getOneByOpenId(String openId){
        return wxMapper.getOneByOpenId(openId);
    }




    @Override
    public Map getAnthTokenByCode(String code) {
        String response = HttpUtils.URLPost(authUrl + "&code=" + code + "&grant_type=authorization_code");
        Map map = JsonUtils.json2Map(response);
        return map;
    }

    public String getAccessToken(){
        Map<String ,String > map = new HashMap();
        map.put("appid",appid);
        map.put("secret",appsecret);
        map.put("grant_type","client_credential");
        String response = HttpUtils.URLGet("https://api.weixin.qq.com/cgi-bin/token",map,"UTF-8");
        map.clear();
        map = JsonUtils.json2Map(response);
        String accessToken = map.get("access_token");
        System.out.println(accessToken);
        return accessToken;
    }




}
