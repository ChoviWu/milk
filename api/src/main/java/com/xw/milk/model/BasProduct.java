package com.xw.milk.model;

import java.io.Serializable;
import java.math.BigDecimal;
import javax.persistence.*;

@Table(name = "bas_product")
public class BasProduct implements Serializable {
    @Id
    private Integer id;

    /**
     * 产品名称
     */
    @Column(name = "product_name")
    private String productName;

    /**
     * 产品规格
     */
    @Column(name = "product_size")
    private String productSize;

    /**
     * 产品品牌
     */
    @Column(name = "product_brand")
    private String productBrand;

    /**
     * 商品折扣 price= price*discount*0.1
     */
    @Column(name = "product_discount")
    private BigDecimal productDiscount;

    /**
     * 父级id 一级标题 parent_id为0
     */
    @Column(name = "parent_id")
    private Integer parentId;

    /**
     * 商品价格
     */
    @Column(name = "product_price")
    private BigDecimal productPrice;

    private String temp1;

    private String temp2;

    /**
     * 产品介绍
     */
    @Column(name = "product_intro")
    private String productIntro;

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
     * 获取产品名称
     *
     * @return product_name - 产品名称
     */
    public String getProductName() {
        return productName;
    }

    /**
     * 设置产品名称
     *
     * @param productName 产品名称
     */
    public void setProductName(String productName) {
        this.productName = productName;
    }

    /**
     * 获取产品规格
     *
     * @return product_size - 产品规格
     */
    public String getProductSize() {
        return productSize;
    }

    /**
     * 设置产品规格
     *
     * @param productSize 产品规格
     */
    public void setProductSize(String productSize) {
        this.productSize = productSize;
    }

    /**
     * 获取产品品牌
     *
     * @return product_brand - 产品品牌
     */
    public String getProductBrand() {
        return productBrand;
    }

    /**
     * 设置产品品牌
     *
     * @param productBrand 产品品牌
     */
    public void setProductBrand(String productBrand) {
        this.productBrand = productBrand;
    }

    /**
     * 获取商品折扣 price= price*discount*0.1
     *
     * @return product_discount - 商品折扣 price= price*discount*0.1
     */
    public BigDecimal getProductDiscount() {
        return productDiscount;
    }

    /**
     * 设置商品折扣 price= price*discount*0.1
     *
     * @param productDiscount 商品折扣 price= price*discount*0.1
     */
    public void setProductDiscount(BigDecimal productDiscount) {
        this.productDiscount = productDiscount;
    }

    /**
     * 获取父级id 一级标题 parent_id为0
     *
     * @return parent_id - 父级id 一级标题 parent_id为0
     */
    public Integer getParentId() {
        return parentId;
    }

    /**
     * 设置父级id 一级标题 parent_id为0
     *
     * @param parentId 父级id 一级标题 parent_id为0
     */
    public void setParentId(Integer parentId) {
        this.parentId = parentId;
    }

    /**
     * 获取商品价格
     *
     * @return product_price - 商品价格
     */
    public BigDecimal getProductPrice() {
        return productPrice;
    }

    /**
     * 设置商品价格
     *
     * @param productPrice 商品价格
     */
    public void setProductPrice(BigDecimal productPrice) {
        this.productPrice = productPrice;
    }

    /**
     * @return temp1
     */
    public String getTemp1() {
        return temp1;
    }

    /**
     * @param temp1
     */
    public void setTemp1(String temp1) {
        this.temp1 = temp1;
    }

    /**
     * @return temp2
     */
    public String getTemp2() {
        return temp2;
    }

    /**
     * @param temp2
     */
    public void setTemp2(String temp2) {
        this.temp2 = temp2;
    }

    /**
     * 获取产品介绍
     *
     * @return product_intro - 产品介绍
     */
    public String getProductIntro() {
        return productIntro;
    }

    /**
     * 设置产品介绍
     *
     * @param productIntro 产品介绍
     */
    public void setProductIntro(String productIntro) {
        this.productIntro = productIntro;
    }
}