package com.webup.soa.utils;

import java.text.SimpleDateFormat;
import java.util.Random;

/**
 * Created by Keke on 2016/12/3.
 */
public class DataNOUtil {
    private DataNOUtil(){}

    private static Random random = new Random();
    private static String GOODSNO = "PN"; //产品编号
    private static String ORDERNO = "DN"; //订单编号
    private static String CONTRACTNO = "HN"; //合同编号
    private static String DELIVERYNO = "TH";

    private static String randNum [] = {"1","2","3","4","5","6","7","8","9","0"};

    public static String getGoodsno(){
        return getNO(GOODSNO);
    }
    public static String getOrderno(){
        return getNO(ORDERNO);
    }
    public static String getContractno(){
        return getNO(CONTRACTNO);
    }
    public static String getDeliveryno() {
        return getNO(DELIVERYNO);
    }

    private static String getNO(String v){
        long now = System.currentTimeMillis();
        SimpleDateFormat outFormat = new SimpleDateFormat("yyMMdd");
        return v+outFormat.format(now) + String.valueOf(now).substring(String.valueOf(now).length()-6);
    }

    private static String getRand(){
        String rand = "";
        for(int i=0; i<3; i++){
            rand += randNum[random.nextInt(10)];
        }
        return rand;
    }

}
