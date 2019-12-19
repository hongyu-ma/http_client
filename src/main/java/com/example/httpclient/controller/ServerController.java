package com.example.httpclient.controller;

import com.example.httpclient.entity.HttpClientResult;
import com.example.httpclient.utils.HttpClientUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * @Description server端
 *
 * @Author mahongyu
 * @Date 2019-12-19 10:11
 */
@RestController
@RequestMapping("/server")
@Slf4j
public class ServerController {
    /**get*/
    @RequestMapping("/get")
    public String testGet() throws Exception {
        log.info("server端发送get无参请求测试");
        HttpClientResult result = HttpClientUtils.doGet("http://127.0.0.1:8080/client/get");
        return result.getContent();
    }
    /**get含参数*/
    @RequestMapping("/getWithParam")
    public String testGetWithParam() throws Exception {
        Map<String, String> params = new HashMap<>();
        params.put("message", "helloworld");
        log.info("server端发送get请求测试,参数是：{}", params);
        HttpClientResult result = HttpClientUtils.doGet("http://127.0.0.1:8080/client/getWithParam", params);
        return result.getContent();
    }
    /**post*/
    @RequestMapping("/post")
    public String testPost() throws Exception {
        Map<String, String> headers = new HashMap<String, String>();
        headers.put("Cookie", "123");
        headers.put("Connection", "keep-alive");
        headers.put("Accept", "application/json");
        headers.put("Accept-Language", "zh-CN,zh;q=0.9");
        headers.put("User-Agent", "Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/65.0.3325.181 Safari/537.36");
        log.info("server端发送post无参请求");
        HttpClientResult result = HttpClientUtils.doPost("http://127.0.0.1:8080/client/post", headers, null);
        return result.getContent();
    }
    /**post 含参数*/
    @RequestMapping("/postWithParam")
    public String testPostWithParam() throws Exception {
        Map<String, String> params = new HashMap<String, String>();
        params.put("code", "0");
        params.put("message", "helloworld");
        log.info("server端发送post请求，参数为：{}",params);
        HttpClientResult result = HttpClientUtils.doPost("http://127.0.0.1:8080/client/postWithParam", params);
        return result.getContent();
    }

}
