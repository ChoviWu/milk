package com.xw.milk.tools;
//

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpException;
import org.apache.commons.httpclient.HttpStatus;
import org.apache.commons.httpclient.MultiThreadedHttpConnectionManager;
import org.apache.commons.httpclient.methods.GetMethod;
import org.apache.commons.httpclient.methods.PostMethod;
import org.apache.http.HeaderIterator;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.ParseException;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.CookieStore;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.protocol.HttpClientContext;
import org.apache.http.entity.mime.HttpMultipartMode;
import org.apache.http.entity.mime.MultipartEntityBuilder;
import org.apache.http.entity.mime.content.FileBody;
import org.apache.http.impl.client.*;
import org.apache.http.impl.cookie.BasicClientCookie;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.CharsetUtils;
import org.apache.http.util.EntityUtils;

import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.*;

//import org.apache.log4j.Logger;

/**
 * Created by Administrator on 2016/12/6.
 */
public class HttpUtils {

//    private static Logger log = Logger.getLogger(HttpUtils.class);

    /**
     * 定义编码格式 UTF-8
     */
    public static final String URL_PARAM_DECODECHARSET_UTF8 = "UTF-8";

    /**
     * 定义编码格式 GBK
     */
    public static final String URL_PARAM_DECODECHARSET_GBK = "GBK";

    private static final String URL_PARAM_CONNECT_FLAG = "&";

    private static final String EMPTY = "";

    private static MultiThreadedHttpConnectionManager connectionManager = null;

    private static int connectionTimeOut = 50000;

    private static int socketTimeOut = 50000;

    private static int maxConnectionPerHost = 20;

    private static int maxTotalConnections = 20;

    private static HttpClient client;

    public  static CookieStore cookieStore = null;

    public  static CloseableHttpClient httpClient = null;
    public  static HttpClientContext context = null;
//    public  static CookieStore cookieStore = null;
    public  static RequestConfig requestConfig = null;

    static {
        connectionManager = new MultiThreadedHttpConnectionManager();
        connectionManager.getParams().setConnectionTimeout(connectionTimeOut);
        connectionManager.getParams().setSoTimeout(socketTimeOut);
        connectionManager.getParams().setDefaultMaxConnectionsPerHost(maxConnectionPerHost);
        connectionManager.getParams().setMaxTotalConnections(maxTotalConnections);
        client = new HttpClient(connectionManager);
    }

    public static String URLPost(String url) {
        return URLPost(url, null);
    }


    /**
     * POST方式提交数据
     *
     * @param url    待请求的URL
     * @param params 要提交的数据
     * @return 响应结果
     * @throws IOException IO异常
     */
    public static String URLPost(String url, Map<String, Object> params) {
        return URLPost(url, params, null);
    }


    public static String AbsoluteURLPost(String url, Map<String, Object> params, String enc) {
        String response = EMPTY;
        PostMethod postMethod = null;
        try {
            postMethod = new PostMethod(url);
            if (enc == null || ("").equals(enc)) {
                enc = URL_PARAM_DECODECHARSET_UTF8; //默认
            }
            postMethod.setRequestHeader("Content-Type", "application/x-www-form-urlencoded;charset=" + enc);
            //将表单的值放入postMethod中
            if (params != null) {
                Set<String> keySet = params.keySet();
                for (String key : keySet) {
                    Object value = params.get(key);
                    if (value != null) {
                        postMethod.addParameter(key, value.toString());
                    }
                }
            }
            //执行postMethod
            int statusCode = client.executeMethod(postMethod);
            if (statusCode == HttpStatus.SC_OK) {
                response = postMethod.getResponseBodyAsString();
            } else {
//                log.info("url:" + url);
//                log.error("响应状态码 = " + postMethod.getStatusCode());
            }
        } catch (HttpException e) {
//            log.error("发生致命的异常，可能是协议不对或者返回的内容有问题", e);
            e.printStackTrace();
        } catch (IOException e) {
//            log.error("发生网络异常", e);
            e.printStackTrace();
        } finally {
            if (postMethod != null) {
                postMethod.releaseConnection();
                postMethod = null;
            }
        }

        return response;
    }

