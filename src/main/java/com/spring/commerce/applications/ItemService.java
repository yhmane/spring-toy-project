package com.spring.commerce.applications;

import com.spring.commerce.domain.item.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
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

    private static final Logger LOGGER = LogManager.getLogger(ItemService.class);

    private final ItemRepository itemRepository;

    @Autowired
    public ItemService(ItemRepository itemRepository) {
        this.itemRepository = itemRepository;
    }

    public List<ItemResponseDto> list() {
        return itemRepository.findAllDesc()
                .map(ItemResponseDto::new).collect(Collectors.toList());
    }

    public ItemResponseDto getItem(Long id) {

        LOGGER.info("ItemService getItem param id : " + id);

        Item item = itemRepository.findById(id)
                .orElseThrow(() -> new ItemNotFoundException(id));

        LOGGER.info("ItemService getItem item entity id : " + item.getId());

        return ItemResponseDto.builder()
                .id(item.getId())
                .name(item.getName())
                .price(item.getPrice())
                .stockQuantity(item.getStockQuantity())
                .build();
    }

    public Item create(ItemRequestDto dto) {

        LOGGER.info("ItemService create param name : " + dto.getName());
        LOGGER.info("ItemService create param price : " + dto.getPrice());
        LOGGER.info("ItemService create param stockQuantity : " + dto.getStockQuantity());

        return itemRepository.save(dto.toEntity());
    }

    public void update(Long id, ItemRequestDto dto) {

        LOGGER.info("ItemService update param id : " + id);
        LOGGER.info("ItemService update param name : " + dto.getName());
        LOGGER.info("ItemService update param price : " + dto.getPrice());
        LOGGER.info("ItemService update param stockQuantity : " + dto.getStockQuantity());

        Item item = itemRepository.findById(id)
                .orElseThrow(() -> new ItemNotFoundException(id));

        LOGGER.info("ItemService update item entity id : " + item.getId());

        item.update(dto);
    }

    public void soldOut(Long id) {

        LOGGER.info("ItemService soldOut param id : " + id);

        Item item = itemRepository.findById(id)
                .orElseThrow(() -> new ItemNotFoundException(id));

        LOGGER.info("ItemService soldOut item entity id : " + item.getId());

        item.soldOut(id);
    }
}
