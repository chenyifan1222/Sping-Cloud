package com.payment.rest;

import com.cloud.kavin.entity.CommonResult;
import com.cloud.kavin.entity.Payment;
import com.netflix.appinfo.InstanceInfo;
import com.netflix.discovery.shared.Applications;
import com.payment.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;
import java.util.concurrent.TimeUnit;

@RestController
@Slf4j
public class PaymentRest {
    @Resource
    PaymentService paymentService;

    @Value("${server.port}")
    private String serverPort;

    @Resource
    DiscoveryClient discoveryClient;

    @RequestMapping(value = "/payment/{id}")
    public CommonResult<Payment> get(@PathVariable("id") Long id) {
        return new CommonResult(200, "serverPort = " + serverPort, paymentService.getUserById(id));
    }


    @PostMapping(value = "/payment/create")
    public CommonResult create(@RequestBody Payment payment) {
        return new CommonResult(200, "serverPort = " + serverPort, paymentService.saveUser(payment));
    }

    @RequestMapping(value = "/payment/discovery")
    public Object discovery() {
        List<String> services = discoveryClient.getServices();

        services.stream().forEach(s -> {
            System.out.printf(s + "\t");
        });

        List<ServiceInstance> instances = discoveryClient.getInstances("CLOUD-PAYMENT-SERVICE");

        instances.stream().forEach(i ->{
            System.out.println(i.getServiceId() + "\t" + i.getPort() + "\t" + i.getHost());
        });

        return this.discoveryClient;
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
