package com.alibaba.sentinel;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @RestController
    public class TestController {

        @GetMapping(value = "/hello")
        @SentinelResource("hello")
        public String hello() {
            return "Hello Sentinel";
        }


        @GetMapping(value = "/testA")
        @SentinelResource("testA")
        public String testA() {
            return "Hello testA";
        }

        @GetMapping(value = "/testB")
        @SentinelResource("testB")
        public String testB() {
            return "Hello testB";
        }
    }
}