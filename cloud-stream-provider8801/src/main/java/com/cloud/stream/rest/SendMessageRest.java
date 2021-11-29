package com.cloud.stream.rest;

import com.cloud.stream.service.IMesageProvider;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class SendMessageRest {

    @Resource
    private IMesageProvider mesageProvider;

    @GetMapping("/send")
    public void send(){
        mesageProvider.send();
    }
}
