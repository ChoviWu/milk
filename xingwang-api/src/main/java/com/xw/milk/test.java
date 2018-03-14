package com.xw.milk;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.*;

public class test {

    public static void main(String[] args) {
//        System.out.println(test(4));
//        test2();
//        test3();
        tests test = new tests();
        Thread thread = new Thread(test);
        thread.start();
        for (int i = 0;i<100;i++){
            System.out.println("Main Thread..." + i);
        }
    }
    public static int test(int number){

        if(number<=1){
            return 1;
        }
       return number*test(number-1);
    }
    public static  void test2(){
        int a = 1,b= 1;
        if(a==2&&b/0==1){
            System.out.println(a+" "+ b );
        }
    }
    public static  void test3(){
        short s = 1;
        s = (short)(s+ 1);
        System.out.println(s);
    }
    public   void test3(Integer u){
        short s = 1;
        s = (short)(s+ 1);
        System.out.println(s);
    }
    @Test
    public   void test4() throws InstantiationException, IllegalAccessException {
       testClass2 testClass2 = new testClass();
        System.out.println(testClass2.a1);
        System.out.println(testClass2.getA1());
        Map map = new HashMap();
        int i = 1;
        map.put("u",i);
     }

    final class testClass extends testClass2{
        final int a = 1;
        public void getA(){
//            a = a+1;
        }
     }

     class testClass2{
        String a1 = "";
         ThreadPoolExecutor poolExecutor = new ScheduledThreadPoolExecutor(10);
        public void setA1(String a1) {
            poolExecutor.setKeepAliveTime(200,TimeUnit.SECONDS);//200秒
            poolExecutor.setMaximumPoolSize(20);//最大线程池数量
            poolExecutor.setCorePoolSize(5);//核心池
//            poolExecutor.setThreadFactory();
            BlockingQueue queue = new ArrayBlockingQueue(5);//缓存队列  FIFO
            queue.add("");//
            this.a1 = a1;
        }

        public String getA1() throws IllegalAccessException, InstantiationException {
            a1+="hello ";
            Class<? extends test> test = com.xw.milk.test.class;
            test test1 = test.newInstance();
//            test.isPrimitive()
            test1.test4();
            return a1;
        }

        @Override
        public boolean equals(Object obj) {
            return super.equals(obj);
        }
    }

//    abstract class tests{
//        private String a1;
//
//       public abstract void test1();
//
//       protected abstract  void test();
//
//    }


}
class tests implements Runnable{

    @Override
    public void run() {
        for(int i = 0;i<100;i++){
            System.out.println("Thread..."+ i);
        }
    }
}
