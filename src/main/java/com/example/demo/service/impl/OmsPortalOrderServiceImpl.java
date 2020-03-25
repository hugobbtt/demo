package com.example.demo.service.impl;

import com.example.demo.common.api.CommonResult;
import com.example.demo.component.CancelOrderSender;
import com.example.demo.dto.OrderParam;
import com.example.demo.service.OmsPortalOrderService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class OmsPortalOrderServiceImpl implements OmsPortalOrderService {
    @Autowired
    private CancelOrderSender cancelOrderSender;

    @Override
    public void cancelOrder(Long orderId) {
        // todo 执行一系列取消订单的操作
        log.info("process cancelOrder orderId:{}", orderId);
    }

    @Override
    public Object generateOrder(OrderParam orderParam) {
        // todo 执行一系列下单操作
        log.info("process generateOrder");
        // 下单完成后开启一个延迟消息，用于当用户没有付款时取消订单
        long delayTimes = 30 * 1000;
        cancelOrderSender.sendMessage(11L, delayTimes);
        return CommonResult.success(null, "下单成功");
    }

}
