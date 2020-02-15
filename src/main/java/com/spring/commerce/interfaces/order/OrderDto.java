package com.spring.commerce.interfaces.order;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class OrderDto {
    private Long itemId;        // 이름
    private String itemName;        // 이름
    private int orderPrice;  // 아이템 가격 가격
    private int count;          // 아이템 주문 수량

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
