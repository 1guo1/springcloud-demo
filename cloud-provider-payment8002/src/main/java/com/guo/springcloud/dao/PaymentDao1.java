package com.guo.springcloud.dao;

import com.guo.springcloud.entities.Payment;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface PaymentDao1 {
    int create(Payment payment);

    Payment getPaymentById(@Param("id") Long id);
}

