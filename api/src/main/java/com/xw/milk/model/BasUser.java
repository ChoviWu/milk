package com.xw.milk.model;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;

@Table(name = "bas_user")
public class BasUser    implements Serializable {
    /**
     * 用户名
     */
    private String username;

    /**
     * 手机号
     */
    private String mobile;

    /**
     * 用户类型
     */
    private String type;

    private Date addtime;

    @Column(name = "last_login_ip")
    private String lastLoginIp;

    /**
     * 最后登陆时间
     */
    @Column(name = "last_login_time")
    private Date lastLoginTime;

    private String addip;

    /**
     * 主键
     */
    @Id
    private Integer id;

    /**
     * 微信唯一id 可做主键
     */
    @Column(name = "open_id")
    private String openId;

    /**
     * 获取主键
     *
     * @return id - 主键
     */
    public Integer getId() {
        return id;
    }

    /**
     * 设置主键
     *
     * @param id 主键
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 获取微信唯一id 可做主键
     *
     * @return open_id - 微信唯一id 可做主键
     */
    public String getOpenId() {
        return openId;
    }

    /**
     * 设置微信唯一id 可做主键
     *
     * @param openId 微信唯一id 可做主键
     */
    public void setOpenId(String openId) {
        this.openId = openId;
    }


    /**
     * 获取用户名
     *
     * @return username - 用户名
     */
    public String getUsername() {
        return username;
    }

    /**
     * 设置用户名
     *
     * @param username 用户名
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * 获取手机号
     *
     * @return mobile - 手机号
     */
    public String getMobile() {
        return mobile;
    }

    /**
     * 设置手机号
     *
     * @param mobile 手机号
     */
    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    /**
     * 获取用户类型
     *
     * @return type - 用户类型
     */
    public String getType() {
        return type;
    }

    /**
     * 设置用户类型
     *
     * @param type 用户类型
     */
    public void setType(String type) {
        this.type = type;
    }

    /**
     * @return addtime
     */
    public Date getAddtime() {
        return addtime;
    }

    /**
     * @param addtime
     */
    public void setAddtime(Date addtime) {
        this.addtime = addtime;
    }

    /**
     * @return last_login_ip
     */
    public String getLastLoginIp() {
        return lastLoginIp;
    }

    /**
     * @param lastLoginIp
     */
    public void setLastLoginIp(String lastLoginIp) {
        this.lastLoginIp = lastLoginIp;
    }

    /**
     * 获取最后登陆时间
     *
     * @return last_login_time - 最后登陆时间
     */
    public Date getLastLoginTime() {
        return lastLoginTime;
    }

    /**
     * 设置最后登陆时间
     *
     * @param lastLoginTime 最后登陆时间
     */
    public void setLastLoginTime(Date lastLoginTime) {
        this.lastLoginTime = lastLoginTime;
    }

    /**
     * @return addip
     */
    public String getAddip() {
        return addip;
    }

    /**
     * @param addip
     */
    public void setAddip(String addip) {
        this.addip = addip;
    }
}