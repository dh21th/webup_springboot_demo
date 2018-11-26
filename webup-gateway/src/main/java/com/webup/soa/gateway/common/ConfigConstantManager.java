package com.webup.soa.gateway.common;

import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/******************************************
 * @createDate: 2018/2/28
 * @company: (C) Copyright 亿兆华盛 2018
 * @since: JDK 1.8
 * @projectName:webup-gateway
 * @Description: 配置文件信息
 ******************************************/
@Data
@Component
public class ConfigConstantManager {

    @Value("${key-word-decrypt}")
    private String[] decryptKeyWords;

    @Autowired
    private SecretKey secretKey;

    @Data
    @Component
    @ConfigurationProperties("secret-key")
    public class SecretKey {

        private String payServiceKey;

        private String msgServiceKey;

    }

}
