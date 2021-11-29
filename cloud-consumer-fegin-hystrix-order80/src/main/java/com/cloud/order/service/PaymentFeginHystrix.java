package com.cloud.order.service;

import com.cloud.kavin.entity.CommonResult;
import com.cloud.kavin.entity.Payment;
import org.springframework.stereotype.Component;

/**
 *客户端兜底方法实现
 */
@Component
public class PaymentFeginHystrix implements PaymentFeginService{
    @Override
    public CommonResult<Payment> get(Long id) {
        return null;
    }

    @Override
    public CommonResult<Payment> timeout() {
        return null;
    }
}
