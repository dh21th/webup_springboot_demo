package com.webup.soa.utils;

import java.text.DecimalFormat;

/**
 * Created by denghua on 2017-9-19.
 */
public class XYmatch {
    private static double EARTH_RADIUS = 6378.137;
    private static double rad(double d){
        return d * Math.PI / 180.0;
    }
    /**
     * 计算两个经纬度之间的距离
     * @param args
     */
    public static void main(String[] args) {
//        double y1 = 43.850857;
//        double x1 = 125.331928;
//        double y2 = 43.899063;
//        double x2 = 125.33279;

        double y1 = 39.935715;
        double x1 = 116.572348;
        double y2 = 39.935715;
        double x2 = 116.572348;

        System.out.println(getDistanceStr(y1, x1, y2, x2));

        double jieguo = getDistance(y1, x1, y2, x2);
        double jieguo2 = jieguo*1000;
        double jieguo3 = Math.round(jieguo2);
        DecimalFormat df =new DecimalFormat("#####0.0");
        DecimalFormat dfa =new DecimalFormat("#####0");
        if(jieguo3>=1000){
            System.out.println(df.format(jieguo3/1000)+"公里");
        }else{
            System.out.println(dfa.format(jieguo3)+"米");
        }
    }
    public static String getDistanceStr(double y1, double x1, double y2, double x2)
    {
        double s =Math.round(getDistance(y1, x1, y2, x2)*1000);
        if(s>=1000){
            DecimalFormat df =new DecimalFormat("#####0.0");
            return df.format(s/1000)+"公里";
        }else{
            DecimalFormat dfa =new DecimalFormat("#####0");
            return dfa.format(s)+"米";
        }
    }
    public static double getDistance(double y1, double x1, double y2, double x2)
    {
        double radLat1 = rad(y1);
        double radLat2 = rad(y2);
        double a = radLat1 - radLat2;
        double b = rad(x1) - rad(x2);
        double s = 2 * Math.asin(Math.sqrt(Math.pow(Math.sin(a/2),2) +
                Math.cos(radLat1)*Math.cos(radLat2)*Math.pow(Math.sin(b/2),2)));
        s = s * EARTH_RADIUS;
        return s;
    }
}

