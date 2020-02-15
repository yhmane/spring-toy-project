package com.spring.commerce.interfaces.order;

import com.spring.commerce.domain.Order;
import com.spring.commerce.domain.OrderItem;
import com.spring.commerce.domain.OrderStatus;
import lombok.Builder;
import lombok.Getter;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Builder
@Getter
public class OrderDto {
    private int itemId;        // 이름
    private String itemName;        // 이름
    private int orderPrice;  // 아이템 가격 가격
    private int count;          // 아이템 주문 수량


    public Order toEntity() {
        List<OrderItem> orderItemList = new ArrayList<OrderItem>();
        return Order.builder()
                .orderDate(new Date())
                .orderItems(orderItemList)
                .status(OrderStatus.ORDER).build();
    }

    @Override
    public String toString() {
        return "OrderDto{" +
                "itemId=" + itemId +
                ", itemName='" + itemName + '\'' +
                ", orderPrice=" + orderPrice +
                ", count=" + count +
                '}';
    }
}
