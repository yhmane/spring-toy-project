package com.spring.commerce.interfaces;

import com.spring.commerce.applications.OrderService;
import com.spring.commerce.domain.Order;
import com.spring.commerce.domain.OrderItemRequestDto;
import lombok.AllArgsConstructor;
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

    private OrderService orderService;

    @GetMapping("/orders")
    public List<Order> list() {
        return orderService.list();
    }
    @GetMapping("/orders/{id}")
    public Order getOrder(@PathVariable Long id) {
        return orderService.getOrder(id);
    }

    @PostMapping("/orders")
    public ResponseEntity<?> create(@Valid @RequestBody List<OrderItemRequestDto> list) throws URISyntaxException {

        Order order = orderService.create(list);
        URI location = new URI("/orders/" + order.getOrderId());

        return ResponseEntity.created(location).body("{}");
    }
}
