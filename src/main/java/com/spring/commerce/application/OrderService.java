package com.spring.commerce.application;

import com.spring.commerce.domain.OrderedItem;
import com.spring.commerce.infra.OrderedItemRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {
    private OrderedItemRepository orderedItemRepository;

    public OrderService(OrderedItemRepository orderedItemRepository) {
        this.orderedItemRepository = orderedItemRepository;
    }

    public List<OrderedItem> findAllOrderedItems() {
        return orderedItemRepository.findAll();
    }
}
