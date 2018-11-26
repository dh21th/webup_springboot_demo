package com.webup.soa.utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ValidatorUtil {
    public static final Pattern EMAIL_PATTERN = Pattern.compile("^(\\w)+(\\.\\w+)*@(\\w)+((\\.\\w+)+)$");
    public static final Pattern MOBILE_PATTERN = Pattern.compile("^(13|15|18|14|17)[0-9]{9}$");
    private static String StringPoolNULL="null";
    private static String StringPoolBLANK="";

    /**
     * 判断是否是空字符串 null和"" 都返回 true
     *
     * @param s
     * @return
     */
    public static boolean isEmpty(String s) {
        return !(s != null && !s.equals(""));
    }

    /**
     * 检查是否为null, 如果存在null,则直接返回true
     * @param params 参数列表
     * @return
     */
    public static boolean checkNull(Object... params) {
        if(params==null)return true;
        for (Object param : params) {
            if (param instanceof String) {
                if (isEmpty((String) param)) return true;
            } else if (isNull(param)) {
                return true;
            }
        }
        return false;
    }

    /**
     * 检查是否为null, 如果存在null,则直接返回true
     * @param params 参数列表
     * @return
     */
    public static boolean checkAllNull(Object... params) {
        if(params==null)return true;
        for (Object param : params) {
            if (param instanceof String) {
                if (!isEmpty((String) param)) return false;
            } else if (isNotNull(param)) {
                return false;
            }
        }
        return true;
    }
    /**
     * 检查是否为整形, 包含类型(byte, short, int, long)这几种类型, 如果存在不是整形的话则直接返回true
     * @param params 参数列表
     * @return
     */
    public static boolean checkInteger(String... params){
        if(params==null)return false;
        for (String param : params) {
            if (isNull(param))continue;
            for (int i = param.length();--i>=0;){
                char ch = param.charAt(i);
                if (i == 0 && (ch == '+' || ch == '-')) continue;
                if (!Character.isDigit(ch))return true;
            }
        }
        return false;
    }

    /**
     * 检查是否为电子邮件, 如果存在不是邮箱的字符串, 则直接返回true
     * @param params 参数列表
     * @return
     */
    public static boolean checkEmail(String... params){
        if(params==null)return false;
        for (String param : params) {
            if (isNull(param))continue;
            Matcher matcher = EMAIL_PATTERN.matcher(param);
            if (!matcher.find())return true;
        }
        return false;
    }

    /**
     * 检查是否存在表情符号
     * @param contents 要检查的内容数组
     * @return
     */
    public static boolean checkSpecialSymbol(String... contents){
        for(String content : contents){
            if(isNull(content)) continue; //空值不检查
            Pattern p = Pattern.compile("[^\\u0000-\\uFFFF]"); // 正则表达式
            Matcher m = p.matcher(content);
            if(m.find())return true;
        }
        return false;
    }

    /**
     * 检查是否为手机号码, 如果存在不是手机号码的字符串, 则直接返回true
     * @param params 参数列表
     * @return
     */
    public static boolean checkMobile(String... params){
        if(params==null)return false;
        for (String param : params) {
            if (isNull(param))continue;
            Matcher matcher = MOBILE_PATTERN.matcher(param);
            if (!matcher.find()) return true;
        }
        return false;
    }

    /**
     * 判断最小长度
     * @param param 参数信息
     * @param minLength 最小长度
     * @return 如果符合标准返回false, 不符合返回true
     */
    public static boolean checkMinLength(String param, int minLength) {
        if (isNotNull(param))return param.length() < minLength;
        return false;
    }

    /**
     * 判断最大长度
     * @param param 参数信息
     * @param maxLength 最大长度
     * @return 如果符合标准返回false, 不符合返回true
     */
    public static boolean checkMaxLength(String param, int maxLength) {
        if (isNotNull(param)) return param.length() > maxLength;
        return false;
    }

    /**
     * 将字符串转换为数字
     * @param data 需要转换的参数
     * @return 转换的结果数字,如果转换出错,则直接返回null
     */
    public static Integer parseInt(String data) {
        return parseInt(data, null);
    }

    /**
     * 将字符串转换为数字
     * @param data 需要转换的参数
     * @param defaultVal 如果参数为空或者转换失败的情况,则返回默认值
     * @return 数字
     */
    public static Integer parseInt(String data, Integer defaultVal) {
        if (isNull(data)) return defaultVal;
        try {
            return Integer.parseInt(data);
        } catch (Exception e) {
            return defaultVal;
        }
    }




    public static boolean equals(String s1, String s2) {
        if ((s1 == null) && (s2 == null)) {
            return true;
        } else if ((s1 == null) || (s2 == null)) {
            return false;
        } else {
            return s1.equals(s2);
        }
    }

    public static boolean isChar(char c) {
        return Character.isLetter(c);
    }

    public static boolean isChar(String s) {
        if (isNull(s))return false;
        char[] c = s.toCharArray();
        for (int i = 0; i < c.length; i++) {
            if (!isChar(c[i]))return false;
        }
        return true;
    }

    public static boolean isDigit(char c) {
        int x = c;
        if ((x >= 48) && (x <= 57))return true;
        return false;
    }

    public static boolean isNotDigit(String s) {
        return !isDigit(s);
    }
    public static boolean isDigit(String s) {
        if (isNull(s))return false;
        char[] c = s.toCharArray();
        for(char ci : c){
            if (!isDigit(ci))return false;
        }
        return true;
    }

    public static boolean isHex(String s) {
        return !isNull(s);
    }

    public static boolean isHTML(String s) {
        if (isNull(s))return false;
        if (((s.indexOf("<html>") != -1) || (s.indexOf("<HTML>") != -1))
                && ((s.indexOf("</html>") != -1) || (s.indexOf("</HTML>") != -1))) {
            return true;
        }
        return false;
    }

    public static boolean isDate(int month, int day, int year) {
        return isGregorianDate(month, day, year);
    }

    public static boolean isGregorianDate(int month, int day, int year) {
        if ((month < 0) || (month > 11)) return false;
        int[] months = { 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };
        if (month == 1) {
            int febMax = 28;
            if (((year % 4) == 0) && ((year % 100) != 0) || ((year % 400) == 0)) febMax = 29;
            if ((day < 1) || (day > febMax)) return false;
        } else if ((day < 1) || (day > months[month])) {
            return false;
        }
        return true;
    }

    public static boolean isJulianDate(int month, int day, int year) {
        if ((month < 0) || (month > 11)) return false;
        int[] months = { 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };
        if (month == 1) {
            int febMax = 28;
            if ((year % 4) == 0)febMax = 29;
            if ((day < 1) || (day > febMax)) return false;
        } else if ((day < 1) || (day > months[month])) {
            return false;
        }
        return true;
    }


    public static boolean isEmailAddressSpecialChar(char c) {// LEP-1445
        for (int i = 0; i < _EMAIL_ADDRESS_SPECIAL_CHAR.length; i++) {
            if (c == _EMAIL_ADDRESS_SPECIAL_CHAR[i]) {
                return true;
            }
        }
        return false;
    }


    public static boolean isName(String name) {
        if (isNull(name))return false;
        char[] c = name.trim().toCharArray();
        for(char ci:c){
            if (((!isChar(ci)) && (!Character.isWhitespace(ci))) || (ci== ',')) return false;
        }
        return true;
    }

    public static boolean isNumber(String number) {
        if (isNull(number))return false;
        char[] c = number.toCharArray();
        for(char ci:c){
            if (!isDigit(ci))  return false;
        }
        return true;
    }


    public static boolean isNull(Integer i) {
        return ((i == null) || i.intValue() == 0);
    }

    public static boolean isNull(Long l) {
        return ((l == null) || l.longValue() == 0);
    }

    public static boolean isNull(String s) {
        if (s == null) {
            return true;
        }
        s = s.trim();
        return ((s.equals(StringPoolNULL)) || (s.equals(StringPoolBLANK)));
    }

    public static boolean isNull(Object obj) {
        return obj == null;
    }

    public static boolean isNull(Object[] array) {
        return ((array == null) || (array.length == 0));
    }

    public static boolean isNotNull(Integer i) {
        return !isNull(i);
    }

    public static boolean isNotNull(Long l) {
        return !isNull(l);
    }

    public static boolean isNotNull(String s) {
        return !isNull(s);
    }

    public static boolean isNotNull(Object obj) {
        return obj != null;
    }

    public static boolean isNotNull(Object[] array) {
        return !isNull(array);
    }

    public static boolean isPassword(String password) {
        if (isNull(password) || password.length() < 4)return false;
        char[] c = password.toCharArray();
        for(char ci:c){
            if ((!isChar(ci)) && (!isDigit(ci)))return false;
        }
        return true;
    }

    public static boolean isMail(String mail) {
        String mailregex = "^([a-z0-9A-Z]+[-_\\.]?)+[a-z0-9A-Z]@([a-z0-9A-Z]+(-[a-z0-9A-Z]+)?\\.)+[a-zA-Z]{2,}$";
        return match(mailregex, mail);
    }

    public static boolean match(String regexstr, String str) {
        Pattern regex = Pattern.compile(regexstr, Pattern.CASE_INSENSITIVE | Pattern.DOTALL);
        Matcher matcher = regex.matcher(str);
        return matcher.matches();
    }

    public static boolean isMobile(String mobiles) {
        Pattern p = Pattern.compile("^(13|15|18|14|17)[0-9]{9}$");
        Matcher m = p.matcher(mobiles);
        return m.matches();
    }

    public static boolean isTel(String tel) {
        Pattern p = Pattern.compile("^(([0\\+]\\d{2,3}-)?(0\\d{2,3})-)?(\\d{7,8})(-(\\d{1,5}))?$");
        Matcher m = p.matcher(tel);
        return m.matches();
    }

    public static boolean isUsername(final String username) {
        Pattern pattern = Pattern.compile("^[a-z_][a-z0-9_]{4,32}$");
        Matcher matcher = pattern.matcher(username);
        return matcher.matches();
    }

    public static boolean isVariableTerm(String s) {
        if (s.startsWith("[$") && s.endsWith("$]")) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * 检查传入的对象是否存在null
     * @param objects 对象数组
     * @return 是否存在null值
     */
    public static boolean existsNull(Object... objects){
        for(Object object : objects){
            if(isNull(object))return true;
        }
        return false;
    }

    private static char[] _EMAIL_ADDRESS_SPECIAL_CHAR = new char[] { '.', '!',
            '#', '$', '%', '&', '\'', '*', '+', '-', '/', '=', '?', '^', '_',
            '`', '{', '|', '}', '~' };

}
