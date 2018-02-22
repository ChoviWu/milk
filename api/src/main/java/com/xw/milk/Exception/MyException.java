package com.xw.milk.Exception;

/**
 * Created by Administrator on 2017/9/24.
 */
public class MyException extends  RuntimeException {

    private  String message;

    private  String code;

    public MyException(String message, String code) {
        this.message = message;
        this.code = code;
    }

    @Override
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}
