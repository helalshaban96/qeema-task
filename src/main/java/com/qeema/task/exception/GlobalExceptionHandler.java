package com.qeema.task.exception;

import com.qeema.task.model.ErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;


@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(BusinessException.class)
    public ResponseEntity<ErrorResponse> handleBusinessException(BusinessException ex) {
        HttpStatus status = HttpStatus.INTERNAL_SERVER_ERROR; // Default status
        switch (ex.getErrorCode().getErrorCodeGroup()) {
            case VALIDATION:
                status = HttpStatus.BAD_REQUEST;
                break;
            case DATABASE:
                status = HttpStatus.SERVICE_UNAVAILABLE;
                break;
            case NOT_FOUND:
                status = HttpStatus.NOT_FOUND;
                break;
        }
        ErrorResponse errorResponse = ErrorResponse.builder()
                .code(ex.getErrorCode().getCode())
                .message(ex.getMessage())
                .build();

        return new ResponseEntity<>(errorResponse, status);
    }
}