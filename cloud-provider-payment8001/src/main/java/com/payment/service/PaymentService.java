package com.payment.service;

import com.cloud.kavin.entity.Payment;
import com.payment.mapper.PaymentMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class PaymentService {

    @Resource
    PaymentMapper paymentMapper;

    public Payment getUserById(Long id){
        return paymentMapper.getUserById(id);
    }

    public int saveUser(Payment payment){
        return paymentMapper.saveUser(payment);
    }
}
