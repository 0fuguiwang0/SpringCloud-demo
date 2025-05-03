package com.rabbit.product.service.impl;
import java.math.BigDecimal;
import java.util.concurrent.TimeUnit;

import com.rabbit.product.bean.Product;
import com.rabbit.product.service.ProductService;
import org.springframework.stereotype.Service;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: RabbitRed
 * @Date: 2025/05/02/21:28
 * @Description:
 */
@Service
public class ProductServiceImpl implements ProductService {

    @Override
    public Product getProductById(Long productId) {
        Product product = new Product();
        product.setId(productId);
        product.setPrice(new BigDecimal("99"));
        product.setProductName("苹果"+productId);
        product.setNum(2);
//        try {
//            TimeUnit.SECONDS.sleep(100);
//        } catch (InterruptedException e) {
//            throw new RuntimeException(e);
//        }
        return product;
    }
}
