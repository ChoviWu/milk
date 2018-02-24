package com.xw.milk.model;

import java.util.Date;
import javax.persistence.*;

@Table(name = "sys_log")
public class SysLog {
    @Id
    private Integer id;

    /**
     * 模型
     */
    private String module;

    /**
     * 方法
     */
    private String method;

    private Date addtime;

    /**
     * 参数
     */
    private String args;

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
     * 获取模型
     *
     * @return module - 模型
     */
    public String getModule() {
        return module;
    }

    /**
     * 设置模型
     *
     * @param module 模型
     */
    public void setModule(String module) {
        this.module = module;
    }

    /**
     * 获取方法
     *
     * @return method - 方法
     */
    public String getMethod() {
        return method;
    }

    /**
     * 设置方法
     *
     * @param method 方法
     */
    public void setMethod(String method) {
        this.method = method;
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
     * 获取参数
     *
     * @return args - 参数
     */
    public String getArgs() {
        return args;
    }

    /**
     * 设置参数
     *
     * @param args 参数
     */
    public void setArgs(String args) {
        this.args = args;
    }
}