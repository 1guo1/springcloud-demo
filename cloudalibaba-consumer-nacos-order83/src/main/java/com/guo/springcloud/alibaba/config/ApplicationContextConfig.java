package com.guo.springcloud.alibaba.config;

//Nacos自带Ribbon，引入RestTemplate

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class ApplicationContextConfig {
    @Bean
    @LoadBalanced //RestTemplate结合Ribbon做负载均衡一定要加@LoadBalanced
    public RestTemplate getRestTemplate() {
        return new RestTemplate();
    }
}
