//package com.webup.soa.http;
//
//
//import org.apache.http.HttpEntity;
//import org.apache.http.NameValuePair;
//import org.apache.http.client.config.RequestConfig;
//import org.apache.http.client.entity.UrlEncodedFormEntity;
//import org.apache.http.client.methods.CloseableHttpResponse;
//import org.apache.http.client.methods.HttpGet;
//import org.apache.http.client.methods.HttpPost;
//import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
//import org.apache.http.impl.client.CloseableHttpClient;
//import org.apache.http.impl.client.HttpClients;
//import org.apache.http.message.BasicNameValuePair;
//import org.apache.http.util.EntityUtils;
//import org.springframework.stereotype.Component;
//
//
//import javax.net.ssl.HostnameVerifier;
//import javax.net.ssl.SSLContext;
//import javax.net.ssl.SSLSession;
//import javax.net.ssl.TrustManager;
//import java.security.SecureRandom;
//import java.util.ArrayList;
//import java.util.List;
//import java.util.Map;
//import java.util.Set;
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
//public class YzHttpClientTools {
//
//    /**
//     * 发送get请求
//     *
//     * @param url
//     * @return
//     * @throws Exception
//     */
//    public String doGet(String url) throws Exception {
//        String result = null;
//
//        CloseableHttpClient httpclient = HttpClients.createDefault();
//        try {
//            //设置请求超时
//            RequestConfig requestConfig = RequestConfig.custom()
//                    .setConnectionRequestTimeout(5000).setConnectTimeout(5000)
//                    .setSocketTimeout(5000).build();
//
//            HttpGet httpget = new HttpGet(url);
//            httpget.setConfig(requestConfig);
//
//            CloseableHttpResponse response = httpclient.execute(httpget);
//
//            int status = response.getStatusLine().getStatusCode();
//            if (status >= 200 && status < 300) {
//                HttpEntity entity = response.getEntity();
//                if (entity != null) {
//                    result = EntityUtils.toString(entity);
//                }
//            }
//
//            response.close();
//        } finally {
//            httpclient.close();
//        }
//
//        return result;
//    }
//
//    /**
//     * 发送post请求
//     *
//     * @param url
//     * @param params
//     * @return
//     * @throws Exception
//     */
//    public String doPost(String url, Map<String, String> params, int timeOut) throws Exception {
//        String result = null;
//
//        CloseableHttpClient httpclient = HttpClients.createDefault();
//        try {
//            //设置请求超时
//            RequestConfig requestConfig = RequestConfig.custom()
//                    .setConnectionRequestTimeout(timeOut).setConnectTimeout(timeOut)
//                    .setSocketTimeout(timeOut).build();
//
//            HttpPost httpost = new HttpPost(url);
//
//            httpost.setConfig(requestConfig);
//
//            List<NameValuePair> nvps = new ArrayList<NameValuePair>();
//            Set<String> keySet = params.keySet();
//            for (String key : keySet) {
//                nvps.add(new BasicNameValuePair(key, params.get(key)));
//            }
//            httpost.setHeader("Content-Type", "application/x-www-form-urlencoded; charset=utf-8");
//            httpost.setEntity(new UrlEncodedFormEntity(nvps, "UTF-8"));
//
//            CloseableHttpResponse response = httpclient.execute(httpost);
//            int status = response.getStatusLine().getStatusCode();
//            if (status >= 200 && status < 300) {
//                HttpEntity entity = response.getEntity();
//                if (entity != null) {
//                    result = EntityUtils.toString(entity);
//                }
//            }
//            response.close();
//        } finally {
//            httpclient.close();
//        }
//        return result;
//    }
//
//    /**
//     * 支持SSL协议的html post请求
//     * @param url       ：   url地址
//     * @param params    ：   json串
//     * @return
//     * @throws Exception
//     */
//    public String doPostWithSSL(String url, Map<String, String> params, int timeOut) throws Exception {
//        String result = null;
//        CloseableHttpClient httpclient = null;
//        try {
//            //设置请求超时
//            RequestConfig requestConfig = RequestConfig.custom()
//                    .setConnectionRequestTimeout(timeOut).setConnectTimeout(timeOut)
//                    .setSocketTimeout(timeOut).build();
//
//            SSLContext sslcontext = SSLContext.getInstance("SSLv3");
//            sslcontext.init(null, new TrustManager[]{new TrustAnyTrustManager()}, new SecureRandom());
//
//            SSLConnectionSocketFactory sslsf = new SSLConnectionSocketFactory(sslcontext, new HostnameVerifier() {
//                @Override
//                public boolean verify(String var1, SSLSession var2) {
//                    return true;
//                }
//            });
//
//            httpclient = HttpClients.custom().setSSLSocketFactory(sslsf).build();
//
//            HttpPost httpost = new HttpPost(url);
//
//            httpost.setConfig(requestConfig);
//
//            List<NameValuePair> nvps = new ArrayList<NameValuePair>();
//            Set<String> keySet = params.keySet();
//            for (String key : keySet) {
//                nvps.add(new BasicNameValuePair(key, params.get(key)));
//            }
//
//            httpost.setEntity(new UrlEncodedFormEntity(nvps, "UTF-8"));
//
//            CloseableHttpResponse response = httpclient.execute(httpost);
//            int status = response.getStatusLine().getStatusCode();
//            if (status >= 200 && status < 300) {
//                HttpEntity entity = response.getEntity();
//                if (entity != null) {
//                    result = EntityUtils.toString(entity);
//                }
//            }
//            response.close();
//        } finally {
//            if(null != httpclient) {
//                httpclient.close();
//            }
//        }
//
//        return result;
//    }
//
//}
