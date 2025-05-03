package com.rabbit.order.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.rabbit.order.bean.Order;
import com.rabbit.order.properties.OrderProperties;
import com.rabbit.order.service.OrderService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: RabbitRed
 * @Date: 2025/05/02/21:40
 * @Description:
 */
//@RefreshScope //动态刷新
@Slf4j
@RestController
public class OrderController {
    @Autowired
    OrderService orderService;

    //    @Value("${order.timeout}")
//    String orderTimeout;
//    @Value("${order.auto-confirm}")
//    String orderAutoConfirm;
    @Autowired
    OrderProperties orderProperties;


    @GetMapping("/config")
    public String config() {
        return "order.timeout=" + orderProperties.getTimeout() + " orderAutoConfirm=" + orderProperties.getAutoConfirm() + "order.db.url=" + orderProperties.getDbUrl();
    }

    // 创建订单
    @GetMapping("/create")
    public Order createOrder(@RequestParam("userId") Long userId,
                             @RequestParam("productId") Long productId) {
        Order order = orderService.createOrder(productId, userId);
        return order;
    }
    @GetMapping("/seckill")
    @SentinelResource(value = "seckill-order",fallback = "seckillFallback")
    public Order seckill(@RequestParam(value = "userId",required = false) Long userId,
                         @RequestParam(value = "productId",defaultValue = "1000") Long productId){
        Order order = orderService.createOrder(productId, userId);
        order.setId(Long.MAX_VALUE);
        return order;
    }

    public Order seckillFallback(Long userId,Long productId, Throwable exception){
        System.out.println("seckillFallback....");
        Order order = new Order();
        order.setId(productId);
        order.setUserId(userId);
        order.setAddress("异常信息："+exception.getClass());
        return order;
    }

    @GetMapping("/writeDb")
    public String writeDb(){
        return "writeDb success....";
    }

    @GetMapping("/readDb")
    public String readDb(){
        log.info("readDb...");
        return "readDb success....";
    }
}
