package com.webup.soa.exception;

/******************************************
 * @author: 大鹏 (xupenghong@elion.com.cn)
 * @createDate: 2017/8/2
 * @company: (C) Copyright 亿兆华盛 2017
 * @since: JDK 1.8
 * @projectName:IntelliJ IDEA
 * @Description:参数校验异常类
 ******************************************/
public class ParamValidException extends RuntimeException {

    public ParamValidException(String message) {
        super(message);
    }

}
