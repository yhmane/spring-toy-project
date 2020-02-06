package com.spring.commerce.interfaces;

import com.spring.commerce.application.ItemService;
import com.spring.commerce.domain.Item;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ItemController {
    private ItemService itemService;

    public ItemController(ItemService itemService) {
        this.itemService = itemService;
    }

    @GetMapping("/api/items")
    public List<Item> list() {
        List<Item> items = itemService.findAllItem();
        return items;
    }

    @GetMapping("/api/items/{id}")
    public ResponseEntity find(@PathVariable final Long id) {
        return ResponseEntity.ok()
                .body(itemService.find(id))
                ;
    }

    @PostMapping("/api/items")
    public ResponseEntity<?> save(@RequestBody Item item) {
        return new ResponseEntity<>(itemService.save(item),
                HttpStatus.CREATED);
    }

}
