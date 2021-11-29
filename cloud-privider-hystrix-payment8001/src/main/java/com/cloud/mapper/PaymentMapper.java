package com.cloud.mapper;

import com.cloud.kavin.entity.Payment;

public interface PaymentMapper {

    public Payment getUserById(Long id);

    public int saveUser(Payment payment);
}
