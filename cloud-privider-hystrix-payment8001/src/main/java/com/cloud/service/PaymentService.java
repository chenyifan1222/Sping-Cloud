package com.cloud.service;

import cn.hutool.core.util.IdUtil;
import com.cloud.kavin.entity.Payment;
import com.cloud.mapper.PaymentMapper;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import javax.annotation.Resource;

@Service
public class PaymentService {

    @Resource
    PaymentMapper paymentMapper;


    public Payment getUserById(Long id) {
        return paymentMapper.getUserById(id);
    }

    public int saveUser(Payment payment) {
        return paymentMapper.saveUser(payment);
    }

    //   熔断开始
    @HystrixCommand(fallbackMethod = "circuitBreaker_fallback",commandProperties = {
            @HystrixProperty(name = "circuitBreaker.enabled", value = "true"), // 是否开启断路器
            @HystrixProperty(name = "circuitBreaker.requestVolumeThreshold", value = "10"),  // 请求次数
            @HystrixProperty(name = "circuitBreaker.sleepWindowInMilliseconds", value = "10000"),  // 时间范围
            @HystrixProperty(name = "circuitBreaker.errorThresholdPercentage", value = "60"),     // 失败率达到多少跳闸
    })
    public String circuitBreaker(@PathVariable("id") Long  id) {
        if (id < 0){
            throw new RuntimeException("id 不能为负数");
        }

        String s = IdUtil.simpleUUID();

        return Thread.currentThread().getName() + "\t" + "流水号：" + s;
    }

    public String circuitBreaker_fallback(@PathVariable("id") Long  id) {

        return "id 不能为负数";
    }
}
