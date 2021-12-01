package com.config;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @auther chenyf
 * @date 2021年11月30日18:51
 */
@SpringBootApplication
@EnableDiscoveryClient
public class Config3377 {
    public static void main(String[] args) {
        SpringApplication.run(Config3377.class, args);
    }

}
