package com.example.httpclient.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

/**
 * @Description client端
 *
 * @Author mahongyu
 * @Date 2019-12-18 14:48
 */
@RestController
@RequestMapping("/client")
@Slf4j
public class ClientController {

    @GetMapping("/get")
    public String get() throws InterruptedException {
        log.info("client端接收get无参请求");
        return "get无参请求成功";
    }

    @GetMapping("/getWithParam")
    public String getWithParam(@RequestParam String message) {
        log.info("client端接收get含参请求，参数：{}",message);
        return "get带参请求成功,参数message: " + message;
    }

    @PostMapping("/post")
    public String post(@RequestHeader("User-Agent") String userAgent,
                       @RequestHeader("Accept") String accept,
                       @RequestHeader("Accept-Language") String acceptLanguage,
                       @RequestHeader("Accept-Encoding") String acceptEncoding,
                       @RequestHeader("Cookie") String cookie,
                       @RequestHeader("Connection") String conn) {
        // 打印请求头信息
        System.out.println("Cookie = " + cookie);
        System.out.println("Connection = " + conn);
        System.out.println("Accept = " + accept);
        System.out.println("Accept-Language = " + acceptLanguage);
        System.out.println("Accept-Encoding = " + acceptEncoding);
        System.out.println("User-Agent = " + userAgent);
        log.info("client接收post请求");
        return "post无参请求成功";
    }

    @PostMapping("/postWithParam")
    public String postWithParam(@RequestParam String code, @RequestParam String message) {
        log.info("client接收post含参数请求");
        return "post带参请求成功,参数code: " + code + ",参数message: " + message;
    }



}
