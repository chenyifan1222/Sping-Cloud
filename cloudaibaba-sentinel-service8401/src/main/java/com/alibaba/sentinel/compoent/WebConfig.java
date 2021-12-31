package com.alibaba.sentinel.compoent;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.List;

@Configuration
public class WebConfig {
    /**
     * 注册第三方过滤器
     * 功能与spring mvc中通过配置web.xml相同
     * @return
     */
    @Bean
    public FilterRegistrationBean thirdFilter(){
        ThirdPartFilter thirdPartFilter = new ThirdPartFilter();
        FilterRegistrationBean filterRegistrationBean = new FilterRegistrationBean() ;
 
        filterRegistrationBean.setFilter(thirdPartFilter);
        List<String > urls = new ArrayList<>();
        // 匹配所有请求路径
        urls.add("/*");
        filterRegistrationBean.setUrlPatterns(urls);
 
        return filterRegistrationBean;
    }
}