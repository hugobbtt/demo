package com.example.demo.service;

import com.example.demo.dto.OrderParam;

public interface OmsPortalOrderService {

    void cancelOrder(Long orderId);

    Object generateOrder(OrderParam orderParam);

}
