package com.webup.soa.http;

import javax.net.ssl.X509TrustManager;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;

/******************************************
 * @author: 大鹏 (xupenghong@elion.com.cn)
 * @createDate: 2016/8/12
 * @company: (C) Copyright 亿兆华盛 2017
 * @since: JDK 1.8
 * @projectName:codegen
 * @Description:信任所有客户端证书
 ******************************************/
public class TrustAnyTrustManager  implements X509TrustManager {

    @Override
    public void checkClientTrusted(X509Certificate[] x509Certificates, String s) throws CertificateException {

    }

    @Override
    public void checkServerTrusted(X509Certificate[] x509Certificates, String s) throws CertificateException {

    }

    @Override
    public X509Certificate[] getAcceptedIssuers() {
        return new X509Certificate[0];
    }
}
