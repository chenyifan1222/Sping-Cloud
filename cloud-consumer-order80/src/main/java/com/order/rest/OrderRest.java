package com.order.rest;

import com.cloud.kavin.entity.CommonResult;
import com.cloud.kavin.entity.Payment;
import com.order.lb.LoadBalancer;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import java.net.URI;
import java.util.List;

@RestController
@Slf4j
public class OrderRest {

    // private static final String PAYMENT_URL = "http://localhost:8001";

    private static final String PAYMENT_URL = "http://CLOUD-PAYMENT-SERVICE";

    @Resource
    RestTemplate restTemplate;

    @Resource
    private LoadBalancer loadBalancer;

    @Resource
    private DiscoveryClient discoveryClient;

    @RequestMapping(value = "/order/{id}")
    public CommonResult<Payment> get(@PathVariable("id") Long id) {

        CommonResult forObject = restTemplate.getForObject(PAYMENT_URL + "/payment/" + id, CommonResult.class);

        return forObject;
    }


    @PostMapping(value = "/order/create")
    public CommonResult create(@RequestBody Payment payment) {

        CommonResult forObject = restTemplate.postForObject(PAYMENT_URL + "/payment/create", payment, CommonResult.class);

        return forObject;
    }


    @GetMapping(value = "/get/lb")
    public String getLb() {

        List<ServiceInstance> instances = discoveryClient.getInstances("CLOUD-PAYMENT-SERVICE");

        if (instances == null){
            return null;
        }

        ServiceInstance instance = loadBalancer.instance(instances);

        URI uri = instance.getUri();

        return restTemplate.getForObject(uri + "/payment/lb", String.class);
    }
}
