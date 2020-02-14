package com.spring.commerce.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * @author hwang-yunho on 2020. 2. 14.
 * @project commerce
 */
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ItemResponseDto {

    private Long id;

    private String name;

    private int price;

    private int stockQuantity;

    public ItemResponseDto(Item entity) {
        this.id = entity.getId();
        this.name = entity.getName();
        this.price = entity.getPrice();
        this.stockQuantity = entity.getStockQuantity();
    }
}
