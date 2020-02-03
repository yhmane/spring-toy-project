package com.spring.commerce.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * @author hwang-yunho on 2020. 2. 3.
 * @project commerce
 */
@Entity
@Getter
@NoArgsConstructor
public class Item {

    @Id @GeneratedValue
    private Long id;

    @Column
    private String name;

    @Column
    private int price;

    @Column
    private int stockQuantity;

    @Builder
    public Item(String name, int price, int stockQuantity) {
        this.name = name;
        this.price = price;
        this.stockQuantity = stockQuantity;
    }
}
