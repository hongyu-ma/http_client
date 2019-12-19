package com.example.httpclient.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @Description 响应结果封装类
 * @Author mahongyu
 * @Date 2019-12-19 10:17
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class HttpClientResult implements Serializable {

    private int code;

    private String content;
}
