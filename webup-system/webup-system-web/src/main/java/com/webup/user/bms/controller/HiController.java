package com.webup.user.bms.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HiController {
    @RequestMapping(value = "/hi")
    public String home(@RequestParam(value="name" ,required =false ) String name){
        return "hi YZ-DEMO，" + name;
    }
    @RequestMapping(value = "/hi2")
    public String home2(@RequestParam(value="name" ,required =false ) String name){
        return "hi2 YZ-DEMO，" + name;
    }
}
