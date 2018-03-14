package com.xw.milk.util;

import javax.servlet.http.HttpServletRequest;
import java.util.logging.Logger;


/**
 * Created by ChoviWu on 2017/12/24
 * Description :
 */
public class IpUtils {

    public final static Logger LOGGER = Logger.getLogger("IpUtils");

    private static ThreadLocal<String > ip = new ThreadLocal();

    public static String getRemoteIp(HttpServletRequest request) {
        String ip = request.getHeader("x-forwarded-for");
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("Proxy-Client-IP");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("WL-Proxy-Client-IP");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getRemoteAddr();
        }
        final String[] arr = ip.split(",");
        for (final String str : arr) {
            if (!"unknown".equalsIgnoreCase(str)) {
                ip = str;
                break;
            }
        }
       // LOGGER.info(" Request Ip is : "+ ip);
        return ip;
    }

    public static void set(HttpServletRequest request){
        ip.set(getRemoteIp(request));
    }
    public static String  get() {
        return ip.get();
    }

    public static void  clear() {
         ip.remove();
    }
}
