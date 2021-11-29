package com.rule;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MyRule {


    /**
     * ribbon 官方警告 不能放在@ComponentScan注解下扫描要不然达不到定制化功能，会被所有客户端所共享
     * @return
     */

    @Bean
    public IRule getRandomRule(){
        return new RandomRule();
    }
}
