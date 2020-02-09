package com.spring.commerce.interfaces.item;

import com.spring.commerce.domain.Item;
import com.spring.commerce.domain.Order;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
@AllArgsConstructor
public class ItemService {
    private final ItemRepository itemRepository;

    public Item itemSave(ItemDto itemDto) {
        Item item = new Item();
        item.setName(itemDto.getName());
        item.setPrice(itemDto.getPrice());
        item.setStockQuantity(itemDto.getStockQuantity());
        return itemRepository.save(item);
    }

    public List<ItemDto> findAll() {
        List<ItemDto> itemDtoList = new ArrayList<ItemDto>();
        List<Item> itemList = itemRepository.findAll();
        for (Item item : itemList) {
            ItemDto itemDto = new ItemDto();
            itemDto.setName(item.getName());
            itemDto.setPrice(item.getPrice());
            itemDto.setStockQuantity(item.getStockQuantity());
            itemDtoList.add(itemDto);
        }
        return itemDtoList;
    }

    public Item findOne(Long id) {
        return itemRepository.findById(id).orElse(null);
    }
}
