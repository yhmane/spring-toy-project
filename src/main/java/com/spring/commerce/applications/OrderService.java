package com.spring.commerce.applications;

import com.spring.commerce.domain.enums.OrderStatus;
import com.spring.commerce.domain.item.Item;
import com.spring.commerce.domain.item.ItemNotFoundException;
import com.spring.commerce.domain.item.ItemRepository;
import com.spring.commerce.domain.order.Order;
import com.spring.commerce.domain.order.OrderNotFoundException;
import com.spring.commerce.domain.order.OrderRepository;
import com.spring.commerce.domain.order.OrderResponseDto;
import com.spring.commerce.domain.orderItem.OrderItem;
import com.spring.commerce.domain.orderItem.OrderItemRepository;
import com.spring.commerce.domain.orderItem.OrderItemRequestDto;
import com.spring.commerce.domain.orderItem.OrderItemResponseDto;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author hwang-yunho on 2020. 2. 4.
 * @project commerce
 */
@Service
@AllArgsConstructor
@Transactional
public class OrderService {

    private OrderRepository orderRepository;

    private ItemRepository itemRepository;

    private OrderItemRepository orderItemRepository;

    public List<OrderResponseDto> list() {
        List<Order> list = orderRepository.findAll();

        List<OrderResponseDto> dtos = new ArrayList<>();

        for (Order order : list) {
            dtos.add(OrderResponseDto.builder()
                    .id(order.getId())
                    .orderDate(order.getCreatedDate())
                    .orderStatus(order.getOrderStatus())
                    .orderItems(orderItemRepository.findByOrder(order)
                            .map(OrderItemResponseDto::new).collect(Collectors.toList()))
                    .build());
        }
        return dtos;
    }

    public OrderResponseDto getOrder(Long id) {
        Order order = orderRepository.findById(id)
                .orElseThrow(() -> new OrderNotFoundException(id));

        return OrderResponseDto.builder()
                .id(order.getId())
                .orderDate(order.getCreatedDate())
                .orderStatus(order.getOrderStatus())
                .orderItems(orderItemRepository.findByOrder(order)
                        .map(OrderItemResponseDto::new).collect(Collectors.toList()))
                .build();
    }

    public Order create(List<OrderItemRequestDto> list) {

        Order order = orderRepository.save(list.get(0).toOrderEntity());

        for (OrderItemRequestDto dto : list) {
            Item item = itemRepository.findById(dto.getId())
                    .orElseThrow(() -> new ItemNotFoundException(dto.getId()));

            item.calculateStockQuantity(dto.getCount());

            OrderItem orderItem = orderItemRepository.save(dto.toEntity(order, item, item.getPrice()));
        }
        return order;
    }

    public void updateOrderStatus(Long id, OrderStatus orderStatus) {

        Order order = orderRepository.findById(id)
                .orElseThrow(() -> new OrderNotFoundException(id));

        order.updateOrderStatus(orderStatus);
    }
}

