package com.guo.springcloud.alibaba.controller;
//业务类controller

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FlowLimitController {
    @GetMapping("/testA")
    public String testA() {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "--------testA";
    }

    @GetMapping("/testB")
    public String testB() {
        return "--------testB";
    }
}

