package com.example.httpclient.controller;

import com.example.httpclient.entity.HttpClientResult;
import com.example.httpclient.utils.HttpClientUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * @Description 发送HTTP请求的控制器
 * @Author mahongyu
 * @Date 2019-12-19 10:11
 */
@RestController
@RequestMapping("/server")
@Slf4j
public class ServerController {

    @RequestMapping("/get")
    public String testGet() throws Exception {
        log.info("server端发送get无参请求测试");
        HttpClientResult result = HttpClientUtils.doGet("http://127.0.0.1:8080/client/get");
        return result.getContent();
    }

    @RequestMapping("/getWithParam")
    public String testGetWithParam() throws Exception {
        Map<String, String> params = new HashMap<>();
        params.put("message", "helloworld");
        log.info("server端发送get请求测试,参数是：{}", params);
        HttpClientResult result = HttpClientUtils.doGet("http://127.0.0.1:8080/client/getWithParam", params);
        return result.getContent();
    }


}
