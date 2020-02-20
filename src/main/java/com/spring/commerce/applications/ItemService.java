package com.spring.commerce.applications;

import com.spring.commerce.domain.item.Item;
import com.spring.commerce.domain.item.ItemRepository;
import com.spring.commerce.domain.item.ItemRequestDto;
import com.spring.commerce.domain.item.ItemResponseDto;
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

        // TODO 1. 에러 처리 필요 (임시로 처리)
        Item item = itemRepository.findById(id)
                .orElseThrow(() -> new NullPointerException());

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

        // TODO 1. 에러 처리 필요 (임시로 처리)
        Item item = itemRepository.findById(id)
                .orElseThrow(() -> new NullPointerException());

        item.update(dto);
    }

    public void soldOut(Long id) {

        // TODO 1. 에러 처리 필요 (임시로 처리)
        Item item = itemRepository.findById(id)
                .orElseThrow(() -> new NullPointerException());

        item.soldOut(id);
    }
}
