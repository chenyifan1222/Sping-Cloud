package com.alibaba.sentinel.controller;

import cn.hutool.core.util.IdUtil;
import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @auther chenyf
 * @date 2021年12月01日15:39
 */
@RestController
public class SentinelController {

    @GetMapping(value = "/testHotKey")
    @SentinelResource(value = "testHotKey", blockHandler = "error_handle")
    public String testHotKey(@RequestParam (required = false, value = "p1") String s1, @RequestParam (required = false, value = "p2") String s2) throws Exception {
        int age  = 10/0;
        return "Hello Sentinel testHotKey";
    }

    public String error_handle(String s1, String s2, BlockException blockException) {
        return "Hello Sentinel testHotKey watch";
    }

    @GetMapping(value = "/glable")
    public String glable() throws Exception {
        return "Hello glable";
    }

    @GetMapping(value = "/testC")
    @SentinelResource(value = "testC", blockHandlerClass = ExceptionHandleController.class, blockHandler = "handel_1")
    public String testC() throws Exception {
        return "Hello testC";
    }

    @GetMapping(value = "/testD")
    @SentinelResource(value = "testD", blockHandlerClass = ExceptionHandleController.class, blockHandler = "handel_2")
    public String testD() throws Exception {
        return "Hello testD";
    }

    public static void main(String[] args) {
        System.out.println(IdUtil.getSnowflake(1, 3).nextId());
    }
}
