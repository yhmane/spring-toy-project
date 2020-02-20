package com.spring.commerce.domain;

import com.spring.commerce.domain.enums.OrderStatus;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

/**
 * @author hwang-yunho on 2020. 2. 15.
 * @project commerce
 */
@Getter
@Setter
@NoArgsConstructor
public class OrderResponseDto {

    private Long id;

    List<OrderItemResponseDto> orderItems = new ArrayList<OrderItemResponseDto>();

    private OrderStatus orderStatus;

    private String orderDate;

    @Builder
    public OrderResponseDto(Long id, List<OrderItemResponseDto> orderItems, OrderStatus orderStatus, LocalDateTime orderDate) {
        this.id = id;
        this.orderItems = orderItems;
        this.orderStatus = orderStatus;
        this.orderDate = localDateTimeToString(orderDate);
    }

    public OrderResponseDto(Order entity) {
        this.id = entity.getId();
        this.orderStatus = entity.getOrderStatus();
        this.orderDate = localDateTimeToString(entity.getCreatedDate());
    }

    private String localDateTimeToString(LocalDateTime localDateTime) {
        return localDateTime.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
    }
}
