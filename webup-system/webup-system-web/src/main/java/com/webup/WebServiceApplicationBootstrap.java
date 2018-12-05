package com.webup;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
//import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.data.elasticsearch.repository.config.EnableElasticsearchRepositories;


/******************************************
 * @author: 邓华 (denghua@elion.com.cn)
 * @createDate: 2018/1/16
 * @company: (C) Copyright 亿兆华盛 2018
 * @since: JDK 1.8
 * @Description:
 *  RabbitAutoConfiguration.class,HibernateJpaAutoConfiguration.class,MongoAutoConfiguration.class, MongoDataAutoConfiguration.class,
 ******************************************/

@SpringBootApplication(
        scanBasePackages="com.webup",
        exclude = {
                DataSourceAutoConfiguration.class
        }
)
//@SpringBootApplication(scanBasePackages="com.webup.user.bms") //.service
//@EnableDiscoveryClient
@EnableFeignClients(basePackages="com.webup")
//@EnableEurekaClient
//@EnableDiscoveryClient
@MapperScan("com.webup.user.bms.mapper")
//@EnableElasticsearchRepositories(basePackages={"com.webup"})
public class WebServiceApplicationBootstrap {

    public static void main(String[] args) {
        SpringApplication.run(WebServiceApplicationBootstrap.class, args);
    }

}
