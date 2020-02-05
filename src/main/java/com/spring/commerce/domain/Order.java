package com.spring.commerce.domain;

import com.spring.commerce.domain.enums.OrderStatus;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

/**
 * @author hwang-yunho on 2020. 2. 4.
 * @project commerce
 */
@Entity
@Getter
@NoArgsConstructor
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long orderId;

    @OneToMany(mappedBy = "order")
    List<OrderItem>  orderItems = new ArrayList<OrderItem>();

    @Column
    private LocalDateTime orderDate;

    @Column
    @Enumerated(EnumType.STRING)
    private OrderStatus orderStatus;

    @Builder
    public Order(LocalDateTime orderDate, OrderStatus orderStatus) {
        this.orderDate = orderDate;
        this.orderStatus = orderStatus;
    }

    public void setOrderItems(List<OrderItem> orderItems) {
        this.orderItems = orderItems;
    }
}
