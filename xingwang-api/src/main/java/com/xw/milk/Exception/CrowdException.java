package com.xw.milk.Exception;

/**
 * Created by fuxx on 15/10/9.
 */
public class CrowdException  extends  RuntimeException{

    private String code;
    private String message;

    public String getCode() {
        return code;
    }

    @Override
    public String getMessage() {
        return message;
    }

    public CrowdException(String code) {
        super("");
        this.code = code;
    }
    public CrowdException(String code,String message) {
        super("");
        this.code = code;
        this.message = message;
    }

}
