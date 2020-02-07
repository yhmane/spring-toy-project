package com.spring.commerce.domain;


import lombok.Getter;

import javax.persistence.*;

@Entity
@Getter
public class OrderedItem {

    @Id
    @GeneratedValue
    private Long id;

    @ManyToOne
    private Item item;
    private int orderPrice;
    private int count;

    public OrderedItem() {
    }

    public OrderedItem(Long id, Item item, int orderPrice, int count) {
        this.id = id;
        this.item = item;
        this.orderPrice = orderPrice;
        this.count = count;
    }


}
