package com.spring.commerce.domain;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * @author hwang-yunho on 2020. 2. 4.
 * @project commerce
 */
public interface OrderItemRepository extends JpaRepository<OrderItem, Long> {
    OrderItem save(OrderItem orderItem);

    List<OrderItem> findByOrder(Order order);
}
