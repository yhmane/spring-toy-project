package com.spring.commerce.interfaces;

import com.spring.commerce.application.ItemService;
import com.spring.commerce.domain.Item;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ItemController {
    private ItemService itemService;

    public ItemController(ItemService itemService) {
        this.itemService = itemService;
    }

    @GetMapping("/items")
    public List<Item> list() {
        List<Item> items = itemService.findAllItem();
        return items;
    }
}
