//package com.webup.soa;
//
//import org.springframework.boot.SpringApplication;
//import org.springframework.boot.autoconfigure.SpringBootApplication;
//import org.springframework.boot.autoconfigure.amqp.RabbitAutoConfiguration;
//import org.springframework.boot.autoconfigure.data.mongo.MongoDataAutoConfiguration;
//import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
//import org.springframework.boot.autoconfigure.mongo.MongoAutoConfiguration;
//import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;
//import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
//import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
//import org.springframework.web.bind.annotation.RestController;
//
///******************************************
// * @author: 大鹏 (xupenghong@elion.com.cn)
// * @createDate: 2018/1/16
// * @company: (C) Copyright 亿兆华盛 2018
// * @since: JDK 1.8
// * @projectName:yizhao-pay
// * @Description:
// ******************************************/
//
//@SpringBootApplication(
//		exclude = {
//				RabbitAutoConfiguration.class,
//				MongoAutoConfiguration.class, MongoDataAutoConfiguration.class,
//				DataSourceAutoConfiguration.class, HibernateJpaAutoConfiguration.class
//		}
//)
//@EnableDiscoveryClient
//@EnableEurekaClient
//@RestController
//public class CoreServiceApplicationBootstrap {
//
//	public static void main(String[] args) {
//		SpringApplication.run(CoreServiceApplicationBootstrap.class, args);
//	}
//
//}
