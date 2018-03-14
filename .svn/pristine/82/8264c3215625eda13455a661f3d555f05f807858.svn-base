package com.xw.milk.model;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;

@Table(name = "bas_user_t")
public class BasUser implements Serializable {
    @Id
    private Integer id;

    /**
     * 用户名（xw+UUID）
     */
    @Column(name = "user_name")
    private String userName;

    /**
     * 密码（通过加盐并用MD5生成）用户注册密码可为空
     */
    private String password;

    /**
     * 盐值，与用户密码结合加密
     */
    private String salt;

    /**
     * 用户手机号（注册完成，商户修改用户类型，用户即可绑定手机号进行下单，手机号唯一
     */
    private String phone;

    /**
     * 用户类型1客户，2消费者，0管理员
     */
    @Column(name = "user_type")
    private Integer userType;

    /**
     * 用户微信唯一标识
     */
    @Column(name = "open_id")
    private String openId;

    /**
     * 注册时间
     */
    @Column(name = "record_time")
    private Date recordTime;

    /**
     * 上次登录地址（XXX省XXX市）
     */
    @Column(name = "last_login_city")
    private String lastLoginCity;

    /**
     * 上次登录时间
     */
    @Column(name = "last_login_time")
    private Date lastLoginTime;

    /**
     * 注册地址（XXX省XXX市）
     */
    @Column(name = "record_addr")
    private String recordAddr;

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
     * 获取用户名（xw+UUID）
     *
     * @return user_name - 用户名（xw+UUID）
     */
    public String getUserName() {
        return userName;
    }

    /**
     * 设置用户名（xw+UUID）
     *
     * @param userName 用户名（xw+UUID）
     */
    public void setUserName(String userName) {
        this.userName = userName;
    }

    /**
     * 获取密码（通过加盐并用MD5生成）用户注册密码可为空
     *
     * @return password - 密码（通过加盐并用MD5生成）用户注册密码可为空
     */
    public String getPassword() {
        return password;
    }

    /**
     * 设置密码（通过加盐并用MD5生成）用户注册密码可为空
     *
     * @param password 密码（通过加盐并用MD5生成）用户注册密码可为空
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * 获取盐值，与用户密码结合加密
     *
     * @return salt - 盐值，与用户密码结合加密
     */
    public String getSalt() {
        return salt;
    }

    /**
     * 设置盐值，与用户密码结合加密
     *
     * @param salt 盐值，与用户密码结合加密
     */
    public void setSalt(String salt) {
        this.salt = salt;
    }

    /**
     * 获取用户手机号（注册完成，商户修改用户类型，用户即可绑定手机号进行下单，手机号唯一
     *
     * @return phone - 用户手机号（注册完成，商户修改用户类型，用户即可绑定手机号进行下单，手机号唯一
     */
    public String getPhone() {
        return phone;
    }

    /**
     * 设置用户手机号（注册完成，商户修改用户类型，用户即可绑定手机号进行下单，手机号唯一
     *
     * @param phone 用户手机号（注册完成，商户修改用户类型，用户即可绑定手机号进行下单，手机号唯一
     */
    public void setPhone(String phone) {
        this.phone = phone;
    }

    /**
     * 获取用户类型1客户，2消费者，0管理员
     *
     * @return user_type - 用户类型1客户，2消费者，0管理员
     */
    public Integer getUserType() {
        return userType;
    }

    /**
     * 设置用户类型1客户，2消费者，0管理员
     *
     * @param userType 用户类型1客户，2消费者，0管理员
     */
    public void setUserType(Integer userType) {
        this.userType = userType;
    }

    /**
     * 获取用户微信唯一标识
     *
     * @return open_id - 用户微信唯一标识
     */
    public String getOpenId() {
        return openId;
    }

    /**
     * 设置用户微信唯一标识
     *
     * @param openId 用户微信唯一标识
     */
    public void setOpenId(String openId) {
        this.openId = openId;
    }

    /**
     * 获取注册时间
     *
     * @return record_time - 注册时间
     */
    public Date getRecordTime() {
        return recordTime;
    }

    /**
     * 设置注册时间
     *
     * @param recordTime 注册时间
     */
    public void setRecordTime(Date recordTime) {
        this.recordTime = recordTime;
    }

    /**
     * 获取上次登录地址（XXX省XXX市）
     *
     * @return last_login_city - 上次登录地址（XXX省XXX市）
     */
    public String getLastLoginCity() {
        return lastLoginCity;
    }

    /**
     * 设置上次登录地址（XXX省XXX市）
     *
     * @param lastLoginCity 上次登录地址（XXX省XXX市）
     */
    public void setLastLoginCity(String lastLoginCity) {
        this.lastLoginCity = lastLoginCity;
    }

    /**
     * 获取上次登录时间
     *
     * @return last_login_time - 上次登录时间
     */
    public Date getLastLoginTime() {
        return lastLoginTime;
    }

    /**
     * 设置上次登录时间
     *
     * @param lastLoginTime 上次登录时间
     */
    public void setLastLoginTime(Date lastLoginTime) {
        this.lastLoginTime = lastLoginTime;
    }

    /**
     * 获取注册地址（XXX省XXX市）
     *
     * @return record_addr - 注册地址（XXX省XXX市）
     */
    public String getRecordAddr() {
        return recordAddr;
    }

    /**
     * 设置注册地址（XXX省XXX市）
     *
     * @param recordAddr 注册地址（XXX省XXX市）
     */
    public void setRecordAddr(String recordAddr) {
        this.recordAddr = recordAddr;
    }
}