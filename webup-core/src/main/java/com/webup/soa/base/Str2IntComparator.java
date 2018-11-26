package com.webup.soa.base;

import java.util.Comparator;
/**
 * 集合排序类
 *
 * @author denghua
 * @create 2017-07-27 14:43
 */

public class Str2IntComparator implements Comparator<String> {

    private boolean reverseOrder; // 是否倒序

    public Str2IntComparator(boolean reverseOrder) {
        this.reverseOrder = reverseOrder;
    }

    @Override
    public int compare(String arg0, String arg1) {
        if(reverseOrder){
            return Integer.parseInt(arg1) - Integer.parseInt(arg0);
        }
        else{
            return Integer.parseInt(arg0) - Integer.parseInt(arg1);
        }
    }
}
