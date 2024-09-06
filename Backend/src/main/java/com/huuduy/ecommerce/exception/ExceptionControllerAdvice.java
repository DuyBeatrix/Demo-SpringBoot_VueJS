package com.huuduy.ecommerce.exception;

import com.huuduy.ecommerce.config.ApiResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionControllerAdvice{

    @ExceptionHandler(value = CustomException.class)
    public ApiResponse<String> handleUpdateFailException(CustomException exception)
    {
        return new ApiResponse<>(exception.getMessage(), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(value = AuthenticationFailException.class)
    public final ApiResponse<String> handleAuthenticationFailException(AuthenticationFailException exception) {
        return new ApiResponse<>(exception.getMessage(), HttpStatus.BAD_REQUEST);
    }
}

