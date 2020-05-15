package com.guo.springcloud.controller;

import com.guo.springcloud.entities.CommonResult;
import com.guo.springcloud.entities.Payment;
import com.guo.springcloud.service.PaymentService;
import com.guo.springcloud.service.impl.PaymentServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by dell on 2020/3/23.
 */
@RestController
@Slf4j
public class PaymentController {

    @Resource
    private PaymentService paymentService;

    @Value("${server.port}")
    private String serverPost;


    @Autowired
    private DiscoveryClient discoveryClient;


    public Object discovery(){
        List<String> services = discoveryClient.getServices();

        for (String service : services) {
            log.info(service);
        }

//        discoveryClient.getInstances("")
        return this.discoveryClient;
    }

    @PostMapping(value = "/payment/create")
    public CommonResult create(@RequestBody Payment payment){
        int result = paymentService.create(payment);
        log.info("*****插入结果："+result);
        if(result > 0){
            return new CommonResult(200,"插入数据成功 serverPost="+serverPost,result);
        }else{
            return new CommonResult(444,"插入数据失败",null);
        }
    }
    @GetMapping(value = "/payment/get/{id}")
    public CommonResult getPaymentById(@PathVariable("id") Long id){
        Payment payment = paymentService.getPaymentById(id);
        log.info("*****插入结果："+payment);
        if(payment != null){
            return new CommonResult(200,"查询成功 serverPost="+serverPost,payment);
        }else{
            return new CommonResult(444,"没有对应记录,查询ID："+id,null);
        }
    }
    @GetMapping(value = "/payment/lb/{id}")
    public String lb(@PathVariable("id") Long id){
//        Payment payment = paymentService.getPaymentById(id);
//        log.info("*****插入结果："+payment);
       return serverPost;
    }


}
