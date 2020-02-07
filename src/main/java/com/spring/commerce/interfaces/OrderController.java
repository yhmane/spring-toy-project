package com.spring.commerce.interfaces;

import com.spring.commerce.application.OrderService;
import com.spring.commerce.domain.OrderedItem;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class OrderController {
    private OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @GetMapping("/api/ordered")
    public List<OrderedItem> orderedList() {
        return orderService.findAllOrderedItems();
    }
}
