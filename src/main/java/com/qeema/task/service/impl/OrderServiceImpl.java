package com.qeema.task.service.impl;

import com.qeema.task.entity.OrderEntity;
import com.qeema.task.enums.ErrorCode;
import com.qeema.task.exception.BusinessException;
import com.qeema.task.model.Order;
import com.qeema.task.repository.OrderRepository;
import com.qeema.task.service.OrderService;
import jakarta.transaction.Transactional;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Transactional
    @Override
    public Order createOrder(Order order) throws BusinessException {
        OrderEntity orderEntity = modelMapper.map(order, OrderEntity.class);
        orderEntity = orderRepository.save(orderEntity);
        return modelMapper.map(orderEntity, Order.class);
    }

    @Override
    public Order getOrderById(Long id) throws BusinessException {
        return orderRepository.findById(id)
                .map(entity -> modelMapper.map(entity, Order.class))
                .orElseThrow(() -> new BusinessException("Order not found", ErrorCode.ORDER_NOT_FOUND));
    }

    @Async
    public void startOrderFulfillment(Long orderId) {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        System.out.println("Order fulfillment process started for order ID: " + orderId);
    }

    @Override
    public List<Order> getAllOrders() {
        return orderRepository.findAll().stream()
                .map(entity -> modelMapper.map(entity, Order.class))
                .collect(Collectors.toList());
    }
}
