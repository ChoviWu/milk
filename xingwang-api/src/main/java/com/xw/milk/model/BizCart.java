package com.xw.milk.model;

import java.io.Serializable;
import java.math.BigDecimal;
import javax.persistence.*;

@Table(name = "biz_cart_t")
public class BizCart implements Serializable {
    @Id
    private Integer id;

    /**
     * 用户编号
     */
    @Column(name = "user_id")
    private Integer userId;

    /**
     * 产品编号
     */
    @Column(name = "product_id")
    private Integer productId;

    /**
     * 产品数量
     */
    @Column(name = "product_quantity")
    private Integer productQuantity;

    /**
     * 购物车价格
     */
    @Column(name = "product_price")
    private BigDecimal productPrice;

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
     * 获取用户编号
     *
     * @return user_id - 用户编号
     */
    public Integer getUserId() {
        return userId;
    }

    /**
     * 设置用户编号
     *
     * @param userId 用户编号
     */
    public void setUserId(Integer userId) {
        this.userId = userId;
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

    /**
     * 获取产品数量
     *
     * @return product_quantity - 产品数量
     */
    public Integer getProductQuantity() {
        return productQuantity;
    }

    /**
     * 设置产品数量
     *
     * @param productQuantity 产品数量
     */
    public void setProductQuantity(Integer productQuantity) {
        this.productQuantity = productQuantity;
    }

    /**
     * 获取购物车价格
     *
     * @return product_price - 购物车价格
     */
    public BigDecimal getProductPrice() {
        return productPrice;
    }

    /**
     * 设置购物车价格
     *
     * @param productPrice 购物车价格
     */
    public void setProductPrice(BigDecimal productPrice) {
        this.productPrice = productPrice;
    }
}