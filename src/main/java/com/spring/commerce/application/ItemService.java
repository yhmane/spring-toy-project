package com.spring.commerce.application;

import com.spring.commerce.domain.Item;
import com.spring.commerce.infra.ItemRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ItemService {
    private ItemRepository itemRepository;

    public ItemService(ItemRepository itemRepository) {
        this.itemRepository = itemRepository;
    }

    public List<Item> findAllItem() {
        return itemRepository.findAll();
    }

    public void save(Item item){
        itemRepository.save(Item.builder()
                .name(item.getName())
                .price(item.getPrice())
                .stockQuantity(5).build()
        );
    }
}
