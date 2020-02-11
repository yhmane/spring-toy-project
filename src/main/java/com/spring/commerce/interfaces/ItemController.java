package com.spring.commerce.interfaces;

import com.spring.commerce.applications.ItemService;
import com.spring.commerce.domain.Item;
import com.spring.commerce.domain.ItemRequestDto;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.net.URI;
import java.net.URISyntaxException;
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
    public ResponseEntity<?> create(@Valid @RequestBody ItemRequestDto dto) throws URISyntaxException {

        Item item = itemService.create(dto);
        URI location = new URI("/items/" + item.getItemId());

        return ResponseEntity.created(location).body("{}");
    }

    @PatchMapping("/items/{id}")
    public String update(@PathVariable Long id, @RequestBody ItemRequestDto dto ) {

        itemService.update(id, dto);
        return "{}";
    }

    @PutMapping("/items/{id}")
    public String soldOut(@PathVariable Long id) {
        itemService.soldOut(id);
        return "{}";
    }
}
