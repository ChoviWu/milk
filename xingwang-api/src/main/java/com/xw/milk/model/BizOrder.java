package com.xw.milk.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.*;

@Table(name = "biz_order_t")
public class BizOrder implements Serializable {
    @Id
    private Integer id;

    /**
     * 订单号
     */
    @Column(name = "order_id")
    private String orderId;

    /**
     * 用户id
     */
    @Column(name = "user_id")
    private Integer userId;

    /**
     * 订单状态 0：新订单，1：已完成，2：配送中，3：取消
     */
    @Column(name = "order_status")
    private Integer orderStatus;

    /**
     * 支付的金额
     */
    @Column(name = "order_money")
    private BigDecimal orderMoney;

    /**
     * 优惠金额
     */
    @Column(name = "reduced_price")
    private BigDecimal reducedPrice;

    /**
     * 配送收货人
     */
    @Column(name = "receiver_name")
    private String receiverName;

    /**
     * 配送收货人电话
     */
    @Column(name = "receiver_phone")
    private String receiverPhone;

    /**
     * 配送时间(大约时间)
     */
    @Column(name = "shipping_time")
    private Date shippingTime;

    /**
     * 下单时间
     */
    @Column(name = "order_time")
    private Date orderTime;

    /**
     * 配送地址
     */
    @Column(name = "shipping_addr")
    private String shippingAddr;

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
     * 获取订单号
     *
     * @return order_id - 订单号
     */
    public String getOrderId() {
        return orderId;
    }

    /**
     * 设置订单号
     *
     * @param orderId 订单号
     */
    public void setOrderId(String orderId) {
        this.orderId = orderId;
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
     * 获取订单状态 0：新订单，1：已完成，2：配送中，3：取消
     *
     * @return order_status - 订单状态 0：新订单，1：已完成，2：配送中，3：取消
     */
    public Integer getOrderStatus() {
        return orderStatus;
    }

    /**
     * 设置订单状态 0：新订单，1：已完成，2：配送中，3：取消
     *
     * @param orderStatus 订单状态 0：新订单，1：已完成，2：配送中，3：取消
     */
    public void setOrderStatus(Integer orderStatus) {
        this.orderStatus = orderStatus;
    }

    /**
     * 获取支付的金额
     *
     * @return order_money - 支付的金额
     */
    public BigDecimal getOrderMoney() {
        return orderMoney;
    }

    /**
     * 设置支付的金额
     *
     * @param orderMoney 支付的金额
     */
    public void setOrderMoney(BigDecimal orderMoney) {
        this.orderMoney = orderMoney;
    }

    /**
     * 获取优惠金额
     *
     * @return reduced_price - 优惠金额
     */
    public BigDecimal getReducedPrice() {
        return reducedPrice;
    }

    /**
     * 设置优惠金额
     *
     * @param reducedPrice 优惠金额
     */
    public void setReducedPrice(BigDecimal reducedPrice) {
        this.reducedPrice = reducedPrice;
    }

    /**
     * 获取配送收货人
     *
     * @return receiver_name - 配送收货人
     */
    public String getReceiverName() {
        return receiverName;
    }

    /**
     * 设置配送收货人
     *
     * @param receiverName 配送收货人
     */
    public void setReceiverName(String receiverName) {
        this.receiverName = receiverName;
    }

    /**
     * 获取配送收货人电话
     *
     * @return receiver_phone - 配送收货人电话
     */
    public String getReceiverPhone() {
        return receiverPhone;
    }

    /**
     * 设置配送收货人电话
     *
     * @param receiverPhone 配送收货人电话
     */
    public void setReceiverPhone(String receiverPhone) {
        this.receiverPhone = receiverPhone;
    }

    /**
     * 获取配送时间(大约时间)
     *
     * @return shipping_time - 配送时间(大约时间)
     */
    public Date getShippingTime() {
        return shippingTime;
    }

    /**
     * 设置配送时间(大约时间)
     *
     * @param shippingTime 配送时间(大约时间)
     */
    public void setShippingTime(Date shippingTime) {
        this.shippingTime = shippingTime;
    }

    /**
     * 获取下单时间
     *
     * @return order_time - 下单时间
     */
    public Date getOrderTime() {
        return orderTime;
    }

    /**
     * 设置下单时间
     *
     * @param orderTime 下单时间
     */
    public void setOrderTime(Date orderTime) {
        this.orderTime = orderTime;
    }

    /**
     * 获取配送地址
     *
     * @return shipping_addr - 配送地址
     */
    public String getShippingAddr() {
        return shippingAddr;
    }

    /**
     * 设置配送地址
     *
     * @param shippingAddr 配送地址
     */
    public void setShippingAddr(String shippingAddr) {
        this.shippingAddr = shippingAddr;
    }
}