package com.qeema.task.facade;

import com.qeema.task.exception.BusinessException;
import com.qeema.task.model.Order;

import java.util.List;

public interface OrderFacade {
    Order createOrder(Order order) throws BusinessException;
    Order getOrderById(Long orderId) throws BusinessException;
    List<Order> getAllOrders();
}
