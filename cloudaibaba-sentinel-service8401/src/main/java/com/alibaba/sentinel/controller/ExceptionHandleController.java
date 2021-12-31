package com.alibaba.sentinel.controller;

import com.cloud.kavin.entity.CommonResult;

/**
 * @auther chenyf
 * @date 2021年12月01日16:55
 */
public class ExceptionHandleController {

    public CommonResult handel_1(){
        return new CommonResult(444, "handel_1 exception");
    }

    public CommonResult handel_2(){
        return new CommonResult(444, "handel_2 exception");
    }
}
