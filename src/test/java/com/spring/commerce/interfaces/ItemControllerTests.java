package com.spring.commerce.interfaces;

import com.spring.commerce.applications.ItemService;
import com.spring.commerce.domain.item.ItemResponseDto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.Matchers.containsString;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * @author hwang-yunho on 2020. 3. 2.
 * @project commerce
 */
@AutoConfigureMockMvc
@ContextConfiguration(classes = {ItemController.class, ItemService.class})
@WebMvcTest
class ItemControllerTests {

    @Autowired
    private MockMvc mvc;

    @MockBean
    private ItemService itemService;

    @DisplayName("item 전체 리스트 확인")
    @Test
    void list() throws Exception {
        List<ItemResponseDto> items = new ArrayList<ItemResponseDto>();
        items.add(ItemResponseDto.builder()
                .id(1L)
                .name("신라면 5봉지")
                .price(3500)
                .stockQuantity(200000)
                .build());
        items.add(ItemResponseDto.builder()
                .id(2L)
                .name("코카콜라 1.5L")
                .price(2600)
                .stockQuantity(350000)
                .build());

        given(itemService.list()).willReturn(items);

        mvc.perform(get("/items")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(content().string(containsString("\"id\":1")))
                .andExpect(content().string(containsString("\"name\":\"신라면 5봉지\"")))
                .andExpect(content().string(containsString("\"id\":2")))
                .andExpect(content().string(containsString("\"name\":\"코카콜라 1.5L\"")))
                .andExpect(status().isOk());
    }

    @DisplayName("item 1번 확인")
    @Test
    void getItem() throws Exception {
        ItemResponseDto dto = ItemResponseDto.builder()
                .id(1L)
                .name("신라면 5봉지")
                .price(3500)
                .stockQuantity(200000)
                .build();

        given(itemService.getItem(1L)).willReturn(dto);

        mvc.perform(get("/items/1")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(content().string(containsString("\"id\":1")))
                .andExpect(content().string(containsString("\"name\":\"신라면 5봉지\"")))
                .andExpect(status().isOk());
    }

    @Test
    void create() throws Exception{
        //TODO tdd를 단계별로 적용해보자..
    }

    @Test
    void update() {
    }

    @Test
    void soldOut() {
    }
}