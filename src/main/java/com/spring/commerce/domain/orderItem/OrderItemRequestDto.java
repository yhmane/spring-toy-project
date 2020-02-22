package com.spring.commerce.domain.orderItem;

import com.spring.commerce.domain.enums.OrderStatus;
import com.spring.commerce.domain.item.Item;
import com.spring.commerce.domain.order.Order;
import com.spring.commerce.domain.orderItem.OrderItem;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

/**
 * @author hwang-yunho on 2020. 2. 4.
 * @project commerce
 */
@Getter
@Setter
@NoArgsConstructor
public class OrderItemRequestDto {
    private Long id;

    @Max(value = 100000000, message = "100000001개 이상의 수량은 주문할 수 없습니다.")
    @Min(value = 1, message = "1개 이상의 수량을 선택해 주세요.")
    private int count;

    public Order toOrderEntity() {
        return Order.builder()
                .orderStatus(OrderStatus.READY)
                .build();
    }

    public OrderItem toEntity(Order order, Item item, int price) {
        return OrderItem.builder()
                .order(order)
                .item(item)
                .orderPrice(count * price)
                .count(count)
                .build();
    }
}
