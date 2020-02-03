package com.spring.commerce.interfaces;

import com.spring.commerce.domain.Item;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ItemController {

    @GetMapping("/items")
    public List<Item> list() {
        return null;
    }
}
