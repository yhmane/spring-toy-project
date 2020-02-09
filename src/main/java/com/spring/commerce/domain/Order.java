package com.spring.commerce.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "ORDERS")
@Getter
@Setter
public class Order {

    @Id
    @GeneratedValue
    @Column(name = "ORDER_ID")
    private Long id;

//    @ManyToOne
//    @JoinColumn(name = "MEMBER_ID")
//    private Member member;

    @OneToMany(        cascade = CascadeType.ALL,
            orphanRemoval = true,mappedBy = "order")
    private List<OrderItem> orderItems = new ArrayList<OrderItem>();

    @Temporal(TemporalType.TIMESTAMP)
    private Date orderDate;

    @Enumerated(EnumType.ORDINAL)
    private OrderStatus status;

//    public void setMember(Member member) {
//        if(this.member != null) {
//            this.member.getOrders().remove(this);
//        }
//        this.member = member;
//        member.getOrders().add(this);
//    }

    public void addOrderItem(OrderItem orderItem) {
        orderItems.add(orderItem);
        orderItem.setOrder(this);
    }

}

