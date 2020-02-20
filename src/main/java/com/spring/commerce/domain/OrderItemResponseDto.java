package com.spring.commerce.domain;

import lombok.Builder;
import lombok.Getter;

/**
 * @author hwang-yunho on 2020. 2. 15.
 * @project commerce
 */
@Getter
public class OrderItemResponseDto {

    private Long id;

    private ItemResponseDto itemResponseDto;

    private int orderPrice;

    private int count;


    @Builder
    public OrderItemResponseDto(Long id, ItemResponseDto itemResponseDto, int orderPrice, int count) {
        this.id = id;
        this.itemResponseDto = itemResponseDto;
        this.orderPrice = orderPrice;
        this.count = count;
    }

    public OrderItemResponseDto(OrderItem entity) {
        this.id = entity.getId();
        this.itemResponseDto = new ItemResponseDto(entity.getItem());
        this.orderPrice = entity.getOrderPrice();
        this.count = entity.getCount();
    }
}
