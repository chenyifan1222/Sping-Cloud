package com.payment.rest;

import com.cloud.kavin.entity.CommonResult;
import com.cloud.kavin.entity.Payment;
import com.payment.service.PaymentService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.concurrent.TimeUnit;

@RestController
public class PaymentRest {
    @Resource
    PaymentService paymentService;

    @Value("${server.port}")
    private String serverPort;

    @RequestMapping(value = "/payment/{id}")
    public CommonResult<Payment> get(@PathVariable("id") Long  id){
        return new CommonResult(200, "serverPort = " +  serverPort , paymentService.getUserById(id));
    }


    @PostMapping(value = "/payment/create")
    public CommonResult create(@RequestBody Payment payment){
        return new CommonResult(200, "serverPort = " +  serverPort , paymentService.saveUser(payment));
    }

    @RequestMapping(value = "/payment/lb")
    public String lb() {
        return serverPort;
    }

    @RequestMapping(value = "/payment/paymentTimeOut")
    public String paymentTimeOut() {
        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return serverPort;
    }
}
