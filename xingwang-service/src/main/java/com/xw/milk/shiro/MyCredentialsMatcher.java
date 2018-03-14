//package com.xw.milk.shiro;
//
//import org.apache.shiro.authc.AuthenticationInfo;
//import org.apache.shiro.authc.AuthenticationToken;
//import org.apache.shiro.authc.UsernamePasswordToken;
//import org.apache.shiro.authc.credential.SimpleCredentialsMatcher;
//
///**
// * Created by ChoviWu on 2018/02/05
// * Description:
// */
//public class MyCredentialsMatcher extends SimpleCredentialsMatcher {
//
//
//    @Override
//    public boolean doCredentialsMatch(AuthenticationToken token, AuthenticationInfo info) {
//        UsernamePasswordToken user = (UsernamePasswordToken) token;
//        String password = String.valueOf(user.getPassword());
//        this.equals(info.getCredentials(),password);
//        return true;
//    }
//}
