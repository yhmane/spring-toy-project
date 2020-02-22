package com.spring.commerce.advice;

import com.spring.commerce.domain.order.OrderNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * @author hwang-yunho on 2020. 2. 22.
 * @project commerce
 */
@RestControllerAdvice
public class OrderErrorAdvice {

    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(OrderNotFoundException.class)
    public String handleNotFound(OrderNotFoundException e) {
        return e.getMessage();
    }
}
