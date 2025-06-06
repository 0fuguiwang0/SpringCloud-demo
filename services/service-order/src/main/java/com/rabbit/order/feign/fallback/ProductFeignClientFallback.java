package com.rabbit.order.feign.fallback;

import com.rabbit.order.feign.ProductFeignClient;
import com.rabbit.product.bean.Product;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;


@Component
public class ProductFeignClientFallback implements ProductFeignClient {
    @Override
    public Product getProductById(Long id) {
        System.out.println("兜底回调....");
        Product product = new Product();
        product.setId(id);
        product.setPrice(new BigDecimal("0"));
        product.setProductName("未知商品");
        product.setNum(0);

        return product;
    }
}
