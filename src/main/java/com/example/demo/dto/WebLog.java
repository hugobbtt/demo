package com.example.demo.dto;

import lombok.Getter;
import lombok.Setter;

/**
 * @author Hugo
 * @date 2020/4/15
 * 添加AOP切面实现接口日志记录
 * 用于封装需要记录的日志信息，包括操作的描述、时间、消耗时间、url、请求参数和返回结果等信息。
 */
@Getter
@Setter
public class WebLog {
    /**
     * 操作描述
     */
    private String description;

    /**
     * 操作用户
     */
    private String username;

    /**
     * 操作开始时间
     */
    private Long startTime;

    /**
     * 消耗时间
     */
    private Integer spendTime;

    /**
     * 根目录
     */
    private String basePath;

    private String uri;

    private String url;

    /**
     * 请求类型
     */
    private String method;

    private String ip;

    /**
     * 请求参数
     */
    private Object parameter;

    /**
     * 请求返回的结果
     */
    private Object result;
}
