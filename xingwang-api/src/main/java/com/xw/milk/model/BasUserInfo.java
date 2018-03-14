package com.xw.milk.model;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;

@Table(name = "bas_user_info_t")
public class BasUserInfo implements Serializable {
    @Id
    private Integer id;

    /**
     * 用户id
     */
    @Column(name = "user_id")
    private Integer userId;

    /**
     * 配送收货人电话（客户一般收货人和phone是一个）
     */
    @Column(name = "receiver_phone")
    private String receiverPhone;

    private Date addtime;

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
     * 获取用户id
     *
     * @return user_id - 用户id
     */
    public Integer getUserId() {
        return userId;
    }

    /**
     * 设置用户id
     *
     * @param userId 用户id
     */
    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    /**
     * 获取配送收货人电话（客户一般收货人和phone是一个）
     *
     * @return receiver_phone - 配送收货人电话（客户一般收货人和phone是一个）
     */
    public String getReceiverPhone() {
        return receiverPhone;
    }

    /**
     * 设置配送收货人电话（客户一般收货人和phone是一个）
     *
     * @param receiverPhone 配送收货人电话（客户一般收货人和phone是一个）
     */
    public void setReceiverPhone(String receiverPhone) {
        this.receiverPhone = receiverPhone;
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
}