package com.spring.commerce.interfaces.item;

import com.spring.commerce.domain.Item;
import com.spring.commerce.domain.Order;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/item")
public class ItemController {

    private final ItemService itemService;

    public ItemController(ItemService itemService) {
        this.itemService = itemService;
    }

    /**
     * READ
     * 모든 아이템 리스트를 반환
     * @return List<Item>
     */
    @GetMapping("/list")
    public List<ItemDto> list() {
        return itemService.findAll();
    }

    /**
     * POST
     * 아이템 생성
     * @return Item
     */
    @PostMapping("/create")
    public Item create(@RequestBody ItemDto itemDto) {
        return itemService.itemSave(itemDto);
    }

}
