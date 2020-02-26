package com.spring.commerce.applications;

import com.spring.commerce.domain.enums.OrderStatus;
import com.spring.commerce.domain.item.Item;
import com.spring.commerce.domain.item.ItemNotFoundException;
import com.spring.commerce.domain.item.ItemOverlapException;
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
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
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

    private static final Logger LOGGER = LogManager.getLogger(OrderService.class);

    private final OrderRepository orderRepository;

    private final ItemRepository itemRepository;

    private final OrderItemRepository orderItemRepository;

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

        LOGGER.info("OrderService getItem param id : " + id);

        Order order = orderRepository.findById(id)
                .orElseThrow(() -> new OrderNotFoundException(id));

        LOGGER.info("OrderService getOrder order entity id : " + order.getId());

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
        LOGGER.info("OrderService create order entity id : " + order.getId());

        // 아이템 중복 오류
        if(list.stream().map(OrderItemRequestDto::getId).distinct().count() != list.size()) {
            throw new ItemOverlapException();
        }


        for (OrderItemRequestDto dto : list) {
            Item item = itemRepository.findById(dto.getId())
                    .orElseThrow(() -> new ItemNotFoundException(dto.getId()));

            LOGGER.info("OrderService create item entity id : " + item.getId());
            LOGGER.info("OrderService create item  before Stock: " + item.getStockQuantity());
            LOGGER.info("OrderService create item  ordered Stock: " + dto.getCount());
            item.calculateStockQuantity(dto.getCount());

            LOGGER.info("OrderService create item after Stock : " + item.getStockQuantity());

            OrderItem orderItem = orderItemRepository.save(dto.toEntity(order, item, item.getPrice()));
        }
        return order;
    }

    public void updateOrderStatus(Long id, OrderStatus orderStatus) {

        LOGGER.info("OrderService updateOrderStatus param id : " + id);
        LOGGER.info("OrderService updateOrderStatus param orderStatus : " + orderStatus);

        Order order = orderRepository.findById(id)
                .orElseThrow(() -> new OrderNotFoundException(id));

        LOGGER.info("OrderService updateOrderStatus order entity id : " + order.getId());
        order.updateOrderStatus(orderStatus);
        orderCancelItemStockUpdate(order);

    }

    /**
     * 주문취소나 실패로인한 재고상태 업데이트
     * @param order
     */
    public void orderCancelItemStockUpdate(Order order) {

        LOGGER.info("orderCancelItemStockUpdate order id: " + order.getId());
        LOGGER.info("orderCancelItemStockUpdate order orderStatus: " + order.getOrderStatus());

        if(order.getOrderStatus().equals(OrderStatus.CANCEL) || order.getOrderStatus().equals(OrderStatus.FAILURE)) {

            List<OrderItemResponseDto> orderItemList = orderItemRepository.findByOrder(order)
                    .map(OrderItemResponseDto::new).collect(Collectors.toList());

            for(OrderItemResponseDto oi : orderItemList) {
                Item item = itemRepository.findById(oi.getItemResponseDto().getId())
                        .orElseThrow(() -> new ItemNotFoundException(oi.getItemResponseDto().getId()));

                LOGGER.info("orderCancelItemStockUpdate item id: " + item.getId());
                LOGGER.info("orderCancelItemStockUpdate item before stock: " + item.getStockQuantity());
                LOGGER.info("orderCancelItemStockUpdate order cancel stock: " + oi.getCount());

                // 삭감된 재고를 다시 재고에 더하여 줌
                item.calculateStockQuantity(-oi.getCount());
                LOGGER.info("orderCancelItemStockUpdate item after stock: " + item.getStockQuantity());
            }
        }
    }
}

