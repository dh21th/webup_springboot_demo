package com.webup.soa.gateway.microservice;

import com.webup.soa.base.JsonResult;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/******************************************
 * @createDate: 2018/4/12
 * @company: (C) Copyright 亿兆华盛 2018
 * @since: JDK 1.8
 * @projectName:webup-pay
 * @Description:
 ******************************************/
@FeignClient(name = "yz-msg-service", path = "/yz-message")
public interface MsgServiceInterface {

    @RequestMapping(value = "/message/push", method = RequestMethod.POST)
    JsonResult sendShortMsg();

}
