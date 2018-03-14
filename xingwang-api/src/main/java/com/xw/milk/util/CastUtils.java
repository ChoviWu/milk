package com.xw.milk.util;

public class CastUtils<T> {

    public <T> T  castClass ( Class<T> clazz) throws IllegalAccessException, InstantiationException {
        T t = clazz.newInstance();
        return t;
    }
}
