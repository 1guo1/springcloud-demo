package com.guo.springcloud.service;

import com.guo.springcloud.entities.Payment;
import org.apache.ibatis.annotations.Param;

/**
 * Created by dell on 2020/3/23.
 */
public interface PaymentService {
    public int create(Payment payment);

    public Payment getPaymentById(@Param("id") Long id);
}
