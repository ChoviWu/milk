package com.xw.milk.model;

import javax.persistence.*;
import java.io.Serializable;

@Table(name = "biz_order_detail_t")
public class BizOrderDetail implements Serializable {
    @Id
    private Integer id;

    /**
     * 订单号
     */
    @Column(name = "order_id")
    private String orderId;

    /**
     * 产品编号
     */
    @Column(name = "product_id")
    private Integer productId;

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
     * 获取产品编号
     *
     * @return product_id - 产品编号
     */
    public Integer getProductId() {
        return productId;
    }

    /**
     * 设置产品编号
     *
     * @param productId 产品编号
     */
    public void setProductId(Integer productId) {
        this.productId = productId;
    }
}