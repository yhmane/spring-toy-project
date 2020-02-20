package com.spring.commerce.domain.item;

import com.spring.commerce.domain.item.Item;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * @author hwang-yunho on 2020. 2. 14.
 * @project commerce
 */
@Getter
@NoArgsConstructor
public class ItemResponseDto {

    private Long id;

    private String name;

    private int price;

    private int stockQuantity;

    @Builder
    public ItemResponseDto(Long id, String name, int price, int stockQuantity) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.stockQuantity = stockQuantity;
    }

    public ItemResponseDto(Item entity) {
        this.id = entity.getId();
        this.name = entity.getName();
        this.price = entity.getPrice();
        this.stockQuantity = entity.getStockQuantity();
    }
}
