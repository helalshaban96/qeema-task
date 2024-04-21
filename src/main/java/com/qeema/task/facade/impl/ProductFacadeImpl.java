package com.qeema.task.facade.impl;

import com.qeema.task.exception.BusinessException;
import com.qeema.task.facade.ProductFacade;
import com.qeema.task.model.Product;
import com.qeema.task.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ProductFacadeImpl implements ProductFacade {

    @Autowired
    private ProductService productService;

    @Override
    public Product addProductToOrder(Long orderId, Product product) throws BusinessException {
        return productService.addProductToOrder(orderId, product);
    }

    @Override
    public List<Product> getProductsByOrderId(Long orderId) throws BusinessException {
        return productService.getProductsByOrderId(orderId);
    }
    @Override
    public Product createProduct(Product product) {

        return productService.createProduct(product);
    }
}