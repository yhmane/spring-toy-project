package com.spring.commerce.interfaces;

import com.spring.commerce.application.OrderService;
import com.spring.commerce.domain.OrderItem;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class OrderController {
    private OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @GetMapping("/api/order/items")
    public List<OrderItem> orderItemList() {
        return orderService.findAllOrderItems();
    }
}
