package com.spring.commerce.domain;

import lombok.*;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Table;
import org.hibernate.annotations.Where;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.io.Serializable;


@Entity
@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Builder
//@SQLDelete(sql="Update item SET deleted = 1' where id=?")
//@Where(clause="deleted <> 1")
public class Item implements Serializable {
    @Id
    @GeneratedValue
    @Column(name = "ITEM_ID")
    private Long id;

    private String name;        // 이름
    private int price;          // 가격
    private int stockQuantity;  // 재고 수량

    @Column(name="deleted")
    private Integer deleted;

//    @Builder
//    public Item(String name, int price, int stockQuantity) {
//        this.name = name;
//        this.price = price;
//        this.stockQuantity = stockQuantity;
//    }
    public void updateInfo(String name, int price, int stockQuantity) {
        this.name = name;
        this.price = price;
        this.stockQuantity = stockQuantity;
    }
}
