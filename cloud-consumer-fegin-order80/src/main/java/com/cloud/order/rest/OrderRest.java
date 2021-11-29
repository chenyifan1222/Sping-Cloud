package com.cloud.order.rest;

import com.cloud.kavin.entity.CommonResult;
import com.cloud.kavin.entity.Payment;
import com.cloud.order.service.PaymentFeginService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@Slf4j
@RestController
public class OrderRest {

    @Resource
    private PaymentFeginService paymentFeginService;

    @RequestMapping(value = "/consumer/order/{id}")
    public CommonResult<Payment> get(@PathVariable("id") Long id){
        return paymentFeginService.get(id);
    }

    @RequestMapping(value = "/consumer/timeout")
    public CommonResult<Payment> timeout(){
        return paymentFeginService.timeout();
    }
}
