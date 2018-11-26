package com.webup.soa.utils;

import java.util.Map;

/******************************************
 * @author: 大鹏 (xupenghong@elion.com.cn)
 * @createDate: 2017/10/27
 * @company: (C) Copyright 亿兆华盛 2017
 * @since: JDK 1.8
 * @projectName:IntelliJ IDEA
 * @Description:类功能描述
 ******************************************/
public class ValidationResult {

    //校验结果是否有错
    private boolean hasErrors;

    //校验错误信息
    private Map<String, String> errorMsg;

    public boolean isHasErrors() {
        return hasErrors;
    }

    public void setHasErrors(boolean hasErrors) {
        this.hasErrors = hasErrors;
    }

    public Map<String, String> getErrorMsg() {
        return errorMsg;
    }

    public void setErrorMsg(Map<String, String> errorMsg) {
        this.errorMsg = errorMsg;
    }

    public String getErrorMessage() {
        return this.getErrorMsg() + "";
    }

    @Override
    public String toString() {
        return "ValidationResult [hasErrors=" + hasErrors + ", errorMsg="
                + errorMsg + "]";
    }

}
