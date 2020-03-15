package com.spring.commerce.interfaces;

import com.spring.commerce.applications.ItemService;
import com.spring.commerce.domain.item.Item;
import com.spring.commerce.domain.item.ItemRequestDto;
import com.spring.commerce.domain.item.ItemResponseDto;
import lombok.AllArgsConstructor;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
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

    private static final Logger LOGGER = LogManager.getLogger(ItemController.class);

    private final ItemService itemService;

    @GetMapping("/items")
    public List<ItemResponseDto>  list() {
        return itemService.list();
    }

    @GetMapping("/items/{id}")
    public ItemResponseDto getItem(@PathVariable Long id) {
        LOGGER.info("itemController GET /items/ param id : " + id);
        return itemService.getItem(id);
    }

    @PostMapping("/items")
    public ResponseEntity<?> create(@Valid @RequestBody ItemRequestDto dto) throws URISyntaxException {

        LOGGER.info("itemController POST /items param name : " + dto.getName());
        LOGGER.info("itemController POST /items param price : " + dto.getPrice());
        LOGGER.info("itemController POST /items param stockQuantity : " + dto.getStockQuantity());

        Item item = itemService.create(dto);
        URI location = new URI("/items/" + item.getId());

        return ResponseEntity.created(location).body("{}");
    }

    @PatchMapping("/items/{id}")
    public String update(@PathVariable Long id, @RequestBody ItemRequestDto dto ) {

        LOGGER.info("itemController PATCH /items param id : " + id);
        LOGGER.info("itemController PATCH /items param name : " + dto.getName());
        LOGGER.info("itemController PATCH /items param price : " + dto.getPrice());
        LOGGER.info("itemController PATCH /items param stockQuantity : " + dto.getStockQuantity());

        itemService.update(id, dto);
        return "{}";
    }

    @PutMapping("/items/{id}")
    public String soldOut(@PathVariable Long id) {

        LOGGER.info("itemController PUT /items param id : " + id);

        itemService.soldOut(id);
        return "{}";
    }
}
