//package com.example.shiro;
//
//import CrowdException;
//import SysEmployee;
//import SysResource;
//import SysRole;
//import org.apache.shiro.authc.AuthenticationInfo;
//import org.apache.shiro.authc.AuthenticationToken;
//import org.apache.shiro.authc.SimpleAuthenticationInfo;
//import org.apache.shiro.authc.UsernamePasswordToken;
//import org.apache.shiro.authz.AuthorizationInfo;
//import org.apache.shiro.authz.SimpleAuthorizationInfo;
//import org.apache.shiro.realm.AuthorizingRealm;
//import org.apache.shiro.subject.PrincipalCollection;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Component;
//import org.springframework.util.StringUtils;
//
//import java.util.ArrayList;
//import java.util.HashMap;
//import java.util.List;
//import java.util.Map;
//
///**
// * Created by ChoviWu on 2018/02/05
// * Description:
// */
//@Component
//public class ShiroRealm   extends AuthorizingRealm {
//        @Autowired
//        private SysEmployeeMapper userMapper;
//        @Autowired
//        private SysRoleMapper roleMapper;
//        @Autowired
//        private SysResourceMapper resourceMapper;
//
//        //认证.登录
//        @Override
//        protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) {
//            UsernamePasswordToken utoken=(UsernamePasswordToken) token;//获取用户输入的token
//            SysEmployee user = userMapper.getUserByPhone(utoken.getUsername());
//            if(StringUtils.isEmpty(user))
//                throw new CrowdException("user.login.username.no_such_user");
//
//            user = userMapper.getUserByNameAndPassword(user.getEmpName(),user.getPassword());
//
//            return new SimpleAuthenticationInfo(user, user.getPassword(),this.getClass().getName());//放入shiro.调用CredentialsMatcher检验密码
//        }
//        //授权
//        @Override
//        protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principal) {
//            SysEmployee user=(SysEmployee) principal.fromRealm(this.getClass().getName()).iterator().next();//获取session中的用户
//            List<String> permissions=new ArrayList<>();
//            List<String> roleList=new ArrayList<>();
//            Map map = new HashMap();
//            map.put("userId",user.getId());
//            List<SysRole> roles = roleMapper.getRolesByUserId(map);
//            if(roles.size()>0) {
//                for(SysRole role : roles) {
//                    List<SysResource> resourceList = resourceMapper.getResourcesByRoleId(map);
//                    if(resourceList.size()>0) {
//                        for(SysResource resource : resourceList) {
//                            permissions.add(resource.getUrl());
//                        }
//                    }
//                    roleList.add(role.getName());
//                }
//            }
//            SimpleAuthorizationInfo info=new SimpleAuthorizationInfo();
//            info.addStringPermissions(permissions);//将权限放入shiro中.
//            return info;
//        }
//
//    }
