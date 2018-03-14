package com.xw.milk.util;

import com.xw.milk.Exception.CrowdException;
import org.springframework.util.StringUtils;

/**
 * Created by ChoviWu on 2018/02/22
 * Description:
 */
public class AssertUtil {

    /**
     * Null
     * @param obj
     * @param message
     */
    public static void isNullOrEmpty(Object obj,String message){
        if(StringUtils.isEmpty(obj))
            throw new CrowdException(message);
    }

    public static void isFalse(Boolean flag,String message){
        if(!flag)
            throw new CrowdException(message);
    }


    public static void isTrue(Object obj,Object object,String message){
        if(StringUtils.isEmpty(obj) || StringUtils.isEmpty(object))
            throw new CrowdException("param_is_not_null");
        if(!obj.equals(object))
            throw new CrowdException(message);
    }

    /**
     * 取反
     * @param flag
     * @param message
     */
    public static void isTrue(Boolean flag,String message){

        if(!flag)
            throw new CrowdException(message);
    }
}
