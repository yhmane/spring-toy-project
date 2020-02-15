package com.spring.commerce.domain;

import lombok.*;
import org.hibernate.annotations.Table;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.io.Serializable;


@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Builder
public class Item implements Serializable {
    @Id
    @GeneratedValue
    @Column(name = "ITEM_ID")
    private Long id;

    private String name;        // 이름
    private int price;          // 가격
    private int stockQuantity;  // 재고 수량

//    @Builder
//    public Item(String name, int price, int stockQuantity) {
//        this.name = name;
//        this.price = price;
//        this.stockQuantity = stockQuantity;
//    }
}
