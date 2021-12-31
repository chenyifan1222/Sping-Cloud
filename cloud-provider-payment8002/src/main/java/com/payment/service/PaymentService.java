package com.payment.service;

import com.cloud.kavin.entity.Payment;
import com.cloud.kavin.entity.PaymentInfo;
import com.payment.mapper.PaymentInfoMapper;
import com.payment.mapper.PaymentMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.support.TransactionTemplate;

import javax.annotation.Resource;

@Service
public class PaymentService {

    @Resource
    PaymentMapper     paymentMapper;
    @Resource
    PaymentInfoMapper paymentInfoMapper;
    @Resource
    private TransactionTemplate transactionTemplate;

    public Payment getUserById(Long id) {
        return paymentMapper.getUserById(id);
    }

    public int saveUser(Payment payment) {
        return paymentMapper.saveUser(payment);
    }


    @Transactional
    public void testTransaction() {
        Payment payment = new Payment();
        payment.setName("扎实");
        paymentMapper.saveUser(payment);
        PaymentInfo paymentInfo = new PaymentInfo();
        paymentInfo.setInfo("扎实1");
        paymentInfoMapper.saveUser(paymentInfo);
    }


}
