package com.spring.commerce.interfaces.item;

import com.spring.commerce.domain.Item;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Getter
public class ItemDto {
    private int id;        // 고유번호
    private String name;        // 이름
    private int price;          // 가격
    private int stockQuantity;  // 재고 수량

    public Item toEntity() {
        return Item.builder()
                .name(this.getName())
                .price(this.getPrice())
                .stockQuantity(this.getStockQuantity()).build();
    }
}
