package com.qeema.task.facade.impl;

import com.qeema.task.exception.BusinessException;
import com.qeema.task.facade.OrderFacade;
import com.qeema.task.model.Order;
import com.qeema.task.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class OrderFacadeImpl implements OrderFacade {

    @Autowired
    private OrderService orderService;

    @Override
    public Order createOrder(Order order) throws BusinessException {
        return orderService.createOrder(order);
    }

    @Override
    public Order getOrderById(Long orderId) throws BusinessException {
        return orderService.getOrderById(orderId);
    }

    @Override
    public List<Order> getAllOrders() {
        return orderService.getAllOrders();
    }
}