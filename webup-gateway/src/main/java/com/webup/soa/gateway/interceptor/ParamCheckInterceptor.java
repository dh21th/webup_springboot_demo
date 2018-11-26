package com.webup.soa.gateway.interceptor;

import com.webup.soa.gateway.common.GlobalConfig;
import com.webup.soa.gateway.utils.ValidationResult;
import com.webup.soa.gateway.utils.ValidationUtils;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/******************************************
 * @createDate: 2018/1/25
 * @company: (C) Copyright 亿兆华盛 2018
 * @since: JDK 1.8
 * @projectName:webup-gateway
 * @Description:
 ******************************************/
@Aspect
@Component
public class ParamCheckInterceptor {

    @Around(value = "execution(* com.webup.soa.*.controller.*.*(..))")
    public Object validParam(ProceedingJoinPoint joinPoint) throws Throwable {
        Object object = joinPoint.getTarget();
        Map<String, String> errorMsg = new HashMap<>();
        try {
            Signature signature = joinPoint.getSignature();
            Class[] paramTypes = getParamTypes(signature.toLongString());
            Object[] args = joinPoint.getArgs();
            if (paramTypes.length == 0) {
                return joinPoint.proceed();
            }
            //考虑只有一个参数，并且是自定义参数类型的情况
            if (paramTypes.length == 1 && !isNativeClass(paramTypes[0])) {
                ValidationResult validResult = ValidationUtils.validateEntity(args[0]);
                if (validResult.getErrorMsg() != null) {
                    return invokeErrorsMethod(validResult.getErrorMsg());
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return joinPoint.proceed();
    }

    private boolean isNativeClass(Class clasz) {
        boolean flag = false;
        String className = clasz.getName();
        if (className != null) {
            String[] cl = className.split("\\.");
            if (cl[0].equals("java") || cl[0].equals("javax")) {
                flag = true;
            }
            if ("java.util.Map".equalsIgnoreCase(className)) {
                flag = false;
            }
        }
        return flag;
    }

    private Object invokeErrorsMethod(Map<String, String> errorMsg) throws Exception {
        return null;
    }

    /**
     * 考虑无参形式
     *
     * @param str
     * @return
     * @throws ClassNotFoundException
     */
    private Class[] getParamTypes(String str) throws ClassNotFoundException {
        Pattern pattern = Pattern.compile("\\(.*?\\)");
        str = str.replaceAll("\\s", "");
        Matcher matcher = pattern.matcher(str);
        while (matcher.find()) {
            str = str.substring(matcher.start() + 1, matcher.end() - 1);
        }
        Class[] classes = new Class[0];
        if (str.length() > 0) {
            String[] clasz = str.split(",");
            int size = clasz.length;
            classes = new Class[size];
            for (int i = 0; i < size; i++) {
                classes[i] = Class.forName(clasz[i]);
            }
        }
        return classes;
    }
}
