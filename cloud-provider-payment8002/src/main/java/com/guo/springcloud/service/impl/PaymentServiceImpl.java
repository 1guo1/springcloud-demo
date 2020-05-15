package com.guo.springcloud.service.impl;

import com.guo.springcloud.dao.PaymentDao1;
import com.guo.springcloud.entities.Payment;
import com.guo.springcloud.service.PaymentService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Created by dell on 2020/3/23.
 */
@Service
public class PaymentServiceImpl implements PaymentService {
    @Resource
    private PaymentDao1 paymentDao1;

    public int create(Payment payment){
        return paymentDao1.create(payment);
    }
    public Payment getPaymentById(Long id){
        return paymentDao1.getPaymentById(id);
    }
}
