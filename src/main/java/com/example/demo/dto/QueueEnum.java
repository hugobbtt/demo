package com.example.demo.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * 消息队列枚举配置
 */
@Getter
@AllArgsConstructor
public enum QueueEnum {
    /**
     * 消息通知队列
     */
    QUEUE_ORDER_CANCEL("mall.order.direct",
                        "mall.order.cancel",
                        "mall.order.cancel"),

    /**
     * 消息通知ttl队列
     */
    QUEUE_TTL_ORDER_CANCEL("mall.order.direct.ttl",
                            "mall.order.cancel.ttl",
                            "mall.order.cancel.ttl");

    private String exchange;
    private String name;
    private String routeKey;

}
