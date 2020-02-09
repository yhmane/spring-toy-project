package com.spring.commerce.interfaces.order;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class OrderDto {
    private Long itemId;        // 이름
    private String itemName;        // 이름
    private int orderPrice;  // 아이템 가격 가격
    private int count;          // 아이템 주문 수량
    private List<OrderDto> list = new ArrayList<>();


    public void setAddOrderDtoList(OrderDto orderDto) {
        System.out.println("set add order Dto List");
        System.out.println(orderDto.toString());
        list.add(orderDto);
    }

    @Override
    public String toString() {
        return "OrderDto{" +
                "itemId=" + itemId +
                ", itemName='" + itemName + '\'' +
                ", orderPrice=" + orderPrice +
                ", count=" + count +
                ", list=" + list +
                '}';
    }
}
