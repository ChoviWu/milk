package com.xw.milk.util;

public class ClientUtils {

    public static ThreadLocal<String> clientHolder=new ThreadLocal<String>();

    public static String get() {
        return clientHolder.get();
    }

    public static void clear(){
        clientHolder.remove();
    }

    public static void set(String client) {
        clientHolder.set(client);
    }
}
