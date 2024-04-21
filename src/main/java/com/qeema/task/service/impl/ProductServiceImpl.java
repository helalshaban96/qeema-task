package com.qeema.task.service.impl;

import com.qeema.task.entity.ProductEntity;
import com.qeema.task.entity.OrderEntity;
import com.qeema.task.enums.ErrorCode;
import com.qeema.task.exception.BusinessException;
import com.qeema.task.model.Product;
import com.qeema.task.repository.ProductRepository;
import com.qeema.task.repository.OrderRepository;
import com.qeema.task.service.ProductService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public Product addProductToOrder(Long orderId, Product product) throws BusinessException {
        OrderEntity order = orderRepository.findById(orderId)
                .orElseThrow(() -> new BusinessException(ErrorCode.ORDER_NOT_FOUND));

        ProductEntity productEntity = modelMapper.map(product, ProductEntity.class);
        productEntity.setOrder(order);
        productEntity = productRepository.save(productEntity);
        return modelMapper.map(productEntity, Product.class);
    }

    @Override
    public List<Product> getProductsByOrderId(Long orderId) throws BusinessException {
        List<ProductEntity> entities = productRepository.findByOrderId(orderId); // Assumes findByOrder_Id exists and is correct
        return entities.stream()
                .map(entity -> modelMapper.map(entity, Product.class))
                .collect(Collectors.toList());
    }
    @Override
    public Product createProduct(Product product) {
        ProductEntity productEntity = modelMapper.map(product, ProductEntity.class);
        return modelMapper.map(productRepository.save(productEntity), Product.class) ;
    }

}
