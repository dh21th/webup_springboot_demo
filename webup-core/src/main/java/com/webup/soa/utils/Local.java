//package com.webup.soa.utils;
//
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.beans.factory.InitializingBean;
//import org.springframework.stereotype.Component;
//
//import java.io.UnsupportedEncodingException;
//import java.net.URLDecoder;
//
///******************************************
// * @author: 大鹏 (xupenghong@elion.com.cn)
// * @createDate: 2017/7/31
// * @company: (C) Copyright 亿兆华盛 2017
// * @since: JDK 1.8
// * @projectName:IntelliJ IDEA
// * @Description:类功能描述
// ******************************************/
//@Component
//@Slf4j
//public class Local implements InitializingBean {
//
//    /**  工程部署目录  */
//    private String projectLocal = null;
//
//    public String getProjectLocal() {
//        return projectLocal;
//    }
//
//    private void init() {
//        String local;
//        try {
//            local = URLDecoder.decode(this.getClass().getProtectionDomain().getCodeSource().getLocation().getFile(), "utf-8");
//
//            if(System.getProperty("os.name").toLowerCase().contains("windows")) {
//                int index = local.indexOf("lib");
//                if(index > -1) {
//                    local = local.substring(1, index) + "classes/";//web服务器下运行
//                } else {
////                    if(local.indexOf("target") > -1) { //maven环境
////                        local = local.substring(0, local.lastIndexOf("target")) + "src/main/webapp/";
////                    } else {
//                        local = local.substring(1, local.lastIndexOf("/") + 1);
////                    }
//                }
//
//                if(local.startsWith("/")) {
//                    local = local.substring(1);
//                }
//
//                log.info("Windows采集程序部署路径 >>>>>>>>>>>>>>>>>>>> {}", local);
//            } else {//linux
//                int index = local.indexOf("WEB-INF");
//                local = local.substring(0, index) + "WEB-INF/classes/";//web服务器下运行
//                log.info("Linux采集程序部署路径 >>>>>>>>>>>>>>>>>>>> {}", local);
//            }
//            projectLocal = local;
//        } catch (UnsupportedEncodingException e) {
//            e.printStackTrace();
//        }
//    }
//
//    @Override
//    public void afterPropertiesSet() throws Exception {
//        //init();
//    }
//}
