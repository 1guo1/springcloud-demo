package com.guo.springcloud.service;

//业务类启用 @HystrixCommand

import cn.hutool.core.util.IdUtil;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.concurrent.TimeUnit;

@Service
public class PaymentService {
    /**
     * 正常访问
     *
     * @param id
     * @return
     */
    public String paymentInfo_OK(Integer id) {
        return "线程池：" + Thread.currentThread().getName() + "   paymentInfo_OK,id：" + id + "\t" + "O(∩_∩)O哈哈~";
    }

    /**
     * http://localhost:8001/payment/hystrix/timeout/31
     *
     * @param id
     * @return
     * @HystrixCommand报异常后如何处理： 一旦调用服务方法失败并抛出了错误信息后，
     * 会自动调用@HystrixCommand标注好的fallbackMethod调用类中的指定方法
     */
    @HystrixCommand(fallbackMethod = "paymentInfo_TimeOutHandler", commandProperties = {
            //设置这个线程的超时时间是3s，3s内是正常的业务逻辑，超过3s调用fallbackMethod指定的方法进行处理
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "3000")
    })
    public String paymentInfo_Timeout(Integer id) {
        int timeNumber = 5;
        //int age = 10/0;
        try {
            TimeUnit.SECONDS.sleep(timeNumber);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "线程池：" + Thread.currentThread().getName() + "   paymentInfo_Timeout,id：" + id + "\t" + "O(∩_∩)O哈哈~" + "   耗时(秒)：" + timeNumber;
    }

    public String paymentInfo_TimeOutHandler(Integer id) {
        return "线程池：" + Thread.currentThread().getName() + "   系统繁忙，请稍后再试,id：" + id + "\t" + "o(╥﹏╥)o";
    }


    @HystrixCommand(fallbackMethod = "getFallback", commandProperties =
            {@HystrixProperty(name = "circuitBreaker.enabled", value = "true"),// 是否开启断路器
            @HystrixProperty(name = "circuitBreaker.requestVolumeThreshold", value = "10"),// 请求次数
            @HystrixProperty(name = "circuitBreaker.sleepWindowInMilliseconds", value = "10000"),// 时间窗口期
            @HystrixProperty(name = "circuitBreaker.errorThresholdPercentage", value = "60")}) // 失败率达到多少后跳闸
    public String paymentCircuitBreaker(@PathVariable("id") Integer id) {
        if (id < 0) {
            throw new RuntimeException("不能为负数");
        }
        String str = IdUtil.simpleUUID();
        return Thread.currentThread().getName() + "\t调用成功流水号为" + str;
    }

    public String getFallback(@PathVariable("id") Integer id) {
        return "id不能为负数，请稍后再试   id  =" + id;
    }
}

