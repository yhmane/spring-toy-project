package com.spring.commerce.domain.orderItem;

import com.spring.commerce.domain.order.Order;
import com.spring.commerce.domain.orderItem.OrderItem;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.stream.Stream;

/**
 * @author hwang-yunho on 2020. 2. 4.
 * @project commerce
 */
public interface OrderItemRepository extends JpaRepository<OrderItem, Long> {
    OrderItem save(OrderItem orderItem);

    Stream<OrderItem> findByOrder(Order order);
}
