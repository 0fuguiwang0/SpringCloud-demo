package com.rabbit.product.service;


import com.rabbit.product.bean.Product;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: RabbitRed
 * @Date: 2025/05/02/21:27
 * @Description:
 */

public interface ProductService {
    Product getProductById(Long productId);
}
