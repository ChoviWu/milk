package com.xw.milk.util;//package com.example.util;
//
//
//import org.apache.commons.codec.binary.Base64;
//
//import javax.imageio.ImageIO;
//import java.awt.*;
//import java.awt.image.BufferedImage;
//import java.io.*;
//import java.util.Arrays;
//import java.util.Random;
//import java.awt.Color;
//import java.awt.Font;
//import java.awt.Graphics;
//import java.awt.Graphics2D;
//import java.awt.image.BufferedImage;
//import java.io.BufferedOutputStream;
//import java.io.FileOutputStream;
//import java.io.IOException;
//
//import com.sun.image.codec.jpeg.JPEGCodec;
//import com.sun.image.codec.jpeg.JPEGImageEncoder;
//import com.Customer;
//
//public class ImageUtils {
//    private static BufferedImage image;
//    private static int imageWidth = 300;  //图片的宽度
//    private static int imageHeight = 500; //图片的高度
//    //生成图片文件
//    @SuppressWarnings("restriction")
//    public static void createImage(String fileLocation) {
//        BufferedOutputStream bos = null;
//        if(image != null){
//            try {
//                FileOutputStream fos = new FileOutputStream(fileLocation);
//                bos = new BufferedOutputStream(fos);
//
//                JPEGImageEncoder encoder = JPEGCodec.createJPEGEncoder(bos);
//                encoder.encode(image);
//                bos.close();
//            } catch (Exception e) {
//                e.printStackTrace();
//            }finally{
//                if(bos!=null){//关闭输出流
//                    try {
//                        bos.close();
//                    } catch (IOException e) {
//                        e.printStackTrace();
//                    }
//                }
//            }
//        }
//    }
//
//    /**
//     *
//     * @param name
//     * @param id
//     * @param classname
//     * @param logoImg   图片的logo地址
//     * @param customer 用户
//     * @param imgurl   图片生成的地址
//     */
//    public static void graphicsGeneration(String name, String id, String classname, String logoImg,
//                                   Customer customer, String imgurl) {
//        int H_title = 30;     //头部高度
//        int H_mainPic = 200;  //轮播广告高度
//        int H_tip = 60;  //上网提示框高度
//        int H_btn = 25;  //按钮栏的高度
//        int tip_2_top = (H_title+H_mainPic);
//        int btns_2_top = tip_2_top+H_tip+20;
//        int btn1_2_top = btns_2_top+10;
//        int btn2_2_top = btn1_2_top+H_btn;
//        int btn3_2_top = btn2_2_top+H_btn;
//        int btn4_2_top = btn3_2_top+H_btn;
//        int W_btn = 280;  //按钮栏的宽度
//
//        image = new BufferedImage(imageWidth, imageHeight, BufferedImage.TYPE_INT_RGB);
//        //设置图片的背景色
//        Graphics2D main = image.createGraphics();
//        main.setColor(Color.white);
//        main.fillRect(0, 0, imageWidth, imageHeight);
//
//
//        //***********************插入中间广告图
//        Graphics mainPic = image.getGraphics();
//        BufferedImage bimg = null;
//        try {
//            bimg = ImageIO.read(new File(logoImg));
//        } catch (Exception e) {}
////
//        if(bimg!=null){
//            mainPic.drawImage(bimg, 0, 0, imageWidth, H_mainPic, null);
//            mainPic.dispose();
//        }
//        //***********************设置下面的提示框
//
//        Graphics2D tip = image.createGraphics();
////        //设置区域颜色
////        tip.setColor(Color.CYAN);
////        //填充区域并确定区域大小位置
//        tip.fillRect(0, 0, 0, 0);
//
//        //***********************设置下面的按钮块
//        //设置字体颜色，先设置颜色，再填充内容
//        tip.setColor(Color.black);
//        tip.drawString("您的信息：", 20, 220);
//        tip.setColor(Color.BLACK);
//        tip.setFont(new Font("宋体", Font.BOLD, 18));
//        tip.drawString("姓名："+customer.getName(), 20, 250);
//        //***********************按钮
//        Font btnFont = new Font("宋体", Font.BOLD, 14);
//        Graphics2D btn1 = image.createGraphics();
//        btn1.setColor(new Color(41,192 , 50));//#29C65A
//        btn1.fillRect(10, btn1_2_top, W_btn, H_btn);
//        btn1.setColor(Color.BLACK);
//        btn1.drawRect(10, 200, W_btn, H_btn);
//        //btn1 文本
//        btn1.setColor(Color.white);
//        btn1.setFont(btnFont);
//        btn1.drawString(customer.getString(), 20, btn1_2_top+(H_btn/2)+5);
//
//        Graphics2D btn2 = image.createGraphics();
//        btn2.setColor(new Color(141,120 , 22));//#29C65A
//        btn2.fillRect(10, btn2_2_top, W_btn, H_btn);
//        btn2.setColor(Color.BLACK);
//        btn2.drawRect(10, btn2_2_top, W_btn, H_btn);
//        //btn2文本
//        btn2.setColor(Color.white);
//        btn2.setFont(btnFont);
//        btn2.drawString("学号/手机号:"+customer.getNumber(), 40, btn2_2_top+(H_btn/2)+5);
//        Graphics2D btn3 = image.createGraphics();
//        btn3.setColor(new Color(141,120 , 22));//#29C65A
//        btn3.fillRect(10, btn3_2_top, W_btn, H_btn);
//        btn3.setColor(Color.BLACK);
//        btn3.drawRect(10, btn3_2_top, W_btn, H_btn);
//        //btn2文本
//        btn3.setColor(Color.white);
//        btn3.setFont(btnFont);
//        btn3.drawString("学校是:"+customer.getSchool(), 40, btn3_2_top+(H_btn/2)+5);
//        Graphics2D btn4 = image.createGraphics();
//        btn4.setColor(new Color(141,120 , 22));//#29C65A
//        btn4.fillRect(10, btn4_2_top, W_btn, H_btn);
//        btn4.setColor(Color.BLACK);
//        btn4.drawRect(10, btn4_2_top, W_btn, H_btn);
//        //btn2文本
//        btn4.setColor(Color.white);
//        btn4.setFont(btnFont);
//        btn4.drawString("考试时间:"+customer.getKaoshi_date(), 20, btn4_2_top+(H_btn/2)+5);
//
//        createImage(imgurl);
////        return
//    }
//
//    public static void main(String[] args) {
//        ImageUtils cg = new ImageUtils();
//        try {
//            Customer customer = new Customer();
//            customer.setScore("100/100");
//            cg.graphicsGeneration(
//                    " 来自计科伍子", "1", "12","https://mmbiz.qpic.cn/mmbiz_jpg/OkvX0mYRqs0kUMPB9zsWXB77uyr4NuicicuPhoBhFwj4j6ia68sQSvLdYWNY1SOnCibBhdgmFwxAAXiaahTMUDVuBww/0?wx_fmt=jpeg",customer,
//                    "C:\\Users\\Administrator\\Documents\\1.jpg");
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }
//}