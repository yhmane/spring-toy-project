package com.spring.commerce.domain.order;

import com.spring.commerce.domain.BaseTimeEntity;
import com.spring.commerce.domain.enums.OrderStatus;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

/**
 * @author hwang-yunho on 2020. 2. 4.
 * @project commerce
 */
@Entity
@Getter
@NoArgsConstructor
public class Order extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    @Enumerated(EnumType.STRING)
    private OrderStatus orderStatus;

    @Builder
    public Order(OrderStatus orderStatus) {
        this.orderStatus = orderStatus;
    }

    public void updateOrderStatus(OrderStatus orderStatus) {
        this.orderStatus = orderStatus;
    }
}
