package com.xw.milk.service;

import com.alibaba.dubbo.config.annotation.Service;
import org.springframework.beans.factory.annotation.Autowired;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

/**
 * Created by ChoviWu
 * Date: 2017-12-05
 * Description :
 */
@Service(version = "1.0.0")
public abstract class BaseServiceImpl<T> implements BaseService<T> {

    @Autowired
    protected Mapper<T> mapper;


    public T selectByKey(Object key) {
        return mapper.selectByPrimaryKey(key);
    }

    
    public T selectOne(T entity){
        return mapper.selectOne(entity);
    }

    
    public int save(T entity) {
        return mapper.insert(entity);
    }

    
    public int delete(Object key) {
        return mapper.deleteByPrimaryKey(key);
    }

    
    public int updateAll(T entity) {
        return mapper.updateByPrimaryKey(entity);
    }

    
    public int updateNotNull(T entity) {
        return mapper.updateByPrimaryKeySelective(entity);
    }

    @Override
    public List<T> selectAll() {

        return mapper.selectAll();
    }

}
