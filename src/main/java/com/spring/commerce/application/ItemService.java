package com.spring.commerce.application;

import com.spring.commerce.domain.Item;
import com.spring.commerce.infra.ItemRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ItemService {
    private ItemRepository itemRepository;

    public ItemService(ItemRepository itemRepository) {
        this.itemRepository = itemRepository;
    }

    public List<Item> findAllItem() {
        return itemRepository.findAll();
    }

    public Item save(Item item){
        return itemRepository.save(item);
    }

    public Optional<Item> find(Long id) {
        return itemRepository.findById(id);
    }


}
