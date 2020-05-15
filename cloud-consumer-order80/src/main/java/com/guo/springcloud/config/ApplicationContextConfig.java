package com.guo.springcloud.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * Created by dell on 2020/3/23.
 */
@Configuration
public class ApplicationContextConfig {
    @Bean
    @LoadBalanced// 此注解为让resttemplate支持负载均衡，使消费者可以消费不同的提供者，而不需要指定某个端口
    public RestTemplate getRestTemplate(){
        return new RestTemplate();
    }
}
