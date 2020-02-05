package com.spring.commerce.interfaces;

import com.spring.commerce.applications.ItemService;
import com.spring.commerce.domain.Item;
import com.spring.commerce.domain.ItemRequestDto;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

/**
 * @author hwang-yunho on 2020. 2. 3.
 * @project commerce
 */
@RestController
@AllArgsConstructor
public class ItemController {

    private ItemService itemService;

    @GetMapping("/items")
    public List<Item>  list() {
        return itemService.list();
    }

    @GetMapping("/items/{id}")
    public Item getItem(@PathVariable Long id) {
        return itemService.getItem(id);
    }

    @PostMapping("/items")
    public Item create(@Valid @RequestBody ItemRequestDto dto) {
        return itemService.create(dto);
    }
}
