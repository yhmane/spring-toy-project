package com.spring.commerce.interfaces;

import com.spring.commerce.applications.OrderService;
import com.spring.commerce.domain.enums.OrderStatus;
import com.spring.commerce.domain.order.Order;
import com.spring.commerce.domain.order.OrderResponseDto;
import com.spring.commerce.domain.orderItem.OrderItemRequestDto;
import lombok.AllArgsConstructor;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

/**
 * @author hwang-yunho on 2020. 2. 4.
 * @project commerce
 */
@RestController
@AllArgsConstructor
public class OrderController {

    private static final Logger LOGGER = LogManager.getLogger(OrderController.class);

    private final OrderService orderService;

    @GetMapping("/orders")
    public List<OrderResponseDto> list() {
        return orderService.list();
    }

    @GetMapping("/orders/{id}")
    public OrderResponseDto getOrder(@PathVariable Long id) {
        LOGGER.info("OrderController GET /orders/ param id : " + id);
        OrderResponseDto dto = orderService.getOrder(id);
        return dto;
    }

    @PostMapping("/orders")
    public ResponseEntity<?> create(@Valid @RequestBody List<OrderItemRequestDto> list) throws URISyntaxException {

        Order order = orderService.create(list);
        URI location = new URI("/orders/" + order.getId());

        return ResponseEntity.created(location).body("{}");
    }

    @PutMapping("/orders/{id}")
    public String update(@PathVariable Long id, @Valid @RequestBody OrderStatus orderStatus) {

        LOGGER.info("OrderController PUT /orders/ param id : " + id);
        LOGGER.info("OrderController PUT /orders/ param orderStatus : " + orderStatus);
        orderService.updateOrderStatus(id, orderStatus);

        return "{}";
    }
}
