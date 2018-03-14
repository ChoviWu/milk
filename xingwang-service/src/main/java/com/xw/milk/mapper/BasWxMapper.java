package com.xw.milk.mapper;

import com.xw.milk.model.BasWx;
import org.apache.ibatis.annotations.Param;
import tk.mybatis.mapper.common.Mapper;

public interface BasWxMapper extends Mapper<BasWx> {

    BasWx getOneByOpenId(@Param("openId") String openId);
}