package com.xw.milk.model;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;

@Table(name = "sys_user")
public class SysUser implements Serializable {
    @Id
    private Integer id;

    /**
     * 系统用户名
     */
    @Column(name = "sys_name")
    private String sysName;

    private String password;

    /**
     * 盐值
     */
    private String salt;

    /**
     * 用户类型  1  后台管理员   -1  超级管理员
     */
    private Integer type;

    private Date addtime;

    @Column(name = "last_login_time")
    private Date lastLoginTime;

    /**
     * @return id
     */
    public Integer getId() {
        return id;
    }

    /**
     * @param id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 获取系统用户名
     *
     * @return sys_name - 系统用户名
     */
    public String getSysName() {
        return sysName;
    }

    /**
     * 设置系统用户名
     *
     * @param sysName 系统用户名
     */
    public void setSysName(String sysName) {
        this.sysName = sysName;
    }

    /**
     * @return password
     */
    public String getPassword() {
        return password;
    }

    /**
     * @param password
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * 获取盐值
     *
     * @return salt - 盐值
     */
    public String getSalt() {
        return salt;
    }

    /**
     * 设置盐值
     *
     * @param salt 盐值
     */
    public void setSalt(String salt) {
        this.salt = salt;
    }

    /**
     * 获取用户类型  1  后台管理员   -1  超级管理员
     *
     * @return type - 用户类型  1  后台管理员   -1  超级管理员
     */
    public Integer getType() {
        return type;
    }

    /**
     * 设置用户类型  1  后台管理员   -1  超级管理员
     *
     * @param type 用户类型  1  后台管理员   -1  超级管理员
     */
    public void setType(Integer type) {
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
     * @return last_login_time
     */
    public Date getLastLoginTime() {
        return lastLoginTime;
    }

    /**
     * @param lastLoginTime
     */
    public void setLastLoginTime(Date lastLoginTime) {
        this.lastLoginTime = lastLoginTime;
    }
}