package com.spring.commerce.application;

import com.spring.commerce.domain.Item;
import com.spring.commerce.infra.ItemRepository;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.BDDMockito.given;


@RunWith(SpringRunner.class)
public class ItemServiceTest {
    private ItemService itemService;
    
    @Mock
    private ItemRepository itemRepository;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        //MockItemRepository();
        itemService = new ItemService(itemRepository);
    }

    private void MockItemRepository() {

        // given
        String name = "cap";
        int price = 1000;
        int stock = 5;

        itemRepository.save(Item.builder()
                .name(name)
                .price(price)
                .stockQuantity(5).build()
        );
    }

    @After
    public void cleanup() {
        itemRepository.deleteAll();
    }

    @Test
    public void findAllItem() {
        // given
        String name = "cap";
        int price = 1000;
        int stock = 5;

        // when
        List<Item> itemList = itemService.findAllItem();
        given(itemRepository.findAll()).willReturn(itemList);
        // then
        Item findItem = itemList.get(0);
        assertThat(findItem.getName().equals("cap"));
    }
}