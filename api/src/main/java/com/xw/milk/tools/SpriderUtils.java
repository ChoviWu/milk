package com.xw.milk.tools;

import com.xw.milk.base.Constant;
import com.xw.milk.util.JsonUtils;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URL;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

/**
 * Created by ChoviWu on 2017/12/20
 * Description :
 */

public class SpriderUtils {

    private static Logger logger = Logger.getLogger("SpriderUtils");
    /**
     * 定向爬取
     * @param i  爬取的页数
     * @param type  爬取的类型
     * @return
     */
    public static Map<String,Object> getHtml(Integer type,Integer i) {
        Map <String,Object> map = new HashMap<String,Object>();

        Elements movieEle = null;
        HttpClient client = HttpClients.createDefault();
        HttpGet httpGet = null;
        if(i != 1) {
            httpGet = new HttpGet(Constant.BASE_URL +type  + "_" + i + Constant.URL_END);
        }else{
            httpGet = new HttpGet(Constant.BASE_URL + type + Constant.URL_END);
        }
        //执行 get请求
        HttpResponse response = null;
        try {
            response = client.execute(httpGet);
        } catch (IOException e) {
            e.printStackTrace();
        }
        //返回获取实体
        HttpEntity entity = response.getEntity();
        //获取网页内容，指定编码
        String web = null;
        try {
            web = EntityUtils.toString(entity);
        } catch (IOException e) {
            e.printStackTrace();
        }
        String url = Constant.BASE_URL + i + Constant.URL_END;
        Document doc = null;
        try {
            doc = Jsoup.parse(new URL(url).openStream(), "GBK", url);
            movieEle = doc.getElementsByClass("img-list")
                    .get(0).getElementsByTag("li");
            String pages = doc.getElementById("pages").getElementsByTag("span").get(0).text();
            Integer number = Integer.valueOf(pages.substring(1,pages.indexOf("条")));
            Integer page = (number%30==0)? (number/30) : (number/30)+1 ;
            logger.info("共有 "+number+"条数据, 分为"+page + "页");
            map.put("elements", movieEle);
            map.put("type", i);
            map.put("page", page);
            //page大于1  开启定时器
        } catch (IOException e) {
            e.printStackTrace();
        }
        return map;
    }

    /**
     * 获取资源的描述和更新日期
     * @param element
     * @return
     */
    public static Map<String,String> getDescription(Element element){
        Map<String ,String > result = new HashMap<String, String>();

        result.put("description",element.getElementsByTag("li").get(0).
                getElementsByTag("p").get(0).text());//电影描述
        result.put("url",Constant.PARENT_URL+element.getElementsByClass("play-img").attr("href"));//电影地址

        result.put("updateTime",element.getElementsByClass("star").get(1).text());//电影更新时间
        result.put("title",element.getElementsByTag("h5").text());//电影名
        result.put("logo",element.getElementsByTag("a").get(0)
                .getElementsByTag("img").attr("src"));//电影的logo
        return result;
    }

    public static List<Map<String ,String >> parseHtml(String value) {
        Document doc = null;
        List<Map<String, String>> mapList = new ArrayList<>();
        try {
            value = URLEncoder.encode(value, "utf-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        System.out.println(value);
        try {
            try {
                //爬取17kyun
                doc = Jsoup.parse(new URL(Constant.BASE_LOVE_URL +"/s/"+  value+".html").openStream(),
                        "UTF-8", Constant.BASE_LOVE_URL+"/s/" +  value+".html");
                logger.info("搜索的电影名： " + URLDecoder.decode(value,"utf-8"));
                mapList = searchMovieList(doc);
                if(mapList!=null){
                    //如果包含所搜的电影关键字
                    return mapList;
                }else{
                    mapList.clear();
                    return judge(doc,value,mapList);
                }
            } catch (IOException e1) {
                e1.printStackTrace();
            }
        }catch (Exception e){
            logger.info(e.getMessage());
        }
        return null;
    }
    public static List<Map<String ,String >> searchMovieList(Document doc){
        List<Map<String ,String >> mapList = new ArrayList<>();
        Elements elements = doc.getElementsByClass("item");
       // logger.info("get movie document : "+elements);
        if(elements!=null) {
            Elements tags = elements.get(1).getElementsByClass("content");
            if (tags != null) {
                for (Element element : tags) {
                    Elements movieEle = element.getElementsByClass("content");//.getElementsByClass("videopic");
                    if (movieEle.size() > 0) {
                        Map<String, String> map = getDescriptionTwo(movieEle.get(0));
                        mapList.add(map);

                    }
                }
                return mapList;
            }
        }
        return null;
    }

    /**
     * 获取资源的描述和更新日期
     * @param element
     * @return
     */
    public static Map<String,String> getDescriptionTwo(Element element) {
        Map<String ,String > result = new HashMap<String, String>();

//            Document doc = Jsoup.parse(new URL(Constant.BASE_LOVE_URL + element.getElementsByClass("videopic").attr("data-original")).openStream(),
//                    "gbk",Constant.BASE_LOVE_URL+element.getElementsByClass("videopic").attr("data-original"));
//            System.out.println(doc);
//            String picUrl = doc.getElementsByTag("img").get(0).attr("src");
            String moviePic = "https://mmbiz.qpic.cn/mmbiz_jpg/OkvX0mYRqs0kUMPB9zsWXB77uyr4NuicicuPhoBhFwj4j6ia68sQSvLdYWNY1SOnCibBhdgmFwxAAXiaahTMUDVuBww/0?wx_fmt=jpeg";
            result.put("description",element.getElementsByTag("ul").text());//电影描述
            result.put("url",Constant.BASE_LOVE_URL+element.getElementsByClass("videopic").attr("href"));//电影地址
            result.put("title",element.getElementsByClass("head").text());//电影名
            result.put("logo",moviePic);//电影的logo
            logger.info(JsonUtils.toJson(result));
            return result;
    }

    /**
     * 琪琪布8  爬虫
     * @param doc
     * @param value
     * @param mapList
     * @return
     */
    private static List<Map<String ,String >> judge(Document doc,String  value,List<Map<String,String >> mapList) {
        try {
            value = new String (value.getBytes("GBK"),"UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        logger.info("Movie " + value);
        //如果返回超时   开始爬下一个网站
        try {
            doc = Jsoup.parse(new URL("http://www.qiqibu88.com/soso.asp?kwtype=0&searchword=" + value).openStream(),
                    "GBK", "http://www.qiqibu88.com/soso.asp?kwtype=0&searchword=" + value);
        } catch (IOException e1) {
            e1.printStackTrace();
        }

        Elements elements = doc.getElementsByClass("img-list");
        logger.info("QiQibu8 search Result : " + elements.size());
        if (elements != null) {
            for (Element element : elements) {
                Elements movieEle = element.getElementsByTag("li");
                if (movieEle.size() > 0) {
                    Map<String, String> map = getDescription(movieEle.get(0));
                    mapList.add(map);
                }
            }
            return mapList;
        }
        return null;
    }


//    public static void main(String[] args) {
//        Document doc = null;
//        String  value = "芳华";
////        try {
//        List<Map<String ,String >> map =  parseHtml(value);
////            doc = Jsoup.parse(new URL("http://www.ayingshi.com/search.php?searchword="+value ).openStream(),
////                    "UTF-8",  "http://www.ayingshi.com/search.php?searchword="+value );
////            searchMovieList(doc);
////            System.out.println(doc);
////        } catch (IOException e) {
////            e.printStackTrace();
////        }
//    }
}
