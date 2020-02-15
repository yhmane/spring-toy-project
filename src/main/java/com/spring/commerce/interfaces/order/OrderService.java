package com.spring.commerce.interfaces.order;

import com.spring.commerce.domain.Item;
import com.spring.commerce.domain.Order;
import com.spring.commerce.domain.OrderItem;
import com.spring.commerce.domain.OrderStatus;
import com.spring.commerce.interfaces.item.ItemService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
@Transactional
@AllArgsConstructor
public class OrderService {

    private final OrderRepository orderRepository;
    private final ItemService itemService;

    public Order orderSave(List<OrderDto> orderDtoList) {
        List<OrderItem> orderItemList = new ArrayList<OrderItem>();

        Order order = Order.builder()
                .orderDate(new Date())
                .orderItems(orderItemList)
                .status(OrderStatus.ORDER).build();

        for (OrderDto orderDto : orderDtoList) {
            Item item = itemService.findOne(orderDto.getItemId());
            OrderItem orderItem = OrderItem.builder()
                    .item(item)
                    .order(order)
                    .count(orderDto.getCount())
                    .orderPrice(orderDto.getOrderPrice()).build();
            orderItemList.add(orderItem);
        }

        return orderRepository.save(order);
    }

    public List<OrderDto> findAll() {
        List<OrderDto> orderDtoList = new ArrayList<OrderDto>();

        List<Order> orderList = orderRepository.findAll();
        for (Order order : orderList) {
            List<OrderItem> orderItemList = order.getOrderItems();
            for (OrderItem orderItem : orderItemList) {
                OrderDto orderDtoTemp = OrderDto.builder()
                        .count(orderItem.getCount())
                        .orderPrice(orderItem.getOrderPrice())
                        .itemName(orderItem.getItem().getName()).build();
                orderDtoList.add(orderDtoTemp);
            }
        }

        return orderDtoList;
    }
}


