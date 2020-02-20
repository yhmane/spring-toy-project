package com.spring.commerce.domain.item;

import com.spring.commerce.domain.BaseTimeEntity;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

/**
 * @author hwang-yunho on 2020. 2. 3.
 * @project commerce
 */
@Entity
@Getter
@NoArgsConstructor
public class Item extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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

    // TODO  4. 재고가 0 밑으로 떨어질 경우 처리 해줘야 함
    public void calculateStockQuantity(int count) {
        this.stockQuantity = stockQuantity - count;
    }

    public void update(ItemRequestDto dto) {
        this.name = dto.getName();
        this.price = dto.getPrice();
        this.stockQuantity = dto.getStockQuantity();
    }

    public void soldOut(Long id) {
        this.stockQuantity = 0;
    }
}