    /**
     * POST方式提交数据
     *
     * @param url    待请求的URL
     * @param params 要提交的数据
     * @param enc    编码
     * @return 响应结果
     * @throws IOException IO异常
     */
    public static String URLPost(String url, Map<String, Object> params, String enc) {
        //url = Constants.SERVER_PATH + url;
//        log.info(url);
        String response = EMPTY;
        PostMethod postMethod = null;
        try {
            postMethod = new PostMethod(url);
            if (enc == null || ("").equals(enc)) {
                enc = URL_PARAM_DECODECHARSET_UTF8; //默认
            }
            postMethod.setRequestHeader("Content-Type", "application/x-www-form-urlencoded;charset=" + enc);
            //将表单的值放入postMethod中
            if (params != null) {
                Set<String> keySet = params.keySet();
                for (String key : keySet) {
                    Object value = params.get(key);
                    if (value != null) {
                        postMethod.addParameter(key, value.toString());
                    }
                }
            }

            //执行postMethod
            int statusCode = client.executeMethod(postMethod);
            if (statusCode == HttpStatus.SC_OK) {
                response = postMethod.getResponseBodyAsString();
            } else {
//                log.info("url:" + url);
//                log.error("响应状态码 = " + postMethod.getStatusCode());
            }
        } catch (HttpException e) {
//            log.error("发生致命的异常，可能是协议不对或者返回的内容有问题", e);
            e.printStackTrace();
        } catch (IOException e) {
//            log.error("发生网络异常", e);
            e.printStackTrace();
        } finally {
            if (postMethod != null) {
                postMethod.releaseConnection();
                postMethod = null;
            }
        }

        return response;
    }



    /**
     * GET方式提交数据
     *
     * @param url    待请求的URL
     * @param params 要提交的数据
     * @param enc    编码
     * @return 响应结果
     * @throws IOException IO异常
     */
    public static String URLGet(String url, Map<String, String> params, String enc) {
        url = "" + url;
        String response = EMPTY;
        GetMethod getMethod = null;
        StringBuffer strtTotalURL = new StringBuffer(EMPTY);

        if (enc == null || enc.equals("")) {
            enc = URL_PARAM_DECODECHARSET_UTF8; //默认
        }

        if (strtTotalURL.indexOf("?") == -1) {
            strtTotalURL.append(url).append("?").append(getUrl(params, enc));
        } else {
            strtTotalURL.append(url).append("&").append(getUrl(params, enc));
        }
//        log.debug("GET请求URL = \n" + strtTotalURL.toString());

        try {
            getMethod = new GetMethod(strtTotalURL.toString());
            getMethod.setRequestHeader("Content-Type", "application/x-www-form-urlencoded;charset=" + enc);
            //执行getMethod
            int statusCode = client.executeMethod(getMethod);
            if (statusCode == HttpStatus.SC_OK) {
                response = getMethod.getResponseBodyAsString();
            } else {
//                log.debug("响应状态码 = " + getMethod.getStatusCode());
            }
        } catch (Exception e)  {
//            log.error("发生网络异常", e);
            e.printStackTrace();
        } finally {
            if (getMethod != null) {
                getMethod = null;
            }
        }

        return response;
    }

