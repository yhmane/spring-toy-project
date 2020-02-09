package com.spring.commerce.interfaces.order;

import com.spring.commerce.domain.Item;
import com.spring.commerce.domain.Order;
import com.spring.commerce.domain.OrderItem;
import com.spring.commerce.domain.OrderStatus;
import com.spring.commerce.interfaces.item.ItemService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

@Service
@Transactional
@AllArgsConstructor
public class OrderService {

    private final OrderRepository orderRepository;
    private final ItemService itemService;

    public Order orderSave(List<OrderDto> orderDtoList) {
        final Order order = new Order();
        order.setOrderDate(new Date());

        List<OrderItem> orderItemList = new ArrayList<OrderItem>();
        for (OrderDto orderDto : orderDtoList) {
            OrderItem orderItem = new OrderItem();
            Item item = itemService.findOne(orderDto.getItemId());
            orderItem.setCount(orderDto.getCount());
            orderItem.setOrder(order);
            orderItem.setOrderPrice(orderDto.getOrderPrice());
            orderItem.setItem(item);
            orderItemList.add(orderItem);
        }

        order.setOrderItems(orderItemList);
        order.setStatus(OrderStatus.ORDER);
        return orderRepository.save(order);
    }

    public OrderDto findAll() {
        OrderDto orderDto = new OrderDto();
        List<Order> orderList = orderRepository.findAll();
        System.out.println(1);
        for (Order order : orderList) {
            System.out.println(2);
            List<OrderItem> orderItemList = order.getOrderItems();
            for (OrderItem orderItem : orderItemList) {
                System.out.println(3);

                OrderDto orderDtoTemp = new OrderDto();
                System.out.println(4);
                orderDtoTemp.setCount(orderItem.getCount());
                orderDtoTemp.setOrderPrice(orderItem.getOrderPrice());
                orderDtoTemp.setItemName(orderItem.getItem().getName());
                System.out.println(5);
                System.out.println(orderDtoTemp.toString());
                System.out.println(6);
                orderDto.setAddOrderDtoList(orderDtoTemp);
                System.out.println(7);
            }
        }
        System.out.println(4);
        return orderDto;
    }
}