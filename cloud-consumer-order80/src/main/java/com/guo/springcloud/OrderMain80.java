package com.guo.springcloud;

import com.guo.myrule.MyselfRule;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.netflix.ribbon.RibbonClients;

/**
 * Created by dell on 2020/3/23.
 */
@SpringBootApplication
@EnableEurekaClient
@RibbonClients(value = {@RibbonClient(value = "CLOUD-PAYMENT-SERVICE",configuration = MyselfRule.class)})
public class OrderMain80 {

    public static void main(String[] args) {
        SpringApplication.run(OrderMain80.class,args);
    }
}
