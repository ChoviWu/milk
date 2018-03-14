package com.xw.milk.util;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.xw.milk.common.Result;
import org.springframework.http.converter.json.AbstractJackson2HttpMessageConverter;

import java.io.Serializable;
public final class ServletResponse<T> implements Serializable {

    private String  messageCode;
    private String messageText;
    private T result;


    public ServletResponse<T> success(String status,T data){
        if(StringUtils.isEmpty(status)) {
            return createData(Result.QUERY_SUCCESS.getMessage(), data);
        }
        return createData(status,data);
    }
    public ServletResponse<T> success(T data){
        return createData( Result.QUERY_SUCCESS.getMessage(),data);
    }

    public ServletResponse<T> fail(T data){
        return createData(Result.QUERY_SUCCESS.getMessage(),data);
    }

    public ServletResponse<T> fail(String status,T data){
        if(StringUtils.isEmpty(status)) {
            return createData(Result.QUERY_SUCCESS.getMessage(), data);
        }
        return createData(status,data);
    }

    public ServletResponse<T> createData(String status,T data){
        return new ServletResponse("0000",status,data);
    }

    public ServletResponse() {

    }

    public ServletResponse(String messageCode, String messageText, T result) {
        this.messageCode = messageCode;
        this.messageText = messageText;
        this.result = result;
    }
}
