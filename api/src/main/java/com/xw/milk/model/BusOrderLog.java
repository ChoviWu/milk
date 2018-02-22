package com.xw.milk.model;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;

@Table(name = "bus_order_log")
public class BusOrderLog implements Serializable {
    @Id
    private Integer id;

    /**
     * 用户id
     */
    @Column(name = "user_id")
    private Integer userId;

    /**
     * 与order表 订单号一致
     */
    @Column(name = "order_no")
    private String orderNo;

    /**
     * 产品id（下单产品id）
     */
    @Column(name = "product_id")
    private Integer productId;

    /**
     * 状态
     */
    @Column(name = "order_status")
    private Integer orderStatus;

    /**
     * 备注
     */
    private String remark;

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
     * 获取与order表 订单号一致
     *
     * @return order_no - 与order表 订单号一致
     */
    public String getOrderNo() {
        return orderNo;
    }

    /**
     * 设置与order表 订单号一致
     *
     * @param orderNo 与order表 订单号一致
     */
    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo;
    }

    /**
     * 获取产品id（下单产品id）
     *
     * @return product_id - 产品id（下单产品id）
     */
    public Integer getProductId() {
        return productId;
    }

    /**
     * 设置产品id（下单产品id）
     *
     * @param productId 产品id（下单产品id）
     */
    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    /**
     * 获取状态
     *
     * @return order_status - 状态
     */
    public Integer getOrderStatus() {
        return orderStatus;
    }

    /**
     * 设置状态
     *
     * @param orderStatus 状态
     */
    public void setOrderStatus(Integer orderStatus) {
        this.orderStatus = orderStatus;
    }

    /**
     * 获取备注
     *
     * @return remark - 备注
     */
    public String getRemark() {
        return remark;
    }

    /**
     * 设置备注
     *
     * @param remark 备注
     */
    public void setRemark(String remark) {
        this.remark = remark;
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