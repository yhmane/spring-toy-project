package com.spring.commerce.advice;

import com.spring.commerce.domain.item.ItemNotFoundException;
import com.spring.commerce.domain.item.ItemOverlapException;
import com.spring.commerce.domain.item.ItemStockLimitException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * @author hwang-yunho on 2020. 2. 20.
 * @project commerce
 */
@RestControllerAdvice
public class ItemErrorAdvice {

    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(ItemNotFoundException.class)
    public String handleNotFound(ItemNotFoundException e) {
        return e.getMessage();
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(ItemOverlapException.class)
    public String handleOverlapEntity(ItemOverlapException e) {
        return e.getMessage();
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(ItemStockLimitException.class)
    public String handleStockLimit(ItemStockLimitException e) {
        return e.getMessage();
    }
}
