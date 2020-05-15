package com.guo.springcloud.service;

//业务逻辑接口 + @FeignClient 配置调用provider服务

import com.guo.springcloud.entities.CommonResult;
import com.guo.springcloud.entities.Payment;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Component
@FeignClient(value = "CLOUD-PAYMENT-SERVICE")  //指定调用哪个微服务
public interface PaymentFeignService {

    @GetMapping(value = "/payment/get/{id}")
        //哪个地址
    CommonResult<Payment> getPaymentById(@PathVariable("id") Long id);
}
