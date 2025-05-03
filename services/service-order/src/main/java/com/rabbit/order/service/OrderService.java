package com.rabbit.order.service;


import com.rabbit.order.bean.Order;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: RabbitRed
 * @Date: 2025/05/02/21:44
 * @Description:
 */
public interface OrderService {
    Order createOrder(Long productId, Long userId);
}
