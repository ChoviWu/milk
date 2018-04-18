package com.xw.milk.Exception;



import java.util.HashMap;

/**
 * Created by Administrator on 2015/12/9.
 */

public class ExceptionMessage {


    public static HashMap<String,String> exceptionMessage=new HashMap<String, String>();

    static  {

        //处理用户异常信息
        exceptionMessage.put("user.login.password.password_not_correct","您输入的密码有误");
        exceptionMessage.put("user.login.username.no_such_user","您输入的用户不存在");
        //处理找回密码异常
        exceptionMessage.put("sys.user.add.user_exist","用户已存在");
        exceptionMessage.put("user.forget.user_not_exist","你输入的用户不存在");
        exceptionMessage.put("user.forget.mobile_not_exist","你输入的手机号码不存在");
        exceptionMessage.put("user.not_is_guarantee_company","此账号不是担保账号");

        //处理投资异常信息
        exceptionMessage.put("item.invest.session_out","您还未登陆，请先登陆");

      
    }



}
