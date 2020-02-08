package com.spring.commerce.application;

import com.spring.commerce.domain.OrderItem;
import com.spring.commerce.infra.OrderItemRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {
    private OrderItemRepository orderItemRepository;

    public OrderService(OrderItemRepository orderItemRepository) {
        this.orderItemRepository = orderItemRepository;
    }

    public List<OrderItem> findAllOrderItems() {
        return orderItemRepository.findAll();
    }
}
