package com.spring.commerce.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * @author hwang-yunho on 2020. 2. 3.
 * @project commerce
 */
@NoArgsConstructor
@Getter
@Setter
public class ItemRequestDto {

    private String name;

    private int price;

    private int stockQuantity;

    @Builder
    public ItemRequestDto(String name, int price, int stockQuantity) {
        this.name = name;
        this.price = price;
        this.stockQuantity = stockQuantity;
    }

    public Item toEntity() {
        return Item.builder()
                .name(name)
                .price(price)
                .stockQuantity(stockQuantity)
                .build();
    }
}
