package com.cloud.order.config;

import feign.Logger;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FeginConfig {

    @Bean
    Logger.Level feginLoginLevel(){
        return Logger.Level.FULL;
    }
}
