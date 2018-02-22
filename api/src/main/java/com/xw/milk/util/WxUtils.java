package com.xw.milk.util;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class WxUtils {
    //配置微信公众号时填写的Token
    private static final String token = "yours";
    //公众号
    public static final String AppID = "yours";
    public static final  String AppSecret  = "yours";
    //小程序
    public static final  String AppProgram  = "yours";
    public static final  String AppProgramSecret  = "yours";



    public static boolean checkSignature(String signature, String timestamp, String nonce) {

        // 拼接字符串
        String[] arr = new String[] { token, timestamp, nonce };
        // 排序
        Arrays.sort(arr);
        // 生成字符串
        StringBuffer content = new StringBuffer();
        for (int i = 0; i < arr.length; i++) {
            content.append(arr[i]);
        }
        // SHA1加密
        String tmp = DecriptUtil.SHA1(content.toString());
        return tmp.equals(signature);
    }

    public static String getAccessToken(){
        Map<String ,String > map = new HashMap();
        map.put("appid",AppID);
        map.put("secret",AppSecret);
        map.put("grant_type","client_credential");
        String response = HttpUtils.URLGet("https://api.weixin.qq.com/cgi-bin/token",map,"UTF-8");
        map.clear();
        map = JsonUtils.json2Map(response);
        String accessToken = map.get("access_token");
        System.out.println(accessToken);
        return accessToken;
    }
    public static String getMediaId(String accessToken,String url){
        Map map = new HashMap();
        String postUrl = "?access_token="+accessToken+"&type=image";
        Map<String, String> textMap = new HashMap<String, String>();
        textMap.put("name", "testName");
        Map<String, String> fileMap = new HashMap<String, String>();
        fileMap.put("userfile", url);
        String response = HttpUtils.formUpload(
                "http://file.api.weixin.qq.com/cgi-bin/media/upload"+postUrl,textMap,fileMap);
        map = JsonUtils.json2Map(response);
        String mediaId = (String) map.get("media_id");
        return mediaId;
    }

//    public static void main(String[] args) {
//        File file = new File("https://pic.cnblogs.com/face/1018056/20160901075637.png");
//        if(!file.exists()){
//            try {
//                file.createNewFile();
//                InputStream in = new FileInputStream(file);
//                byte [] len = new byte[1024];
//                OutputStream ou = new FileOutputStream("D:\\我的文档\\桌面\\test.jpg");
//
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//
//        }
//        System.out.println(getMediaId(getAccessToken(),"https://pic.cnblogs.com/face/1018056/20160901075637.png"));
//    }
}
