package com.spring.commerce.interfaces.order;

import com.spring.commerce.domain.Order;
import com.spring.commerce.interfaces.item.ItemDto;
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
    public List<OrderDto> list() {
        return orderService.findAll();
    }

    /**
     * POST
     * 주문 생성
     * @return String
     */
    @PostMapping("/create")
    public Order create(@RequestBody List<OrderDto> orderDtoList) {
        return orderService.orderSave(orderDtoList);
    }

    /**
     * UPDATE
     * 주문 업데이트
     * @return ItemDto
     */
    @PatchMapping("/update/{id}")
    public OrderDto update(@PathVariable int id, @RequestBody OrderDto orderDto) {
        return orderService.update(id, orderDto);
    }

    /**
     * DELETE
     * 주문 삭제
     * @return boolean
     */
    @DeleteMapping("/delete/{id}")
    public Boolean update(@PathVariable int id) {
        return orderService.delete(id);
    }
}
