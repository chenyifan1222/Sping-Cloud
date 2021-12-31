package com.alibaba.sentinel.controller;

import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import java.util.Map;

/**
 * @auther chenyf
 * @date 2021年12月22日14:07
 */
@RestController
public class SprmvcController {

    @GetMapping(value = "/multipartResolver")
    public String multipartResolver(MultipartHttpServletRequest request) throws Exception {
        MultiValueMap<String, MultipartFile> multiFileMap = request.getMultiFileMap();

        return multiFileMap.toString();
    }
}
