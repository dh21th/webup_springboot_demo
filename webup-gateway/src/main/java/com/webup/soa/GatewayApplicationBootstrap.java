package com.webup.soa;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

/******************************************
 * @createDate: 2018/1/16
 * @company: (C) Copyright 亿兆华盛 2018
 * @since: JDK 1.8
 * @projectName:webup-gateway
 * @Description:
 ******************************************/
@SpringBootApplication(
        scanBasePackages="com.webup.soa",
        exclude = {
                DataSourceAutoConfiguration.class
        }
)
@EnableDiscoveryClient
@EnableFeignClients
public class GatewayApplicationBootstrap {

//    @Bean
//    @LoadBalanced
//    RestTemplate restTemplate() {
//        return new RestTemplate();
//    }

    public static void main(String[] args) {
        SpringApplication.run(GatewayApplicationBootstrap.class, args);
    }

}
