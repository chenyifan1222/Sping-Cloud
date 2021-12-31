package com.payment.mapper;

import com.cloud.kavin.entity.PaymentInfo;

public interface PaymentInfoMapper {

    public PaymentInfo getUserById(Long id);

    public int saveUser(PaymentInfo payment);
}
