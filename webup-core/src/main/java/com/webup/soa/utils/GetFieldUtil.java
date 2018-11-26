package com.webup.soa.utils;

import java.lang.reflect.Field;

/**
 * 组织JAVA BEAN的所有set模拟数据
 *
 * @author denghua
 * @create 2017-06-06 13:37
 */
public class GetFieldUtil {
    private GetFieldUtil(){};

    /**
     * 打印JAVA BEAN的所有set模拟数据
     * @param clazz
     */
    public static void printSetMethod(Class clazz) {
        String lowerName = toLowerCaseString(clazz.getSimpleName());
        System.out.println(clazz.getSimpleName()+" "+lowerName+" = new "+clazz.getSimpleName()+"();");
        Field[] fields = clazz.getDeclaredFields();
        for (Field f : fields) {
            String fName = f.getName();
            String fTypeName = f.getType().getName();
                String result = lowerName + ".set" + toUperCaseString(fName)+"(";
                if (fTypeName.contains("Integer")||fTypeName.contains("int")) {
                    result += "111" ;
                } else if (fTypeName.contains("Long") || fTypeName.contains("long")) {
                    result += "111l";
                } else if (fTypeName.contains("String")) {
                    if (fName.contains("Time")) {
                        result += "\"2017-02-13 18:00:00\"";
                    }else{
                        result += "\"122\"";
                    }
                } else if (fTypeName.contains("Date")) {
                    result += "new Date()";
                } else if (fTypeName.contains("decimal")) {
                    result += "new BigDecimal(222)";
                } else if (fTypeName.contains("Double")) {
                    result += "new Double(111)";
                } else if (fTypeName.contains("Float")) {
                    result += "new Float(232.22)";
                } else {
                    result += "111";
                }
                result += ");";
                System.out.println(result);
        }
    }

    /**
     * 首字母小写
     * @param name
     * @return
     */
    public static String toLowerCaseString(String name) {
        char[] cs = name.toCharArray();
        cs[0]+=32;
        return String.valueOf(cs);
    }

    /**
     * 首字母大写
     * @param name
     * @return
     */
    public static String toUperCaseString(String name) {
        char[] cs = name.toCharArray();
        cs[0]-=32;
        return String.valueOf(cs);
    }


    public static void main(String[] args) throws ClassNotFoundException {
//        Class clazz = Car.class;
//        printSetMethod(clazz);
    }
}
