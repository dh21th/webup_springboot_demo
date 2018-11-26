package com.webup.soa.gateway.filter;

import com.webup.soa.gateway.common.ConfigConstantManager;
import com.webup.soa.gateway.common.GlobalConfig;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Enumeration;

/******************************************
 * @createDate: 2018/2/26
 * @company: (C) Copyright 亿兆华盛 2018
 * @since: JDK 1.8
 * @projectName:webup-gateway
 * @Description: 主要做重要参数的解密处理
 ******************************************/
@Component("authFilter")
@WebFilter(filterName="authFilter", urlPatterns="/*")
public class AuthFilter implements Filter {

    @Autowired
    private ConfigConstantManager configConstantManager;

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest httpServletRequest = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;

        String method = httpServletRequest.getMethod();

        String contentType = httpServletRequest.getHeader("content-type");

        if(method.toLowerCase().equals("post") && StringUtils.isNotBlank(contentType) && contentType.equals(GlobalConfig.CONTENT_TYPE)) {
            String[] uris = httpServletRequest.getRequestURI().split("/");
            String secretKey = null;
            if(uris[2].equals("pay_service")) {
                secretKey = configConstantManager.getSecretKey().getPayServiceKey();
            }
            GatewayHttpServletRequestWrapper request = new GatewayHttpServletRequestWrapper(httpServletRequest, secretKey, configConstantManager.getDecryptKeyWords());

            filterChain.doFilter(request, response);
        } else {
            filterChain.doFilter(httpServletRequest, response);
        }
    }

    @Override
    public void destroy() {

    }

}
