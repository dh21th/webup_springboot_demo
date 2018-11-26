package com.webup.user.bms.page;

import com.github.pagehelper.PageHelper;
import com.webup.soa.utils.AspectUtils;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.Method;

/**
 * 拦截分页请求，加入分页信息
 *
 * @author denghua
 * @create 2017-06-10 12:30
 */
@Aspect
@Component
public class PageAspect {


    /**
     * Before增强，实现分页拦截
     * 要求：需要分页的方法中第一个参数必须是request对象
     * @param jp
     * @throws Exception
     */

    @Before("execution(* com.webup.user.bms.controller.*.*(..))")
    public void beforeController(JoinPoint jp) throws Exception {
        AspectUtils.pageAspect(jp);
    }

//    //后置异常通知
//    @AfterThrowing("pageCut()")
//    public void throwss(JoinPoint jp){
//        System.out.println("方法异常时执行.....");
//    }
//
//    //后置最终通知,final增强，不管是抛出异常或者正常退出都会执行
//    @After("pageCut()")
//    public void after(JoinPoint jp){
//        System.out.println("方法最后执行.....");
//    }
//
//    @AfterReturning(returning = "ret", pointcut = "pageCut()")
//    public void doAfterReturning(Object ret) throws Throwable {
//        // 处理完请求，返回内容
//        System.out.println("方法的返回值 : " + ret);
//    }
//
//    //环绕通知,环绕增强，相当于MethodInterceptor
//    @Around("pageCut()")
//    public Object arround(ProceedingJoinPoint pjp) {
//        System.out.println("方法环绕start.....");
//        try {
//            Object o =  pjp.proceed();
//            System.out.println("方法环绕proceed，结果是 :" + o);
//            return o;
//        } catch (Throwable e) {
//            e.printStackTrace();
//            return null;
//        }
//    }

}
