package com.spring.commerce.domain.dto;

import com.spring.commerce.domain.Item;
import lombok.Getter;

@Getter
public class ItemDto {
    private Long id;
    private String name;
    private int price;
    private int stockQuantity;

   public ItemDto(Item entity) {
       this.id = entity.getId();
       this.name = entity.getName();
       this.price = entity.getPrice();
       this.stockQuantity = entity.getStockQuantity();
   }

}
