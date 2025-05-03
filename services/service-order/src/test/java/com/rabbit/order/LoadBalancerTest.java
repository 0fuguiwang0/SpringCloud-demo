package com.rabbit.order;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: RabbitRed
 * @Date: 2025/05/03/10:05
 * @Description:
 */
@SpringBootTest
public class LoadBalancerTest {

    @Autowired
    LoadBalancerClient loadBalancerClient;
    DiscoveryClient discoveryClient;


//    @Test
//    void test(){
//
////        discoveryClient.getInstances("service-product");
//
//
//        ServiceInstance choose = loadBalancerClient.choose("service-product");
//        System.out.println("choose = " + choose.getHost() +"："+choose.getPort());
//        choose = loadBalancerClient.choose("service-product");
//        System.out.println("choose = " + choose.getHost() +"："+choose.getPort());
//        choose = loadBalancerClient.choose("service-product");
//        System.out.println("choose = " + choose.getHost() +"："+choose.getPort());
//        choose = loadBalancerClient.choose("service-product");
//        System.out.println("choose = " + choose.getHost() +"："+choose.getPort());
//        choose = loadBalancerClient.choose("service-product");
//        System.out.println("choose = " + choose.getHost() +"："+choose.getPort());
//    }
}
