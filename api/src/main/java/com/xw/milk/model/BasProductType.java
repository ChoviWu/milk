package com.xw.milk.model;

import javax.persistence.*;

@Table(name = "bas_product_type")
public class BasProductType {
    @Id
    private Integer id;

    /**
     * 1牛奶  2  酸奶  3  其他
     */
    private Integer type;

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
     * 获取1牛奶  2  酸奶  3  其他
     *
     * @return type - 1牛奶  2  酸奶  3  其他
     */
    public Integer getType() {
        return type;
    }

    /**
     * 设置1牛奶  2  酸奶  3  其他
     *
     * @param type 1牛奶  2  酸奶  3  其他
     */
    public void setType(Integer type) {
        this.type = type;
    }
}