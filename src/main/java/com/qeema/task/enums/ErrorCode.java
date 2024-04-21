package com.qeema.task.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum ErrorCode {

    PRODUCT_NOT_VALID("1001", "Invalid product details", ErrorCodeGroup.VALIDATION),
    ORDER_EMPTY("1002", "No products in the order", ErrorCodeGroup.VALIDATION),
    PRODUCT_NOT_FOUND("2001", "Product not found", ErrorCodeGroup.NOT_FOUND),
    ORDER_NOT_FOUND("2002", "Order not found", ErrorCodeGroup.NOT_FOUND),
    DATABASE_ERROR("3001", "Database operation failed", ErrorCodeGroup.DATABASE);

    private final String code;
    private final String message;
    private final ErrorCodeGroup errorCodeGroup;
}