package com.spring.commerce.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.*;

/**
 * @author hwang-yunho on 2020. 2. 3.
 * @project commerce
 */
@Entity
@Getter
@NoArgsConstructor
public class Item extends BaseTimeEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long itemId;

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

    // TODO  4. 재고가 0 밑으로 떨어질 경우 처리 해줘야 함
    public void calculateStockQuantity(int count) {
        this.stockQuantity = stockQuantity - count;
    }

    public void update(ItemRequestDto dto) {
        this.name = dto.getName();
        this.price = dto.getPrice();
        this.stockQuantity = dto.getStockQuantity();
    }

    @LastModifiedDate
    public void soldOut(Long id) {
        this.stockQuantity = 0;
    }
}