    /**
     * 据Map生成URL字符串
     *
     * @param map      Map
     * @param valueEnc URL编码
     * @return URL
     */
    private static String getUrl(Map<String, String> map, String valueEnc) {

        if (valueEnc.equals("") || valueEnc == null) {
            valueEnc = URL_PARAM_DECODECHARSET_UTF8; //默认
        }

        if (null == map || map.keySet().size() == 0) {
            return (EMPTY);
        }
        StringBuffer url = new StringBuffer();
        Set<String> keys = map.keySet();
        for (Iterator<String> it = keys.iterator(); it.hasNext(); ) {
            String key = it.next();
            if (map.containsKey(key)) {
                String val = map.get(key);
                String str = val != null ? val : EMPTY;
                try {
                    str = URLEncoder.encode(str, valueEnc);
                } catch (UnsupportedEncodingException e) {
                    e.printStackTrace();
                }
                url.append(key).append("=").append(str).append(URL_PARAM_CONNECT_FLAG);
            }
        }
        String strURL = EMPTY;
        strURL = url.toString();
        if (URL_PARAM_CONNECT_FLAG.equals(EMPTY + strURL.charAt(strURL.length() - 1))) {
            strURL = strURL.substring(0, strURL.length() - 1);
        }

        return (strURL);
    }

//    public static  void main(String  []args){
//        String json = URLPost("http://school.zhihuishu.com/ajax/loginUserIsAccount?account=13087578729&password=wuchaowei");
//        System.out.println(json);
//    }
    private static void init() {
        context = HttpClientContext.create();
        cookieStore = new BasicCookieStore();
        // 配置超时时间（连接服务端超时1秒，请求数据返回超时2秒）
        requestConfig = RequestConfig.custom().setConnectTimeout(120000).setSocketTimeout(60000)
                .setConnectionRequestTimeout(60000).build();
        // 设置默认跳转以及存储cookie
        httpClient = HttpClientBuilder.create()
                .setKeepAliveStrategy(new DefaultConnectionKeepAliveStrategy())
                .setRedirectStrategy(new DefaultRedirectStrategy()).setDefaultRequestConfig(requestConfig)
                .setDefaultCookieStore(cookieStore).build();
    }

    /**
     * http get
     *
     * @param url
     * @return response
     * @throws ClientProtocolException
     * @throws IOException
     */
    public static CloseableHttpResponse get(String url) throws ClientProtocolException, IOException {
        HttpGet httpget = new HttpGet(url);
        CloseableHttpResponse response = httpClient.execute(httpget, context);
        try {
            cookieStore = context.getCookieStore();
//            List<Cookie> cookies = cookieStore.getCookies();
//            for (Cookie cookie : cookies) {
//                LOG.debug("key:" + cookie.getName() + "  value:" + cookie.getValue());
//            }
        } finally {
            response.close();
        }
        return response;
    }

    /**
     * http post
     *
     * @param url
     * @param parameters
     *            form表单
     * @return response
     * @throws ClientProtocolException
     * @throws IOException
     */
    public static CloseableHttpResponse post(String url, String parameters)
            throws ClientProtocolException, IOException {
        HttpPost httpPost = new HttpPost(url);
        List<BasicNameValuePair> nvps = toNameValuePairList(parameters);
        httpPost.setEntity(new UrlEncodedFormEntity((List<? extends org.apache.http.NameValuePair>) nvps, "UTF-8"));
        CloseableHttpResponse response = httpClient.execute(httpPost, context);
        try {
            cookieStore = context.getCookieStore();
//            List<Cookie> cookies = cookieStore.getCookies();
//            for (Cookie cookie : cookies) {
//                LOG.debug("key:" + cookie.getName() + "  value:" + cookie.getValue());
//            }
        } finally {
            response.close();
        }
        return response;

    }

