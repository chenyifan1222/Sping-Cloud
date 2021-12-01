package com.cloud.nacos;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @auther chenyf
 * @date 2021年11月30日16:38
 */
@SpringBootApplication
@EnableDiscoveryClient
public class NacosConsumer9902 {

    public static void main(String[] args) {

        SpringApplication.run(NacosConsumer9902.class,args);
    }

    @RestController
    public class NacosController{

        @Autowired
        private LoadBalancerClient loadBalancerClient;
        @Autowired
        private RestTemplate       restTemplate;

        @Value("${spring.application.name}")
        private String appName;

        @Value("${spring.providerUrl}")
        private String providerUrl;

        @GetMapping("/echo/app-name")
        public String echoAppName(){
            //Access through the combination of LoadBalanceClient and RestTemplate
            ServiceInstance serviceInstance = loadBalancerClient.choose("nacos-provider-9901");
            String          path            = String.format("http://%s:%s/echo/%s",serviceInstance.getHost(),serviceInstance.getPort(),appName);
            System.out.println("request path:" +path);
            return restTemplate.getForObject(path,String.class);
        }

        @GetMapping("/echo/app-name1")
        public String echoAppName1(){
            String forObject = restTemplate.getForObject(providerUrl + "/each" + "/sd", String.class);

            return forObject;
        }
    }

    //Instantiate RestTemplate Instance
    @Bean
    public RestTemplate restTemplate(){

        return new RestTemplate();
    }


}
