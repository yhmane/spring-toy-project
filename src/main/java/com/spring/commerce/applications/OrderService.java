package com.spring.commerce.applications;

import com.spring.commerce.domain.*;
import com.spring.commerce.domain.enums.OrderStatus;
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
        // TODO 2. 에러처리 필요 (임시로 NullPointer 에러 발생하게 처리)
        Order order = orderRepository.findById(id)
                .orElseThrow(() -> new NullPointerException());

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
            // TODO 3. 에러처리 필요 (임시로 NullPointer 에러 발생하게 처리)
            Item item = itemRepository.findById(dto.getId())
                    .orElseThrow(() -> new NullPointerException());

            item.calculateStockQuantity(dto.getCount());

            // TODO 4. 재고처리 필요 (일단 -재고 로도 가능하게 구현 후 수정)
            OrderItem orderItem = orderItemRepository.save(dto.toEntity(order, item, item.getPrice()));
        }
        return order;
    }

    public void updateOrderStatus(Long id, OrderStatus orderStatus) {
        // TODO 2. 에러처리 필요 (임시로 NullPointer 에러 발생하게 처리)
        Order order = orderRepository.findById(id)
                .orElseThrow(() -> new NullPointerException());

        order.updateOrderStatus(orderStatus);
    }
}

