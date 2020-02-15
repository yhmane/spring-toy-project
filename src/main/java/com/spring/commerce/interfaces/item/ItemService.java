package com.spring.commerce.interfaces.item;

import ch.qos.logback.core.net.SyslogOutputStream;
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
        Item item = itemDto.toEntity();
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

    public Item findOne(int id) {
        return itemRepository.findById((long) id).orElse(null);
    }

    public ItemDto update(int id, ItemDto itemDto) {
        Item item = this.findOne(id);
        item.updateInfo(itemDto.getName(), itemDto.getPrice(), itemDto.getStockQuantity());
        itemRepository.save(item);
        return itemDto;
    }

    public Boolean delete(int itemId) {
        Item item = this.findOne(itemId);
        itemRepository.delete(item);

        return true;
    }
}
