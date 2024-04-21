package com.qeema.task.facade;

import com.qeema.task.exception.BusinessException;
import com.qeema.task.model.Product;

import java.util.List;

public interface ProductFacade {
    Product createProduct(Product product);
    Product addProductToOrder(Long orderId, Product product) throws BusinessException;
    List<Product> getProductsByOrderId(Long orderId) throws BusinessException;
}