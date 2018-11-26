package com.webup.soa.utils;

import java.util.Date;
import java.util.Random;

/******************************************
 * @author: 大鹏 (xupenghong@elion.com.cn)
 * @createDate: 2017/10/25
 * @company: (C) Copyright 亿兆华盛 2017
 * @since: JDK 1.8
 * @projectName:IntelliJ IDEA
 * @Description:类功能描述
 ******************************************/
public class GenerateCodeUtil {

    private  static int[] array = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};

    private static Random random = new Random();

    public static String getCode(String prefix) {
        StringBuilder builder = new StringBuilder();
        builder.append(prefix);
        builder.append(DateUtils.formatDate(new Date(), DateUtils.CODE));
        builder.append(generateNoRepeatCode(6));
        return builder.toString();
    }

    /**
     *  生成指定位数的随机数
     * @return
     */
    public static String generateCode(int size) {
        StringBuilder code = new StringBuilder();
        while(code.length() < size) {
            double d = Math.floor(Math.random() * 10);
            code.append((int)d);
        }
        return code.toString();
    }

    /**
     *  生成指定位数不重复的随机数
     * @return
     */
    public static String generateNoRepeatCode(int size) {
        for (int i = 10; i > 1; i--) {
            int index = random.nextInt(i);
            int tmp = array[index];
            array[index] = array[i - 1];
            array[i - 1] = tmp;
        }

        int result = 0;
        for(int i = 0; i < size; i ++){
            result = result * 10 + array[i];
        }
        return String.valueOf(result);
    }

}
