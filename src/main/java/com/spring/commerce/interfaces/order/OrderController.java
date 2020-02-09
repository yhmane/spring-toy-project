package com.spring.commerce.interfaces.order;

import com.spring.commerce.domain.Order;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/order")
//@AllArgsConstructor
public class OrderController {

    private final OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

     /**
      * READ
      * 모든 주문 리스트를 반환
      * @return OrderDto
      */
    @GetMapping("/list")
    public OrderDto list() {
        return orderService.findAll();
    }

    /**
     * POST
     * 주문 생성
     * @return String
     */
    @PostMapping("/create")
    public Order create(@RequestBody OrderDto orderDto) {
        return orderService.orderSave(orderDto.getList());
    }

}
