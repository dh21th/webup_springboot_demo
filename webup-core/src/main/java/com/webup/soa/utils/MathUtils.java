package com.webup.soa.utils;

import java.math.BigDecimal;

/**
 * Created by zhaosy on 2018/1/15.
 */
public class MathUtils {

    public static BigDecimal formatComma2BigDecimal(Object obj) {
        String val = String.valueOf(obj);
        if (val == null)
            return new BigDecimal("0.00");

        val = val.replaceAll(",", "");
        if (!isNumber(val))
            return new BigDecimal("0.00");

        BigDecimal decimal = new BigDecimal(val);
        decimal = decimal.setScale(2, BigDecimal.ROUND_HALF_UP);

        return decimal;

    }
    public static boolean isNumber(String value) {
        return isInteger(value) || isDouble(value);
    }
    public static boolean isDouble(String value) {
        try {
            Double.parseDouble(value);
            if (value.contains("."))
                return true;
            return false;
        } catch (NumberFormatException e) {
            return false;
        }
    }
    public static boolean isInteger(String value) {
        try {
            Integer.parseInt(value);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}
