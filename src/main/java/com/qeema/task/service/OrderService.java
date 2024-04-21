package com.qeema.task.service;

import com.qeema.task.exception.BusinessException;
import com.qeema.task.model.Order;

import java.util.List;
import java.util.Optional;

public interface OrderService {
    Order createOrder(Order order) throws BusinessException;

    Order getOrderById(Long id) throws BusinessException;

    void startOrderFulfillment(Long orderId) throws BusinessException;
    List<Order> getAllOrders();

}
