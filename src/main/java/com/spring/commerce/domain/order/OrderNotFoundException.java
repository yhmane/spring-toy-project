package com.spring.commerce.domain.order;

/**
 * @author hwang-yunho on 2020. 2. 22.
 * @project commerce
 */
public class OrderNotFoundException extends RuntimeException {
    public OrderNotFoundException(Long id) {
        super("OrderNotFoundException order id : " + id);
    }
}
