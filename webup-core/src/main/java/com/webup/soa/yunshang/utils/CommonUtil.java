package com.webup.soa.yunshang.utils;

import java.util.List;

/**
 * Created by wangxingbao on 2018/4/30.
 * 通用公共方法
 */
public class CommonUtil {
    public static String listToString(List list, char separator) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < list.size(); i++) {
            sb.append(list.get(i)).append(separator);
        }
        return sb.toString().substring(0, sb.toString().length() - 1);
    }
}
