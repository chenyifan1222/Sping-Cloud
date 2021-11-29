package com.cloud.rest;

import cn.hutool.core.util.IdUtil;
import com.cloud.service.PaymentService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.concurrent.TimeUnit;

@RestController
@Slf4j
public class PaymentRest {

    @Value("${server.port}")
    private String serverPort;

    @Resource
    PaymentService paymentService;

    @RequestMapping(value = "/payment/normal")
    public String normal() {
        return serverPort;
    }

    @HystrixCommand(fallbackMethod = "paymentTimeOut_TimeoutHandle",commandProperties = {@HystrixProperty(name
     = "execution.isolation.thread.timeoutInMilliseconds", value = "3000")})
    @RequestMapping(value = "/payment/hystrix")
    public String paymentTimeOut() {
//        try {
//            TimeUnit.SECONDS.sleep(5);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }

        System.out.println(10/0);
        return serverPort;
    }

    @HystrixCommand(fallbackMethod = "paymentTimeOut_TimeoutHandle")
    public String paymentTimeOut_TimeoutHandle() {

        System.out.println("服务问题");
        return serverPort;
    }

    //   熔断开始
    @RequestMapping(value = "/payment/paymentHysTimeOut/{id}")
    public String paymentHysTimeOut(@PathVariable("id") Long  id) {
        return paymentService.circuitBreaker(id);
    }
}
