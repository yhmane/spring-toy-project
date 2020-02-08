package com.spring.commerce.domain;


import lombok.Getter;

import javax.persistence.*;

@Entity
@Getter
public class OrderItem {

    @Id
    @GeneratedValue
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "item_id")
    private Item item;

    private int orderPrice;
    private int count;

    public OrderItem() {
    }

    public OrderItem(Long id, Item item, int orderPrice, int count) {
        this.id = id;
        this.item = item;
        this.orderPrice = orderPrice;
        this.count = count;
    }


}
