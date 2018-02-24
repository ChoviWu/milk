package com.xw.milk.service;

import java.util.List;


public interface BaseService<T> {

    T selectByKey(Object key);

    T selectOne(T entity);

    int save(T entity);

    int saveNotNull(T entity);

    int delete(Object key);

    int updateAll(T entity);

    int updateNotNull(T entity);

    List<T> selectAll();

//    List<T> selectPage(int pageNum, int pageSize, T entity);
}