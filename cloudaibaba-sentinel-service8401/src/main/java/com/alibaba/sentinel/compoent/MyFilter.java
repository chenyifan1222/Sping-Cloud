package com.alibaba.sentinel.compoent;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * @auther chenyf
 * @date 2021年12月10日14:36
 */
@Slf4j
public class MyFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        log.info("初始化过滤器{}", filterConfig.getFilterName());
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        // chain.doFilter()方法执行之前为预处理阶段，该方法执行结束即代表用户的请求已经得到控制器处理。
        // 因此，如果在doFilter中忘记调用chain.doFilter()方法，则用户的请求将得不到处理。
        log.info("start to doFilter");
        long startTime = System.currentTimeMillis();
        chain.doFilter(request, response);
        long endTime = System.currentTimeMillis();
        log.info("the request of {} consumes {}ms.", getUrlFrom(request), (endTime - startTime));
        log.info("end to doFilter");
    }

    @Override
    public void destroy() {
        log.info("销毁过滤器");
    }

    private String getUrlFrom(ServletRequest servletRequest){
        if (servletRequest instanceof HttpServletRequest){
            return ((HttpServletRequest) servletRequest).getRequestURL().toString();
        }

        return "";
    }
}
