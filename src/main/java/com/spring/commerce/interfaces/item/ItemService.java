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
        Item item = Item.builder()
                .name(itemDto.getName())
                .price(itemDto.getPrice())
                .stockQuantity(itemDto.getStockQuantity()).build();
        return itemRepository.save(item);
    }

    public List<ItemDto> findAll() {
        List<ItemDto> itemDtoList = new ArrayList<ItemDto>();
        List<Item> itemList = itemRepository.findAll();
        for (Item item : itemList) {
            ItemDto itemDto = ItemDto.builder()
                    .name(item.getName())
                    .price(item.getPrice())
                    .stockQuantity(item.getStockQuantity()).build();
            itemDtoList.add(itemDto);
        }
        return itemDtoList;
    }

    public Item findOne(Long id) {
        return itemRepository.findById(id).orElse(null);
    }
}
