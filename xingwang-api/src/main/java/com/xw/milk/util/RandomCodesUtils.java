package com.xw.milk.util;


public class RandomCodesUtils {

    /**
     * 创建指定数量的随机字符串
     *
     * @param numberFlag 是否是纯数字
     * @param length  长度
     * @return
     */
    public static String createRandom(boolean numberFlag, int length) {
        String retStr = "";
        String strTable = numberFlag ? "1234567890" : "1234567890abcdefghijkmnpqrstuvwxyz";
        int len = strTable.length();
        boolean bDone = true;
        do {
            retStr = "";
            int count = 0;
            for (int i = 0; i < length; i++) {
                double dblR = Math.random() * len;
                int intR = (int) Math.floor(dblR);
                char c = strTable.charAt(intR);
                if (('0' <= c) && (c <= '9')) {
                    count++;
                }
                retStr += strTable.charAt(intR);
            }
            if (count >= 2) {
                bDone = false;
            }
        } while (bDone);

        return retStr;

    }

    /**
     *
     *
     * @return 生成一串订单号 没有参数，带4位随机码
     */
    public static String getOrderNo(){
        //生成统一订单号
        String orderNo = getTimeStamp()+(int)(Math.random()*10000);
        return orderNo;
    }

    //生成addtime的timestamp格式
    public static String getTimeStamp(){
        return Long.toString(DateUtils.getTimeStampSeconds());
    }
}