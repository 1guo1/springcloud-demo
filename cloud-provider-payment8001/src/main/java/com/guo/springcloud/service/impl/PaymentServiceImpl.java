package com.guo.springcloud.service.impl;

import com.guo.springcloud.dao.PaymentDao;
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
    private PaymentDao paymentDao;

    public int create(Payment payment){
        return paymentDao.create(payment);
    }
    public Payment getPaymentById(Long id){
        return paymentDao.getPaymentById(id);
    }
}
