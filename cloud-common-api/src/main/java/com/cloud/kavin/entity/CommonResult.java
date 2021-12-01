package com.cloud.kavin.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class CommonResult <T>{

    private int code;

    private String message;

    private T data;

    public CommonResult(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public CommonResult(int code, String message, T data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }

    public static <T> CommonResult<T> success(T data){
        return new CommonResult(200, "成功", data);
    }
    public static <T> CommonResult<T> fail(T data){
        return new CommonResult(500, "失败");
    }
}
