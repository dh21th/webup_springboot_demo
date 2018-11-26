package com.webup.soa.annotation;

import java.lang.annotation.*;

/******************************************
 * @author: 大鹏 (xupenghong@elion.com.cn)
 * @createDate: 2017-12-06 8:42
 * @company: (C) Copyright 亿兆华盛 2017
 * @since: JDK 1.8
 * @projectName:IntelliJ IDEA
 * @Description:
 * update by hujun 2017-12-08
 ******************************************/
@Target({ElementType.TYPE, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface ForbidRepeatAnnotation {

    byte method();
}
