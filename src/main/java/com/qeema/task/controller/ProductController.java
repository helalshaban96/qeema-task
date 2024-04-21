package com.qeema.task.controller;

import com.qeema.task.facade.ProductFacade;
import com.qeema.task.model.Product;
import com.qeema.task.exception.BusinessException;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/products")
@Api(value = "Product Management System", tags = "Products")
public class ProductController {

    @Autowired
    private ProductFacade productFacade;

    @PostMapping("/create")
    @ApiOperation(value = "Create a new product", response = Product.class)
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Product successfully created"),
            @ApiResponse(code = 400, message = "Invalid product details provided")
    })
    public ResponseEntity<Product> createProduct(@RequestBody Product product) {
        try {
            Product newProduct = productFacade.createProduct(product);
            return ResponseEntity.status(201).body(newProduct);
        } catch (BusinessException e) {
            return ResponseEntity.badRequest().body(null);
        }
    }

    @PostMapping("/add-to-order/{orderId}")
    @ApiOperation(value = "Add a product to an order", response = Product.class)
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Product successfully added to order"),
            @ApiResponse(code = 400, message = "Invalid product details provided"),
            @ApiResponse(code = 404, message = "Order not found")
    })
    public ResponseEntity<Product> addProductToOrder(@PathVariable Long orderId, @RequestBody Product product) {
        try {
            Product addedProduct = productFacade.addProductToOrder(orderId, product);
            return ResponseEntity.status(201).body(addedProduct);
        } catch (BusinessException e) {
            return ResponseEntity.badRequest().body(null);
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/by-order/{orderId}")
    @ApiOperation(value = "Retrieve all products by order ID", response = Product[].class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Products retrieved successfully"),
            @ApiResponse(code = 404, message = "No products found or order does not exist")
    })
    public ResponseEntity<?> getProductsByOrderId(@PathVariable Long orderId) {
        try {
            return ResponseEntity.ok(productFacade.getProductsByOrderId(orderId));
        } catch (BusinessException e) {
            return ResponseEntity.notFound().build();
        }
    }
}
