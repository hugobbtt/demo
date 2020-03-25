package com.example.demo.dto;

import lombok.Getter;
import lombok.Setter;

/**
 * 生成订单时传入的参数
 */
@Getter
@Setter
public class OrderParam {
    // 收货地址ID
    private Long memberReceiveAddressId;
    // 优惠券ID
    private Long couponId;
    // 使用的积分数
    private Integer useIntegration;
    // 支付方式
    private Integer payType;
}
