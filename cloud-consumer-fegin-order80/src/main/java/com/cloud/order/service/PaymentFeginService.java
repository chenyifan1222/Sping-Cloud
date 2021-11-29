package com.cloud.order.service;

import com.cloud.kavin.entity.CommonResult;
import com.cloud.kavin.entity.Payment;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Component
@FeignClient(value = "CLOUD-PAYMENT-SERVICE")
public interface PaymentFeginService {

    @RequestMapping(value = "/payment/{id}")
    public CommonResult<Payment> get(@PathVariable("id") Long id);


    @RequestMapping(value = "/payment/paymentTimeOut")
    public CommonResult<Payment> timeout();
}
