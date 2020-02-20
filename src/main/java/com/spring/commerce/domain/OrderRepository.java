package com.spring.commerce.domain;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author hwang-yunho on 2020. 2. 4.
 * @project commerce
 */
public interface OrderRepository extends JpaRepository<Order, Long> {
    Order save(Order order);
}