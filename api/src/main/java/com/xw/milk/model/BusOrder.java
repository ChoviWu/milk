package com.xw.milk.model;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;

@Table(name = "bus_order")
public class BusOrder implements Serializable {
    @Id
    private Integer id;

    /**
     * 用户id
     */
    @Column(name = "user_id")
    private Integer userId;

    /**
     * 订单号
     */
    @Column(name = "order_no")
    private String orderNo;

    /**
     * 订单状态 1 已完成 已配送    0 已下单 即将配送  -1已取消
     */
    @Column(name = "order_status")
    private Integer orderStatus;

    /**
     * 多个产品id 用逗号分隔
     */
    @Column(name = "product_id")
    private String productId;

    /**
     * 是否打印票据 1打印 0 未打印
     */
    @Column(name = "is_print")
    private Integer isPrint;

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
     * 获取订单号
     *
     * @return order_no - 订单号
     */
    public String getOrderNo() {
        return orderNo;
    }

    /**
     * 设置订单号
     *
     * @param orderNo 订单号
     */
    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo;
    }

    /**
     * 获取订单状态 1 已完成 已配送    0 已下单 即将配送  -1已取消
     *
     * @return order_status - 订单状态 1 已完成 已配送    0 已下单 即将配送  -1已取消
     */
    public Integer getOrderStatus() {
        return orderStatus;
    }

    /**
     * 设置订单状态 1 已完成 已配送    0 已下单 即将配送  -1已取消
     *
     * @param orderStatus 订单状态 1 已完成 已配送    0 已下单 即将配送  -1已取消
     */
    public void setOrderStatus(Integer orderStatus) {
        this.orderStatus = orderStatus;
    }

    /**
     * 获取多个产品id 用逗号分隔
     *
     * @return product_id - 多个产品id 用逗号分隔
     */
    public String getProductId() {
        return productId;
    }

    /**
     * 设置多个产品id 用逗号分隔
     *
     * @param productId 多个产品id 用逗号分隔
     */
    public void setProductId(String productId) {
        this.productId = productId;
    }

    /**
     * 获取是否打印票据 1打印 0 未打印
     *
     * @return is_print - 是否打印票据 1打印 0 未打印
     */
    public Integer getIsPrint() {
        return isPrint;
    }

    /**
     * 设置是否打印票据 1打印 0 未打印
     *
     * @param isPrint 是否打印票据 1打印 0 未打印
     */
    public void setIsPrint(Integer isPrint) {
        this.isPrint = isPrint;
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