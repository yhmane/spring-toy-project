package com.spring.commerce.interfaces.item;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Getter
@Setter
public class ItemDto {
    private String name;        // 이름
    private int price;          // 가격
    private int stockQuantity;  // 재고 수량
}
