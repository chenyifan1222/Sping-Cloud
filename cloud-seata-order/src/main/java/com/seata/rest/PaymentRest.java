package com.seata.rest;

import com.cloud.kavin.entity.CommonResult;
import com.cloud.kavin.entity.Payment;
import com.cloud.kavin.entity.TOrder;
import com.seata.service.OrderService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;
import java.util.concurrent.TimeUnit;

@RestController
@Slf4j
public class PaymentRest {
    @Resource
    OrderService paymentService;

    @Value("${server.port}")
    private String serverPort;

    @RequestMapping(value = "/order/{id}")
    public CommonResult<Payment> get(@PathVariable("id") Long id) {
        return new CommonResult(200, "serverPort = " + serverPort, paymentService.getUserById(id));
    }

    @PostMapping(value = "/order/create")
    public CommonResult create(@RequestBody TOrder payment) {
        return new CommonResult(200, "serverPort = " + serverPort, paymentService.saveUser(payment));
    }
}
