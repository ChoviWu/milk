package com.xw.milk.mapper;

import com.xw.milk.model.BasUser;
import com.xw.milk.model.VO.BasUserVO;
import org.apache.ibatis.annotations.Param;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;
import java.util.Map;

public interface BasUserMapper extends Mapper<BasUser> {

    List<BasUser> getList(Map map);

    int modifyUserType(Map map);

    int registerUser(Map map);

    int updateUserName(@Param("username") String username, @Param("userId") Integer userId);

    BasUserVO getUserByOpenId(Map map);

    int bindPhone(Map map);

    BasUser getUserByPhone(@Param("phone") String  phone);

    BasUser getUserByUserName(@Param("username")String username);
}