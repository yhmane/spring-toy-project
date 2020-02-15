package com.spring.commerce.domain;

import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "ORDERS")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Builder
public class Order {

    @Id
    @GeneratedValue
    @Column(name = "ORDER_ID")
    private Long id;

    @OneToMany(
        cascade = CascadeType.ALL,
        orphanRemoval = true,
        mappedBy = "order"
    )

    private List<OrderItem> orderItems = new ArrayList<OrderItem>();

    @Temporal(TemporalType.TIMESTAMP)
    private Date orderDate;

    @Enumerated(EnumType.STRING)
    private OrderStatus status;


    public void updateInfo(OrderStatus status) {
        this.status = status;
    }
//    @ManyToOne
//    @JoinColumn(name = "MEMBER_ID")
//    private Member member;

//    public void setMember(Member member) {
//        if(this.member != null) {
//            this.member.getOrders().remove(this);
//        }
//        this.member = member;
//        member.getOrders().add(this);
//    }
}

