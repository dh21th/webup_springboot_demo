package com.webup.soa.gateway.filter;

import com.alibaba.fastjson.JSONObject;
import com.webup.soa.gateway.common.GlobalConfig;
import com.webup.soa.gateway.utils.AesEncryptionUtil;
import org.apache.commons.lang.StringUtils;

import javax.servlet.ReadListener;
import javax.servlet.ServletInputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;

/******************************************
 * @createDate: 2018/2/28
 * @company: (C) Copyright 亿兆华盛 2018
 * @since: JDK 1.8
 * @projectName:webup-gateway
 * @Description: 解密请求参数
 ******************************************/
public class GatewayHttpServletRequestWrapper extends HttpServletRequestWrapper {

    private String requestBody;

    /**
     * Constructs a request object wrapping the given request.
     *
     * @param request The request to wrap
     * @throws IllegalArgumentException if the request is null
     */
    public GatewayHttpServletRequestWrapper(HttpServletRequest request, String secretKey, String[] decryptKeyWords) {
        super(request);

        try {
            InputStream is = request.getInputStream();
            StringBuffer builder = new StringBuffer();
            byte[] buff = new byte[1024];
            int read;
            while ((read = is.read(buff)) > 0) {
                builder.append(new String(buff, 0, read));
            }

            if (StringUtils.isNotBlank(builder.toString())) {
                requestBody = builder.toString();

                JSONObject jsonObject = JSONObject.parseObject(requestBody);

                if (jsonObject.containsKey(GlobalConfig.PLATFORM) && jsonObject.getString(GlobalConfig.PLATFORM)
                        .toLowerCase().equals(GlobalConfig.PLATFORM_APP)) {

                    for (String decryptKeyWord : decryptKeyWords) {
                        if (jsonObject.containsKey(decryptKeyWord)) {
                            jsonObject.put(decryptKeyWord, AesEncryptionUtil.decrypt(jsonObject.getString
                                    (decryptKeyWord), AesEncryptionUtil.AES_CBC_PKCS5, secretKey));
                            continue;
                        }
                    }

                    requestBody = jsonObject.toJSONString();
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Override
    public ServletInputStream getInputStream() throws IOException {
        final ByteArrayInputStream bais = new ByteArrayInputStream(requestBody.getBytes());
        return new ServletInputStream() {

            @Override
            public boolean isFinished() {
                return false;
            }

            @Override
            public boolean isReady() {
                return false;
            }

            @Override
            public void setReadListener(ReadListener listener) {

            }

            @Override
            public int read() throws IOException {
                return bais.read();
            }
        };
    }

}
