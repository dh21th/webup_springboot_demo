package com.webup.soa.utils;

import com.github.pagehelper.PageHelper;
import org.aspectj.lang.JoinPoint;

import javax.servlet.http.HttpServletRequest;

public class AspectUtils {
    /**
     * 默认从第一页开始
     */
    static int pageNum = 1;
    /**
     * 默认每页显示10条记录
     */
    static int pageSize = 10;

    public static void pageAspect(JoinPoint jp) throws Exception {
        Object[] args = jp.getArgs();
        if(null==args || args.length == 0 || !(args[0] instanceof HttpServletRequest)){
            return;
        }
        HttpServletRequest request = (HttpServletRequest)args[0];
        if(request.getParameter("pageNo") != null && request.getParameter("pageSize") !=null){
            int num = Integer.parseInt(request.getParameter("pageNo"));
            int size = Integer.parseInt(request.getParameter("pageSize"));
            PageHelper.startPage( num < 0 ? pageNum : num , size < 0 ? pageSize : size);
        }
    }

//            Method getMethodPageNo = getGetter(args[0].getClass(), "pageNo");
//            if( null == getMethodPageNo ){
//                getMethodPageNo = getGetter(args[0].getClass().getSuperclass(), "pageNo");
//                if( null == getMethodPageNo ){
//                    return;
//                }
//            }
//            Method getMethodPageSize = getGetter(args[0].getClass(), "pageSize");
//            if( null == getMethodPageSize ){
//                getMethodPageSize = getGetter(args[0].getClass().getSuperclass(), "pageSize");
//                if( null == getMethodPageSize ){
//                    return;
//                }
//            }
//            Integer num = (Integer) getMethodPageNo.invoke(args[0]);
//            Integer size = (Integer) getMethodPageSize.invoke(args[0]);
//            if(null == num || null == size){
//                return;
//            }
//            PageHelper.startPage( num < 0 ? pageNum : num , size < 0 ? pageSize : size);
//    private static Method getGetter(Class<?> clazz, String fieldName) {
//        String getMethodName = "get" + fieldName.substring(0,1).toUpperCase()+fieldName.substring(1);
//        try {
//            return clazz.getDeclaredMethod(getMethodName);
//        } catch (Exception e) {
//            return null;
//        }
//    }
}
