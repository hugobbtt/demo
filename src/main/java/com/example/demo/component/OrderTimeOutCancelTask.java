package com.example.demo.component;

import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * 订单超时取消并解锁库存的定时器
 */
@Component
@Slf4j
public class OrderTimeOutCancelTask {

    @Scheduled(cron = "0 0/10 * ? * ?")
    private void cancelTimeOutOrder() {
        // todo: 调用取消订单的方法
        log.info("取消订单，并根据sku编号释放锁定库存");
    }
}
