//package com.webup.user.common;
//
//import com.alibaba.fastjson.JSON;
//import feign.RequestInterceptor;
//import feign.RequestTemplate;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import java.io.UnsupportedEncodingException;
//import java.net.URLDecoder;
//
//public class TransmitUserInfoFeighClientIntercepter implements RequestInterceptor {
//
//    private static final Logger log = LoggerFactory.getLogger(TransmitUserInfoFeighClientIntercepter.class);
//    public TransmitUserInfoFeighClientIntercepter() {
//    }
//
//    @Override
//    public void apply(RequestTemplate requestTemplate) {
//        //从应用上下文中取出user信息，放入Feign的请求头中
//        UserInfo user = UserInfoContext.getUser();
//        if (user != null) {
//            try {
//                String userJson = JSON.toJSONString(user);
//                requestTemplate.header("KEY_USERINFO_IN_HTTP_HEADER",new String[]{URLDecoder.decode(userJson,"UTF-8")});
//            } catch (UnsupportedEncodingException e) {
//                log.error("用户信息设置错误",e);
//            }
//        }
//    }
//}