package com.spring.commerce.applications;

import com.spring.commerce.domain.*;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

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

    public List<Order> list() {
        List<Order> list = orderRepository.findAll();
        return list;
    }

    public Order getOrder(Long id) {
        // TODO 2. 에러처리 필요 (임시로 NullPointer 에러 발생하게 처리)
        Order order = orderRepository.findById(id)
                .orElseThrow(() -> new NullPointerException());

        System.out.println(order.getOrderItems());
        return order;
    }

    public Order create(List<OrderItemRequestDto> list) {

        Order order = orderRepository.save(list.get(0).toOrderEntity());

        for(OrderItemRequestDto dto : list) {
            // TODO 3. 에러처리 필요 (임시로 NullPointer 에러 발생하게 처리)
            Item item = itemRepository.findById(dto.getItemId())
                    .orElseThrow(() -> new NullPointerException());

            item.calculateStockQuantity(dto.getCount());

            // TODO 4. 재고처리 필요 (일단 -재고 로도 가능하게 구현 후 수정)
            OrderItem orderItem = orderItemRepository.save(dto.toEntity(order, item, item.getPrice()));
        }

        List<OrderItem> orderItems = orderItemRepository.findByOrder(order);
        order.setOrderItems(orderItems);

        return order;
    }
}

