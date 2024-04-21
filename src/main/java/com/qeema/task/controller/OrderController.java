package com.qeema.task.controller;

import com.qeema.task.exception.BusinessException;
import com.qeema.task.model.Order;
import com.qeema.task.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/orders")
public class OrderController {

    @Autowired
    private OrderService orderService;

    /**
     * Create a new order.
     * @param orderDto the order data transfer object containing order details.
     * @return the created order and HTTP status.
     */
    @PostMapping("/")
    public ResponseEntity<Order> createOrder(@RequestBody Order orderDto) {
        try {
            Order createdOrder = orderService.createOrder(orderDto);
            return ResponseEntity.ok(createdOrder);
        } catch (Exception e) {
            // Log the exception details here and handle different types of exceptions if needed
            return ResponseEntity.badRequest().body(null);  // Return 400 Bad Request in case of exceptions
        }
    }

    /**
     * Get an order by its ID.
     * @param id the ID of the order.
     * @return the order if found, or HTTP 404 Not Found.
     */
    @GetMapping("/{id}")
    public ResponseEntity<Order> getOrderById(@PathVariable Long id) {
        try {
            Order order = orderService.getOrderById(id);
            return ResponseEntity.ok(order);
        } catch (BusinessException e) {
            return ResponseEntity.notFound().build();
        }
    }
    /**
     * Get all orders.
     * @return all orders as a list.
     */
    @GetMapping("/")
    public ResponseEntity<Iterable<Order>> getAllOrders() {
        return ResponseEntity.ok(orderService.getAllOrders());
    }
}
