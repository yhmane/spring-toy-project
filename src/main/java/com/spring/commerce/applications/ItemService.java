package com.spring.commerce.applications;

import com.spring.commerce.domain.item.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author hwang-yunho on 2020. 2. 3.
 * @project commerce
 */
@Service
@Transactional
public class ItemService {

    private ItemRepository itemRepository;

    @Autowired
    public ItemService(ItemRepository itemRepository) {
        this.itemRepository = itemRepository;
    }

    public List<ItemResponseDto> list() {
        return itemRepository.findAllDesc()
                .map(ItemResponseDto::new).collect(Collectors.toList());
    }

    public ItemResponseDto getItem(Long id) {

        Item item = itemRepository.findById(id)
                .orElseThrow(() -> new ItemNotFoundException(id));

        return ItemResponseDto.builder()
                .id(item.getId())
                .name(item.getName())
                .price(item.getPrice())
                .stockQuantity(item.getStockQuantity())
                .build();
    }

    public Item create(ItemRequestDto dto) {
        Item item = itemRepository.save(dto.toEntity());
        return item;
    }

    public void update(Long id, ItemRequestDto dto) {

        Item item = itemRepository.findById(id)
                .orElseThrow(() -> new ItemNotFoundException(id));

        item.update(dto);
    }

    public void soldOut(Long id) {

        Item item = itemRepository.findById(id)
                .orElseThrow(() -> new ItemNotFoundException(id));

        item.soldOut(id);
    }
}