    public static void upload(String url) {
        try {
            HttpPost httppost = new HttpPost(url);
            FileBody bin = new FileBody(new File("C:\\Users\\zhangwenchao\\Desktop\\jinzhongzi.jpg"));
            HttpEntity reqEntity = MultipartEntityBuilder.create()
                    .setMode(HttpMultipartMode.BROWSER_COMPATIBLE)
                    .addPart("uploadFile", bin)
                    .setCharset(CharsetUtils.get("UTF-8")).build();
            httppost.setEntity(reqEntity);
            System.out.println("executing request: "+ httppost.getRequestLine());
            CloseableHttpResponse response = httpClient.execute(httppost,context);
            try {
                cookieStore = context.getCookieStore();
//                List<Cookie> cookies = cookieStore.getCookies();
//                for (Cookie cookie : cookies) {
//                    LOG.debug("key:" + cookie.getName() + "  value:" + cookie.getValue());
//                }

                System.out.println("----------------------------------------");
                System.out.println(response.getStatusLine());
                HttpEntity resEntity = response.getEntity();
                if (resEntity != null) {
                    // 响应长度
                    System.out.println("Response content length: "
                            + resEntity.getContentLength());
                    // 打印响应内容
                    System.out.println("Response content: "
                            + EntityUtils.toString(resEntity));
                }
                // 销毁
                EntityUtils.consume(resEntity);
            } finally {
                response.close();
            }
        } catch (ClientProtocolException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }




    @SuppressWarnings("unused")
    private static List<BasicNameValuePair> toNameValuePairList(String parameters) {
        List<BasicNameValuePair> nvps = new ArrayList<BasicNameValuePair>();
        String[] paramList = parameters.split("&");
        for (String parm : paramList) {
            int index = -1;
            for (int i = 0; i < parm.length(); i++) {
                index = parm.indexOf("=");
                break;
            }
            String key = parm.substring(0, index);
            String value = parm.substring(++index, parm.length());
            nvps.add(new BasicNameValuePair(key, value));
        }
        System.out.println(nvps.toString());
        return nvps;
    }

    /**
     * 手动增加cookie
     * @param name
     * @param value
     * @param domain
     * @param path
     */
    public static void addCookie(String name, String value, String domain, String path) {
        BasicClientCookie cookie = new BasicClientCookie(name, value);
        cookie.setDomain(domain);
        cookie.setPath(path);
        cookieStore.addCookie(cookie);
    }

    /**
     * 把结果console出来
     *
     * @param httpResponse
     * @throws ParseException
     * @throws IOException
     */
    public static void printResponse(HttpResponse httpResponse) throws ParseException, IOException {
        // 获取响应消息实体
        HttpEntity entity = httpResponse.getEntity();
        // 响应状态
        System.out.println("status:" + httpResponse.getStatusLine());
        System.out.println("headers:");
        HeaderIterator iterator = httpResponse.headerIterator();
        while (iterator.hasNext()) {
            System.out.println("\t" + iterator.next());
        }
        // 判断响应实体是否为空
        if (entity != null) {
            //      String responseString = EntityUtils.toString(entity);
            //      System.out.println("response length:" + responseString.length());
            //      System.out.println("response content:" + responseString.replace("\r\n", ""));
        }
        System.out.println(
                "------------------------------------------------------------------------------------------\r\n");
    }

    /**
     * 把当前cookie从控制台输出出来
     *
     */
    public static void printCookies() {
        System.out.println("headers:");
        cookieStore = context.getCookieStore();
//        List<Cookie> cookies = cookieStore.getCookies();
//        for (Cookie cookie : cookies) {
//            System.out.println("key:" + cookie.getName() + "  value:" + cookie.getValue());
//        }
    }

    /**
     * 检查cookie的键值是否包含传参
     *
     * @param key
     * @return
     */
    public static boolean checkCookie(String key) {
        cookieStore = context.getCookieStore();
        List<org.apache.http.cookie.Cookie> cookies = cookieStore.getCookies();
        boolean res = false;
//        for (Cookie cookie : cookies) {
//            if (cookie.getName().equals(key)) {
//                res = true;
//                break;
//            }
//        }？
        return res;
    }

    /**
     * 直接把Response内的Entity内容转换成String
     *
     * @param httpResponse
     * @return
     * @throws ParseException
     * @throws IOException
     */
    public static String toString(CloseableHttpResponse httpResponse) throws ParseException, IOException {
        // 获取响应消息实体
        HttpEntity entity = httpResponse.getEntity();
        if (entity != null)
            return EntityUtils.toString(entity);
        else
            return null;
    }

}
